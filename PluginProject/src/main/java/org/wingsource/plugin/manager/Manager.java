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
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	/**
	 * The logger variable for logging at different levels.
	 */	
	public static final Logger logger=Logger.getLogger(Manager.class.getName());

	
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
	
	private static final Manager SINGLE_INSTANCE = new Manager();
	
	private Manager() {
		this.bootstrap();
	}
	
	/**
	 * Singleton method
	 */
	public static final Manager instance() {
		return SINGLE_INSTANCE;
	}
	
	/***
	 * This method loads all the jars and fetches the wplugin.xml file and loads 
	 * all the information into class2JarMapper map. 
	 */
	private void bootstrap() {
		try {
			this.loadAllJars();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadAllJars() throws Exception{
		String commonDir = System.getProperty("user.home");
		logger.finest("Common Dir: " + commonDir);
		String dirName = (new StringBuilder().append(commonDir).append(File.separator).append(Constant.PLUGIN_HOME_DIRECTORY_NAME).append(File.separator)).toString();
		List<String> jarList = this.getAllJars(dirName);
		this.loadInfo(jarList,dirName);
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
	
	private void loadInfo(List<String> jarNameList,String dir) throws Exception{
		JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.manager.xml.wsp");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		for (String jarFileName : jarNameList) {
			InputStream is = new ByteArrayInputStream(this.read(Constant.PLUGIN_XML_FILE_NAME, dir+jarFileName));
			Plugins plugins = (Plugins) unmarshaller.unmarshal(is);
			List<Plugin> pluginList = plugins.getPlugin();
			for (Plugin p : pluginList) {
				String clazz = p.getClazz();
				String symbol = p.getId();
				logger.finest("Plugin class : "+clazz+ " symbol "+symbol);
				this.class2JarMapper.put(clazz, dir+jarFileName);
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
	
	/**
	 * Classpath Hack
	 * 
	 * taken from http://dev.eclipse.org/newslists/news.eclipse.platform/msg79732.html 
	 * 
	 * @param u
	 * @throws IOException
	 */
	private void addURL(URL u) throws IOException {

		final Class[] parameters = new Class[] { URL.class };
		URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class sysclass = URLClassLoader.class;

		try {
			Method method = sysclass.getDeclaredMethod("addURL", parameters);
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { u });
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw new IOException("Error, could not add URL to system classloader");
		}// end try catch
	}// end method
	
	private void addFileToSystemClassLoader(File file) throws MalformedURLException, IOException {
		this.addURL(file.toURI().toURL());
	}
	
	public SymbolResolverService getResolver() {
		return new SymbolResolverService() {
			public org.wingsource.plugin.Plugin resolve(String symbol) {
				org.wingsource.plugin.Plugin ret = null;
				try {
					Manager mgr = Manager.instance();
					String className = mgr.symbol2ClassMapper.get(symbol);
					String jarName = mgr.class2JarMapper.get(className);
					if(jarName != null) {
						File f = new File(jarName);
						mgr.addFileToSystemClassLoader(f);
						Class<org.wingsource.plugin.Plugin> clazz = (Class<org.wingsource.plugin.Plugin>)Class.forName(className);
						ret = clazz.newInstance();
					}
				}catch(Exception e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
				}
				return ret;
			}
		};
	}
}
