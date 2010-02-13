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
package org.wingsource.plugin.manager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.wingsource.plugin.SymbolResolverService;
import org.wingsource.plugin.manager.xml.wsp.Plugin;
import org.wingsource.plugin.manager.xml.wsp.Plugins;

/**
 * The plugin manager core data structure is stored here. This is also the 
 * entry point for all the operations that can be performed.
 * @author samikc
 *
 */
public class Manager {

	/***
	 * Stores all the class names that this manager has discovered by looking at
	 * wplugin.xml file in the jar files in the directories.
	 * 
	 *  Key = the class name (fully qualified) that can be loaded from a jar file.
	 *  Value = the jar file name
	 *  
	 *  The public bootstrap method does all the trick to create this information.
	 */
	private Map<String, String> class2JarMapper = new HashMap<String, String>();
	
	private Map<String,String>  symbol2ClassMapper = new HashMap<String, String>();
	
	private Manager() {
		this.bootstrap();
	}
	
	/***
	 * This method loads all the jars and fetches the wplugin.xml file and loads 
	 * all the information into class2JarMapper map. 
	 */
	private void bootstrap() {
		this.loadAllJars();
	}
	
	private void loadAllJars() {
		String commonDir = System.getProperty("user.home");
		String dirName = (new StringBuilder().append(commonDir).append(File.separator).append(Constant.PLUGIN_HOME_DIRECTORY_NAME).append(File.separator)).toString();
		List<String> jarList = this.getAllJars(dirName);
		this.loadInfo(jarList);
	}
	
	private List<String> getAllJars(String directory) {
		List<String> ret = new ArrayList<String>();
		File dir = new File(directory);
		for (String f : dir.list()) {
			if (f.endsWith("jar")) {
				ret.add(f);
			}
		}
		return ret;
	}
	
	private void loadInfo(List<String> jarNameList) throws Exception{
		JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.manager.xml.wsp");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		for (String jarFileName : jarNameList) {
			InputStream is = new ByteArrayInputStream(this.read(Constant.PLUGIN_XML_FILE_NAME, jarFileName));
			Plugins plugins = (Plugins) unmarshaller.unmarshal(is);
			List<Plugin> pluginList = plugins.getPlugin();
			for (Plugin p : pluginList) {
				String clazz = p.getClazz();
				String symbol = p.getId();
				this.class2JarMapper.put(clazz, jarFileName);
				this.symbol2ClassMapper.put(symbol, clazz);
			}
		}
		
	}
	
	private byte[] read(String filename,String jarFileName) throws IOException {
		FileInputStream fileStream = new FileInputStream(jarFileName);
		ZipInputStream zis = new ZipInputStream(fileStream);
		ZipEntry ze = null;
		while ((ze = zis.getNextEntry())!= null && !ze.getName().equals(filename));
		int size = (int)ze.getSize();
		byte[] ret = new byte[size];
		int rb=0;
        int chunk=0;
        while (((int)size - rb) > 0) {
            chunk=zis.read(ret,rb,(int)size - rb);
            if (chunk==-1) {
               break;
            }
            rb+=chunk;
        }
        return ret;
	}
	
	public static SymbolResolverService getResolver() {
		return new SymbolResolverService() {
			public org.wingsource.plugin.Plugin resolve(String symbol) {
				Manager mgr = new Manager();
				String className = mgr.symbol2ClassMapper.get(symbol);
				String jarName = mgr.class2JarMapper.get(className);
				File f = new File(jarName);
				ClassLoader cl = new URLClassLoader(new URL[] {f.toURI().toURL()}, Manager.class.getClass().getClassLoader());
				Class<org.wingsource.plugin.Plugin> clazz = (Class<org.wingsource.plugin.Plugin>) Class.forName(className, true, cl);
				org.wingsource.plugin.Plugin ret = clazz.newInstance();
				return ret;
			}
		};
	}
}
