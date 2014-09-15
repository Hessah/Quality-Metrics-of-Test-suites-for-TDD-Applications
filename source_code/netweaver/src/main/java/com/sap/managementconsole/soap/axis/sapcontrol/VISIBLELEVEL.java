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
package com.sap.managementconsole.soap.axis.sapcontrol;

/**
 * VISIBLELEVEL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class VISIBLELEVEL implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected VISIBLELEVEL(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "SAPControl-UNKNOWN";
    public static final java.lang.String _value2 = "SAPControl-OPERATOR";
    public static final java.lang.String _value3 = "SAPControl-EXPERT";
    public static final java.lang.String _value4 = "SAPControl-DEVELOPER";
    public static final VISIBLELEVEL value1 = new VISIBLELEVEL(_value1);
    public static final VISIBLELEVEL value2 = new VISIBLELEVEL(_value2);
    public static final VISIBLELEVEL value3 = new VISIBLELEVEL(_value3);
    public static final VISIBLELEVEL value4 = new VISIBLELEVEL(_value4);
    public java.lang.String getValue() { return _value_;}
    public static VISIBLELEVEL fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        VISIBLELEVEL enumeration = (VISIBLELEVEL)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static VISIBLELEVEL fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(VISIBLELEVEL.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "VISIBLE-LEVEL"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
