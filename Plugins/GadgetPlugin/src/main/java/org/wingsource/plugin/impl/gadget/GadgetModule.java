package org.wingsource.plugin.impl.gadget;


import org.wingsource.PropertiesClassLoader;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scope;

public class GadgetModule implements Module {

	public void configure(Binder binder) {
		Class c = DummyGadgetService.class;
		try {
			PropertiesClassLoader pcl = new PropertiesClassLoader("module.properties");
			c = pcl.getClazz("gadgetplugin");
		}catch (Exception e) {
			// We do not do anything just load the default class
		}
		binder.bind(GadgetService.class).to(c);
	}

}
