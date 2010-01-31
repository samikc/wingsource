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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Pluglet;
import org.wingsource.plugin.TypeResolverService;
import org.wingsource.plugin.sexp.Operand;
import org.wingsource.plugin.sexp.Operation;
import org.wingsource.plugin.util.ThreadList;

/**
 * @author samikc
 *
 */
public class PluginEngine {
	private static final Logger logger=Logger.getLogger(Operation.class.getName());
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
		Operation operation = Operation.toOperation(expression);
		return pMgr.execute(operation, trs);
	}

	private class PluginServiceManager {
	
		/**
		 * This class is responsible for resolving an operation to a simple operand. It implements Runnable
		 * so that it could be executed independently in a separate thread.
		 * 
		 * @author vpillai
		 *
		 */
		private class OperationResolver implements Runnable {
			
			private PluginServiceManager pluginServiceManager;
			private Operation operation;
			private TypeResolverService trs;
			private PluginResponse pluginResponse = null;
			
			public OperationResolver(PluginServiceManager pMgr, Operation operation, TypeResolverService trs) {
				this.pluginServiceManager = pMgr;
				this.operation = operation;
				this.trs = trs;
			}

			/**
			 * Invokes execute() method of plugin service manager to resolve a given operation.
			 * 
			 */
			public void run() {
				try {
					this.pluginResponse = this.pluginServiceManager.execute(operation, trs);
				} catch (Exception e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
				} 
			}
			
			/**
			 * Return the PluginResponse
			 * 
			 * @return
			 */
			public PluginResponse getResponse() {
				return this.pluginResponse;
			}
		}
		/**************************** END OF OperationResolver class *************************************/
		
		public PluginResponse execute(Operation operation,TypeResolverService trs) throws IOException, RecognitionException {
			
			Pluglet pServ = trs.resolve(operation.operator());
			List<Object> operandList = new ArrayList<Object>();
			ThreadList<OperationResolver> oList = new ThreadList<OperationResolver>(operation.operator());
			for (Operand op : operation.operands()) {
				switch(op.type()) {
				case ATOM:
					operandList.add(op.value());
					break;
				case OPERATION:
					Operation opn = (Operation)op.value();
					oList.add(new OperationResolver(this, opn, trs));
					break;
				}
			}
			oList.execute();
//			logger.finest("Continue " + operation.operator());
			for(OperationResolver or : oList) {
				PluginResponse pResponse = or.getResponse();
				operandList.add(pResponse.getResponse());
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
	
	/**************************** END OF PluginServiceManager class *************************************/
}