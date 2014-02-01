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
package org.wingsource.plugin.impl.layout;

import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.impl.gadget.bean.Gadget;
import org.wingsource.plugin.impl.layout.bean.Layout;

/**
 * @author samikc
 *
 */
public class LayoutPlugin implements Plugin {
	// Constant for new line
	private static final String NEWLINE = "\n";


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
		List<Object> operandList = (List<Object>)prequest.getAttribute(PluginRequest.OPERANDS);
		Integer width = 100;
		
		Layout layout = new Layout();

		for (Object o : operandList) {
			if(o instanceof Gadget) {
				layout.add((Gadget)o);
			} else {
				String operand = (String) o;
				try {
					width = Integer.parseInt(operand);
					layout.setWidth(width);
				}catch (NumberFormatException e) {
					// This must be the decorator
					layout.setDecorater(operand);
				}
				
			}
		}
		presponse.setResponse(layout);
	}
}
