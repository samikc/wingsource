/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wingsource.plugin.engine;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.wingsource.plugin.SymbolResolverService;
import org.wingsource.plugin.lang.xml.crawler.Crawler;
import org.wingsource.plugin.lang.xml.crawler.Required;

/**
 * Works with the {@link PluginExplorer} and its crawler.xml file. It crawls the web 
 * for plugins that are mentioned in the crawl.xml to find all the plugin mentioned
 * therein.
 * 
 * @author samikc
 *
 */
public class PluginCrawler {

	private String xmlFileName;
	private Crawler crawler;
	private SymbolResolverService srs;
	public PluginCrawler(String crawlerFileName) throws JAXBException {
		this.xmlFileName = crawlerFileName;
		JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.lang.crawler");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		this.crawler = (Crawler) unmarshaller.unmarshal(new File(crawlerFileName));
		this.srs = PluginExplorer.instance().getResolver();
	}
	
	public void crawl() {
		List<Required> requiredList = this.crawler.getRequired();
		for (Required r : requiredList) {
			if (this.srs.resolve(r.getSymbol()) == null) {
				// We do not have a symbol resolver as of now so lets get it
				try {
					URL url = new URL(r.getWingsite());
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
