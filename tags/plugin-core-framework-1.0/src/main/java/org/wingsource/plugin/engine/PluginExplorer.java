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

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.wingsource.plugin.OperandTypeResolverService;
import org.wingsource.plugin.SymbolResolverService;
import org.wingsource.plugin.lang.xml.wsp.Plugin;
import org.wingsource.plugin.lang.xml.wsp.Plugins;
import org.wingsource.plugin.util.ClasspathSearch;

/**
 * The plugin manager core data structure is stored here. This is also the 
 * entry point for all the operations that can be performed.
 * @author samikc
 *
 */
public class PluginExplorer {
	/**
	 * The logger variable for logging at different levels.
	 */	
	public static final Logger logger=Logger.getLogger(PluginExplorer.class.getName());

	// The plugin XML file name
	public final static String PLUGIN_XML_FILE_NAME = "plugin.xml";
	
	/***
	 * Stores all the class names that this manager has discovered by looking at
	 * wplugin.xml file in the jar files in the directories.
	 * 
	 *  Key = the class name (fully qualified) that can be loaded from a jar file.
	 *  Value = the jar file name
	 *  
	 *  The public bootstrap method does all the trick to create this information.
	 */
	private Map<String,String>  symbol2ClassMapper = new HashMap<String, String>();
	
	private static final PluginExplorer SINGLE_INSTANCE = new PluginExplorer();
	
	private PluginExplorer() {
		this.bootstrap();
	}
	
	/**
	 * Singleton method
	 */
	public static final PluginExplorer instance() {
		return SINGLE_INSTANCE;
	}
	
	/***
	 * This method loads all the jars and fetches the wplugin.xml file and loads 
	 * all the information into class2JarMapper map. 
	 */
	private void bootstrap() {
		try {
			this.loadPlugins();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadPlugins() throws Exception{

		//add file paths from class path
		URL[] urls = ClasspathSearch.instance().search(PluginExplorer.class, "PLUGIN-INF",PLUGIN_XML_FILE_NAME);
		
		if((urls != null) && (urls.length > 0)) {
			logger.finest("Found " + urls.length + " files with name plugin.xml. Loading them now...");
			
			for(URL url: urls) {
				logger.finest("loading " + url.toString());
				loadPlugin(url.openStream());
			}
		}
		else {
			logger.finest("Could not find any file matching plugin.xml");
		}
	}
	
	/**
	 * @param openStream
	 */
	private void loadPlugin(InputStream is) {
		
		try {
			JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.lang.xml.wsp");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Plugins plugins = (Plugins) unmarshaller.unmarshal(is);
			List<Plugin> pluginList = plugins.getPlugin();
			for (Plugin p : pluginList) {
				String clazz = p.getClazz();
				String symbol = p.getId();
				logger.finest("Plugin class : "+clazz+ " symbol "+symbol);
				this.symbol2ClassMapper.put(symbol, clazz);
			}
		}
		catch(Exception e) {
			//do Nothing
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	
	
	public SymbolResolverService getResolver(final OperandTypeResolverService otrs) {
		return new SymbolResolverService() {
			public org.wingsource.plugin.Plugin resolve(String symbol) {
				org.wingsource.plugin.Plugin ret = null;
				try {
					logger.finest("Symbol: " + symbol); 
					PluginExplorer mgr = PluginExplorer.instance();
					String className = mgr.symbol2ClassMapper.get(symbol);
					logger.finest("Symbol: " + symbol + "class:" + className);
					if(className!=null) {
						
						Class<org.wingsource.plugin.Plugin> clazz = (Class<org.wingsource.plugin.Plugin>)Class.forName(className);
						ret = (org.wingsource.plugin.Plugin) clazz.newInstance();
					}
					else {
						//the symbol may be an operand so try to get it's type.
						if(otrs != null) {
							String type = otrs.resolve(symbol);
							logger.finest("type:" + type);
							if(type != null) {
								ret = this.resolve(type);
							}
						}
					}
				}catch(Exception e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
				}
				return ret;
			}
		};
	}
}
