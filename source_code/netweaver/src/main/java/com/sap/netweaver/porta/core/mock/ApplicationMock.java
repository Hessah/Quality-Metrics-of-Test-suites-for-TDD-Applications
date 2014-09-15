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
package com.sap.netweaver.porta.core.mock;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.ApplicationStatus;

public class ApplicationMock implements Application {
	
	private String id;
	private String name;
	private String vendor;
	private String version;
	private String location;
	private ApplicationStatus status;
	
	public ApplicationMock(File archive) {
		name = getAppName(archive);
		vendor = "sap.com";
		id = "name: '" + name + "', vendor: '" + vendor + "'";
		version = "7.1003." + getTimeStamp() + ".0000";
		location = "SAP AG";
		status = ApplicationStatus.STARTED;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public ApplicationStatus getStatus() {
		return status;
	}
	
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	
	public boolean equals(Object o) {
		return ((ApplicationMock) o).id.equals(id);
	}
	
	public int hashCode() {
		return id.hashCode();
	}
	
	public String toString() {
		return id + "|" + name + "|" + vendor + "|" + version + "|" + location + "|" + status;
	}
	
	private String getAppName(File archive) {
		String fileName = archive.getName();
		int dot = fileName.lastIndexOf('.');
		if (dot != -1) {
			fileName = fileName.substring(0, dot);
		}
		return fileName;
	}
	
	private String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());
		return sdf.format(date);
	}

}
