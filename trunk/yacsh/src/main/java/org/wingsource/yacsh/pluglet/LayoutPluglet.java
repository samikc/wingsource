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
package org.wingsource.yacsh.pluglet;

import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Pluglet;
import org.wingsource.yacsh.YacshConfig;
import org.wingsource.yacsh.bean.Gadget;
import org.wingsource.yacsh.bean.Layout;
import org.wingsource.yacsh.spi.YacshModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author samikc
 *
 */
public class LayoutPluglet implements Pluglet {
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
		StringBuilder sbuild = new StringBuilder();
		Integer width = 100;
		sbuild.append("<layout>").append(NEWLINE);
		Injector i = YacshConfig.get();

		for (Object o : operandList) {
			String operand = (String) o;
			try {
				width = Integer.parseInt(operand);
				sbuild.append("<width>").append(width.toString()).append("</width>").append(NEWLINE);
			}catch(NumberFormatException e) {
				// If we are here that implies that it is not a number so we can process it
				// for gadget id.
				//Gadget g = new Gadget();
				Gadget g = i.getInstance(Gadget.class);
				g.setId(operand);
				sbuild.append(g.toXml());
			}
		}
		sbuild.append("</layout>").append(NEWLINE);
		Layout layout = new Layout();
		layout.setLayoutXml(sbuild.toString());
		presponse.setResponse(layout);
	}
}
