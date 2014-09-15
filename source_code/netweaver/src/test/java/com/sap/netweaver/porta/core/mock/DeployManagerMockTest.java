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

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.ApplicationStatus;
import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;

public class DeployManagerMockTest {
	
	private static final File[] FILES = new File[] {
			new File("/tmp/app1.jar"),
			new File("/tmp/app2.jar"),
			new File("/tmp/app3.jar")
	};
	
	private DeployManagerMock dm;
	
	@Before
	public void createDeployManager() {
		dm = new DeployManagerMock();
		dm.setAuthenticationCallback(new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				return new Credentials(CoreModuleMock.USER, CoreModuleMock.PASS);
			}
		});
	}

	@Test
	public void testScenario() throws Exception {
		assertEquals(0, dm.getApplications().length);
		
		dm.deploy(FILES);
		Application[] apps = dm.getApplications();
		assertEquals(3, apps.length);
		assertEquals(ApplicationStatus.STARTED, apps[1].getStatus());
		
		dm.stop(new Application[] { apps[1] });
		assertEquals(ApplicationStatus.STOPPED, apps[1].getStatus());
		
		dm.start(new Application[] { apps[1] });
		assertEquals(ApplicationStatus.STARTED, apps[1].getStatus());
		
		dm.undeploy(new Application[] { apps[1] });
		apps = dm.getApplications();
		assertEquals(2, apps.length);
	}
	
	@Test
	public void testDuplicates() throws Exception {
		dm.deploy(FILES);
		assertEquals(3, dm.getApplications().length);
		
		dm.deploy(new File[] { FILES[1] });
		Application[] apps = dm.getApplications();
		assertEquals(3, apps.length);
		
		Application app2 = null;
		for (Application app : apps) {
			if ("app2".equals(app.getName())) {
				app2 = app;
				break;
			}
		}
		assertNotNull(app2);
		
		dm.undeploy(new Application[] { app2 });
		assertEquals(2, dm.getApplications().length);
		
		dm.deploy(new File[] { FILES[1] });
		assertEquals(3, dm.getApplications().length);
	}
	
}
