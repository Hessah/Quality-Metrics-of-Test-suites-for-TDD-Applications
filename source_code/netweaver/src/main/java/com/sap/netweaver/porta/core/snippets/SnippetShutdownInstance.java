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

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.Stub;

import com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_ServiceLocator;

public class SnippetShutdownInstance {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 1; // J2EE instance
	
	public static final String USER = "user";
	public static final String PASS = "pass";
	
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

		// Add authentication to the SOAP message
		addAuthentication(control, USER, PASS);
		
		// Shutdown the instance
		control.shutdown(0);
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
	
	private static void addAuthentication(SAPControlPortType control, String user, String pass) {
		Stub stub = (Stub) control;
		stub._setProperty(Stub.USERNAME_PROPERTY, user);
		stub._setProperty(Stub.PASSWORD_PROPERTY, pass);
	}

}
