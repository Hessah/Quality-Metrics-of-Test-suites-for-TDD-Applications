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
package com.sap.engine.services.dc.wsgate;

/**
 * DeployWSPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public interface DeployWSPortType extends java.rmi.Remote {
    public com.sap.engine.services.dc.wsgate.Application[] start(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
    public com.sap.engine.services.dc.wsgate.Application[] stop(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
    public java.lang.String getVersion() throws java.rmi.RemoteException;
    public com.sap.engine.services.dc.wsgate.DeployResult deploy(com.sap.engine.services.dc.wsgate.ArchiveFile[] archiveFiles, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
    public com.sap.engine.services.dc.wsgate.Application[] getApplications(com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
    public com.sap.engine.services.dc.wsgate.DeployResult undeploy(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
    public com.sap.engine.services.dc.wsgate.DeployResult deployLocal(java.lang.String[] archivePaths, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault;
}
