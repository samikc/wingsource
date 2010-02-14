package org.wingsource.plugin.impl.crawler;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.engine.PluginCrawler;

public class CrawlerPlugin implements Plugin{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void service(PluginRequest request, PluginResponse response) {
		List<Object> oList = (List<Object>)request.getAttribute(PluginRequest.OPERANDS);
		String xmlFileName = (String) oList.get(0);
		try {
			PluginCrawler pc = new PluginCrawler(xmlFileName);
			pc.crawl();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
