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
 * ACOperationArguments.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ACOperationArguments  implements java.io.Serializable {
    private java.lang.String mArgumentsName;
    private java.lang.String mArgumentsValue;

    public ACOperationArguments() {
    }

    public ACOperationArguments(
           java.lang.String mArgumentsName,
           java.lang.String mArgumentsValue) {
           this.mArgumentsName = mArgumentsName;
           this.mArgumentsValue = mArgumentsValue;
    }


    /**
     * Gets the mArgumentsName value for this ACOperationArguments.
     * 
     * @return mArgumentsName
     */
    public java.lang.String getMArgumentsName() {
        return mArgumentsName;
    }


    /**
     * Sets the mArgumentsName value for this ACOperationArguments.
     * 
     * @param mArgumentsName
     */
    public void setMArgumentsName(java.lang.String mArgumentsName) {
        this.mArgumentsName = mArgumentsName;
    }


    /**
     * Gets the mArgumentsValue value for this ACOperationArguments.
     * 
     * @return mArgumentsValue
     */
    public java.lang.String getMArgumentsValue() {
        return mArgumentsValue;
    }


    /**
     * Sets the mArgumentsValue value for this ACOperationArguments.
     * 
     * @param mArgumentsValue
     */
    public void setMArgumentsValue(java.lang.String mArgumentsValue) {
        this.mArgumentsValue = mArgumentsValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ACOperationArguments)) return false;
        ACOperationArguments other = (ACOperationArguments) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mArgumentsName==null && other.getMArgumentsName()==null) || 
             (this.mArgumentsName!=null &&
              this.mArgumentsName.equals(other.getMArgumentsName()))) &&
            ((this.mArgumentsValue==null && other.getMArgumentsValue()==null) || 
             (this.mArgumentsValue!=null &&
              this.mArgumentsValue.equals(other.getMArgumentsValue())));
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
        if (getMArgumentsName() != null) {
            _hashCode += getMArgumentsName().hashCode();
        }
        if (getMArgumentsValue() != null) {
            _hashCode += getMArgumentsValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ACOperationArguments.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationArguments"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MArgumentsName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mArgumentsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MArgumentsValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mArgumentsValue"));
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
