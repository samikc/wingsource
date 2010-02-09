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
package org.wingsource.grid;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wingsource.plugin.engine.PluginEngine;
import org.wingsource.plugin.util.ClasspathSearch;
import org.wingsource.yacsh.YacshConfig;
import org.wingsource.yacsh.YacshSymbolResolver;
import org.wingsource.yacsh.spi.YacshModule;

/**
 * @author pillvin
 *
 */
public class MashupServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PluginEngine pe = new PluginEngine(new YacshSymbolResolver());
			YacshConfig.init(new YacshModule());
			String expr = request.getParameter("expr");
			String page = "(xslt (page (l g1 g2 33) (l g1 g2 33) (l g1 g2 33) wingskin shindigRpc shindigCookies shindigUtil shindigGadgets shindigUserPref jquery jqueryui wingsDnd wings) xform)";
			if (expr != null) {
				page = expr;
			}
			pe.run(page, response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
	
	public static void main(String[] args) {
		try {
			File f = new File("C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/grid/WEB-INF/lib/yacsh-0.0.1-SNAPSHOT.jar");
			System.out.println(f.exists());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
