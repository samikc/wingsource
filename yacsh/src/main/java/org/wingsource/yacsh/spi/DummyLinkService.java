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
package org.wingsource.yacsh.spi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.wingsource.plugin.util.ClasspathSearch;
import org.wingsource.yacsh.LinkService;

/**
 * @author samikc
 *
 */
public class DummyLinkService implements LinkService{
	private static final Logger logger = Logger.getLogger(DummyLinkService.class.getName());
	
	private static Map <String, String> LINK_URL_MAP = new HashMap<String, String>();
	private static Map <String, String> LINK_TYPE_MAP = new HashMap<String, String>();
	
	static {
		URL[] urls = ClasspathSearch.instance().search(DummyGadgetService.class, "APP-INF", "plugin.repository");
		
		for(URL url: urls) {
			try {
				InputStream in = url.openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line = br.readLine();
				int l = 0;
				while (line != null) {
				  String[] tokens = line.split(",");

				  if(tokens.length == 4) {
					  if(tokens[1].equalsIgnoreCase("link")) {
						  LINK_URL_MAP.put(tokens[0], tokens[2]);
						  LINK_TYPE_MAP.put(tokens[0], tokens[3]);
					  }
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
		
		logger.finest(LINK_URL_MAP.toString());
	}

	/* (non-Javadoc)
	 * @see org.wingsource.yacsh.LinkService#getLinkUrl()
	 */
	public String getLinkUrl(String id) {
		return LINK_URL_MAP.get(id);
	}

	/* (non-Javadoc)
	 * @see org.wingsource.yacsh.LinkService#getType()
	 */
	public Mime getType(String id) {
		String type = LINK_TYPE_MAP.get(id);
		return type != null ? (type.equalsIgnoreCase("js") ? Mime.JS 
								:	(type.equalsIgnoreCase("css") ?  Mime.CSS : Mime.UNKNOWN))
			   : Mime.UNKNOWN;
	}

}
