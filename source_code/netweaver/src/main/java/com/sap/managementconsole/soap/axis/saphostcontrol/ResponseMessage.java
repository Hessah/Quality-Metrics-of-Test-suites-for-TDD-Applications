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
 * ResponseMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ResponseMessage  implements java.io.Serializable {
    private java.lang.String mMessageKey;
    private java.lang.String mMessageValue;

    public ResponseMessage() {
    }

    public ResponseMessage(
           java.lang.String mMessageKey,
           java.lang.String mMessageValue) {
           this.mMessageKey = mMessageKey;
           this.mMessageValue = mMessageValue;
    }


    /**
     * Gets the mMessageKey value for this ResponseMessage.
     * 
     * @return mMessageKey
     */
    public java.lang.String getMMessageKey() {
        return mMessageKey;
    }


    /**
     * Sets the mMessageKey value for this ResponseMessage.
     * 
     * @param mMessageKey
     */
    public void setMMessageKey(java.lang.String mMessageKey) {
        this.mMessageKey = mMessageKey;
    }


    /**
     * Gets the mMessageValue value for this ResponseMessage.
     * 
     * @return mMessageValue
     */
    public java.lang.String getMMessageValue() {
        return mMessageValue;
    }


    /**
     * Sets the mMessageValue value for this ResponseMessage.
     * 
     * @param mMessageValue
     */
    public void setMMessageValue(java.lang.String mMessageValue) {
        this.mMessageValue = mMessageValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseMessage)) return false;
        ResponseMessage other = (ResponseMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mMessageKey==null && other.getMMessageKey()==null) || 
             (this.mMessageKey!=null &&
              this.mMessageKey.equals(other.getMMessageKey()))) &&
            ((this.mMessageValue==null && other.getMMessageValue()==null) || 
             (this.mMessageValue!=null &&
              this.mMessageValue.equals(other.getMMessageValue())));
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
        if (getMMessageKey() != null) {
            _hashCode += getMMessageKey().hashCode();
        }
        if (getMMessageValue() != null) {
            _hashCode += getMMessageValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ResponseMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MMessageKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mMessageKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MMessageValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mMessageValue"));
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
