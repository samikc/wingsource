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
package org.wingsource.plugin.example;

import java.io.IOException;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.engine.PluginEngine;

/**
 * @author samikc
 *
 */
public class MainTest extends TestCase {

	/**
	 * @param args
	 */
	public void testMain() {
		//PluginEngine pe = new PluginEngine(new DummySymbolResolver());
		PluginEngine pe = new PluginEngine();
		try {
			Integer i = (Integer) pe.run("(+ 2 (- 005 -3) 3 (- -6 3))").getResponse();
			System.out.println("Answer: " + i);
			assertTrue(i== 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
