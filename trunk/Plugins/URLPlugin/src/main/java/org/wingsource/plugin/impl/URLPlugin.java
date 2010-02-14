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

package org.wingsource.plugin.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.util.ClasspathSearch;

/**
 * @author Admin
 *
 */
public class URLPlugin implements Plugin {
	
	private static final Logger logger = Logger.getLogger(URLPlugin.class.getName());

	private static Map <String, String> URL_MAP = new HashMap<String, String>();
	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Plugin#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Plugin#init()
	 */
	public void init() {
		if(!URL_MAP.isEmpty()) return;
		
		URL[] urls = ClasspathSearch.instance().search(URLPlugin.class, "APP-INF", "plugin.repository");
		
		for(URL url: urls) {
			try {
				InputStream in = url.openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line = br.readLine();
				int l = 0;
				while (line != null) {
				  String[] tokens = line.split(",");

				  if(tokens.length >= 3) {
					  if(tokens[1].equalsIgnoreCase("url")) {
						  URL_MAP.put(tokens[0], tokens[2]);
					  }
				  }
				  else {
					  logger.log(Level.SEVERE, "Incorrect number of tokens found in plugin.repository at line# " + l);
			      }
					  
				  line = br.readLine();
				  l++;
				}
				
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		logger.finest(URL_MAP.toString());
	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Plugin#service(org.wingsource.plugin.PluginRequest, org.wingsource.plugin.PluginResponse)
	 */
	public void service(PluginRequest request, PluginResponse response) {
		
		String pluginId = (String) request.getAttribute(PluginRequest.ID);
		String u = URL_MAP.get(pluginId);
		URL url = null;
		//Handle classpath search separately as it is a proprietary implementation
		if(u.startsWith("cp://")) {
			String u1 = u.substring("cp://".length());
			int lastSlashIndex = u1.lastIndexOf("/");
			String folderName = null;
			String wildcard = null;
			if(lastSlashIndex == -1) {
				folderName = ".";
				wildcard = u1;
			}
			else {
				folderName = u1.substring(0, lastSlashIndex);
				wildcard = u1.substring(lastSlashIndex + 1);
			}
			URL[] urls = ClasspathSearch.instance().search(URLPlugin.class, folderName, wildcard);
			if((urls != null) && (urls.length > 0)) {
				url = urls[0];
			}
		}
		else {
			try {
				url = new URL(u);
			} catch (MalformedURLException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		
		//Got the URL. Lets set it in the response
		response.setResponse(this.getContent(url));
	}
	
	private byte[] getContent(URL url) {
		ByteArrayOutputStream buf = new ByteArrayOutputStream(); 
		try {
			InputStream in = url.openStream();
			
			BufferedInputStream bis = new BufferedInputStream(in); 
		    
		    int result = bis.read(); 
		    while(result != -1) { 
		      byte b = (byte)result; 
		      buf.write(b); 
		      result = bis.read(); 
		    } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buf.toByteArray();
	}

}
