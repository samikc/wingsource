package org.wingsource.plugin.impl.link;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scope;

public class LinkModule implements Module {

	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		binder.bind(LinkService.class).to(DummyLinkService.class);
	}

}
