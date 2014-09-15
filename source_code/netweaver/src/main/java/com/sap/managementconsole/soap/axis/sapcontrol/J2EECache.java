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
 * J2EECache.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EECache  implements java.io.Serializable {
    private java.lang.String cachename;
    private java.lang.String processname;
    private java.lang.String type;
    private long size;
    private long attrSize;
    private long keysSize;
    private int cachedObjects;
    private int usedObjects;
    private int puts;
    private int gets;
    private int hits;
    private int changes;
    private int removes;
    private int evictions;
    private int instanceInvalidations;
    private int clusterInvalidations;
    private java.lang.String updateTime;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public J2EECache() {
    }

    public J2EECache(
           java.lang.String cachename,
           java.lang.String processname,
           java.lang.String type,
           long size,
           long attrSize,
           long keysSize,
           int cachedObjects,
           int usedObjects,
           int puts,
           int gets,
           int hits,
           int changes,
           int removes,
           int evictions,
           int instanceInvalidations,
           int clusterInvalidations,
           java.lang.String updateTime,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.cachename = cachename;
           this.processname = processname;
           this.type = type;
           this.size = size;
           this.attrSize = attrSize;
           this.keysSize = keysSize;
           this.cachedObjects = cachedObjects;
           this.usedObjects = usedObjects;
           this.puts = puts;
           this.gets = gets;
           this.hits = hits;
           this.changes = changes;
           this.removes = removes;
           this.evictions = evictions;
           this.instanceInvalidations = instanceInvalidations;
           this.clusterInvalidations = clusterInvalidations;
           this.updateTime = updateTime;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the cachename value for this J2EECache.
     * 
     * @return cachename
     */
    public java.lang.String getCachename() {
        return cachename;
    }


    /**
     * Sets the cachename value for this J2EECache.
     * 
     * @param cachename
     */
    public void setCachename(java.lang.String cachename) {
        this.cachename = cachename;
    }


    /**
     * Gets the processname value for this J2EECache.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EECache.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the type value for this J2EECache.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this J2EECache.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the size value for this J2EECache.
     * 
     * @return size
     */
    public long getSize() {
        return size;
    }


    /**
     * Sets the size value for this J2EECache.
     * 
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }


    /**
     * Gets the attrSize value for this J2EECache.
     * 
     * @return attrSize
     */
    public long getAttrSize() {
        return attrSize;
    }


    /**
     * Sets the attrSize value for this J2EECache.
     * 
     * @param attrSize
     */
    public void setAttrSize(long attrSize) {
        this.attrSize = attrSize;
    }


    /**
     * Gets the keysSize value for this J2EECache.
     * 
     * @return keysSize
     */
    public long getKeysSize() {
        return keysSize;
    }


    /**
     * Sets the keysSize value for this J2EECache.
     * 
     * @param keysSize
     */
    public void setKeysSize(long keysSize) {
        this.keysSize = keysSize;
    }


    /**
     * Gets the cachedObjects value for this J2EECache.
     * 
     * @return cachedObjects
     */
    public int getCachedObjects() {
        return cachedObjects;
    }


    /**
     * Sets the cachedObjects value for this J2EECache.
     * 
     * @param cachedObjects
     */
    public void setCachedObjects(int cachedObjects) {
        this.cachedObjects = cachedObjects;
    }


    /**
     * Gets the usedObjects value for this J2EECache.
     * 
     * @return usedObjects
     */
    public int getUsedObjects() {
        return usedObjects;
    }


    /**
     * Sets the usedObjects value for this J2EECache.
     * 
     * @param usedObjects
     */
    public void setUsedObjects(int usedObjects) {
        this.usedObjects = usedObjects;
    }


    /**
     * Gets the puts value for this J2EECache.
     * 
     * @return puts
     */
    public int getPuts() {
        return puts;
    }


    /**
     * Sets the puts value for this J2EECache.
     * 
     * @param puts
     */
    public void setPuts(int puts) {
        this.puts = puts;
    }


    /**
     * Gets the gets value for this J2EECache.
     * 
     * @return gets
     */
    public int getGets() {
        return gets;
    }


    /**
     * Sets the gets value for this J2EECache.
     * 
     * @param gets
     */
    public void setGets(int gets) {
        this.gets = gets;
    }


    /**
     * Gets the hits value for this J2EECache.
     * 
     * @return hits
     */
    public int getHits() {
        return hits;
    }


    /**
     * Sets the hits value for this J2EECache.
     * 
     * @param hits
     */
    public void setHits(int hits) {
        this.hits = hits;
    }


    /**
     * Gets the changes value for this J2EECache.
     * 
     * @return changes
     */
    public int getChanges() {
        return changes;
    }


    /**
     * Sets the changes value for this J2EECache.
     * 
     * @param changes
     */
    public void setChanges(int changes) {
        this.changes = changes;
    }


    /**
     * Gets the removes value for this J2EECache.
     * 
     * @return removes
     */
    public int getRemoves() {
        return removes;
    }


    /**
     * Sets the removes value for this J2EECache.
     * 
     * @param removes
     */
    public void setRemoves(int removes) {
        this.removes = removes;
    }


    /**
     * Gets the evictions value for this J2EECache.
     * 
     * @return evictions
     */
    public int getEvictions() {
        return evictions;
    }


    /**
     * Sets the evictions value for this J2EECache.
     * 
     * @param evictions
     */
    public void setEvictions(int evictions) {
        this.evictions = evictions;
    }


    /**
     * Gets the instanceInvalidations value for this J2EECache.
     * 
     * @return instanceInvalidations
     */
    public int getInstanceInvalidations() {
        return instanceInvalidations;
    }


    /**
     * Sets the instanceInvalidations value for this J2EECache.
     * 
     * @param instanceInvalidations
     */
    public void setInstanceInvalidations(int instanceInvalidations) {
        this.instanceInvalidations = instanceInvalidations;
    }


    /**
     * Gets the clusterInvalidations value for this J2EECache.
     * 
     * @return clusterInvalidations
     */
    public int getClusterInvalidations() {
        return clusterInvalidations;
    }


    /**
     * Sets the clusterInvalidations value for this J2EECache.
     * 
     * @param clusterInvalidations
     */
    public void setClusterInvalidations(int clusterInvalidations) {
        this.clusterInvalidations = clusterInvalidations;
    }


    /**
     * Gets the updateTime value for this J2EECache.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EECache.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the dispstatus value for this J2EECache.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this J2EECache.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EECache)) return false;
        J2EECache other = (J2EECache) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cachename==null && other.getCachename()==null) || 
             (this.cachename!=null &&
              this.cachename.equals(other.getCachename()))) &&
            ((this.processname==null && other.getProcessname()==null) || 
             (this.processname!=null &&
              this.processname.equals(other.getProcessname()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.size == other.getSize() &&
            this.attrSize == other.getAttrSize() &&
            this.keysSize == other.getKeysSize() &&
            this.cachedObjects == other.getCachedObjects() &&
            this.usedObjects == other.getUsedObjects() &&
            this.puts == other.getPuts() &&
            this.gets == other.getGets() &&
            this.hits == other.getHits() &&
            this.changes == other.getChanges() &&
            this.removes == other.getRemoves() &&
            this.evictions == other.getEvictions() &&
            this.instanceInvalidations == other.getInstanceInvalidations() &&
            this.clusterInvalidations == other.getClusterInvalidations() &&
            ((this.updateTime==null && other.getUpdateTime()==null) || 
             (this.updateTime!=null &&
              this.updateTime.equals(other.getUpdateTime()))) &&
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
        if (getCachename() != null) {
            _hashCode += getCachename().hashCode();
        }
        if (getProcessname() != null) {
            _hashCode += getProcessname().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += new Long(getSize()).hashCode();
        _hashCode += new Long(getAttrSize()).hashCode();
        _hashCode += new Long(getKeysSize()).hashCode();
        _hashCode += getCachedObjects();
        _hashCode += getUsedObjects();
        _hashCode += getPuts();
        _hashCode += getGets();
        _hashCode += getHits();
        _hashCode += getChanges();
        _hashCode += getRemoves();
        _hashCode += getEvictions();
        _hashCode += getInstanceInvalidations();
        _hashCode += getClusterInvalidations();
        if (getUpdateTime() != null) {
            _hashCode += getUpdateTime().hashCode();
        }
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EECache.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EECache"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cachename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cachename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attrSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attrSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keysSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "keysSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cachedObjects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cachedObjects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usedObjects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usedObjects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "puts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "changes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("removes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "removes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evictions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evictions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanceInvalidations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanceInvalidations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clusterInvalidations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clusterInvalidations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
