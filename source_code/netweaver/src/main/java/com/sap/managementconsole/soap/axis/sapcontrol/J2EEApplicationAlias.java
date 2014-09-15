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
 * J2EEApplicationAlias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEApplicationAlias  implements java.io.Serializable {
    private java.lang.String appName;
    private java.lang.String alias;
    private int totalRequests;
    private java.lang.String appActive;
    private java.lang.String ignoreCookie;

    public J2EEApplicationAlias() {
    }

    public J2EEApplicationAlias(
           java.lang.String appName,
           java.lang.String alias,
           int totalRequests,
           java.lang.String appActive,
           java.lang.String ignoreCookie) {
           this.appName = appName;
           this.alias = alias;
           this.totalRequests = totalRequests;
           this.appActive = appActive;
           this.ignoreCookie = ignoreCookie;
    }


    /**
     * Gets the appName value for this J2EEApplicationAlias.
     * 
     * @return appName
     */
    public java.lang.String getAppName() {
        return appName;
    }


    /**
     * Sets the appName value for this J2EEApplicationAlias.
     * 
     * @param appName
     */
    public void setAppName(java.lang.String appName) {
        this.appName = appName;
    }


    /**
     * Gets the alias value for this J2EEApplicationAlias.
     * 
     * @return alias
     */
    public java.lang.String getAlias() {
        return alias;
    }


    /**
     * Sets the alias value for this J2EEApplicationAlias.
     * 
     * @param alias
     */
    public void setAlias(java.lang.String alias) {
        this.alias = alias;
    }


    /**
     * Gets the totalRequests value for this J2EEApplicationAlias.
     * 
     * @return totalRequests
     */
    public int getTotalRequests() {
        return totalRequests;
    }


    /**
     * Sets the totalRequests value for this J2EEApplicationAlias.
     * 
     * @param totalRequests
     */
    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }


    /**
     * Gets the appActive value for this J2EEApplicationAlias.
     * 
     * @return appActive
     */
    public java.lang.String getAppActive() {
        return appActive;
    }


    /**
     * Sets the appActive value for this J2EEApplicationAlias.
     * 
     * @param appActive
     */
    public void setAppActive(java.lang.String appActive) {
        this.appActive = appActive;
    }


    /**
     * Gets the ignoreCookie value for this J2EEApplicationAlias.
     * 
     * @return ignoreCookie
     */
    public java.lang.String getIgnoreCookie() {
        return ignoreCookie;
    }


    /**
     * Sets the ignoreCookie value for this J2EEApplicationAlias.
     * 
     * @param ignoreCookie
     */
    public void setIgnoreCookie(java.lang.String ignoreCookie) {
        this.ignoreCookie = ignoreCookie;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEApplicationAlias)) return false;
        J2EEApplicationAlias other = (J2EEApplicationAlias) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appName==null && other.getAppName()==null) || 
             (this.appName!=null &&
              this.appName.equals(other.getAppName()))) &&
            ((this.alias==null && other.getAlias()==null) || 
             (this.alias!=null &&
              this.alias.equals(other.getAlias()))) &&
            this.totalRequests == other.getTotalRequests() &&
            ((this.appActive==null && other.getAppActive()==null) || 
             (this.appActive!=null &&
              this.appActive.equals(other.getAppActive()))) &&
            ((this.ignoreCookie==null && other.getIgnoreCookie()==null) || 
             (this.ignoreCookie!=null &&
              this.ignoreCookie.equals(other.getIgnoreCookie())));
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
        if (getAppName() != null) {
            _hashCode += getAppName().hashCode();
        }
        if (getAlias() != null) {
            _hashCode += getAlias().hashCode();
        }
        _hashCode += getTotalRequests();
        if (getAppActive() != null) {
            _hashCode += getAppActive().hashCode();
        }
        if (getIgnoreCookie() != null) {
            _hashCode += getIgnoreCookie().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEApplicationAlias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEApplicationAlias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AppName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Alias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRequests");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TotalRequests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appActive");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AppActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ignoreCookie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IgnoreCookie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
