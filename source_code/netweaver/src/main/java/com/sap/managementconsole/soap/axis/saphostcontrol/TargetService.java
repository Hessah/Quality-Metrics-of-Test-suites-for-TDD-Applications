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
 * TargetService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class TargetService  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType mServiceType;
    private com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier mServiceIdentifier;

    public TargetService() {
    }

    public TargetService(
           com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType mServiceType,
           com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier mServiceIdentifier) {
           this.mServiceType = mServiceType;
           this.mServiceIdentifier = mServiceIdentifier;
    }


    /**
     * Gets the mServiceType value for this TargetService.
     * 
     * @return mServiceType
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType getMServiceType() {
        return mServiceType;
    }


    /**
     * Sets the mServiceType value for this TargetService.
     * 
     * @param mServiceType
     */
    public void setMServiceType(com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType mServiceType) {
        this.mServiceType = mServiceType;
    }


    /**
     * Gets the mServiceIdentifier value for this TargetService.
     * 
     * @return mServiceIdentifier
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier getMServiceIdentifier() {
        return mServiceIdentifier;
    }


    /**
     * Sets the mServiceIdentifier value for this TargetService.
     * 
     * @param mServiceIdentifier
     */
    public void setMServiceIdentifier(com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier mServiceIdentifier) {
        this.mServiceIdentifier = mServiceIdentifier;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TargetService)) return false;
        TargetService other = (TargetService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mServiceType==null && other.getMServiceType()==null) || 
             (this.mServiceType!=null &&
              this.mServiceType.equals(other.getMServiceType()))) &&
            ((this.mServiceIdentifier==null && other.getMServiceIdentifier()==null) || 
             (this.mServiceIdentifier!=null &&
              this.mServiceIdentifier.equals(other.getMServiceIdentifier())));
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
        if (getMServiceType() != null) {
            _hashCode += getMServiceType().hashCode();
        }
        if (getMServiceIdentifier() != null) {
            _hashCode += getMServiceIdentifier().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TargetService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "TargetService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MServiceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mServiceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ServiceType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MServiceIdentifier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mServiceIdentifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ServiceIdentifier"));
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
