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

import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_ServiceLocator;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance;

public class SnippetFindJ2EEInstance {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 1; // J2EE instance
	
	public static void main(String[] args) throws Exception {
		SAPControlPortType control = new SAPControl_ServiceLocator().getSAPControl(getWsUrl());
		SAPInstance[] instances = control.getSystemInstanceList();
		
		System.out.println("Number of SAP instances: " + instances.length);
		System.out.println();
		
		
		for (SAPInstance inst : instances) {
			System.out.println(inst.getHostname() + " " + 
					inst.getInstanceNr() + " " + 
					inst.getHttpPort() + " " + 
					inst.getFeatures() + " " + 
					inst.getDispstatus().toString());
		}
		
		System.out.println();
		
		for (SAPInstance inst : instances) {
			if (inst.getFeatures().indexOf("J2EE") != -1) {
				System.out.println("Instance No. " + inst.getInstanceNr() + " is a J2EE instance. ");
			}
		}
	}
	
	private static URL getWsUrl() throws MalformedURLException {
		int port = 50013 + INST_NR * 100;
		return new URL("http", HOST, port, "/SAPControl.cgi");
	
	}
}
