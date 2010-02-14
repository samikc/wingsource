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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.wingsource.plugin.SymbolResolverService;
import org.wingsource.plugin.lang.xml.crawler.Crawler;
import org.wingsource.plugin.lang.xml.crawler.Required;
import org.wingsource.plugin.lang.xml.wingsite.Symbol;
import org.wingsource.plugin.lang.xml.wingsite.Wingsite;

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
		this.srs = PluginExplorer.instance().getResolver(null);
	}
	
	public void crawl() {
		List<Required> requiredList = this.crawler.getRequired();
		for (Required r : requiredList) {
			if (this.srs.resolve(r.getSymbol()) == null) {
				// We do not have a symbol resolver as of now so lets get it
				try {
					URL url = new URL(r.getWingsite());
					Wingsite wingsite = this.getSite(url);
					URL jarUrl = null;
					for (Symbol symbol :wingsite.getSymbol()) {
						if (symbol.getName().equals(r.getSymbol())) {
							jarUrl = new URL(symbol.getJarUrl());
							InputStream is = jarUrl.openStream();
							String jarName = jarUrl.toString().substring(jarUrl.toString().lastIndexOf("/"));
							File fJar = new File(new StringBuilder().append(System.getProperty("user.home"))
																	.append(File.separator)
																	.append(PluginExplorer.PLUGIN_HOME_DIRECTORY_NAME)
																	.append(File.separator)
																	.append(jarName).toString());
							FileOutputStream fos = new FileOutputStream(fJar);
							int x = 0;
							while(( x = is.read())!= -1) {
								fos.write(x);
							}
							break;
						}
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private Wingsite getSite(URL url) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.lang.wingsite");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Wingsite wingsite = null;
		try {
			wingsite = (Wingsite) unmarshaller.unmarshal(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wingsite;
	}
}
