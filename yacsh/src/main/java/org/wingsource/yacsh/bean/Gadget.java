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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.wingsource.yacsh.GadgetService;
import org.wingsource.yacsh.xml.gadget.Module;
import org.wingsource.yacsh.xml.gadget.Module.Content;

import com.google.inject.Inject;

/**
 * @author samikc
 *
 */
public class Gadget {

	// Constant for new line
	private static final String NEWLINE = "\n";
	private static final Logger log = Logger.getLogger(Gadget.class.getName());
	
	private String id;
	private GadgetService gadgetService;
	private String title = null;
	private String gadgetUrl;
	private ArrayList<String> views = new ArrayList<String>();
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(this.id != id) {
			this.id = id;
			try {
				JAXBContext context = JAXBContext.newInstance("org.wingsource.yacsh.xml.gadget");
				Unmarshaller unmarshaller = context.createUnmarshaller();
				URL url = gadgetService.getGadgetXmlUrl(this.id);
				this.gadgetUrl = url.toString();
				InputStream is = url.openStream();
				Module module = (Module)unmarshaller.unmarshal(is);
				this.title = module.getModulePrefs().getTitle();
				List<Content> contents = module.getContent();
				for (Content c : contents) {
					String v = c.getView();
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
	
	@Inject
	public Gadget(GadgetService gadgetService) {
		super();
		this.gadgetService = gadgetService;
	}

	public String toXml() {
		long t1 = System.currentTimeMillis();
		StringBuilder sbuild = new StringBuilder();

		sbuild.append("<gadget>").append(this.NEWLINE);
		sbuild.append("<id>").append(id).append("</id>").append(this.NEWLINE);
		sbuild.append("<title>").append(this.title).append("</title>").append(this.NEWLINE);
		sbuild.append("<url>").append(this.gadgetUrl).append("</url>").append(this.NEWLINE);
		if (views.size() > 0) {
			sbuild.append("<views>").append(this.NEWLINE);
			for (String s : views) {
				sbuild.append("<view>").append(s).append("</view>").append(this.NEWLINE);
			}
			sbuild.append("</views>").append(this.NEWLINE);
		}
		sbuild.append("</gadget>").append(this.NEWLINE);
		long t2 = System.currentTimeMillis();
		log.info("The id : "+this.id+" "+ (t2 - t1) + " ms.");
		return sbuild.toString();
	}
}
