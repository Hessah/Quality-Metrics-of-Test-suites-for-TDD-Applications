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

public class DeployWSPortTypeProxy implements com.sap.engine.services.dc.wsgate.DeployWSPortType {
  private String _endpoint = null;
  private com.sap.engine.services.dc.wsgate.DeployWSPortType deployWSPortType = null;
  
  public DeployWSPortTypeProxy() {
    _initDeployWSPortTypeProxy();
  }
  
  public DeployWSPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initDeployWSPortTypeProxy();
  }
  
  private void _initDeployWSPortTypeProxy() {
    try {
      deployWSPortType = (new com.sap.engine.services.dc.wsgate.DeployWSServiceLocator()).getDeployWSPort();
      if (deployWSPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)deployWSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)deployWSPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (deployWSPortType != null)
      ((javax.xml.rpc.Stub)deployWSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sap.engine.services.dc.wsgate.DeployWSPortType getDeployWSPortType() {
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType;
  }
  
  public com.sap.engine.services.dc.wsgate.Application[] start(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.start(apps, options);
  }
  
  public com.sap.engine.services.dc.wsgate.Application[] stop(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.stop(apps, options);
  }
  
  public java.lang.String getVersion() throws java.rmi.RemoteException{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.getVersion();
  }
  
  public com.sap.engine.services.dc.wsgate.DeployResult deploy(com.sap.engine.services.dc.wsgate.ArchiveFile[] archiveFiles, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.deploy(archiveFiles, options);
  }
  
  public com.sap.engine.services.dc.wsgate.Application[] getApplications(com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.getApplications(options);
  }
  
  public com.sap.engine.services.dc.wsgate.DeployResult undeploy(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.undeploy(apps, options);
  }
  
  public com.sap.engine.services.dc.wsgate.DeployResult deployLocal(java.lang.String[] archivePaths, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault{
    if (deployWSPortType == null)
      _initDeployWSPortTypeProxy();
    return deployWSPortType.deployLocal(archivePaths, options);
  }
  
  
}