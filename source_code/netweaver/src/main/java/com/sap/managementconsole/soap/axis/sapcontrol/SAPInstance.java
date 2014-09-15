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
package com.sap.managementconsole.soap.axis.sapcontrol;

/**
 * SAPInstance.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPInstance  implements java.io.Serializable {
    private java.lang.String hostname;
    private int instanceNr;
    private int httpPort;
    private int httpsPort;
    private java.lang.String startPriority;
    private java.lang.String features;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public SAPInstance() {
    }

    public SAPInstance(
           java.lang.String hostname,
           int instanceNr,
           int httpPort,
           int httpsPort,
           java.lang.String startPriority,
           java.lang.String features,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.hostname = hostname;
           this.instanceNr = instanceNr;
           this.httpPort = httpPort;
           this.httpsPort = httpsPort;
           this.startPriority = startPriority;
           this.features = features;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the hostname value for this SAPInstance.
     * 
     * @return hostname
     */
    public java.lang.String getHostname() {
        return hostname;
    }


    /**
     * Sets the hostname value for this SAPInstance.
     * 
     * @param hostname
     */
    public void setHostname(java.lang.String hostname) {
        this.hostname = hostname;
    }


    /**
     * Gets the instanceNr value for this SAPInstance.
     * 
     * @return instanceNr
     */
    public int getInstanceNr() {
        return instanceNr;
    }


    /**
     * Sets the instanceNr value for this SAPInstance.
     * 
     * @param instanceNr
     */
    public void setInstanceNr(int instanceNr) {
        this.instanceNr = instanceNr;
    }


    /**
     * Gets the httpPort value for this SAPInstance.
     * 
     * @return httpPort
     */
    public int getHttpPort() {
        return httpPort;
    }


    /**
     * Sets the httpPort value for this SAPInstance.
     * 
     * @param httpPort
     */
    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }


    /**
     * Gets the httpsPort value for this SAPInstance.
     * 
     * @return httpsPort
     */
    public int getHttpsPort() {
        return httpsPort;
    }


    /**
     * Sets the httpsPort value for this SAPInstance.
     * 
     * @param httpsPort
     */
    public void setHttpsPort(int httpsPort) {
        this.httpsPort = httpsPort;
    }


    /**
     * Gets the startPriority value for this SAPInstance.
     * 
     * @return startPriority
     */
    public java.lang.String getStartPriority() {
        return startPriority;
    }


    /**
     * Sets the startPriority value for this SAPInstance.
     * 
     * @param startPriority
     */
    public void setStartPriority(java.lang.String startPriority) {
        this.startPriority = startPriority;
    }


    /**
     * Gets the features value for this SAPInstance.
     * 
     * @return features
     */
    public java.lang.String getFeatures() {
        return features;
    }


    /**
     * Sets the features value for this SAPInstance.
     * 
     * @param features
     */
    public void setFeatures(java.lang.String features) {
        this.features = features;
    }


    /**
     * Gets the dispstatus value for this SAPInstance.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this SAPInstance.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SAPInstance)) return false;
        SAPInstance other = (SAPInstance) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hostname==null && other.getHostname()==null) || 
             (this.hostname!=null &&
              this.hostname.equals(other.getHostname()))) &&
            this.instanceNr == other.getInstanceNr() &&
            this.httpPort == other.getHttpPort() &&
            this.httpsPort == other.getHttpsPort() &&
            ((this.startPriority==null && other.getStartPriority()==null) || 
             (this.startPriority!=null &&
              this.startPriority.equals(other.getStartPriority()))) &&
            ((this.features==null && other.getFeatures()==null) || 
             (this.features!=null &&
              this.features.equals(other.getFeatures()))) &&
            ((this.dispstatus==null && other.getDispstatus()==null) || 
             (this.dispstatus!=null &&
              this.dispstatus.equals(other.getDispstatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHostname() != null) {
            _hashCode += getHostname().hashCode();
        }
        _hashCode += getInstanceNr();
        _hashCode += getHttpPort();
        _hashCode += getHttpsPort();
        if (getStartPriority() != null) {
            _hashCode += getStartPriority().hashCode();
        }
        if (getFeatures() != null) {
            _hashCode += getFeatures().hashCode();
        }
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SAPInstance.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "SAPInstance"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanceNr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanceNr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("httpPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "httpPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("httpsPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "httpsPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startPriority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startPriority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("features");
        elemField.setXmlName(new javax.xml.namespace.QName("", "features"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
