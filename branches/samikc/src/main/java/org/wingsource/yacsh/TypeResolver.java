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
package org.wingsource.yacsh;

import org.wingsource.plugin.Pluglet;
import org.wingsource.plugin.TypeResolverService;
import org.wingsource.yacsh.pluglet.LayoutPluglet;
import org.wingsource.yacsh.pluglet.LinkPluglet;
import org.wingsource.yacsh.pluglet.PagePluglet;

/**
 * @author samikc
 *
 */
public class TypeResolver implements TypeResolverService {

	/* (non-Javadoc)
	 * @see org.wingsource.plugin.TypeResolverService#resolve(java.lang.String)
	 */
	public Pluglet resolve(String operation) {
		// TODO Auto-generated method stub
		if (operation.equals("l")) {
			return new LayoutPluglet();
		}
		if (operation.equals("page")) {
			return new PagePluglet();
		}

		if (operation.equals("link")) {
			return new LinkPluglet();
		}


		
		return null;
	}

}