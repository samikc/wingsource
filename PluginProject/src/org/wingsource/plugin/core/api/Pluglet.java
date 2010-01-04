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
package org.wingsource.plugin.core.api;

/**
 * This class is used for by plugin developers to collect plugin related information.<br/>
 * 
 * The plugin engine uses this to provide only the pluglet (or pluglets) id (or ids) that
 * a plugin may require to fulfill a PluginService request.<br/>
 * <br/>
 * Here are some examples:<br/>
 * <br/>
 * Say there is a page plugin for web page which expects a pluglet id home.html like:
 * <br/>
 * <code>
 * (home.html)
 * </code>
 * <br/>
 * It retrieves the home.html and returns that page.
 * <br/>
 * There may be a case that one has defined the page plugin service in such a way that a page
 * is composed at the run time using several parts like:
 * <br/>
 * <code>
 * (banner.part.html navigation.part.html maincontent.home.part.html footer.part.html)
 * </code>
 * <br/>
 * In first case the id given to the plugin is:
 * <br/>
 * <code>
 * home.html
 * </code>
 * <br/>
 * where as in the second case it is <br/>
 *  
 * banner.part.html navigation.part.html maincontent.part.html=homeconetnt.part.html footer.part.html
 * <br/>
 * There could be another plugin which treats the pluglet in a completely different manner.
 * Like a gadget page processor plugin could use the value of an expression like:
 * <br/>
 * (g1 g2 g3)
 * <br/>
 * As create a page with gadgets g1, g2 and g3 as gadget id and returns their html content as response page. 
 * In short a pluglet is an input parameter to a {@link PluginService}.
 * 
 *  <br/><br/>
 *  <p>
 *  So how can one uses a subclass of {@link Pluglet}?
 *  
 *  Here is an example:
 *  
 *  Say you are working with gadgets as pluglet, so given a gadget id you may want to create a structure like following in your
 *  subclass:
 *  </p>
 *  <pre>
 *  public GadgetPluglet extends Pluglet {
 *  	private URL gadgetXmlUrl;
 *  	private String gadgetTitle;
 *  	private String gadgetAuthor;
 *  
 *  	public GadgetPluglet(String id) {
 *  		super(id);
 *  		...//rest of the constructor here
 *  	}
 *  	... // rest of the class here  
 *  }
 *  </pre>
 *  
 *  <p>
 *  In the plugin configuration one can provide a pluglet attribute for pluglet creation process. 
 *  This class should have a constructor with a string parameter.
 *  <p>
 * @author samikc
 *
 */
public class Pluglet {

	private String id;

	public Pluglet(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
