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
 * WorkProcess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class WorkProcess  implements java.io.Serializable {
    private int no;
    private java.lang.String typ;
    private int pid;
    private java.lang.String status;
    private java.lang.String reason;
    private java.lang.String start;
    private java.lang.String err;
    private java.lang.String sem;
    private java.lang.String cpu;
    private java.lang.String time;
    private java.lang.String program;
    private java.lang.String client;
    private java.lang.String user;
    private java.lang.String action;
    private java.lang.String table;

    public WorkProcess() {
    }

    public WorkProcess(
           int no,
           java.lang.String typ,
           int pid,
           java.lang.String status,
           java.lang.String reason,
           java.lang.String start,
           java.lang.String err,
           java.lang.String sem,
           java.lang.String cpu,
           java.lang.String time,
           java.lang.String program,
           java.lang.String client,
           java.lang.String user,
           java.lang.String action,
           java.lang.String table) {
           this.no = no;
           this.typ = typ;
           this.pid = pid;
           this.status = status;
           this.reason = reason;
           this.start = start;
           this.err = err;
           this.sem = sem;
           this.cpu = cpu;
           this.time = time;
           this.program = program;
           this.client = client;
           this.user = user;
           this.action = action;
           this.table = table;
    }


    /**
     * Gets the no value for this WorkProcess.
     * 
     * @return no
     */
    public int getNo() {
        return no;
    }


    /**
     * Sets the no value for this WorkProcess.
     * 
     * @param no
     */
    public void setNo(int no) {
        this.no = no;
    }


    /**
     * Gets the typ value for this WorkProcess.
     * 
     * @return typ
     */
    public java.lang.String getTyp() {
        return typ;
    }


    /**
     * Sets the typ value for this WorkProcess.
     * 
     * @param typ
     */
    public void setTyp(java.lang.String typ) {
        this.typ = typ;
    }


    /**
     * Gets the pid value for this WorkProcess.
     * 
     * @return pid
     */
    public int getPid() {
        return pid;
    }


    /**
     * Sets the pid value for this WorkProcess.
     * 
     * @param pid
     */
    public void setPid(int pid) {
        this.pid = pid;
    }


    /**
     * Gets the status value for this WorkProcess.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this WorkProcess.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the reason value for this WorkProcess.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this WorkProcess.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the start value for this WorkProcess.
     * 
     * @return start
     */
    public java.lang.String getStart() {
        return start;
    }


    /**
     * Sets the start value for this WorkProcess.
     * 
     * @param start
     */
    public void setStart(java.lang.String start) {
        this.start = start;
    }


    /**
     * Gets the err value for this WorkProcess.
     * 
     * @return err
     */
    public java.lang.String getErr() {
        return err;
    }


    /**
     * Sets the err value for this WorkProcess.
     * 
     * @param err
     */
    public void setErr(java.lang.String err) {
        this.err = err;
    }


    /**
     * Gets the sem value for this WorkProcess.
     * 
     * @return sem
     */
    public java.lang.String getSem() {
        return sem;
    }


    /**
     * Sets the sem value for this WorkProcess.
     * 
     * @param sem
     */
    public void setSem(java.lang.String sem) {
        this.sem = sem;
    }


    /**
     * Gets the cpu value for this WorkProcess.
     * 
     * @return cpu
     */
    public java.lang.String getCpu() {
        return cpu;
    }


    /**
     * Sets the cpu value for this WorkProcess.
     * 
     * @param cpu
     */
    public void setCpu(java.lang.String cpu) {
        this.cpu = cpu;
    }


    /**
     * Gets the time value for this WorkProcess.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this WorkProcess.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the program value for this WorkProcess.
     * 
     * @return program
     */
    public java.lang.String getProgram() {
        return program;
    }


    /**
     * Sets the program value for this WorkProcess.
     * 
     * @param program
     */
    public void setProgram(java.lang.String program) {
        this.program = program;
    }


    /**
     * Gets the client value for this WorkProcess.
     * 
     * @return client
     */
    public java.lang.String getClient() {
        return client;
    }


    /**
     * Sets the client value for this WorkProcess.
     * 
     * @param client
     */
    public void setClient(java.lang.String client) {
        this.client = client;
    }


    /**
     * Gets the user value for this WorkProcess.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this WorkProcess.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the action value for this WorkProcess.
     * 
     * @return action
     */
    public java.lang.String getAction() {
        return action;
    }


    /**
     * Sets the action value for this WorkProcess.
     * 
     * @param action
     */
    public void setAction(java.lang.String action) {
        this.action = action;
    }


    /**
     * Gets the table value for this WorkProcess.
     * 
     * @return table
     */
    public java.lang.String getTable() {
        return table;
    }


    /**
     * Sets the table value for this WorkProcess.
     * 
     * @param table
     */
    public void setTable(java.lang.String table) {
        this.table = table;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkProcess)) return false;
        WorkProcess other = (WorkProcess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.no == other.getNo() &&
            ((this.typ==null && other.getTyp()==null) || 
             (this.typ!=null &&
              this.typ.equals(other.getTyp()))) &&
            this.pid == other.getPid() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.start==null && other.getStart()==null) || 
             (this.start!=null &&
              this.start.equals(other.getStart()))) &&
            ((this.err==null && other.getErr()==null) || 
             (this.err!=null &&
              this.err.equals(other.getErr()))) &&
            ((this.sem==null && other.getSem()==null) || 
             (this.sem!=null &&
              this.sem.equals(other.getSem()))) &&
            ((this.cpu==null && other.getCpu()==null) || 
             (this.cpu!=null &&
              this.cpu.equals(other.getCpu()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.action==null && other.getAction()==null) || 
             (this.action!=null &&
              this.action.equals(other.getAction()))) &&
            ((this.table==null && other.getTable()==null) || 
             (this.table!=null &&
              this.table.equals(other.getTable())));
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
        _hashCode += getNo();
        if (getTyp() != null) {
            _hashCode += getTyp().hashCode();
        }
        _hashCode += getPid();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getStart() != null) {
            _hashCode += getStart().hashCode();
        }
        if (getErr() != null) {
            _hashCode += getErr().hashCode();
        }
        if (getSem() != null) {
            _hashCode += getSem().hashCode();
        }
        if (getCpu() != null) {
            _hashCode += getCpu().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        if (getTable() != null) {
            _hashCode += getTable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkProcess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "WorkProcess"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no");
        elemField.setXmlName(new javax.xml.namespace.QName("", "No"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Typ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Pid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("err");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Err"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Sem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cpu"));
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
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("action");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Action"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Table"));
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
