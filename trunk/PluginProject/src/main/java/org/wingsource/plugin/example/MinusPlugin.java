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
package org.wingsource.plugin.example;

import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.PluginService;

/**
 * @author samikc
 *
 */
public class MinusPlugin implements PluginService{

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.PluginService#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.PluginService#init()
	 */
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.PluginService#service(org.wingsource.plugin.PluginRequest, org.wingsource.plugin.PluginResponse)
	 */
	public void service(PluginRequest prequest, PluginResponse presponse) {
		System.out.println("MinusPlugin");
		List<String> list = prequest.getOperandList();
		Integer res = 0;
		int counter = 0; 
		for (String str : list) {
			Integer i = 0;
			if (counter == 0) {
				if (str.equalsIgnoreCase("six"))
					i = Integer.parseInt("6");
				res = i;
			}else {
				if (str.equalsIgnoreCase("two"))
					i = Integer.parseInt("2");
				if (str.equalsIgnoreCase("three"))
					i = Integer.parseInt("3");
				res -= i;
			}
			counter++;
		}
		if (res == 3) {
			presponse.setResponse("three");
		} else {
			presponse.setResponse(res);
		}
	}

}
