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

import org.wingsource.plugin.AppContextService;

import junit.framework.TestCase;

/**
 * @author samikc
 *
 */
public class AppContextFactoryTest extends TestCase {

	/**
	 * Test method for {@link org.wingsource.plugin.engine.appcontext.AppContextFactory#get(org.wingsource.plugin.engine.appcontext.AppContextType, org.wingsource.plugin.AppContextService)}.
	 */
	public void testGet() {
		//fail("Not yet implemented");
		assertTrue(AppContextFactory.get(AppContextType.SINGLETON, new AppContextService() {
			
			public Map<String, Object> get() {
				// TODO Auto-generated method stub
				return new HashMap<String, Object>();
			}
		}) instanceof SingletonAppContext);
		
		assertTrue(AppContextFactory.get(AppContextType.THREAD, new AppContextService() {
			
			public Map<String, Object> get() {
				// TODO Auto-generated method stub
				return new HashMap<String, Object>();
			}
		}) instanceof ThreadAppContext);
		assertFalse(AppContextFactory.get(AppContextType.SINGLETON, new AppContextService() {
			
			public Map<String, Object> get() {
				// TODO Auto-generated method stub
				return new HashMap<String, Object>();
			}
		}) instanceof ThreadAppContext);
		
		assertFalse(AppContextFactory.get(AppContextType.THREAD, new AppContextService() {
			
			public Map<String, Object> get() {
				// TODO Auto-generated method stub
				return new HashMap<String, Object>();
			}
		}) instanceof SingletonAppContext);
		
		try {
			AppContextFactory.get(AppContextType.THREAD,null);
			AppContextFactory.get(AppContextType.SINGLETON,null);
			AppContextFactory.get(null,null);
			AppContextFactory.get(null, new AppContextService() {
				
				public Map<String, Object> get() {
					// TODO Auto-generated method stub
					return new HashMap<String, Object>();
				}
			});
			fail("Should be a null pointer exception");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
		
	}

}
