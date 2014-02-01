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
package org.wingsource.plugin.impl.link.bean;

/**
 * @author samikc
 *
 */
public class Link {

	private String id;
	private String url;
	private String type;
	private String pointerAttribute;
	private String tag;
	private static final String NEWLINE ="\n";

	public Link(String id, String url, String type, String pointerAttribute,
			String tag) {
		super();
		this.id = id;
		this.url = url;
		this.type = type;
		this.pointerAttribute = pointerAttribute;
		this.tag = tag;
	}
	
	public String toString() {
		StringBuilder sbuild = new StringBuilder();
		sbuild.append("<link type='").append(type).append("' id='").append(id).append("'");
		sbuild.append(" tag='").append(tag).append("' pattr='").append(pointerAttribute).append("' ");
		sbuild.append(" url='").append(url).append("'");
		sbuild.append(" />").append(NEWLINE);
		return sbuild.toString();
	}
}
