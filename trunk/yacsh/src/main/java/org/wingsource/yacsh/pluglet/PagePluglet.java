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

import java.util.ArrayList;
import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Pluglet;
import org.wingsource.yacsh.bean.Layout;
import org.wingsource.yacsh.bean.Link;
import org.wingsource.yacsh.bean.Page;

/**
 * @author samikc
 *
 */
public class PagePluglet implements Pluglet {
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
		List<Object> list = (List<Object>)prequest.getAttribute(PluginRequest.OPERANDS);
		List<Layout> layoutList = new ArrayList<Layout>();
		List<Link>   linkList = new ArrayList<Link>();
		for (Object o : list) {
			if (o instanceof Link) {
				linkList.add((Link)o);
			}
			if (o instanceof Layout) {
				layoutList.add((Layout) o);
			}
		}
		StringBuilder sbuild = new StringBuilder();
		sbuild.append("<page>").append(NEWLINE);
		sbuild.append("<layouts>").append(NEWLINE);
		for (Layout l : layoutList) {
			sbuild.append(l.toString()).append(NEWLINE);
		}
		sbuild.append("</layouts>").append(NEWLINE);
		sbuild.append("<links>").append(NEWLINE);
		for (Link link : linkList) {
			sbuild.append(link.toString());
		}
		sbuild.append("</links>").append(NEWLINE);
		sbuild.append("</page>").append(NEWLINE);
		Page page = new Page();
		page.setPage(sbuild.toString());
		presponse.setResponse(page);
	}

}
