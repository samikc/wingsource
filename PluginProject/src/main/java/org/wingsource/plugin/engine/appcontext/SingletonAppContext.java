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
package org.wingsource.plugin.engine.appcontext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samikc
 *
 */
public class SingletonAppContext extends AppContext{

	private static SingletonAppContext context = new SingletonAppContext();
	
	private SingletonAppContext() {super();}
	
	public static SingletonAppContext instance() {
		return context;
	}
	
	/***
	 * The map can be set if it is null. Once the map is set it cannot be set again.
	 * Thus this singleton class is immutable. 
	 * @param map
	 */
	public void set(Map<String, Object> map) {
		if (contextMap == null) {
			contextMap = map;
		}
	}
	
}
