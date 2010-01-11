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

import org.wingsource.plugin.AppContextService;

/**
 * @author samikc
 *
 */
public class AppContextFactory {
	
	public static AppContext get(AppContextType ct,AppContextService contextService) {
		if (ct == AppContextType.SINGLETON) {
			SingletonAppContext context = SingletonAppContext.instance();
			context.set(contextService.get());
			return context;
		} else {
			ThreadAppContext context = new ThreadAppContext();
			context.set(contextService.get());
			return context;
		}
	}

}
