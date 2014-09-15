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
package com.sap.managementconsole.soap.axis.saphostcontrol;

/**
 * SAPHostControl_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPHostControl_ServiceLocator extends org.apache.axis.client.Service implements com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControl_Service {

/**
 * The SAPHostControl support a group of Host specific operations
 * like : Start / Stop an SAP System; Start/Stop a Database; Mount /
 * Unmount of filesystems; Activate/Deactivate ip addresses.
 */

    public SAPHostControl_ServiceLocator() {
    }


    public SAPHostControl_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SAPHostControl_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SAPHostControl
    private java.lang.String SAPHostControl_address = "http://localhost:1128/SAPHostControl.cgi";

    public java.lang.String getSAPHostControlAddress() {
        return SAPHostControl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SAPHostControlWSDDServiceName = "SAPHostControl";

    public java.lang.String getSAPHostControlWSDDServiceName() {
        return SAPHostControlWSDDServiceName;
    }

    public void setSAPHostControlWSDDServiceName(java.lang.String name) {
        SAPHostControlWSDDServiceName = name;
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface getSAPHostControl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SAPHostControl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSAPHostControl(endpoint);
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface getSAPHostControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControl_BindingStub _stub = new com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControl_BindingStub(portAddress, this);
            _stub.setPortName(getSAPHostControlWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSAPHostControlEndpointAddress(java.lang.String address) {
        SAPHostControl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControl_BindingStub _stub = new com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControl_BindingStub(new java.net.URL(SAPHostControl_address), this);
                _stub.setPortName(getSAPHostControlWSDDServiceName());
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
        if ("SAPHostControl".equals(inputPortName)) {
            return getSAPHostControl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:SAPHostControl", "SAPHostControl");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:SAPHostControl", "SAPHostControl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SAPHostControl".equals(portName)) {
            setSAPHostControlEndpointAddress(address);
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
