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
 * DatabaseComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class DatabaseComponent  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mProperties;
    private com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus;

    public DatabaseComponent() {
    }

    public DatabaseComponent(
           com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mProperties,
           com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus) {
           this.mProperties = mProperties;
           this.mStatus = mStatus;
    }


    /**
     * Gets the mProperties value for this DatabaseComponent.
     * 
     * @return mProperties
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.Property[] getMProperties() {
        return mProperties;
    }


    /**
     * Sets the mProperties value for this DatabaseComponent.
     * 
     * @param mProperties
     */
    public void setMProperties(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mProperties) {
        this.mProperties = mProperties;
    }


    /**
     * Gets the mStatus value for this DatabaseComponent.
     * 
     * @return mStatus
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus getMStatus() {
        return mStatus;
    }


    /**
     * Sets the mStatus value for this DatabaseComponent.
     * 
     * @param mStatus
     */
    public void setMStatus(com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus) {
        this.mStatus = mStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatabaseComponent)) return false;
        DatabaseComponent other = (DatabaseComponent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mProperties==null && other.getMProperties()==null) || 
             (this.mProperties!=null &&
              java.util.Arrays.equals(this.mProperties, other.getMProperties()))) &&
            ((this.mStatus==null && other.getMStatus()==null) || 
             (this.mStatus!=null &&
              this.mStatus.equals(other.getMStatus())));
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
        if (getMProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMStatus() != null) {
            _hashCode += getMStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatabaseComponent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseComponent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "Property"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseStatus"));
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
