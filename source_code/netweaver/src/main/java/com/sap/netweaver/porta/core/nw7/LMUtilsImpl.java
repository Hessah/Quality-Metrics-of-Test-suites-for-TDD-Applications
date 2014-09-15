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

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_ServiceLocator;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance;
import com.sap.netweaver.porta.core.ServerState;

class LMUtilsImpl implements LMUtils {

	public URL getSAPControlWSUrlByPort(String host, int port) throws MalformedURLException {
		return new URL("http", host, port, "/SAPControl.cgi");
	}

	public URL getSAPControlWSUrlByInstance(String host, int instNr) throws MalformedURLException {
		int port = 50013 + instNr * 100;
		return getSAPControlWSUrlByPort(host, port);
	}

	public SAPControlPortType getSAPControlWSProxy(URL wsUrl) throws ServiceException {
		return new SAPControl_ServiceLocator().getSAPControl(wsUrl);
	}

	public SAPControlPortType getSAPControlWSProxyToFirstJ2EEInstance(SAPControlPortType control) throws ServiceException, RemoteException, MalformedURLException {
		// check if the current instance is a J2EE instance
		// retrieve the instance properties
		InstanceProperty[] props = control.getInstanceProperties();
		// look for J2EE Processes property
		for (InstanceProperty prop : props) {
			if ("J2EE Process Table".equals(prop.getProperty())) {
				return control;
			}
		}
		
		// retrieve the list of all instances in the system
		SAPInstance[] instances = control.getSystemInstanceList();
		for (SAPInstance inst : instances) {
			// find the first J2EE instance
			if (inst.getFeatures().indexOf("J2EE") != -1) {
				// determine the sapControlWSUrl
				URL sapControlWSUrl = getSAPControlWSUrlByPort(inst.getHostname(), inst.getHttpPort());
				// initialize the ws proxy to the SAPControl of the J2EE instance
				return getSAPControlWSProxy(sapControlWSUrl);
			}
		}
		
		// no J2EE instance found
		return null;
	}

	public AccessPoint findIcmHttpAccessPoint(SAPControlPortType control) throws RemoteException {
		AccessPoint[] points = control.getAccessPointList();
		for (AccessPoint ap : points) {
			if ("icm".equals(ap.getProcessname()) && "HTTP".equals(ap.getProtocol())) {
				return ap;
			}
		}
		
		throw new IllegalStateException("cannot find the ICM HTTP port");
	}
	
	public ServerState determineServerState(J2EEProcess[] processes) {
		// check if there are any J2EE processes already available
		if (processes == null || processes.length == 0) {
			return ServerState.STOPPED;
		} 
		
		// check if the bootstrap process is running
		if (processes.length == 1 && "J2EE Bootstrap".equals(processes[0].getType())) {
			return ServerState.STARTING;
		}

		// collect the running states of all J2EE processes
		Set<J2EEPSTATE> states = new HashSet<J2EEPSTATE>(processes.length);
		for (J2EEProcess p : processes) {
			if ("J2EE Server".equals(p.getType())) {
				// if there is still a process in Initial state, then the system is still starting
				if ("Initial".equals(p.getStatetext())){
					return ServerState.STARTING;
				} else {
					states.add(p.getState());
				}
			}
		}
		
		// check if there is a process in RUNNING state
		if (states.contains(J2EEPSTATE.value4)) {
			return ServerState.RUNNING;
		// check if all processes are in STOPPED state
		} else if (states.size() == 1 && states.contains(J2EEPSTATE.value1)) {
			return ServerState.STOPPED;
		// check if there is a process in STARTING or CORE-RUNNING state
		} else if (states.contains(J2EEPSTATE.value2) || states.contains(J2EEPSTATE.value3)) {
			return ServerState.STARTING;
		// check if all processes are in STOPPING state
 		} else if (states.size() == 1 && states.contains(J2EEPSTATE.value5)) {
			return ServerState.STOPPING;
		// check if all processes are in STOPPING and STOPPED state
		} else if (states.size() == 2 && states.contains(J2EEPSTATE.value1) && states.contains(J2EEPSTATE.value5)) {
			return ServerState.STOPPING;
		}
		
		return ServerState.UNKNOWN;
	}

}
