package org.wingsource.plugin.impl.gadget;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scope;

public class GadgetModule implements Module {

	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		binder.bind(GadgetService.class).to(DummyGadgetService.class);
	}

}
