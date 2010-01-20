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
package org.wingsource.plugin.engine;

import java.io.IOException;
import java.io.OutputStream;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.TypeResolverService;

/**
 * @author samikc
 *
 */
public class PluginEngine {
	TypeResolverService trs;
	PluginServiceManager pMgr;
	public PluginEngine(TypeResolverService trs) {
		super();
		this.trs = trs;
		pMgr = new PluginServiceManager();
	}

	public void run(String expression, OutputStream os) throws IOException, RecognitionException {
		PluginResponse pRes = this.run(expression);
		Object obj = pRes.getResponse();
		String out = obj.toString();
		os.write(out.getBytes());
	}
	
	public PluginResponse run(String expression) throws IOException, RecognitionException {
		return pMgr.execute(expression, trs);
	}
}
