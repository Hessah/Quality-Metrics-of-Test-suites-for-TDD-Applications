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
 * OperationOptions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class OperationOptions  implements java.io.Serializable {
    private long mTimeout;
    private com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags[] mOptions;

    public OperationOptions() {
    }

    public OperationOptions(
           long mTimeout,
           com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags[] mOptions) {
           this.mTimeout = mTimeout;
           this.mOptions = mOptions;
    }


    /**
     * Gets the mTimeout value for this OperationOptions.
     * 
     * @return mTimeout
     */
    public long getMTimeout() {
        return mTimeout;
    }


    /**
     * Sets the mTimeout value for this OperationOptions.
     * 
     * @param mTimeout
     */
    public void setMTimeout(long mTimeout) {
        this.mTimeout = mTimeout;
    }


    /**
     * Gets the mOptions value for this OperationOptions.
     * 
     * @return mOptions
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags[] getMOptions() {
        return mOptions;
    }


    /**
     * Sets the mOptions value for this OperationOptions.
     * 
     * @param mOptions
     */
    public void setMOptions(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags[] mOptions) {
        this.mOptions = mOptions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationOptions)) return false;
        OperationOptions other = (OperationOptions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.mTimeout == other.getMTimeout() &&
            ((this.mOptions==null && other.getMOptions()==null) || 
             (this.mOptions!=null &&
              java.util.Arrays.equals(this.mOptions, other.getMOptions())));
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
        _hashCode += new Long(getMTimeout()).hashCode();
        if (getMOptions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMOptions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMOptions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperationOptions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOptions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mOptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceOptionsFlags"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
