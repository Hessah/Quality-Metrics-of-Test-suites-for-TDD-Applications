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
 * Property.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class Property  implements java.io.Serializable {
    private java.lang.String mKey;
    private java.lang.String mValue;

    public Property() {
    }

    public Property(
           java.lang.String mKey,
           java.lang.String mValue) {
           this.mKey = mKey;
           this.mValue = mValue;
    }


    /**
     * Gets the mKey value for this Property.
     * 
     * @return mKey
     */
    public java.lang.String getMKey() {
        return mKey;
    }


    /**
     * Sets the mKey value for this Property.
     * 
     * @param mKey
     */
    public void setMKey(java.lang.String mKey) {
        this.mKey = mKey;
    }


    /**
     * Gets the mValue value for this Property.
     * 
     * @return mValue
     */
    public java.lang.String getMValue() {
        return mValue;
    }


    /**
     * Sets the mValue value for this Property.
     * 
     * @param mValue
     */
    public void setMValue(java.lang.String mValue) {
        this.mValue = mValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Property)) return false;
        Property other = (Property) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mKey==null && other.getMKey()==null) || 
             (this.mKey!=null &&
              this.mKey.equals(other.getMKey()))) &&
            ((this.mValue==null && other.getMValue()==null) || 
             (this.mValue!=null &&
              this.mValue.equals(other.getMValue())));
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
        if (getMKey() != null) {
            _hashCode += getMKey().hashCode();
        }
        if (getMValue() != null) {
            _hashCode += getMValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Property.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "Property"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mValue"));
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
