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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.wingsource.plugin.impl.gadget.GadgetService;
import org.wingsource.plugin.impl.gadget.xml.Module;
import org.wingsource.plugin.impl.gadget.xml.Module.Content;
import org.wingsource.plugin.impl.gadget.xml.Module.ModulePrefs;


import com.google.inject.Inject;

/**
 * @author samikc
 *
 */
public class Gadget implements Cloneable{

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
	
	@Inject
	public Gadget(GadgetService gadgetService) {
		super();
		this.uuid = UUID.randomUUID();
		this.gadgetService = gadgetService;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(this.id != id) {
			this.id = id;
			try {
				JAXBContext context = JAXBContext.newInstance("org.wingsource.plugin.impl.gadget.xml");
				Unmarshaller unmarshaller = context.createUnmarshaller();
				URL url = gadgetService.getGadgetXmlUrl(this.id);
				this.gadgetUrl = url.toString();
				InputStream is = url.openStream();
				Module module = (Module)unmarshaller.unmarshal(is);
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
						this.content = this.getContent(href);
					}

					if (v != null && !v.equalsIgnoreCase("null") && !v.equalsIgnoreCase("")) {
						views.add(c.getView());
					}
				}
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private byte[] getContent(String href) {
		ByteArrayOutputStream buf = new ByteArrayOutputStream(); 
		try {
			URL url = new URL(href);
			InputStream in = url.openStream();
			
			BufferedInputStream bis = new BufferedInputStream(in); 
		    
		    int result = bis.read(); 
		    while(result != -1) { 
		      byte b = (byte)result; 
		      buf.write(b); 
		      result = bis.read(); 
		    } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buf.toByteArray();
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
}

