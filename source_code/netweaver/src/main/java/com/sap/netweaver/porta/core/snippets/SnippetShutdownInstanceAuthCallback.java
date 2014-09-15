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
package com.sap.netweaver.porta.core.snippets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.Stub;

import org.apache.axis.AxisFault;

import com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_ServiceLocator;
import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;

public class SnippetShutdownInstanceAuthCallback {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 1; // J2EE instance
	
	public static final String FAULT_UNAUTHORIZED = "(401)Unauthorized";
	public static final String FAULT_INVALID_CREDENTIALS = "Invalid Credentials";
	
	public static AuthenticationCallback callback = new AuthCallback();
	
	public static void main(String[] args) throws Exception {
		SAPControlPortType control = new SAPControl_ServiceLocator().getSAPControl(getWsUrl());
		J2EEProcess[] processes = control.j2EEGetProcessList();
		
		J2EEProcess p = getFirstServerNode(processes);
		if (p == null) {
			System.out.println("There is no server process found. ");
			return;
		}
		
		if (!p.getState().equals(J2EEPSTATE.value4)) { // RUNNING
			System.out.println(p.getName() + " node is not in Running state: " + p.getStatetext());
			return;
		} 
		
		System.out.println(p.getName() + " is in " + p.getStatetext() + " state. Will now stop it. ");

		// Shutdown the instance
		boolean repeat;
		do {
			repeat = false;
			try {
				control.shutdown(0);
			} catch (AxisFault fault) {
				if (FAULT_UNAUTHORIZED.equals(fault.getFaultReason())) {
					Credentials credentials = callback.getCredentials(AuthenticationReason.AUTHORIZATION_REQUIRED);
					addAuthentication(control, credentials.getUser(), credentials.getPassword());
					repeat = true;
				} else if (FAULT_INVALID_CREDENTIALS.equals(fault.getFaultReason())) {
					Credentials credentials = callback.getCredentials(AuthenticationReason.INVALID_CREDENTIALS);
					addAuthentication(control, credentials.getUser(), credentials.getPassword());
					repeat = true;
				} else {
					throw fault;
				}
			}
		} while (repeat);
	}
	
	private static URL getWsUrl() throws MalformedURLException {
		int port = 50013 + INST_NR * 100;
		return new URL("http", HOST, port, "/SAPControl.cgi");
	}
	
	private static J2EEProcess getFirstServerNode(J2EEProcess[] processes) {
		for (J2EEProcess p : processes) {
			if ("J2EE Server".equals(p.getType())) {
				return p;
			}
		}
		return null;
	}
	
	private static void addAuthentication(SAPControlPortType control, String user, String pass) throws IOException {
		Stub stub = (Stub) control;
		stub._setProperty(Stub.USERNAME_PROPERTY, user);
		stub._setProperty(Stub.PASSWORD_PROPERTY, pass);
	}
	
	private static class AuthCallback implements AuthenticationCallback {

		public Credentials getCredentials(AuthenticationReason reason) throws CoreException {
			switch (reason) {
				case AUTHORIZATION_REQUIRED:
					System.out.println("User and password have not been given yet. Please, give user and password.");
					break;
	
				case INVALID_CREDENTIALS:
					System.out.println("Invalid user and password. Try again.");
					break;
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				System.out.print("User: ");
				String user = in.readLine();
				System.out.print("Pass: ");
				String pass = in.readLine();
				return new Credentials(user, pass);
			} catch (IOException e) {
				throw new CoreException(e);
			}
		}
		
	}

}
