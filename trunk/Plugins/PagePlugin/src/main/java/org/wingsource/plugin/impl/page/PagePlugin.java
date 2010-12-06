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
package org.wingsource.plugin.impl.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.impl.link.bean.Link;
import org.wingsource.plugin.impl.layout.bean.Layout;
import org.wingsource.plugin.impl.page.bean.Page;

/**
 * @author samikc
 * @author pillvin
 *
 */
public class PagePlugin implements Plugin {
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
			if (o instanceof Link[]) {
				Link[] links = (Link[])o;
				for(Link link: links) {
					linkList.add(link);
				}
			}
			if (o instanceof Layout) {
				layoutList.add((Layout) o);
			}
		}
		StringBuilder sbuild = new StringBuilder();
		sbuild.append("<page>").append(NEWLINE);
		Map<String, String> metadataMap = this.extractMetadata(layoutList);
		
		if(metadataMap != null) {
			sbuild.append("<metadata>").append(NEWLINE);
			for(String metaName : metadataMap.keySet()) {
				String metaValue = metadataMap.get(metaName);
				sbuild.append("<").append(metaName).append(">").append(metaValue).append("</").append(metaName).append(">").append(NEWLINE);
			}
			sbuild.append("</metadata>").append(NEWLINE);
		}
		
		sbuild.append("<panels>").append(NEWLINE);
		for (Layout l : layoutList) {
			sbuild.append(l.toXml()).append(NEWLINE);
		}
		sbuild.append("</panels>").append(NEWLINE);
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
	
	private Map<String, String> extractMetadata(List<Layout> layoutList) {
		Map<String, String> metaMap = new HashMap<String, String>();
		for(Layout layout: layoutList) {
			Map<String, String> layoutMetaMap = layout.getMetadata();
			if(layoutMetaMap != null) {
				metaMap.putAll(layoutMetaMap);
			}
		}
		
		return metaMap;
		
	}

}
