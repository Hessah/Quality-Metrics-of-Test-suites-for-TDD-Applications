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

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.CoreException;

public interface OperationContext {
	
	public void executeOperation() throws CoreException, RemoteException;
	
	public Object getResult();
	
	public boolean handleFault(AxisFault fault) throws CoreException;
	
	public AuthenticationCallback getAuthenticationCallback();
	
	public void setCredentials(String user, String password);

}
