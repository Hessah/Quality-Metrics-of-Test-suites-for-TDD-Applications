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
 * InstanceServiceOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class InstanceServiceOperation  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.OperationCode mOperationCode;
    private com.sap.managementconsole.soap.axis.saphostcontrol.TargetService mTargetService;

    public InstanceServiceOperation() {
    }

    public InstanceServiceOperation(
           com.sap.managementconsole.soap.axis.saphostcontrol.OperationCode mOperationCode,
           com.sap.managementconsole.soap.axis.saphostcontrol.TargetService mTargetService) {
           this.mOperationCode = mOperationCode;
           this.mTargetService = mTargetService;
    }


    /**
     * Gets the mOperationCode value for this InstanceServiceOperation.
     * 
     * @return mOperationCode
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationCode getMOperationCode() {
        return mOperationCode;
    }


    /**
     * Sets the mOperationCode value for this InstanceServiceOperation.
     * 
     * @param mOperationCode
     */
    public void setMOperationCode(com.sap.managementconsole.soap.axis.saphostcontrol.OperationCode mOperationCode) {
        this.mOperationCode = mOperationCode;
    }


    /**
     * Gets the mTargetService value for this InstanceServiceOperation.
     * 
     * @return mTargetService
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.TargetService getMTargetService() {
        return mTargetService;
    }


    /**
     * Sets the mTargetService value for this InstanceServiceOperation.
     * 
     * @param mTargetService
     */
    public void setMTargetService(com.sap.managementconsole.soap.axis.saphostcontrol.TargetService mTargetService) {
        this.mTargetService = mTargetService;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstanceServiceOperation)) return false;
        InstanceServiceOperation other = (InstanceServiceOperation) obj;
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
            ((this.mTargetService==null && other.getMTargetService()==null) || 
             (this.mTargetService!=null &&
              this.mTargetService.equals(other.getMTargetService())));
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
        if (getMTargetService() != null) {
            _hashCode += getMTargetService().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InstanceServiceOperation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceServiceOperation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOperationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mOperationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationCode"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MTargetService");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mTargetService"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "TargetService"));
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
