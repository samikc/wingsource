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
package org.wingsource.plugin.sexp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.wingsource.plugin.sexp.antlr.SexpLexer;
import org.wingsource.plugin.sexp.antlr.SexpParser;

/**
 * @author vpillai
 *
 */
public class Operation implements Serializable {
	private static final Logger logger=Logger.getLogger(Operation.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2476513140728522208L;
	private static final String TOKEN_OPERATION = "OPERATION";
	
	private String operator;
	private List<Operand<?>> operands;
	
	/**
	 * Empty Constructor
	 * 
	 */
	public Operation() {}
	
	/**
	 * Translates S-Expression into an Operation Tree
	 * 
	 * @param sexpr
	 * @throws IOException
	 * @throws RecognitionException
	 */
	public static Operation toOperation(String sexpr) throws IOException, RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(sexpr.getBytes()));
		SexpLexer lexer = new SexpLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SexpParser parser = new SexpParser(tokens);
		SexpParser.sexpr_return result = parser.sexpr();
		CommonTree tree = (CommonTree) result.getTree();
		Operation op = new Operation();
		logger.info(tree.getText() + " count:" + tree.getChildCount());
		int numberOfChildren = tree.getChildCount();
		for(int i = 0; i < numberOfChildren; i++) {
			Tree child = tree.getChild(i);
		}
		if(tree!=null && tree.getText().equalsIgnoreCase(TOKEN_OPERATION)) { 
			logger.info(""+tree.getChildCount());
		}
		logger.info("done");
		return op;
	}
	
	public Operation(String operator, Operand<?>... operands) {
		this.operator(operator);
		this.operand(operands);
	}
	
	/**
	 * Gets the operator of this operation
	 * 
	 * @return
	 */
	public String operator() {
		return this.operator;
	}
	
	/**
	 * Sets the operator of this operation
	 * 
	 * @param operator
	 */
	public void operator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Returns list of operands of this operation
	 * 
	 * @return
	 */
	public List<Operand<?>> operands() {
		List<Operand<?>> list = this.operands != null ? 
								Collections.unmodifiableList(this.operands) : 
								Collections.<Operand<?>>emptyList();
		return list;
	}
	
	/**
	 * Sets operands. 
	 * 
	 * @param values varargs
	 */
	public void operand(Operand<?>... values) {
		if(this.operands == null) {
			this.operands = new ArrayList<Operand<?>>();
		}
		for(Operand<?> value: values) {
			this.operands.add(value);
		}
	}
	
	/**
	 * Sets operator as null and clears list of operands.
	 * 
	 */
	public void clear() {
		this.operator = null;
		if(this.operands != null) {
			this.operands.clear();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			Operation opn = Operation.toOperation("add g1 g2 g3");
			Operation o = new Operation();
			Operand<Operation> op = new Operand<Operation>(o);
			
			opn.operand(op, new Operand<String>("Vinod"));
			
			for(Operand<?> operand: opn.operands()) {
				System.out.println(operand.type());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
