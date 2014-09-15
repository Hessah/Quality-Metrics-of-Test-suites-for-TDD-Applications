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
package com.sap.netweaver.porta.core.nw7;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

import com.sap.engine.services.dc.wsgate.ArchiveFile;
import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.CoreException;

public interface DMUtils {
	
	public DeployWSPortType getDeployWSProxy(URL wsUrl) throws ServiceException;

	public URL getDeployWSUrl(String host, int port) throws MalformedURLException;
	
	public com.sap.engine.services.dc.wsgate.Application convertApplication(Application app);
	
	public com.sap.engine.services.dc.wsgate.Application[] convertApplications(Application[] apps);
	
	public Application convertApplication(com.sap.engine.services.dc.wsgate.Application app);

	public Application[] convertApplications(com.sap.engine.services.dc.wsgate.Application[] apps);
	
	public DeployResultImpl convertDeployResult(com.sap.engine.services.dc.wsgate.DeployResult deployWSResult);
	
	public String[] getAsArchivePaths(File[] archives) throws CoreException;
	
	public ArchiveFile[] getAsArchiveFiles(File[] archives) throws CoreException;

	public FileUploader getFileUploader(String host, int port);

}
