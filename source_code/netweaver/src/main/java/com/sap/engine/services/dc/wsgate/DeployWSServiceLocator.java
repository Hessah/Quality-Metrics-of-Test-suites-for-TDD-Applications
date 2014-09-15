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
 * DeployWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public class DeployWSServiceLocator extends org.apache.axis.client.Service implements com.sap.engine.services.dc.wsgate.DeployWSService {

    public DeployWSServiceLocator() {
    }


    public DeployWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DeployWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DeployWSPort
    private java.lang.String DeployWSPort_address = "http://10.66.212.71:50000/DeployWSService/DeployWS";

    public java.lang.String getDeployWSPortAddress() {
        return DeployWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DeployWSPortWSDDServiceName = "DeployWSPort";

    public java.lang.String getDeployWSPortWSDDServiceName() {
        return DeployWSPortWSDDServiceName;
    }

    public void setDeployWSPortWSDDServiceName(java.lang.String name) {
        DeployWSPortWSDDServiceName = name;
    }

    public com.sap.engine.services.dc.wsgate.DeployWSPortType getDeployWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DeployWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDeployWSPort(endpoint);
    }

    public com.sap.engine.services.dc.wsgate.DeployWSPortType getDeployWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sap.engine.services.dc.wsgate.DeployWSPortTypeBindingStub _stub = new com.sap.engine.services.dc.wsgate.DeployWSPortTypeBindingStub(portAddress, this);
            _stub.setPortName(getDeployWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDeployWSPortEndpointAddress(java.lang.String address) {
        DeployWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sap.engine.services.dc.wsgate.DeployWSPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sap.engine.services.dc.wsgate.DeployWSPortTypeBindingStub _stub = new com.sap.engine.services.dc.wsgate.DeployWSPortTypeBindingStub(new java.net.URL(DeployWSPort_address), this);
                _stub.setPortName(getDeployWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DeployWSPort".equals(inputPortName)) {
            return getDeployWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DeployWSPort".equals(portName)) {
            setDeployWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
