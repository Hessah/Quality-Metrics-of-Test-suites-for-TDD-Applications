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
package com.sap.netweaver.porta.core.mock;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DebugSessionInfo;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.ServerState;

public class LifecycleManagerMock extends CoreModuleMock implements LifecycleManager {
	
	private static final int STARTING_PERIOD = 40000; // 40 sec
	private static final int STOPPING_PERIOD = 10000; // 10 sec
	private static final int DELAY_STARTING_PERIOD = 5000; // 5 sec
	private static final int DELAY_STOPPING_PERIOD = 5000; // 5 sec
	
	private ServerState state = ServerState.STOPPED;
	private long timestamp = 0L;
	
	public void disableDebugging(String key) throws NotAuthorizedException, CoreException {
		// not implemented
	}

	public DebugSessionInfo enableDebugging() throws NotAuthorizedException, CoreException {
		// not implemented
		return null;
	}

	public ServerState getState() throws NotAuthorizedException, CoreException {
		updateState();
		return state;
	}

	public void start() throws NotAuthorizedException, CoreException {
		checkCredentials();
		updateState();
		
		if (state != ServerState.UNKNOWN && 
			state != ServerState.STOPPED) {
			return;
		}
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(DELAY_STARTING_PERIOD);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				state = ServerState.STARTING;
				timestamp = System.currentTimeMillis();
			}
		}.start();
	}
	
	public void restart() throws NotAuthorizedException, CoreException {
		stop();
		
		while (state != ServerState.STOPPED) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new CoreException(e);
			}
		}
		
		start();
	}

	public void stop() throws NotAuthorizedException, CoreException {
		checkCredentials();
		updateState();
		
		if (state == ServerState.UNKNOWN) {
			state = ServerState.STOPPED;
			return;
		}
		
		if (state != ServerState.RUNNING) {
			return;
		}
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(DELAY_STOPPING_PERIOD);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				state = ServerState.STOPPING;
				timestamp = System.currentTimeMillis();
			}
		}.start();
	}

	private boolean isStartingOrStopping() {
		return timestamp != 0L;
	}
	
	private void updateState() {
		if (!isStartingOrStopping()) 
			return;
		
		long ts = System.currentTimeMillis();
		if (state == ServerState.STARTING) {
			if (ts - timestamp > STARTING_PERIOD) {
				state = ServerState.RUNNING;
				timestamp = 0L;
			}
		} else if (state == ServerState.STOPPING) {
			if (ts - timestamp > STOPPING_PERIOD) {
				state = ServerState.STOPPED;
				timestamp = 0L;
			}
		}
	}

}
