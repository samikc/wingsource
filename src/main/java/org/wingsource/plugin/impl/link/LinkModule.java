package org.wingsource.plugin.impl.link;


import org.wingsource.PropertiesClassLoader;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scope;

public class LinkModule implements Module {

	public void configure(Binder binder) {
		Class c = DummyLinkService.class;
		try {
			PropertiesClassLoader pcl = new PropertiesClassLoader("module.properties");
			c = pcl.getClazz("linkplugin");
		}catch (Exception e) {
			// We do not do anything just load the default class
		}
		//binder.bind(GadgetService.class).to(c);
		binder.bind(LinkService.class).to(c);
	}

}
