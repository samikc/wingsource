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
package org.wingsource.plugin.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Admin
 *
 */
public class ThreadList<E extends Runnable> implements Iterable <E> {
	private static final Logger logger=Logger.getLogger(ThreadList.class.getName());
	
	private ArrayList<E> rList = new ArrayList<E>();
	private ArrayList<Thread> threadList = new ArrayList<Thread>();
	private boolean joined = false;
	private String name = null;
	
	public ThreadList(String name) {
		this.name = name;
	}
	
	/**
	 * Add runnable instance
	 * 
	 * @param r
	 * @return
	 */
	public boolean add(E r) {
		Thread thread = new Thread(r);
		return this.rList.add(r) && this.threadList.add(thread);
	}
	
	/**
	 * Concurrently execute all threads in this list  
	 * 
	 */
	public void execute() {
//		logger.finest("ThreadList:"+this.name+ " start...");
		for(Thread t: this.threadList) {
			t.start();
		}
		
		try {
			this.join();
		} catch (InterruptedException e) {
			//do Nothing
		}
	}
	
	private void join() throws InterruptedException {
		if(!this.joined) {
//			logger.finest("ThreadList:"+this.name+ " join...");
			for(Thread t: this.threadList) {
				t.join();
			}
			this.joined = true;
		}
	}
	
	/**
	 * Get list of all Runnable instances.
	 * 
	 * @return
	 */
	public Iterator<E> iterator() {
		try {
			//make sure all threads have completed execution 
			this.join();
		} catch (InterruptedException e) {
			//do Nothing
		}
		return this.rList.iterator();
	}
	
	/**
	 * Return name of this thread list
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}
