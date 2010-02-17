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
package org.wingsource.plugin.engine.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import java.util.Hashtable;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import org.wingsource.plugin.engine.PluginExplorer;
import org.wingsource.plugin.util.ClasspathSearch;


/**
 * @author samikc
 *
 */
public class PluginEngineClassLoader extends URLClassLoader {
	
	private ClassLoader callingContextClassLoader = null;
	
	/**
	 * @param urls
	 * @param parent
	 */
	public PluginEngineClassLoader(URL[] urls, ClassLoader parent) throws Exception{
		super(urls, PluginEngineClassLoader.class.getClass().getClassLoader());
		loadInfo();
		this.callingContextClassLoader = parent;
		System.out.println("PLUGIN ENGINE CLASS LOADER CONSTRUCTOR");
	}

	/**
	 * The logger variable for logging at different levels.
	 */	
	public static final Logger logger=Logger.getLogger(PluginEngineClassLoader.class.getName());

	private List<String> jars = null;
	
	private final Hashtable<String, Class> loadedClasses = new Hashtable<String, Class>();
	
	/**
	 * @param urls
	 * @throws Exception 
	 */
	/*
	public PluginEngineClassLoader(URL[] urls) throws Exception {
		
		super(urls);
		loadInfo();
		System.out.println("PLUGIN ENGINE CLASS LOADER CONSTRUCTOR");
		// TODO Auto-generated constructor stub
	}
	*/
	public Class loadClass(String className) throws ClassNotFoundException{
		return findClass(className);
	}
	
	private List<String> getAllJars(String directory) {
		List<String> ret = new ArrayList<String>();
		File dir = new File(directory);
		for (String f : dir.list()) {
			if (f.endsWith("jar")) {
				ret.add(directory + f);
			}
		}
		//add file paths from class path
		URL[] urls = ClasspathSearch.instance().search(PluginExplorer.class, ".wsp", "*.jar");
		
		for(URL url: urls) {
			ret.add(url.getFile());
		}
		
		
		URL[] urls1 = ClasspathSearch.instance().search(PluginExplorer.class, "WEB-INF", "*.jar");
		
		for(URL url: urls1) {
			System.out.println("=====>"+url.getFile()+"<======");
			ret.add(url.getFile());
		}
		return ret;


	}
	
	private void loadInfo() throws Exception{
		String commonDir = System.getProperty("user.home");
		String dirName = (new StringBuilder().append(commonDir).append(File.separator).append(PluginExplorer.PLUGIN_HOME_DIRECTORY_NAME).append(File.separator)).toString();
		this.jars = getAllJars(dirName);
	}

	public Class findClass(String className) {
		byte[] classBytes;
		Class ret = null;
		System.out.println("PLUGIN ENGINE CLASS LOADER FINDCLASS :" + className);
		ret = this.loadedClasses.get(className);
		if (ret != null) {
			return ret;
		}
		try {
			ret = findSystemClass(className);
			return ret;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		try {
			ret = this.callingContextClassLoader.loadClass(className);
			return ret;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		
		// check whether we have this class in our control or not 
		for (String jf : this.jars) {
			try {
				JarFile jarFile = new JarFile(jf);
				String tempclassName = className.replaceAll("\\.", "/");
				JarEntry je = jarFile.getJarEntry(tempclassName + ".class");
				if (je != null) {
					InputStream is = jarFile.getInputStream(je);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int next = is.read();
					while (next != -1) {
						baos.write(next);
						next = is.read();
					}
					classBytes = baos.toByteArray();
					//ret = defineClass(className,classBytes,0,classBytes.length,null);
					ret = this.defineClass(className, classBytes, 0, classBytes.length);
					this.loadedClasses.put(className, ret);
					return ret;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
			

		
		
		return ret;
	}

	/*
	public URL findResource(String name) {
		try {
		File file = new File(jarFile);
		String url = file.toURI().toURL().toString();
		return new URL("jar:"+url+"!/"+name);
		} catch (Exception e) {
		return null;
		}

		}
		*/
}
