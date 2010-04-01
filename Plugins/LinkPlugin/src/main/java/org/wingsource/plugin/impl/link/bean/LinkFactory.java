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

import java.util.ArrayList;

import org.wingsource.plugin.impl.link.LinkService;
import org.wingsource.plugin.impl.link.LinkService.Mime;

import com.google.inject.Inject;

/**
 * @author samikc
 *
 */
public class LinkFactory {

	public static final String LINK_DELIMITER = "~";
	private LinkService linkService;
	
	@Inject
	public LinkFactory(LinkService linkService) {
		super();
		this.linkService = linkService;
	}


	public Link[] get(String id) {

		String complexUrl = linkService.getLinkUrl(id);
		String[] urls = complexUrl.split(LINK_DELIMITER);
		ArrayList<Link> links = new ArrayList<Link>();
		Mime type = linkService.getType(id);
		for(String url:urls) {
			Link link = null;
			switch(type) {
				case JS:	link = new Link(id, url, "js", "src", "script");
							break;
				
				case CSS:	link = new Link(id, url, "CSS", "href", "link");
							break;
							
				default:	break;
			}
			links.add(link);
		}
		Link[] linkArr = new Link[links.size()];
		linkArr = links.toArray(linkArr);
		return linkArr;
	}

}
