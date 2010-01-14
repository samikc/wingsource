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
package org.wingsource.plugin.engine;

import java.util.ArrayList;
import java.util.List;

import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.Pluglet;

/**
 * @author samikc
 *
 */
public class Request implements PluginRequest {

	List<String> operandList = new ArrayList<String>();
	/* (non-Javadoc)
	 * @see org.wingsource.plugin.PluginRequest#getParameter(java.lang.String)
	 */
	public Pluglet getParameter(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getOperandList() {
		return operandList;
	}
	public void setOperandList(List<String> operandList) {
		this.operandList = operandList;
	}

}
