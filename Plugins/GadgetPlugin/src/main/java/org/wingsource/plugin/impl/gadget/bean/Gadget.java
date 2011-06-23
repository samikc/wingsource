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
package org.wingsource.plugin.impl.gadget.bean;

import java.io.IOException;
import java.util.UUID;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.wingsource.plugin.impl.gadget.GadgetService;
import org.wingsource.plugin.impl.gadget.xml.Module;
import org.wingsource.plugin.impl.gadget.xml.Module.Content;
import org.wingsource.plugin.impl.gadget.xml.Module.ModulePrefs;


import com.google.inject.Inject;

/**
 * @author samikc
 * @author pillvin
 *
 */
public class Gadget implements Cloneable{
	
	private static final Logger logger = Logger.getLogger(Gadget.class.getName());
	
	
	private static final Map<String, Module> GADGET_MODULE_MAP = new HashMap<String, Module>();
	
	// Constant for new line
	private static final String NEWLINE = "\n";
	private static final Logger log = Logger.getLogger(Gadget.class.getName());
	private static final String RENDER_INLINE = "inline"; //a reserved keyword for inline html.
	
	private UUID uuid;
	private String id;
	private org.wingsource.plugin.impl.gadget.GadgetService gadgetService;
	private String title = null;
	private String gadgetUrl;
	private String render;
	private ArrayList<String> views = new ArrayList<String>();
	private int height;
	private byte[] content = null;
	private Map<String, String> headers = null;

	private String userId;
	@Inject
	public Gadget(GadgetService gadgetService) {
		super();
		this.uuid = UUID.randomUUID();
		this.gadgetService = gadgetService;
	}
	
	public String getId() {
		return id;
	}

	public void load(String tokenId, String id, Map<String, String> requestParameters) {
		this.id = id;
		this.userId = tokenId;
		try {
			URL url = gadgetService.getGadgetXmlUrl(this.id);
			this.gadgetUrl = url.toString();

			Module module = GADGET_MODULE_MAP.get(this.gadgetUrl);

			if(module == null) {
				JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.impl.gadget.xml");
				Unmarshaller unmarshaller = context.createUnmarshaller();
				module = (Module)unmarshaller.unmarshal(this.getContentStream(this.gadgetUrl));
			}
			ModulePrefs mPrefs = module.getModulePrefs();
			this.title = mPrefs.getTitle();
			this.render = mPrefs.getRenderInline();
			List<Content> contents = module.getContent();
			Integer h = module.getModulePrefs().getHeight();
			if(h != null) {
				this.height = h;
			}
			for (Content c : contents) {
				String v = c.getView();
				String href = c.getHref();
				if((this.render != null) && (this.render.equalsIgnoreCase(RENDER_INLINE))) {
					 Response response = this.getResponse(tokenId, href, requestParameters);
					 this.content = response.getContent();
					 this.headers = response.getHeaders();
				}

				if (v != null && !v.equalsIgnoreCase("null") && !v.equalsIgnoreCase("")) {
					views.add(c.getView());
				}
			}
			
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	private Response getResponse(String tokenId, String href, Map<String, String> requestParameters) {
		logger.finest("Fetching content using HttpClient....user-Id: " + tokenId);
		HttpClient hc = new HttpClient();
		hc.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		HttpMethod method = new GetMethod(href);
		method.addRequestHeader("xx-wings-user-id", tokenId);
		ArrayList<NameValuePair> nvpList = new ArrayList<NameValuePair>();
		Set<String> keys = requestParameters.keySet();
		for(String key: keys) {
			String value = requestParameters.get(key);
			nvpList.add(new NameValuePair(key, value));
		}
		
		String qs = method.getQueryString();
		if(qs != null) {
			String[] nvPairs = qs.split("&");
			for(String nvPair: nvPairs) {
				String[] mapping = nvPair.split("=");
				nvpList.add(new NameValuePair(mapping[0],mapping[1]));
			}
		}
		method.setFollowRedirects(true);
		
		NameValuePair[] nvps = new NameValuePair[nvpList.size()];
		nvps = nvpList.toArray(nvps);
		method.setQueryString(nvps);
		
		
		byte[] content = null;
		Header[] headers = null;
		try {
			hc.executeMethod(method);
			content = method.getResponseBody();
			headers = method.getResponseHeaders();
		} catch (HttpException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new Response(content,headers);
	}

	private InputStream getContentStream(String href) {
		logger.finest("Fetching content using HttpClient....");
		HttpClient hc = new HttpClient();
		hc.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		HttpMethod method = new GetMethod(href);
		method.setFollowRedirects(true);
		
		InputStream responseStream = null;
		try {
			hc.executeMethod(method);
			responseStream = method.getResponseBodyAsStream();
		} catch (HttpException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return responseStream;
	}

	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	
	public String toXml() {
		long t1 = System.currentTimeMillis();
		StringBuilder sbuild = new StringBuilder();

		sbuild.append("<gadget>").append(this.NEWLINE);
		sbuild.append("<uuid>").append(this.uuid).append("</uuid>").append(this.NEWLINE);
		sbuild.append("<id>").append(id).append("</id>").append(this.NEWLINE);
		sbuild.append("<title>").append(this.title).append("</title>").append(this.NEWLINE);
		sbuild.append("<url>").append(this.gadgetUrl).append("</url>").append(this.NEWLINE);
		sbuild.append("<height>").append(this.height).append("</height>").append(this.NEWLINE);
		if (views.size() > 0) {
			sbuild.append("<views>").append(this.NEWLINE);
			for (String s : views) {
				sbuild.append("<view>").append(s).append("</view>").append(this.NEWLINE);
			}
			sbuild.append("</views>").append(this.NEWLINE);
		}
		if(this.headers != null) {
			sbuild.append("<headers>").append(NEWLINE);
			for (String headerName : this.headers.keySet()) {
				String headerValue = this.headers.get(headerName);
				sbuild.append("<header>").append(this.NEWLINE);
				sbuild.append("<name>").append(headerName).append("</name>").append(this.NEWLINE);
				sbuild.append("<value>").append(headerValue).append("</value>").append(this.NEWLINE);
				sbuild.append("</header>").append(this.NEWLINE);
			}
			sbuild.append("</headers>").append(NEWLINE);
		}
		if(this.content != null) {
			sbuild.append("<content>").append(NEWLINE);
			sbuild.append("<![CDATA[").append(NEWLINE);
			sbuild.append(new String(this.content));
			sbuild.append("]]>").append(NEWLINE);
			sbuild.append("</content>").append(NEWLINE);
		}
		sbuild.append("</gadget>").append(this.NEWLINE);
		long t2 = System.currentTimeMillis();
		log.finest("The id : "+this.id+" "+ (t2 - t1) + " ms.");
		return sbuild.toString();
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		Gadget g = (Gadget) super.clone();
		g.uuid = UUID.randomUUID();
		return g;
	}
	
	private class Response {
		private byte[] content;

		private Map<String, String> headers;
		
		public Response(byte[] content, Header[] headers) {
			this.content = content;
			
			if((headers != null) && (headers.length > 0)) {
				this.headers = new HashMap<String, String>();
				
				for(Header header: headers) {
					this.headers.put(header.getName(), header.getValue());
				}
			}
		}
		
		/**
		 * @return the content
		 */
		public byte[] getContent() {
			return content;
		}

		/**
		 * @return the headers
		 */
		public Map<String, String> getHeaders() {
			return headers;
		}		
	}
}

