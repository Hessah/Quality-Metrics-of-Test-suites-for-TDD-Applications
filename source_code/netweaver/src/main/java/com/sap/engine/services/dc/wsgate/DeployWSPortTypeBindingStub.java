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
 * DeployWSPortTypeBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public class DeployWSPortTypeBindingStub extends org.apache.axis.client.Stub implements com.sap.engine.services.dc.wsgate.DeployWSPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("start");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "apps"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"), com.sap.engine.services.dc.wsgate.Application[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.Application[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("stop");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "apps"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"), com.sap.engine.services.dc.wsgate.Application[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.Application[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getVersion");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deploy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "archiveFiles"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "archiveFile"), com.sap.engine.services.dc.wsgate.ArchiveFile[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResult"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.DeployResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getApplications");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.Application[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("undeploy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "apps"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"), com.sap.engine.services.dc.wsgate.Application[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResult"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.DeployResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deployLocal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "archivePaths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"), com.sap.engine.services.dc.wsgate.Option[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResult"));
        oper.setReturnClass(com.sap.engine.services.dc.wsgate.DeployResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"),
                      "com.sap.engine.services.dc.wsgate.DeployFault",
                      new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault"), 
                      true
                     ));
        _operations[6] = oper;

    }

    public DeployWSPortTypeBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DeployWSPortTypeBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DeployWSPortTypeBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Application.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "archiveFile");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.ArchiveFile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deploy");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Deploy.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "DeployFault");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.DeployFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployLocal");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.DeployLocal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployLocalResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.DeployLocalResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.DeployResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResult");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.DeployResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getApplications");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Option[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option");
            qName2 = new javax.xml.namespace.QName("", "options");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getApplicationsResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Application[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getVersion");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.GetVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getVersionResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.GetVersionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Option.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "start");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Start.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "startResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Application[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "stop");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Stop.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "stopResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Application[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "undeploy");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.Undeploy.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "undeployResponse");
            cachedSerQNames.add(qName);
            cls = com.sap.engine.services.dc.wsgate.UndeployResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.sap.engine.services.dc.wsgate.Application[] start(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "start"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apps, options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.Application[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.Application[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.Application[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.engine.services.dc.wsgate.Application[] stop(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "stop"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apps, options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.Application[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.Application[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.Application[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String getVersion() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getVersion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.engine.services.dc.wsgate.DeployResult deploy(com.sap.engine.services.dc.wsgate.ArchiveFile[] archiveFiles, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deploy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {archiveFiles, options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.DeployResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.DeployResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.DeployResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.engine.services.dc.wsgate.Application[] getApplications(com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "getApplications"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.Application[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.Application[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.Application[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.engine.services.dc.wsgate.DeployResult undeploy(com.sap.engine.services.dc.wsgate.Application[] apps, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "undeploy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {apps, options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.DeployResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.DeployResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.DeployResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.engine.services.dc.wsgate.DeployResult deployLocal(java.lang.String[] archivePaths, com.sap.engine.services.dc.wsgate.Option[] options) throws java.rmi.RemoteException, com.sap.engine.services.dc.wsgate.DeployFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployLocal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {archivePaths, options});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.engine.services.dc.wsgate.DeployResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.engine.services.dc.wsgate.DeployResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.engine.services.dc.wsgate.DeployResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.engine.services.dc.wsgate.DeployFault) {
              throw (com.sap.engine.services.dc.wsgate.DeployFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
