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
package com.sap.netweaver.porta.core.nw7;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.CoreModule;

public abstract class CoreModuleImpl implements CoreModule {
	
	protected AuthenticationCallback callback;
	
	protected String host;
	protected int instNr;
	
	public CoreModuleImpl(String host, int instNr) {
		this.host = host;
		this.instNr = instNr;
	}

	public void setAuthenticationCallback(AuthenticationCallback callback) {
		this.callback = callback;
	}
	
	protected abstract void initialize() throws CoreException;
	
	protected abstract boolean initialized();
	
	protected void checkInitialized() throws CoreException {
		if (!initialized()) {
			initialize();
		}
	}

}
