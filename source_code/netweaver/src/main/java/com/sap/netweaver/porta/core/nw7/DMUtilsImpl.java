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
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

import com.sap.engine.services.dc.wsgate.ArchiveFile;
import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.engine.services.dc.wsgate.DeployWSServiceLocator;
import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployResultStatus;

class DMUtilsImpl implements DMUtils {

	public DeployWSPortType getDeployWSProxy(URL wsUrl) throws ServiceException {
		return new DeployWSServiceLocator().getDeployWSPort(wsUrl);
	}

	public URL getDeployWSUrl(String host, int port) throws MalformedURLException {
		return new URL("http", host, port, "/DeployWSService/DeployWS");
	}
	
	public com.sap.engine.services.dc.wsgate.Application convertApplication(Application app) {
		return ((ApplicationImpl) app).getProxy();
	}
	
	public com.sap.engine.services.dc.wsgate.Application[] convertApplications(Application[] apps) {
		com.sap.engine.services.dc.wsgate.Application[] applications = new com.sap.engine.services.dc.wsgate.Application[apps.length];
		for (int i = 0; i < applications.length; i++) {
			applications[i] = convertApplication(apps[i]);
		}
		return applications;
	}

	public Application convertApplication(com.sap.engine.services.dc.wsgate.Application app) {
		return new ApplicationImpl(app);
	}

	public Application[] convertApplications(com.sap.engine.services.dc.wsgate.Application[] apps) {
		Application[] applications = new ApplicationImpl[apps.length];
		for (int i = 0; i < applications.length; i++) {
			applications[i] = convertApplication(apps[i]);
		}
		return applications;
	}
	
	public DeployResultImpl convertDeployResult(com.sap.engine.services.dc.wsgate.DeployResult deployWSResult) {
		DeployResultStatus status = DeployResultStatus.getByName(deployWSResult.getStatus());
		String details = deployWSResult.getStatusDetails();
		return new DeployResultImpl(status, details);
	}
	
	public String[] getAsArchivePaths(File[] archives) throws CoreException {
		final String[] archivePaths = new String[archives.length];
		for (int i = 0; i < archives.length; i++) {
			try {
				archivePaths[i] = archives[i].getCanonicalPath();
			} catch (IOException e) {
				throw new CoreException(e);
			}
		}
		return archivePaths;
	}
	
	public ArchiveFile[] getAsArchiveFiles(File[] archives) throws CoreException {
		final ArchiveFile[] archiveFiles = new ArchiveFile[archives.length];
		for (int i = 0; i < archives.length; i++) {
			archiveFiles[i] = new ArchiveFile();
			archiveFiles[i].setFileName(archives[i].getName());
			// serialize archive
			try {
				FileInputStream fis = new FileInputStream(archives[i]);
				byte[] content = new byte[(int) archives[i].length()];
				int off = 0;
				while (off < content.length) {
					int bytesRead = fis.read(content, off, content.length - off);
					off += bytesRead;
				}
				if (off != content.length) {
					throw new IllegalStateException("cannot read complete archive");
				}
				archiveFiles[i].setContent(content);
			} catch (IOException e) {
				throw new CoreException(e);
			}
		}
		return archiveFiles;
	}

	public FileUploader getFileUploader(String host, int port) {
		return new FileUploaderImpl(host, port);
	}

}
