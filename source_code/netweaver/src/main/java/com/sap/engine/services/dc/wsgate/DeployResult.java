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
package com.sap.engine.services.dc.wsgate;

/**
 * DeployResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public class DeployResult  implements java.io.Serializable {
    private com.sap.engine.services.dc.wsgate.Application[] applications;

    private java.lang.String status;

    private java.lang.String statusDetails;

    public DeployResult() {
    }

    public DeployResult(
           com.sap.engine.services.dc.wsgate.Application[] applications,
           java.lang.String status,
           java.lang.String statusDetails) {
           this.applications = applications;
           this.status = status;
           this.statusDetails = statusDetails;
    }


    /**
     * Gets the applications value for this DeployResult.
     * 
     * @return applications
     */
    public com.sap.engine.services.dc.wsgate.Application[] getApplications() {
        return applications;
    }


    /**
     * Sets the applications value for this DeployResult.
     * 
     * @param applications
     */
    public void setApplications(com.sap.engine.services.dc.wsgate.Application[] applications) {
        this.applications = applications;
    }

    public com.sap.engine.services.dc.wsgate.Application getApplications(int i) {
        return this.applications[i];
    }

    public void setApplications(int i, com.sap.engine.services.dc.wsgate.Application _value) {
        this.applications[i] = _value;
    }


    /**
     * Gets the status value for this DeployResult.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DeployResult.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the statusDetails value for this DeployResult.
     * 
     * @return statusDetails
     */
    public java.lang.String getStatusDetails() {
        return statusDetails;
    }


    /**
     * Sets the statusDetails value for this DeployResult.
     * 
     * @param statusDetails
     */
    public void setStatusDetails(java.lang.String statusDetails) {
        this.statusDetails = statusDetails;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeployResult)) return false;
        DeployResult other = (DeployResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applications==null && other.getApplications()==null) || 
             (this.applications!=null &&
              java.util.Arrays.equals(this.applications, other.getApplications()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusDetails==null && other.getStatusDetails()==null) || 
             (this.statusDetails!=null &&
              this.statusDetails.equals(other.getStatusDetails())));
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
        if (getApplications() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getApplications());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getApplications(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusDetails() != null) {
            _hashCode += getStatusDetails().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeployResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applications");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applications"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "application"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
