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
 * DeployLocal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public class DeployLocal  implements java.io.Serializable {
    private java.lang.String[] archivePaths;

    private com.sap.engine.services.dc.wsgate.Option[] options;

    public DeployLocal() {
    }

    public DeployLocal(
           java.lang.String[] archivePaths,
           com.sap.engine.services.dc.wsgate.Option[] options) {
           this.archivePaths = archivePaths;
           this.options = options;
    }


    /**
     * Gets the archivePaths value for this DeployLocal.
     * 
     * @return archivePaths
     */
    public java.lang.String[] getArchivePaths() {
        return archivePaths;
    }


    /**
     * Sets the archivePaths value for this DeployLocal.
     * 
     * @param archivePaths
     */
    public void setArchivePaths(java.lang.String[] archivePaths) {
        this.archivePaths = archivePaths;
    }

    public java.lang.String getArchivePaths(int i) {
        return this.archivePaths[i];
    }

    public void setArchivePaths(int i, java.lang.String _value) {
        this.archivePaths[i] = _value;
    }


    /**
     * Gets the options value for this DeployLocal.
     * 
     * @return options
     */
    public com.sap.engine.services.dc.wsgate.Option[] getOptions() {
        return options;
    }


    /**
     * Sets the options value for this DeployLocal.
     * 
     * @param options
     */
    public void setOptions(com.sap.engine.services.dc.wsgate.Option[] options) {
        this.options = options;
    }

    public com.sap.engine.services.dc.wsgate.Option getOptions(int i) {
        return this.options[i];
    }

    public void setOptions(int i, com.sap.engine.services.dc.wsgate.Option _value) {
        this.options[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeployLocal)) return false;
        DeployLocal other = (DeployLocal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.archivePaths==null && other.getArchivePaths()==null) || 
             (this.archivePaths!=null &&
              java.util.Arrays.equals(this.archivePaths, other.getArchivePaths()))) &&
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              java.util.Arrays.equals(this.options, other.getOptions())));
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
        if (getArchivePaths() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivePaths());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivePaths(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOptions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOptions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOptions(), i);
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
        new org.apache.axis.description.TypeDesc(DeployLocal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "deployLocal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivePaths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivePaths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://sap.com/2009/11/24/deployws", "option"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
