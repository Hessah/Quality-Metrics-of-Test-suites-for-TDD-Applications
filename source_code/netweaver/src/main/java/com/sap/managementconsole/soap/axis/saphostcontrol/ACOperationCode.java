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
 * ACOperationCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ACOperationCode implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ACOperationCode(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "AC-OP-MOUNT";
    public static final java.lang.String _value2 = "AC-OP-UMOUNT";
    public static final java.lang.String _value3 = "AC-OP-IFUP";
    public static final java.lang.String _value4 = "AC-OP-IFDOWN";
    public static final java.lang.String _value5 = "AC-OP-LAST";
    public static final ACOperationCode value1 = new ACOperationCode(_value1);
    public static final ACOperationCode value2 = new ACOperationCode(_value2);
    public static final ACOperationCode value3 = new ACOperationCode(_value3);
    public static final ACOperationCode value4 = new ACOperationCode(_value4);
    public static final ACOperationCode value5 = new ACOperationCode(_value5);
    public java.lang.String getValue() { return _value_;}
    public static ACOperationCode fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ACOperationCode enumeration = (ACOperationCode)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ACOperationCode fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ACOperationCode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationCode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
