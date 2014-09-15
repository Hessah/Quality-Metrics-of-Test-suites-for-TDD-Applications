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

import static com.sap.netweaver.porta.core.AuthenticationReason.*;
import static com.sap.netweaver.porta.core.nw7.FaultReasons.*;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class Operation {
	
	private OperationContext context;
	
	public Operation(OperationContext context) {
		this.context = context;
	}
	
	public Object execute() throws NotAuthorizedException, CoreException {
		boolean repeat;
		do {
			repeat = false;
			try {
				context.executeOperation();
			} catch (NotAuthorizedException e) {
				AuthenticationReason reason = getAuthReason(e.getMessage());
				if (reason == null) {
					reason = AUTHORIZATION_REQUIRED;
				}
				getCredentials(reason);
				repeat = true;
			} catch (AxisFault fault) {
				AuthenticationReason reason = getAuthReason(fault.getFaultReason());
				if (reason == null) {
					repeat = context.handleFault(fault);
				} else {
					getCredentials(reason);
					repeat = true;
				}
			} catch (RemoteException e) {
				throw new CoreException(e);
			}
		} while (repeat);
		
		return context.getResult();
	}
	
	private AuthenticationReason getAuthReason(String faultReason) {
		if (FAULT_UNAUTHORIZED.getFaultReason().equals(faultReason)) {
			return AUTHORIZATION_REQUIRED;
		} else if (FAULT_INVALID_CREDENTIALS.getFaultReason().equals(faultReason)) {
			return INVALID_CREDENTIALS;
		} else if (FAULT_PERMISSION_DENIED.getFaultReason().equals(faultReason)) {
			return PERMISSION_DENIED;
		} else {
			return null;
		}
	}
	
	private void getCredentials(AuthenticationReason reason) throws NotAuthorizedException, CoreException {
		// Retrieve the authentication callback interface
		AuthenticationCallback callback = context.getAuthenticationCallback();
		if (callback == null) {
			throw new NotAuthorizedException("authorization callback is not provided");
		}
		
		// Retrieve authentication credentials
		Credentials credentials;
		try {
			credentials = callback.getCredentials(reason);
		} catch (AuthenticationRefusedException e) {
			throw new NotAuthorizedException("User has not provided user and password");
		}
		
		// Set the credentials
		context.setCredentials(credentials.getUser(), credentials.getPassword());
	}
	
}
