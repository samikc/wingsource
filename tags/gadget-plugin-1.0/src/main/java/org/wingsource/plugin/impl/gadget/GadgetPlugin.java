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
package org.wingsource.plugin.impl.gadget;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.impl.gadget.bean.Gadget;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author samikc
 *
 */
public class GadgetPlugin implements Plugin {

	private static final Logger logger = Logger.getLogger(GadgetPlugin.class.getName());
	
	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Pluglet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Pluglet#init()
	 */
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.Pluglet#service(org.wingsource.plugin.PluginRequest, org.wingsource.plugin.PluginResponse)
	 */
	public void service(PluginRequest request, PluginResponse response) {
		String id = (String) request.getAttribute(PluginRequest.ID);
		
		//check if request contains user id
		String tokenId = (String) request.getAttribute(PluginRequest.TOKEN_ID);
		logger.finest("User Id" + tokenId);
		
		Injector i = Guice.createInjector(new GadgetModule());
		Gadget g = i.getInstance(Gadget.class);
		Map<String, String> params = this.toMap(request);
		g.load(tokenId, id, params);
		response.setResponse(g);	
	}
	
	private Map<String, String> toMap(PluginRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		
		Set<Object> keys = request.keySet();
		
		for(Object k: keys) {
			if(k instanceof String) {
				String key = (String) k;
				Object v = request.getAttribute(key);
				
				//skip reserved attributes
				if(key.equals(PluginRequest.ID) || key.equals(PluginRequest.OPERANDS) || key.equals(PluginRequest.TOKEN_ID)) continue;
				if(v instanceof String) {
					String value = (String) v;
					map.put(key, value);
				}
			}
		}
		
		return map;
	}
}
