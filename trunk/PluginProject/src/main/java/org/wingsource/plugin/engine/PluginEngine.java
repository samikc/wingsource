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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.RecognitionException;
import org.wingsource.plugin.PluginRequest;
import org.wingsource.plugin.PluginResponse;
import org.wingsource.plugin.Plugin;
import org.wingsource.plugin.SymbolResolverService;
import org.wingsource.plugin.sexp.Operand;
import org.wingsource.plugin.sexp.Operation;
import org.wingsource.plugin.util.ThreadList;

/**
 * @author samikc
 *
 */
public class PluginEngine {
	private static final Logger logger=Logger.getLogger(Operation.class.getName());
	
	SymbolResolverService srs;
	PluginServiceManager pMgr;
	
	public PluginEngine(SymbolResolverService srs) {
		super();
		this.srs = srs;
		pMgr = new PluginServiceManager();
	}
	
	public PluginEngine() {
		super();
		this.srs = PluginExplorer.instance().getResolver();
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
		return pMgr.execute(operation, srs);
	}

	private class PluginServiceManager {
	
		/**
		 * This class is responsible for resolving an operation to a simple operand. It implements Runnable
		 * so that it could be executed independently in a separate thread.
		 * 
		 * @author vpillai
		 *
		 */
		private class SymbolResolver implements Runnable {
			
			private PluginServiceManager pluginServiceManager;
			private Operand operand;
			private SymbolResolverService srs;
			private PluginResponse pluginResponse = null;
			
			/**
			 * constructor that takes an operand 
			 * 
			 * @param pMgr
			 * @param operand
			 * @param srs
			 */
			public SymbolResolver(PluginServiceManager pMgr, Operand operand, SymbolResolverService srs) {
				this.pluginServiceManager = pMgr;
				this.operand = operand;
				this.srs = srs;
			}

			/**
			 * Invokes execute() method of plugin service manager to resolve a given operation.
			 * 
			 */
			public void run() {
				try {
					switch(this.operand.type()) {
					case ATOM:
						this.pluginResponse = this.pluginServiceManager.execute((String) this.operand.value(), srs);
						break;
					case OPERATION:
						this.pluginResponse = this.pluginServiceManager.execute((Operation)operand.value(), srs);
						break;
					}

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
		/**************************** END OF OperandResolver class *************************************/
		
		public PluginResponse execute(Operation operation,SymbolResolverService srs) throws IOException, RecognitionException {
			
			Plugin pluglet = srs.resolve(operation.operator());
			List<Object> operandList = new ArrayList<Object>();
			ThreadList<SymbolResolver> oList = new ThreadList<SymbolResolver>(operation.operator());
			for (Operand op : operation.operands()) {
				oList.add(new SymbolResolver(this, op, srs));
			}

			oList.execute();
			for(SymbolResolver or : oList) {
				PluginResponse pResponse = or.getResponse();
				operandList.add(pResponse.getResponse());
			}
			
			PluginRequest pRequest = new Request();
			pRequest.setAttribute(PluginRequest.ID, operation.operator());
			pRequest.setAttribute(PluginRequest.OPERANDS, operandList);
			PluginResponse presponse = new Response(null);
			pluglet.init();
			pluglet.service(pRequest, presponse);
			pluglet.destroy();
			return presponse;
		}

		public PluginResponse execute(String symbol,SymbolResolverService srs) throws IOException, RecognitionException {
			
			Plugin pluglet = srs.resolve(symbol);
			PluginResponse presponse = new Response(null);
			if (pluglet == null) {
				presponse.setResponse(symbol);
				return presponse;
			}
			PluginRequest pRequest = new Request();
			pRequest.setAttribute(PluginRequest.ID, symbol);
			pluglet.init();
			pluglet.service(pRequest, presponse);
			pluglet.destroy();
			return presponse;
		}
	}
	
	/**************************** END OF PluginServiceManager class *************************************/	
}