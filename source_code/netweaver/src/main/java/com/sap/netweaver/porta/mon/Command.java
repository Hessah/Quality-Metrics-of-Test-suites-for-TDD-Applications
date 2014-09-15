/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev (SAP AG) - initial API and implementation
 *******************************************************************************/
package com.sap.netweaver.porta.mon;

public abstract class Command {
	
	public static final int EXIT = 0;
	public static final int START = 1;
	public static final int STOP = 2;
	public static final int RESTART = 3;
	public static final int STATE = 4;
	public static final int ENABLE_DEBUGGING = 5;
	public static final int DISABLE_DEBUGGING = 6;
	public static final int DEPLOY = 7;
	public static final int UNDEPLOY = 8;
	public static final int LIST_APPS = 9;
	public static final int START_APP = 10;
	public static final int STOP_APP = 11;
	
	public static final int MIN_ID = EXIT;
	public static final int MAX_ID = STOP_APP;
	
	public static final String LN = System.getProperty("line.separator");
	
	public abstract String execute() throws Exception;

}
