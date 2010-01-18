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
package org.wingsource.plugin.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;


/**
 * This handy search class helps locate resources in a classpath. 
 *
 * @author <a href="mailto:pillvin@iit.edu">Vinod Pillai </a>
 * @version 1.0
 */
public class ClasspathSearch {
	
	private static final String ZIP_SCHEME = "ZIP";
	private static final String JAR_SCHEME = "JAR";
	
	private static final String JAR_PATH_DELIMITER = "!";
	
	/**
	 * The single instance static variable.
	 */
	private static final ClasspathSearch SINGLE_INSTANCE = new ClasspathSearch();
	
	/**
	 * The logger variable for logging at different levels.
	 */	
	public static final Logger logger=Logger.getLogger(ClasspathSearch.class.getName());


	

	
	
	/**
	 * Makes a new ClasspathSearch object with no arguments. 
	 */
	private ClasspathSearch(){}
	
	/**
	 * This method access the single instance variable and returns the object of ClasspathSearch 
	 * @return ClasspathSearch single instance object.
	 */
	public static ClasspathSearch instance() {
		logger.finest("==>ClasspathSearch : instance");
		logger.finest("<==ClasspathSearch : instance");
		return SINGLE_INSTANCE;
	}
	
	
	/**
	 * The method helps locate properties files in a classpath. 
	 * @param invokerClass Class that invokes the method
	 * @param fileName A fileName  
	 * @return Array of urls 
	 */
	public URL[] findFile(Class invokerClass, String fileName) {
		logger.finest("==>ClasspathSearch : findFile");
		ArrayList<URL> uList = new ArrayList<URL>();
		try {
			ClassLoader cl = Thread.currentThread( ).getContextClassLoader( );
			
	        if ( cl == null ) {
	            cl = getClass( ).getClassLoader( );
	        }
			
	        Enumeration<URL> configUrls = cl.getResources(fileName);
	        
	        if ( !configUrls.hasMoreElements()) {
	            cl = getClass( ).getClassLoader();
	            configUrls = cl.getResources(fileName);
	        }

	        if ( !configUrls.hasMoreElements()) {
	            cl = ClassLoader.getSystemClassLoader( );
	            configUrls = cl.getResources(fileName);
	        }			
			
			while ( configUrls.hasMoreElements()){
	            uList.add(configUrls.nextElement());
	        }
			
			URL invUrl = invokerClass.getResource(fileName);
			if(invUrl != null) {
				uList.add(invUrl);
			}
		}
		catch(Exception e) {
			//do Nothing
			logger.log(Level.SEVERE,e.getMessage(),e.getStackTrace());
		}
			
		URL[] urls = new URL[uList.size()];
		urls = uList.toArray(urls);
		logger.finest("<==ClasspathSearch : findFile");
		return urls;
	}
	
	/**
	 * Search all files and subdirectories recursively for files that match the wildcard pattern.
	 * 
	 * @param file file to search. This could be a directory or a single file.
	 * @param wildcard wildcard pattern
	 * @return files
	 */
	private File[] listFiles(File file, final String wildcard){
		ArrayList<File> filteredURLList = new ArrayList<File>();
		
		if(file.isDirectory()) {
			
			File[] files = file.listFiles();
			
			for(File f: files) {
				File[] fList = this.listFiles(f, wildcard);
				for(File filteredFile: fList) {
					filteredURLList.add(filteredFile);
				}
			}
		}
		else {
			Pattern patt = Pattern.compile(wildcardToRegex(wildcard));
			Matcher m = patt.matcher(file.getName());
			
			if(m.find()) {
				filteredURLList.add(file);
			}
			
		}
		
		File[] files = new File[filteredURLList.size()];
		files = filteredURLList.toArray(files);
		
		return files;

	}
	
	/**
	 * Search for zip entries that match the wildcard pattern.
	 * 
	 * @param zEntries zip entries to search.
	 * @param wildcard wildcard pattern
	 * @return filtered zip entries
	 */
	private ZipEntry[] listZipEntries(ZipEntry[] zEntries, final String wildcard){
		ArrayList<ZipEntry> filteredZipEntries = new ArrayList<ZipEntry>();
		
		
		if(zEntries != null && zEntries.length > 0) {
			for(ZipEntry entry: zEntries) {
				Pattern patt = Pattern.compile(wildcardToRegex(wildcard));
				String eName = entry.getName();
				//get the leaf node i.e. just the file name 
				int index = eName.lastIndexOf('/');
				if(index != -1) {
					eName = eName.substring(index+1, eName.length());
				}
				Matcher m = patt.matcher(eName);
				if(m.find()) {
					
					filteredZipEntries.add(entry);
				}
			}
		}
		
		ZipEntry[] entries = new ZipEntry[filteredZipEntries.size()];
		entries = filteredZipEntries.toArray(entries);
		
		return entries;
	}	
	public URL[] search(final String wildcard) {
		return this.search(ClasspathSearch.class, wildcard);
	}
	
	public URL[] search(Class invokerClass, final String wildcard) {
		return this.search(invokerClass, ".", wildcard);
	}
	
	public URL[] search(Class invokerClass, String folderName, final String wildcard) {
		URL[] urls = this.findFile(invokerClass, folderName);

		ArrayList<URL> filteredURLList = new ArrayList<URL>();
		for(URL url: urls) {
			
			try {
				logger.finest("URL: " + url);
				String u = url.toString();
				//this line is added as url.toUri() throws an IllegalCharacter 
				//Exception if there is a space charater ' ' in the URL
				u = u.replaceAll(" ", "%20");
				
				URI uri = new URI(u);
				String scheme = uri.getScheme();
				boolean isZip = scheme != null ? scheme.equalsIgnoreCase(ZIP_SCHEME) || scheme.equalsIgnoreCase(JAR_SCHEME) : false;

				if(isZip) {
					ZipEntry[] zipEntries = this.getZipEntries(uri);
					ZipEntry[] entries = this.listZipEntries(zipEntries, wildcard);
					
					for(ZipEntry entry: entries) {
						String uJar = "jar:file:" + this.getJarFilePath(uri) + "!/" + entry.getName();
						URL jarUrl = new URL(uJar);
						filteredURLList.add(jarUrl);
					}
				}
				else {
					File file = new File(uri);
					File[] filteredFileList = this.listFiles(file, wildcard);
					
					for(File f : filteredFileList) {
						filteredURLList.add(f.toURI().toURL());
					}
				}
			} catch (MalformedURLException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			} catch (URISyntaxException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		URL[] filteredUrls = new URL[filteredURLList.size()];
		filteredUrls = filteredURLList.toArray(filteredUrls);
		
		return filteredUrls;
	}
	
	/**
	 * This method gets the path to the Jar/Zip file in a URI
	 * 
	 * @param uri
	 * @return
	 */
	private String getJarFilePath(URI uri) {
		
		String filePath = null;
		
		if(uri != null) {

			String path = uri.toString();
			int firstIndex = path.indexOf('/');
			int exclamationIndex = path != null ? path.indexOf(JAR_PATH_DELIMITER): -1;
			filePath = path.substring(firstIndex, exclamationIndex);
		}
		logger.finer("File Path: " + filePath);
		return filePath;
	}
	
	/**
	 * Get relative path inside a jar file in a given URI
	 * 
	 * @param uri
	 * @return
	 */
	private String getRelativePathInsideJar(URI uri) {
		String relativePath = null;
		
		if(uri != null) {
			String path = uri.toString();
			int exclamationIndex = path != null ? path.indexOf(JAR_PATH_DELIMITER): -1;
			
			//2 - first character = '!', second character = '/'
			relativePath = path.substring(exclamationIndex+2, path.length()); 
		}
		return relativePath;
		
	}
	
	/**
	 * Reads the zip file in the URI and lists all the zip entries in the given URI
	 * 
	 * @param uri
	 * @return
	 */
    private ZipEntry[] getZipEntries(URI uri) {
    	ZipEntry[] zEntries = null;
    	if(uri != null) {
    		try {
    			//get the path to the zip archive. Use '!' delimiter 
				String filePath = this.getJarFilePath(uri);
				String subPath =this.getRelativePathInsideJar(uri);  
				ZipFile zFile = new ZipFile(new File(filePath));
				Enumeration en = zFile.entries();
				
				//Ignore entries that are outside subpath
				ArrayList<ZipEntry> zipFiles = new ArrayList<ZipEntry>();
				while(en.hasMoreElements()) {
					ZipEntry entry = (ZipEntry) en.nextElement();
					if(entry.getName().indexOf(subPath)==-1) continue;
					zipFiles.add(entry);
				}
				zEntries = new ZipEntry[zipFiles.size()];
				zEntries = zipFiles.toArray(zEntries);
    		}
    		catch(ZipException ze) {
    			logger.log(Level.SEVERE, ze.getMessage(), ze);
    		}
    		catch(IOException ie) {
    			logger.log(Level.SEVERE, ie.getMessage(), ie);
    		}
//    		catch(URISyntaxException use) {
//    			logger.log(Level.SEVERE, use.getMessage(), use);
//    		}
    	}
		return zEntries;
	}

	private static String wildcardToRegex(String wildcard){
        StringBuffer s = new StringBuffer(wildcard.length());
        s.append('^');
        for (int i = 0, is = wildcard.length(); i < is; i++) {
            char c = wildcard.charAt(i);
            switch(c) {
                case '*':
                    s.append(".*");
                    break;
                case '?':
                    s.append(".");
                    break;
                    // escape special regexp-characters
                case '(': case ')': case '[': case ']': case '$':
                case '^': case '.': case '{': case '}': case '|':
                case '\\':
                    s.append("\\");
                    s.append(c);
                    break;
                default:
                    s.append(c);
                    break;
            }
        }
        s.append('$');
        return(s.toString());
    }
	
//	public static void main(String[] args) {
//	try {
//		URL[] urls = ClasspathSearch.instance().search(ClasspathSearch.class, "portal*.xml");
//		
//		for(URL url: urls) {
//			logger.finest(url);
//		}
//	}
//	catch(Exception e) {
//		logger.log(Level.SEVERE, e.getMessage(), e);
//	}
//}
	
}
