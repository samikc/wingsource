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
import java.util.List;

import org.wingsource.plugin.impl.gadget.bean.Gadget;

/**
 * @author samikc
 *
 */
public class Layout {

	private String layoutXml;
	private static final String NEWLINE = "\n";
	private Integer width;
	private List<Object> contentList = new ArrayList<Object>();

	public String getLayoutXml() {
		return layoutXml;
	}

	public void setLayoutXml(String layoutXml) {
		this.layoutXml = layoutXml;
	}
	
	public String toXml() {
		StringBuilder sbuild = new StringBuilder();
		sbuild.append("<layout>").append(NEWLINE);
		sbuild.append("<width>").append(width.toString()).append("</width>").append(NEWLINE);
		for (Object content : contentList) {
			if(content instanceof Gadget) {
				sbuild.append(((Gadget)content).toXml());
			}
			else if(content instanceof byte[]) {
				sbuild.append(this.toInlineContentXml((byte[])content));
			}
		}
		sbuild.append("</layout>").append(NEWLINE);
		return sbuild.toString();
	}

	private String toInlineContentXml(byte[] content) {
		StringBuilder sb = new StringBuilder();
		sb.append("<content>").append(NEWLINE);
		sb.append("<![CDATA[").append(NEWLINE);
		sb.append(new String(content));
		sb.append("]]>").append(NEWLINE);
		sb.append("</content>").append(NEWLINE);
		return sb.toString();
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
	}
	
	public void add(byte[] inlineContent) {
		this.contentList.add(inlineContent);
	}
	
//	public List<Gadget> getGadgetList() {
//		return this.contentList;
//	}
}
