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

import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.yacsh.YacshConfig;
import org.wingsource.yacsh.bean.Link;
import org.wingsource.yacsh.bean.LinkFactory;
import org.wingsource.yacsh.spi.YacshModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author samikc
 *
 */
public class LinkPlugin implements Plugin {

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
	public void service(PluginRequest prequest, PluginResponse presponse) {
		List<Object> list = (List<Object>)prequest.getAttribute(PluginRequest.OPERANDS);
		String type = list.get(0).toString();
		Link l = null;
		String id = list.get(1).toString();
		Injector i = YacshConfig.get();
		LinkFactory lf = i.getInstance(LinkFactory.class);
		l = lf.get(id, type);
		presponse.setResponse(l);
	}

}
