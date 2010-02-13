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
package org.wingsource.plugin.lang.sexp;

import java.io.Serializable;

/**
 * @author vpillai
 *
 */
public class Operand<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8896276639053371095L;

	public enum Type {ATOM, OPERATION}; 
	private Type type = Type.ATOM;
	private E value;
	
	public Operand(E value) {
		this.value(value);
	}
	
	/**
	 * Sets the value of this operand
	 * 
	 * @param value
	 */
	public void value(E value) {
		this.value = value;
		this.type = (this.value instanceof Operation) ? Type.OPERATION : Type.ATOM;
	}
	
	/**
	 * gets the value of the operand
	 * 
	 * @return
	 */
	public E value() {
		return this.value;
	}
	
	/**
	 * Returns the type of this operand.
	 * 
	 * @return
	 */
	public Type type() {
		return this.type;
	}
}
