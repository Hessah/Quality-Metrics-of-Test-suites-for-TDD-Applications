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

import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_ServiceLocator;

public class SnippetJ2EEGetProcessList {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 0; // J2EE instance
	
	public static void main(String[] args) throws Exception {
		SAPControlPortType control = new SAPControl_ServiceLocator().getSAPControl(getWsUrl());
		J2EEProcess[] processes = control.j2EEGetProcessList();
		
		System.out.println("Number of J2EE processes: " + processes.length);
		System.out.println();
		
		for (J2EEProcess p : processes) {
			System.out.println(p.getPid() + " " + p.getName() + " " + p.getStatetext());
		}
	}
	
	private static URL getWsUrl() throws MalformedURLException {
		int port = 50013 + INST_NR * 100;
		return new URL("http", HOST, port, "/SAPControl.cgi");
	}

}
