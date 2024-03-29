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
package org.wingsource.plugin;

import java.util.Set;

/**
 * @author samikc
 *
 */
public interface PluginRequest {
	String ID = "ORG.WINGSOURCE.PLUGIN.THIS.ID";
	String OPERANDS = "ORG.WINGSOURCE.PLUGIN.OPERANDS";
	String TOKEN_ID = "token.id";
	
	/***
	 * This method is used to retrieve the parameter that are provided as  
	 * @param name
	 * @return
	 */
	//public Pluglet getParameter(String name);
	
	public Object getAttribute(Object key);
	
	public void setAttribute(Object key, Object value);
	
	public Set<Object> keySet();
}
