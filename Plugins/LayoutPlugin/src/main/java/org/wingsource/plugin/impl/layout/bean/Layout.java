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
	private List<Gadget> contentList = new ArrayList<Gadget>();

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
	}
	
	public List<Gadget> getGadgetList() {
		return this.contentList;
	}
}
