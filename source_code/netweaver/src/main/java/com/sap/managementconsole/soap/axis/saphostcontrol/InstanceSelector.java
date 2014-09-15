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
 * InstanceSelector.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class InstanceSelector  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.InstanceStatus aInstanceStatus;
    private java.lang.String aHostname;

    public InstanceSelector() {
    }

    public InstanceSelector(
           com.sap.managementconsole.soap.axis.saphostcontrol.InstanceStatus aInstanceStatus,
           java.lang.String aHostname) {
           this.aInstanceStatus = aInstanceStatus;
           this.aHostname = aHostname;
    }


    /**
     * Gets the aInstanceStatus value for this InstanceSelector.
     * 
     * @return aInstanceStatus
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.InstanceStatus getAInstanceStatus() {
        return aInstanceStatus;
    }


    /**
     * Sets the aInstanceStatus value for this InstanceSelector.
     * 
     * @param aInstanceStatus
     */
    public void setAInstanceStatus(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceStatus aInstanceStatus) {
        this.aInstanceStatus = aInstanceStatus;
    }


    /**
     * Gets the aHostname value for this InstanceSelector.
     * 
     * @return aHostname
     */
    public java.lang.String getAHostname() {
        return aHostname;
    }


    /**
     * Sets the aHostname value for this InstanceSelector.
     * 
     * @param aHostname
     */
    public void setAHostname(java.lang.String aHostname) {
        this.aHostname = aHostname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstanceSelector)) return false;
        InstanceSelector other = (InstanceSelector) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aInstanceStatus==null && other.getAInstanceStatus()==null) || 
             (this.aInstanceStatus!=null &&
              this.aInstanceStatus.equals(other.getAInstanceStatus()))) &&
            ((this.aHostname==null && other.getAHostname()==null) || 
             (this.aHostname!=null &&
              this.aHostname.equals(other.getAHostname())));
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
        if (getAInstanceStatus() != null) {
            _hashCode += getAInstanceStatus().hashCode();
        }
        if (getAHostname() != null) {
            _hashCode += getAHostname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InstanceSelector.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceSelector"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AInstanceStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aInstanceStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceStatus"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AHostname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aHostname"));
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
