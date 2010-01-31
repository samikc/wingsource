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
package org.wingsource.yacsh.spi;

import java.net.MalformedURLException;
import java.net.URL;

import org.wingsource.yacsh.GadgetService;

/**
 * @author samikc
 *
 */
public class DummyGadgetService implements GadgetService {

	/* (non-Javadoc)
	 * @see org.wiingsource.yacsh.GadgetService#getGadgetXmlUrl(java.lang.String)
	 */
	public URL getGadgetXmlUrl(String id) {
		// TODO Auto-generated method stub
		URL ret = null;
		if (id.equalsIgnoreCase("g1")) {
			try {
				ret = new URL("http://ralph.feedback.googlepages.com/googlecalendarviewer.xml");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (id.equalsIgnoreCase("g2")) {
			try {
				ret = new URL("http://gwidgets.com/lig/gpa/p132/love-romance-dating-quotes-tips.xml");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return ret;
	}

}
