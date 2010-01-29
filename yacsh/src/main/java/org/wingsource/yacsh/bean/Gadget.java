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
package org.wingsource.yacsh.bean;

import org.wingsource.yacsh.GadgetService;

import com.google.inject.Inject;

/**
 * @author samikc
 *
 */
public class Gadget {

	private String id;
	private GadgetService gadgetService;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Inject
	public Gadget(GadgetService gadgetService) {
		super();
		this.gadgetService = gadgetService;
	}

	public String toXml() {
		StringBuilder sbuild = new StringBuilder();
		
		sbuild.append("<gadget>");
		sbuild.append("<id>").append(id).append("</id>");
		sbuild.append("</gadget>");
		return sbuild.toString();
	}
}
