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
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Pluglet;
import org.wingsource.plugin.TypeResolverService;
import org.wingsource.plugin.sexp.Operand;
import org.wingsource.plugin.sexp.Operation;

/**
 * @author samikc
 *
 */
public class PluginServiceManager {

	public PluginResponse execute(String expression,TypeResolverService trs) throws IOException, RecognitionException {
		Operation operation = Operation.toOperation(expression);
		Pluglet pServ = trs.resolve(operation.operator());
		List<String> operandList = new ArrayList<String>();
		for (Operand op : operation.operands()) {
			switch(op.type()) {
			case ATOM:
				operandList.add(op.value().toString());
				break;
			case OPERATION:
				PluginResponse pRes = execute(op.value().toString(), trs);
				operandList.add(pRes.getResponse().toString());
				break;
			}
		}
		PluginRequest prequest = new Request();
		prequest.setOperandList(operandList);
		PluginResponse presponse = new Response(null);
		pServ.init();
		pServ.service(prequest, presponse);
		pServ.destroy();
		return presponse;
	}
}
