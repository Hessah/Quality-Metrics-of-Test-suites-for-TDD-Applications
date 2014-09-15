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
 * GCInfo2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class GCInfo2  implements java.io.Serializable {
    private java.lang.String processname;
    private java.lang.String type;
    private java.lang.String reason;
    private java.lang.String startTime;
    private int duration;
    private int cpuTime;
    private long objBytesBefore;
    private long objBytesAfter;
    private long objBytesFreed;
    private long clsBytesBefore;
    private long clsBytesAfter;
    private long clsBytesFreed;
    private long heapSize;
    private int unloadedClasses;
    private long pageFaults;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public GCInfo2() {
    }

    public GCInfo2(
           java.lang.String processname,
           java.lang.String type,
           java.lang.String reason,
           java.lang.String startTime,
           int duration,
           int cpuTime,
           long objBytesBefore,
           long objBytesAfter,
           long objBytesFreed,
           long clsBytesBefore,
           long clsBytesAfter,
           long clsBytesFreed,
           long heapSize,
           int unloadedClasses,
           long pageFaults,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.processname = processname;
           this.type = type;
           this.reason = reason;
           this.startTime = startTime;
           this.duration = duration;
           this.cpuTime = cpuTime;
           this.objBytesBefore = objBytesBefore;
           this.objBytesAfter = objBytesAfter;
           this.objBytesFreed = objBytesFreed;
           this.clsBytesBefore = clsBytesBefore;
           this.clsBytesAfter = clsBytesAfter;
           this.clsBytesFreed = clsBytesFreed;
           this.heapSize = heapSize;
           this.unloadedClasses = unloadedClasses;
           this.pageFaults = pageFaults;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the processname value for this GCInfo2.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this GCInfo2.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the type value for this GCInfo2.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this GCInfo2.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the reason value for this GCInfo2.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this GCInfo2.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the startTime value for this GCInfo2.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this GCInfo2.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the duration value for this GCInfo2.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this GCInfo2.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the cpuTime value for this GCInfo2.
     * 
     * @return cpuTime
     */
    public int getCpuTime() {
        return cpuTime;
    }


    /**
     * Sets the cpuTime value for this GCInfo2.
     * 
     * @param cpuTime
     */
    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }


    /**
     * Gets the objBytesBefore value for this GCInfo2.
     * 
     * @return objBytesBefore
     */
    public long getObjBytesBefore() {
        return objBytesBefore;
    }


    /**
     * Sets the objBytesBefore value for this GCInfo2.
     * 
     * @param objBytesBefore
     */
    public void setObjBytesBefore(long objBytesBefore) {
        this.objBytesBefore = objBytesBefore;
    }


    /**
     * Gets the objBytesAfter value for this GCInfo2.
     * 
     * @return objBytesAfter
     */
    public long getObjBytesAfter() {
        return objBytesAfter;
    }


    /**
     * Sets the objBytesAfter value for this GCInfo2.
     * 
     * @param objBytesAfter
     */
    public void setObjBytesAfter(long objBytesAfter) {
        this.objBytesAfter = objBytesAfter;
    }


    /**
     * Gets the objBytesFreed value for this GCInfo2.
     * 
     * @return objBytesFreed
     */
    public long getObjBytesFreed() {
        return objBytesFreed;
    }


    /**
     * Sets the objBytesFreed value for this GCInfo2.
     * 
     * @param objBytesFreed
     */
    public void setObjBytesFreed(long objBytesFreed) {
        this.objBytesFreed = objBytesFreed;
    }


    /**
     * Gets the clsBytesBefore value for this GCInfo2.
     * 
     * @return clsBytesBefore
     */
    public long getClsBytesBefore() {
        return clsBytesBefore;
    }


    /**
     * Sets the clsBytesBefore value for this GCInfo2.
     * 
     * @param clsBytesBefore
     */
    public void setClsBytesBefore(long clsBytesBefore) {
        this.clsBytesBefore = clsBytesBefore;
    }


    /**
     * Gets the clsBytesAfter value for this GCInfo2.
     * 
     * @return clsBytesAfter
     */
    public long getClsBytesAfter() {
        return clsBytesAfter;
    }


    /**
     * Sets the clsBytesAfter value for this GCInfo2.
     * 
     * @param clsBytesAfter
     */
    public void setClsBytesAfter(long clsBytesAfter) {
        this.clsBytesAfter = clsBytesAfter;
    }


    /**
     * Gets the clsBytesFreed value for this GCInfo2.
     * 
     * @return clsBytesFreed
     */
    public long getClsBytesFreed() {
        return clsBytesFreed;
    }


    /**
     * Sets the clsBytesFreed value for this GCInfo2.
     * 
     * @param clsBytesFreed
     */
    public void setClsBytesFreed(long clsBytesFreed) {
        this.clsBytesFreed = clsBytesFreed;
    }


    /**
     * Gets the heapSize value for this GCInfo2.
     * 
     * @return heapSize
     */
    public long getHeapSize() {
        return heapSize;
    }


    /**
     * Sets the heapSize value for this GCInfo2.
     * 
     * @param heapSize
     */
    public void setHeapSize(long heapSize) {
        this.heapSize = heapSize;
    }


    /**
     * Gets the unloadedClasses value for this GCInfo2.
     * 
     * @return unloadedClasses
     */
    public int getUnloadedClasses() {
        return unloadedClasses;
    }


    /**
     * Sets the unloadedClasses value for this GCInfo2.
     * 
     * @param unloadedClasses
     */
    public void setUnloadedClasses(int unloadedClasses) {
        this.unloadedClasses = unloadedClasses;
    }


    /**
     * Gets the pageFaults value for this GCInfo2.
     * 
     * @return pageFaults
     */
    public long getPageFaults() {
        return pageFaults;
    }


    /**
     * Sets the pageFaults value for this GCInfo2.
     * 
     * @param pageFaults
     */
    public void setPageFaults(long pageFaults) {
        this.pageFaults = pageFaults;
    }


    /**
     * Gets the dispstatus value for this GCInfo2.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this GCInfo2.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GCInfo2)) return false;
        GCInfo2 other = (GCInfo2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.processname==null && other.getProcessname()==null) || 
             (this.processname!=null &&
              this.processname.equals(other.getProcessname()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            this.duration == other.getDuration() &&
            this.cpuTime == other.getCpuTime() &&
            this.objBytesBefore == other.getObjBytesBefore() &&
            this.objBytesAfter == other.getObjBytesAfter() &&
            this.objBytesFreed == other.getObjBytesFreed() &&
            this.clsBytesBefore == other.getClsBytesBefore() &&
            this.clsBytesAfter == other.getClsBytesAfter() &&
            this.clsBytesFreed == other.getClsBytesFreed() &&
            this.heapSize == other.getHeapSize() &&
            this.unloadedClasses == other.getUnloadedClasses() &&
            this.pageFaults == other.getPageFaults() &&
            ((this.dispstatus==null && other.getDispstatus()==null) || 
             (this.dispstatus!=null &&
              this.dispstatus.equals(other.getDispstatus())));
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
        if (getProcessname() != null) {
            _hashCode += getProcessname().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        _hashCode += getDuration();
        _hashCode += getCpuTime();
        _hashCode += new Long(getObjBytesBefore()).hashCode();
        _hashCode += new Long(getObjBytesAfter()).hashCode();
        _hashCode += new Long(getObjBytesFreed()).hashCode();
        _hashCode += new Long(getClsBytesBefore()).hashCode();
        _hashCode += new Long(getClsBytesAfter()).hashCode();
        _hashCode += new Long(getClsBytesFreed()).hashCode();
        _hashCode += new Long(getHeapSize()).hashCode();
        _hashCode += getUnloadedClasses();
        _hashCode += new Long(getPageFaults()).hashCode();
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GCInfo2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "GCInfo2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpuTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cpuTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objBytesBefore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objBytesBefore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objBytesAfter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objBytesAfter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objBytesFreed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objBytesFreed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clsBytesBefore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clsBytesBefore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clsBytesAfter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clsBytesAfter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clsBytesFreed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clsBytesFreed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heapSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "heapSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unloadedClasses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unloadedClasses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageFaults");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageFaults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
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
