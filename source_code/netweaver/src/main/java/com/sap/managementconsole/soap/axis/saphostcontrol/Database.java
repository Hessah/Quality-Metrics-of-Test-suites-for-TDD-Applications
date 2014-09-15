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
 * Database.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class Database  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus;
    private com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mDatabase;
    private com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[] mComponents;

    public Database() {
    }

    public Database(
           com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus,
           com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mDatabase,
           com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[] mComponents) {
           this.mStatus = mStatus;
           this.mDatabase = mDatabase;
           this.mComponents = mComponents;
    }


    /**
     * Gets the mStatus value for this Database.
     * 
     * @return mStatus
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus getMStatus() {
        return mStatus;
    }


    /**
     * Sets the mStatus value for this Database.
     * 
     * @param mStatus
     */
    public void setMStatus(com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus mStatus) {
        this.mStatus = mStatus;
    }


    /**
     * Gets the mDatabase value for this Database.
     * 
     * @return mDatabase
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.Property[] getMDatabase() {
        return mDatabase;
    }


    /**
     * Sets the mDatabase value for this Database.
     * 
     * @param mDatabase
     */
    public void setMDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] mDatabase) {
        this.mDatabase = mDatabase;
    }


    /**
     * Gets the mComponents value for this Database.
     * 
     * @return mComponents
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[] getMComponents() {
        return mComponents;
    }


    /**
     * Sets the mComponents value for this Database.
     * 
     * @param mComponents
     */
    public void setMComponents(com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[] mComponents) {
        this.mComponents = mComponents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Database)) return false;
        Database other = (Database) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mStatus==null && other.getMStatus()==null) || 
             (this.mStatus!=null &&
              this.mStatus.equals(other.getMStatus()))) &&
            ((this.mDatabase==null && other.getMDatabase()==null) || 
             (this.mDatabase!=null &&
              java.util.Arrays.equals(this.mDatabase, other.getMDatabase()))) &&
            ((this.mComponents==null && other.getMComponents()==null) || 
             (this.mComponents!=null &&
              java.util.Arrays.equals(this.mComponents, other.getMComponents())));
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
        if (getMStatus() != null) {
            _hashCode += getMStatus().hashCode();
        }
        if (getMDatabase() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMDatabase());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMDatabase(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMComponents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMComponents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMComponents(), i);
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
        new org.apache.axis.description.TypeDesc(Database.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "Database"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseStatus"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MDatabase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mDatabase"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "Property"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MComponents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mComponents"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseComponent"));
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
