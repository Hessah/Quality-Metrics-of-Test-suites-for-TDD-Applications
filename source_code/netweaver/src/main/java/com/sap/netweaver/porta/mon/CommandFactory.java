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

import static com.sap.netweaver.porta.mon.Command.DEPLOY;
import static com.sap.netweaver.porta.mon.Command.DISABLE_DEBUGGING;
import static com.sap.netweaver.porta.mon.Command.ENABLE_DEBUGGING;
import static com.sap.netweaver.porta.mon.Command.EXIT;
import static com.sap.netweaver.porta.mon.Command.LIST_APPS;
import static com.sap.netweaver.porta.mon.Command.RESTART;
import static com.sap.netweaver.porta.mon.Command.START;
import static com.sap.netweaver.porta.mon.Command.START_APP;
import static com.sap.netweaver.porta.mon.Command.STATE;
import static com.sap.netweaver.porta.mon.Command.STOP;
import static com.sap.netweaver.porta.mon.Command.STOP_APP;
import static com.sap.netweaver.porta.mon.Command.UNDEPLOY;

public class CommandFactory {

	public static Command createCommand(int cmdId) {
		switch (cmdId) {
			case EXIT: 
				return new ExitCommand();
			
			case START:
				return new StartCommand();
			
			case STOP:
				return new StopCommand();
				
			case RESTART:
				return new RestartCommand();
				
			case STATE: 
				return new StateCommand();
				
			case ENABLE_DEBUGGING: 
				return new EnableDebuggingCommand();
				
			case DISABLE_DEBUGGING:
				return new DisableDebuggingCommand();
				
			case DEPLOY: 
				return new DeployCommand();
				
			case UNDEPLOY: 
				return new UndeployCommand();
				
			case LIST_APPS: 
				return new ListAppsCommand();
				
			case START_APP: 
				return new StartAppCommand();
				
			case STOP_APP:
				return new StopAppCommand();
				
			default:
				throw new IllegalArgumentException("command " + cmdId + " is not supported. ");
		}
	}

}
