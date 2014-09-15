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
 * DatabaseStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class DatabaseStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DatabaseStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "SAPHostControl-DB-UNKNOWN";
    public static final java.lang.String _value2 = "SAPHostControl-DB-STOPPED";
    public static final java.lang.String _value3 = "SAPHostControl-DB-STOPPING";
    public static final java.lang.String _value4 = "SAPHostControl-DB-RUNNING";
    public static final java.lang.String _value5 = "SAPHostControl-DB-STARTING";
    public static final java.lang.String _value6 = "SAPHostControl-DB-WARNING";
    public static final java.lang.String _value7 = "SAPHostControl-DB-INSERVICE";
    public static final java.lang.String _value8 = "SAPHostControl-DB-ERROR";
    public static final java.lang.String _value9 = "SAPHostControl-DB-LAST";
    public static final DatabaseStatus value1 = new DatabaseStatus(_value1);
    public static final DatabaseStatus value2 = new DatabaseStatus(_value2);
    public static final DatabaseStatus value3 = new DatabaseStatus(_value3);
    public static final DatabaseStatus value4 = new DatabaseStatus(_value4);
    public static final DatabaseStatus value5 = new DatabaseStatus(_value5);
    public static final DatabaseStatus value6 = new DatabaseStatus(_value6);
    public static final DatabaseStatus value7 = new DatabaseStatus(_value7);
    public static final DatabaseStatus value8 = new DatabaseStatus(_value8);
    public static final DatabaseStatus value9 = new DatabaseStatus(_value9);
    public java.lang.String getValue() { return _value_;}
    public static DatabaseStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DatabaseStatus enumeration = (DatabaseStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DatabaseStatus fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatabaseStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
