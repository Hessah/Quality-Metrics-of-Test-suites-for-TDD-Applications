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
import java.util.HashSet;
import java.util.Set;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.ApplicationStatus;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.DeployResultStatus;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class DeployManagerMock extends CoreModuleMock implements DeployManager {
	
	private Set<Application> repo = new HashSet<Application>();

	public DeployResult deploy(File[] archives) throws NotAuthorizedException,
			CoreException {
		checkCredentials();
		for (File file : archives) {
			repo.add(new ApplicationMock(file));
		}
		return new DeployResultMock(DeployResultStatus.SUCCESS, "All applications are successfully deployed. ");
	}

	public Application[] getApplications() throws NotAuthorizedException, CoreException {
		checkCredentials();
		return repo.toArray(new Application[] { });
	}

	public Application[] start(Application[] apps) throws NotAuthorizedException, CoreException {
		checkCredentials();
		
		for (Application app : apps) {
			((ApplicationMock) app).setStatus(ApplicationStatus.STARTED);
		}
		
		return apps;
	}

	public Application[] stop(Application[] apps) throws NotAuthorizedException, CoreException {
		checkCredentials();
		
		for (Application app : apps) {
			((ApplicationMock) app).setStatus(ApplicationStatus.STOPPED);
		}
		
		return apps;
	}

	public DeployResult undeploy(Application[] apps) throws NotAuthorizedException, CoreException {
		checkCredentials();
		for (Application a : apps) {
			repo.remove(a);
		}
		return new DeployResultMock(DeployResultStatus.SUCCESS, "All applications are successfully undeployed. ");
	}
	
}
