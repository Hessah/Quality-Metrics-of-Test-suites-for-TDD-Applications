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
 * OperationException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class OperationException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private long mFaultCode;
    private java.lang.String mMessage;
    private java.lang.String mOperationID;
    private com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage[] mResponseMessages;

    public OperationException() {
    }

    public OperationException(
           long mFaultCode,
           java.lang.String mMessage,
           java.lang.String mOperationID,
           com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage[] mResponseMessages) {
        this.mFaultCode = mFaultCode;
        this.mMessage = mMessage;
        this.mOperationID = mOperationID;
        this.mResponseMessages = mResponseMessages;
    }


    /**
     * Gets the mFaultCode value for this OperationException.
     * 
     * @return mFaultCode
     */
    public long getMFaultCode() {
        return mFaultCode;
    }


    /**
     * Sets the mFaultCode value for this OperationException.
     * 
     * @param mFaultCode
     */
    public void setMFaultCode(long mFaultCode) {
        this.mFaultCode = mFaultCode;
    }


    /**
     * Gets the mMessage value for this OperationException.
     * 
     * @return mMessage
     */
    public java.lang.String getMMessage() {
        return mMessage;
    }


    /**
     * Sets the mMessage value for this OperationException.
     * 
     * @param mMessage
     */
    public void setMMessage(java.lang.String mMessage) {
        this.mMessage = mMessage;
    }


    /**
     * Gets the mOperationID value for this OperationException.
     * 
     * @return mOperationID
     */
    public java.lang.String getMOperationID() {
        return mOperationID;
    }


    /**
     * Sets the mOperationID value for this OperationException.
     * 
     * @param mOperationID
     */
    public void setMOperationID(java.lang.String mOperationID) {
        this.mOperationID = mOperationID;
    }


    /**
     * Gets the mResponseMessages value for this OperationException.
     * 
     * @return mResponseMessages
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage[] getMResponseMessages() {
        return mResponseMessages;
    }


    /**
     * Sets the mResponseMessages value for this OperationException.
     * 
     * @param mResponseMessages
     */
    public void setMResponseMessages(com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage[] mResponseMessages) {
        this.mResponseMessages = mResponseMessages;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationException)) return false;
        OperationException other = (OperationException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.mFaultCode == other.getMFaultCode() &&
            ((this.mMessage==null && other.getMMessage()==null) || 
             (this.mMessage!=null &&
              this.mMessage.equals(other.getMMessage()))) &&
            ((this.mOperationID==null && other.getMOperationID()==null) || 
             (this.mOperationID!=null &&
              this.mOperationID.equals(other.getMOperationID()))) &&
            ((this.mResponseMessages==null && other.getMResponseMessages()==null) || 
             (this.mResponseMessages!=null &&
              java.util.Arrays.equals(this.mResponseMessages, other.getMResponseMessages())));
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
        _hashCode += new Long(getMFaultCode()).hashCode();
        if (getMMessage() != null) {
            _hashCode += getMMessage().hashCode();
        }
        if (getMOperationID() != null) {
            _hashCode += getMOperationID().hashCode();
        }
        if (getMResponseMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMResponseMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMResponseMessages(), i);
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
        new org.apache.axis.description.TypeDesc(OperationException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MFaultCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mFaultCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOperationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mOperationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MResponseMessages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mResponseMessages"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ResponseMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
