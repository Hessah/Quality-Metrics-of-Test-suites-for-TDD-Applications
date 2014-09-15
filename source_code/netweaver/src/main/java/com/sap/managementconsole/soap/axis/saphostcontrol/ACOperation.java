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
 * ACOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ACOperation  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationCode mOperationCode;
    private com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments[] mOperationArguments;

    public ACOperation() {
    }

    public ACOperation(
           com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationCode mOperationCode,
           com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments[] mOperationArguments) {
           this.mOperationCode = mOperationCode;
           this.mOperationArguments = mOperationArguments;
    }


    /**
     * Gets the mOperationCode value for this ACOperation.
     * 
     * @return mOperationCode
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationCode getMOperationCode() {
        return mOperationCode;
    }


    /**
     * Sets the mOperationCode value for this ACOperation.
     * 
     * @param mOperationCode
     */
    public void setMOperationCode(com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationCode mOperationCode) {
        this.mOperationCode = mOperationCode;
    }


    /**
     * Gets the mOperationArguments value for this ACOperation.
     * 
     * @return mOperationArguments
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments[] getMOperationArguments() {
        return mOperationArguments;
    }


    /**
     * Sets the mOperationArguments value for this ACOperation.
     * 
     * @param mOperationArguments
     */
    public void setMOperationArguments(com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments[] mOperationArguments) {
        this.mOperationArguments = mOperationArguments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ACOperation)) return false;
        ACOperation other = (ACOperation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mOperationCode==null && other.getMOperationCode()==null) || 
             (this.mOperationCode!=null &&
              this.mOperationCode.equals(other.getMOperationCode()))) &&
            ((this.mOperationArguments==null && other.getMOperationArguments()==null) || 
             (this.mOperationArguments!=null &&
              java.util.Arrays.equals(this.mOperationArguments, other.getMOperationArguments())));
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
        if (getMOperationCode() != null) {
            _hashCode += getMOperationCode().hashCode();
        }
        if (getMOperationArguments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMOperationArguments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMOperationArguments(), i);
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
        new org.apache.axis.description.TypeDesc(ACOperation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOperationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mOperationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationCode"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOperationArguments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mOperationArguments"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationArguments"));
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
