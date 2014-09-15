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
 * AlertNode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class AlertNode  implements java.io.Serializable {
    private java.lang.String name;
    private int parent;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR actualValue;
    private java.lang.String description;
    private java.lang.String time;
    private java.lang.String analyseTool;
    private com.sap.managementconsole.soap.axis.sapcontrol.VISIBLELEVEL visibleLevel;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR highAlertValue;
    private java.lang.String alDescription;
    private java.lang.String alTime;
    private java.lang.String tid;

    public AlertNode() {
    }

    public AlertNode(
           java.lang.String name,
           int parent,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR actualValue,
           java.lang.String description,
           java.lang.String time,
           java.lang.String analyseTool,
           com.sap.managementconsole.soap.axis.sapcontrol.VISIBLELEVEL visibleLevel,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR highAlertValue,
           java.lang.String alDescription,
           java.lang.String alTime,
           java.lang.String tid) {
           this.name = name;
           this.parent = parent;
           this.actualValue = actualValue;
           this.description = description;
           this.time = time;
           this.analyseTool = analyseTool;
           this.visibleLevel = visibleLevel;
           this.highAlertValue = highAlertValue;
           this.alDescription = alDescription;
           this.alTime = alTime;
           this.tid = tid;
    }


    /**
     * Gets the name value for this AlertNode.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AlertNode.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the parent value for this AlertNode.
     * 
     * @return parent
     */
    public int getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this AlertNode.
     * 
     * @param parent
     */
    public void setParent(int parent) {
        this.parent = parent;
    }


    /**
     * Gets the actualValue value for this AlertNode.
     * 
     * @return actualValue
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getActualValue() {
        return actualValue;
    }


    /**
     * Sets the actualValue value for this AlertNode.
     * 
     * @param actualValue
     */
    public void setActualValue(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR actualValue) {
        this.actualValue = actualValue;
    }


    /**
     * Gets the description value for this AlertNode.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this AlertNode.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the time value for this AlertNode.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this AlertNode.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the analyseTool value for this AlertNode.
     * 
     * @return analyseTool
     */
    public java.lang.String getAnalyseTool() {
        return analyseTool;
    }


    /**
     * Sets the analyseTool value for this AlertNode.
     * 
     * @param analyseTool
     */
    public void setAnalyseTool(java.lang.String analyseTool) {
        this.analyseTool = analyseTool;
    }


    /**
     * Gets the visibleLevel value for this AlertNode.
     * 
     * @return visibleLevel
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.VISIBLELEVEL getVisibleLevel() {
        return visibleLevel;
    }


    /**
     * Sets the visibleLevel value for this AlertNode.
     * 
     * @param visibleLevel
     */
    public void setVisibleLevel(com.sap.managementconsole.soap.axis.sapcontrol.VISIBLELEVEL visibleLevel) {
        this.visibleLevel = visibleLevel;
    }


    /**
     * Gets the highAlertValue value for this AlertNode.
     * 
     * @return highAlertValue
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getHighAlertValue() {
        return highAlertValue;
    }


    /**
     * Sets the highAlertValue value for this AlertNode.
     * 
     * @param highAlertValue
     */
    public void setHighAlertValue(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR highAlertValue) {
        this.highAlertValue = highAlertValue;
    }


    /**
     * Gets the alDescription value for this AlertNode.
     * 
     * @return alDescription
     */
    public java.lang.String getAlDescription() {
        return alDescription;
    }


    /**
     * Sets the alDescription value for this AlertNode.
     * 
     * @param alDescription
     */
    public void setAlDescription(java.lang.String alDescription) {
        this.alDescription = alDescription;
    }


    /**
     * Gets the alTime value for this AlertNode.
     * 
     * @return alTime
     */
    public java.lang.String getAlTime() {
        return alTime;
    }


    /**
     * Sets the alTime value for this AlertNode.
     * 
     * @param alTime
     */
    public void setAlTime(java.lang.String alTime) {
        this.alTime = alTime;
    }


    /**
     * Gets the tid value for this AlertNode.
     * 
     * @return tid
     */
    public java.lang.String getTid() {
        return tid;
    }


    /**
     * Sets the tid value for this AlertNode.
     * 
     * @param tid
     */
    public void setTid(java.lang.String tid) {
        this.tid = tid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlertNode)) return false;
        AlertNode other = (AlertNode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.parent == other.getParent() &&
            ((this.actualValue==null && other.getActualValue()==null) || 
             (this.actualValue!=null &&
              this.actualValue.equals(other.getActualValue()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.analyseTool==null && other.getAnalyseTool()==null) || 
             (this.analyseTool!=null &&
              this.analyseTool.equals(other.getAnalyseTool()))) &&
            ((this.visibleLevel==null && other.getVisibleLevel()==null) || 
             (this.visibleLevel!=null &&
              this.visibleLevel.equals(other.getVisibleLevel()))) &&
            ((this.highAlertValue==null && other.getHighAlertValue()==null) || 
             (this.highAlertValue!=null &&
              this.highAlertValue.equals(other.getHighAlertValue()))) &&
            ((this.alDescription==null && other.getAlDescription()==null) || 
             (this.alDescription!=null &&
              this.alDescription.equals(other.getAlDescription()))) &&
            ((this.alTime==null && other.getAlTime()==null) || 
             (this.alTime!=null &&
              this.alTime.equals(other.getAlTime()))) &&
            ((this.tid==null && other.getTid()==null) || 
             (this.tid!=null &&
              this.tid.equals(other.getTid())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getParent();
        if (getActualValue() != null) {
            _hashCode += getActualValue().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getAnalyseTool() != null) {
            _hashCode += getAnalyseTool().hashCode();
        }
        if (getVisibleLevel() != null) {
            _hashCode += getVisibleLevel().hashCode();
        }
        if (getHighAlertValue() != null) {
            _hashCode += getHighAlertValue().hashCode();
        }
        if (getAlDescription() != null) {
            _hashCode += getAlDescription().hashCode();
        }
        if (getAlTime() != null) {
            _hashCode += getAlTime().hashCode();
        }
        if (getTid() != null) {
            _hashCode += getTid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlertNode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "AlertNode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ActualValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("analyseTool");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AnalyseTool"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visibleLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VisibleLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "VISIBLE-LEVEL"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highAlertValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "HighAlertValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AlDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AlTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tid"));
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
