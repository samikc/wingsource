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

import org.wingsource.yacsh.LinkService;
import org.wingsource.yacsh.LinkService.Mime;

import com.google.inject.Inject;

/**
 * @author samikc
 *
 */
public class LinkFactory {

	private LinkService linkService;
	
	@Inject
	public LinkFactory(LinkService linkService) {
		super();
		this.linkService = linkService;
	}


	public Link get(String id) {
		String url = linkService.getLinkUrl(id);
		Mime type = linkService.getType(id);
		Link ret = null;
		switch(type) {
			case JS:	ret = new Link(id, url, "js", "src", "script");
						break;
			
			case CSS:	ret = new Link(id, url, "CSS", "href", "link");
						break;
						
			default:	break;
		}
		return ret;
	}

}
