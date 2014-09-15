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
package com.sap.netweaver.porta.ide.eclipse.server.control;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.ide.eclipse.server.ui.dialogs.LoginDialog;

public class AuthCallback implements AuthenticationCallback {

	private boolean isStartStop;
	private String defaultUser;

	public AuthCallback(boolean isStartStop, String defaultUser) {
		super();
		this.isStartStop = isStartStop;
		this.defaultUser = defaultUser;
	}

	public Credentials getCredentials(final AuthenticationReason reason)
			throws CoreException, AuthenticationRefusedException {
	  
		String message;
		switch (reason) {
			case AUTHORIZATION_REQUIRED:
				if (isStartStop) {
					message = "SAP System Administrator credentials needed. ";
				} else {
					message = "Administrator credentials needed. ";
				}
				break;
				
			case INVALID_CREDENTIALS:
				message = "Invalid credentials. ";
				break;
				
			case PERMISSION_DENIED:
				message = "Permission Denied. ";
				break;
				
			default:
				throw new IllegalArgumentException(reason.toString());
		}
		
		Display display = Display.getDefault();
		ShowDialogRunnable runnable = new ShowDialogRunnable(display, message);
		display.syncExec(runnable);
		Credentials credentials = runnable.getCredentials();
		
		if (credentials == null) {
			throw new AuthenticationRefusedException();
		}
		
		return credentials;
	}
	
	private class ShowDialogRunnable implements Runnable {
		
		private Display display;
		private String message;
		
		private Credentials credentials;
		
		public ShowDialogRunnable(Display display, String message) {
			this.display = display;
			this.message = message;
		}

		public void run() {
			Shell shell = display.getActiveShell();
			
			LoginDialog ld = new LoginDialog(shell, getTitle(), message, defaultUser);
			int open = ld.open();
			
			if (open == IDialogConstants.CANCEL_ID) {
				credentials = null;
			} else if (open == IDialogConstants.OK_ID) {
				credentials = new Credentials(ld.getUsername(), ld.getPassword());
			} else {
				credentials = null;
			}
			
		}
		
		public Credentials getCredentials() {
			return credentials;
		}
		
		private String getTitle() {
			if (isStartStop) {
				return "System authorization required";
			} else {
				return "Authorization required";
			}
		}
		
	}
}
