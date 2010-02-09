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
package org.wingsource.yacsh.plugin;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.yacsh.YacshConfig;
import org.wingsource.yacsh.bean.Gadget;

import com.google.inject.Injector;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author samikc
 *
 */
public class GadgetPlugin implements Plugin {

	private static final Logger logger = Logger.getLogger(GadgetPlugin.class.getName());
	
	private static final Map<String, Gadget> cache = new HashMap<String, Gadget>();
	
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
//		logger.info(id);
		
		if(this.cache.containsKey(id)) {
			try {
				response.setResponse(cache.get(id).clone());
			} catch (CloneNotSupportedException e) {
				logger.log(Level.SEVERE, "Couldn't clone gadget with id:" + id, e);
			}
		}
		else {
			Injector i = YacshConfig.get();
			Gadget g = i.getInstance(Gadget.class);
			g.setId(id);
			this.cache.put(id, g);
			response.setResponse(g);	
		}
	}

}
