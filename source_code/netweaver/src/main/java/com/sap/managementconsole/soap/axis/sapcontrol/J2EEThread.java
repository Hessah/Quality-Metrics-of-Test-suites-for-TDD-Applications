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
 * J2EEThread.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEThread  implements java.io.Serializable {
    private java.lang.String processname;
    private java.lang.String startTime;
    private java.lang.String updateTime;
    private java.lang.String taskupdateTime;
    private java.lang.String subtaskupdateTime;
    private java.lang.String task;
    private java.lang.String subtask;
    private java.lang.String name;
    private java.lang.String classname;
    private java.lang.String user;
    private java.lang.String pool;
    private java.lang.String state;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public J2EEThread() {
    }

    public J2EEThread(
           java.lang.String processname,
           java.lang.String startTime,
           java.lang.String updateTime,
           java.lang.String taskupdateTime,
           java.lang.String subtaskupdateTime,
           java.lang.String task,
           java.lang.String subtask,
           java.lang.String name,
           java.lang.String classname,
           java.lang.String user,
           java.lang.String pool,
           java.lang.String state,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.processname = processname;
           this.startTime = startTime;
           this.updateTime = updateTime;
           this.taskupdateTime = taskupdateTime;
           this.subtaskupdateTime = subtaskupdateTime;
           this.task = task;
           this.subtask = subtask;
           this.name = name;
           this.classname = classname;
           this.user = user;
           this.pool = pool;
           this.state = state;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the processname value for this J2EEThread.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EEThread.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the startTime value for this J2EEThread.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this J2EEThread.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the updateTime value for this J2EEThread.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EEThread.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the taskupdateTime value for this J2EEThread.
     * 
     * @return taskupdateTime
     */
    public java.lang.String getTaskupdateTime() {
        return taskupdateTime;
    }


    /**
     * Sets the taskupdateTime value for this J2EEThread.
     * 
     * @param taskupdateTime
     */
    public void setTaskupdateTime(java.lang.String taskupdateTime) {
        this.taskupdateTime = taskupdateTime;
    }


    /**
     * Gets the subtaskupdateTime value for this J2EEThread.
     * 
     * @return subtaskupdateTime
     */
    public java.lang.String getSubtaskupdateTime() {
        return subtaskupdateTime;
    }


    /**
     * Sets the subtaskupdateTime value for this J2EEThread.
     * 
     * @param subtaskupdateTime
     */
    public void setSubtaskupdateTime(java.lang.String subtaskupdateTime) {
        this.subtaskupdateTime = subtaskupdateTime;
    }


    /**
     * Gets the task value for this J2EEThread.
     * 
     * @return task
     */
    public java.lang.String getTask() {
        return task;
    }


    /**
     * Sets the task value for this J2EEThread.
     * 
     * @param task
     */
    public void setTask(java.lang.String task) {
        this.task = task;
    }


    /**
     * Gets the subtask value for this J2EEThread.
     * 
     * @return subtask
     */
    public java.lang.String getSubtask() {
        return subtask;
    }


    /**
     * Sets the subtask value for this J2EEThread.
     * 
     * @param subtask
     */
    public void setSubtask(java.lang.String subtask) {
        this.subtask = subtask;
    }


    /**
     * Gets the name value for this J2EEThread.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this J2EEThread.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the classname value for this J2EEThread.
     * 
     * @return classname
     */
    public java.lang.String getClassname() {
        return classname;
    }


    /**
     * Sets the classname value for this J2EEThread.
     * 
     * @param classname
     */
    public void setClassname(java.lang.String classname) {
        this.classname = classname;
    }


    /**
     * Gets the user value for this J2EEThread.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this J2EEThread.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the pool value for this J2EEThread.
     * 
     * @return pool
     */
    public java.lang.String getPool() {
        return pool;
    }


    /**
     * Sets the pool value for this J2EEThread.
     * 
     * @param pool
     */
    public void setPool(java.lang.String pool) {
        this.pool = pool;
    }


    /**
     * Gets the state value for this J2EEThread.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this J2EEThread.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the dispstatus value for this J2EEThread.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this J2EEThread.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEThread)) return false;
        J2EEThread other = (J2EEThread) obj;
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
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            ((this.updateTime==null && other.getUpdateTime()==null) || 
             (this.updateTime!=null &&
              this.updateTime.equals(other.getUpdateTime()))) &&
            ((this.taskupdateTime==null && other.getTaskupdateTime()==null) || 
             (this.taskupdateTime!=null &&
              this.taskupdateTime.equals(other.getTaskupdateTime()))) &&
            ((this.subtaskupdateTime==null && other.getSubtaskupdateTime()==null) || 
             (this.subtaskupdateTime!=null &&
              this.subtaskupdateTime.equals(other.getSubtaskupdateTime()))) &&
            ((this.task==null && other.getTask()==null) || 
             (this.task!=null &&
              this.task.equals(other.getTask()))) &&
            ((this.subtask==null && other.getSubtask()==null) || 
             (this.subtask!=null &&
              this.subtask.equals(other.getSubtask()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.classname==null && other.getClassname()==null) || 
             (this.classname!=null &&
              this.classname.equals(other.getClassname()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.pool==null && other.getPool()==null) || 
             (this.pool!=null &&
              this.pool.equals(other.getPool()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
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
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        if (getUpdateTime() != null) {
            _hashCode += getUpdateTime().hashCode();
        }
        if (getTaskupdateTime() != null) {
            _hashCode += getTaskupdateTime().hashCode();
        }
        if (getSubtaskupdateTime() != null) {
            _hashCode += getSubtaskupdateTime().hashCode();
        }
        if (getTask() != null) {
            _hashCode += getTask().hashCode();
        }
        if (getSubtask() != null) {
            _hashCode += getSubtask().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getClassname() != null) {
            _hashCode += getClassname().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getPool() != null) {
            _hashCode += getPool().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEThread.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEThread"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
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
        elemField.setFieldName("updateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskupdateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taskupdateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtaskupdateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtaskupdateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("task");
        elemField.setXmlName(new javax.xml.namespace.QName("", "task"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtask");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtask"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pool");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pool"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
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
