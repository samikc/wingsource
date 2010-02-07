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

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.engine.PluginEngine;
import org.wingsource.yacsh.spi.YacshModule;

/**
 * @author samikc
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PluginEngine pe = new PluginEngine(new YacshSymbolResolver());
		YacshConfig.init(new YacshModule());
		try {
			pe.run("(page (l g1 g2 100) (l g1 g2 50) (l g1 g2 50) (link CSS wing) (link JS wingjquery) (link JS wingjqueryui))", System.out);
			
			long t1 = System.currentTimeMillis();
			pe.run("(xslt (page (l g1 g2 100) (l g1 g2 50) (l g1 g2 50) (link CSS wing) (link JS wingjquery) (link JS wingjqueryui)) xform)", System.out);
			long t2 = System.currentTimeMillis();
			System.out.println((t2 - t2) + " ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
