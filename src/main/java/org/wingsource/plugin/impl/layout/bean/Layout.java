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
package org.wingsource.plugin.impl.layout.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wingsource.plugin.impl.gadget.bean.Gadget;

/**
 * @author samikc
 *
 */
public class Layout {

	private String layoutXml;
	private static final String NEWLINE = "\n";
	private static final String META_HEADER_PREFIX = "meta-";
	private Integer width;
	public String getDecorater() {
		return decorater;
	}

	public void setDecorater(String decorater) {
		this.decorater = decorater;
	}

	private String decorater;
	private List<Gadget> contentList = new ArrayList<Gadget>();
	private Map<String, String> metadataMap = new HashMap<String, String>(); //extracts info for all gadget headers prefixed with 'meta-'
	
	public String getLayoutXml() {
		return layoutXml;
	}

	public void setLayoutXml(String layoutXml) {
		this.layoutXml = layoutXml;
	}
	
	public String toXml() {
		StringBuilder sbuild = new StringBuilder();
		sbuild.append("<panel>").append(NEWLINE);
		sbuild.append("<width>").append(width.toString()).append("</width>").append(NEWLINE);
		for (Gadget gadget : contentList) {
				sbuild.append(gadget.toXml());
		}
		sbuild.append("<decoraters>");
			sbuild.append("<decorater>").append(decorater).append("</decorater>");
		sbuild.append("</decoraters>");
		sbuild.append("</panel>").append(NEWLINE);
		return sbuild.toString();
	}


	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	public void add(Gadget g) {
		this.contentList.add(g);
		
		//add meta data as well
		Map<String, String> gHeaders = g.getHeaders();
		
		if(gHeaders != null) {
			int startIndex = META_HEADER_PREFIX.length();
			for(String headerName : gHeaders.keySet()) {
				if(headerName.startsWith(META_HEADER_PREFIX)) {
					int endIndex = headerName.length();
					String metaName = headerName.substring(startIndex, endIndex);
					if(metaName.trim().length() > 0) {
						String value = gHeaders.get(headerName);
						if(value != null) {
							this.metadataMap.put(metaName, value);
						}
					}
				}
			}
		}
	}
	
	public List<Gadget> getGadgetList() {
		return this.contentList;
	}

	public Map<String, String> getMetadata() {

		return this.metadataMap;
	}
}
