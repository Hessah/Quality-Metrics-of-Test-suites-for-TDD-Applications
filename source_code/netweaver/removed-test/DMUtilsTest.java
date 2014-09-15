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

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.sap.engine.services.dc.wsgate.Application;
import com.sap.engine.services.dc.wsgate.ArchiveFile;
import com.sap.engine.services.dc.wsgate.DeployResult;
import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.netweaver.porta.core.ApplicationStatus;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployResultStatus;

public class DMUtilsTest {
	
	private static final String HOST = "my-host";
	private static final int PORT = 57313;
	
	private static final String ID = "app_id";
	private static final String LOCATION = "app_location";
	private static final String NAME = "app_name";
	private static final ApplicationStatus STATUS = ApplicationStatus.UNKNOWN;
	private static final String VENDOR = "app_vendor";
	private static final String VERSION = "app_version";
	
	private final DMUtils utils = new DMUtilsImpl();
	
	@Test
	public void testConstructor() throws Exception {
		new DMUtilsImpl();
	}
	
	@Test
	public void testGetDeployWSUrl() throws Exception {
		URL url = utils.getDeployWSUrl(HOST, PORT);
		String urlStr = String.format("http://%s:%d/DeployWSService/DeployWS", HOST, PORT);
		assertEquals(urlStr, url.toString());
	}
	
	@Test
	public void testGetDeployWSProxy() throws Exception {
		URL wsUrl = utils.getDeployWSUrl(HOST, PORT);
		DeployWSPortType portType = utils.getDeployWSProxy(wsUrl);
		assertNotNull(portType);
	}
	
	@Test
	public void testConvertApplication() throws Exception {
		Application proxy = new Application(ID, LOCATION, NAME, STATUS.toString(), VENDOR, VERSION);
		ApplicationImpl appImpl = new ApplicationImpl(proxy); 
		Application app = utils.convertApplication(appImpl);
		assertEquals(proxy, app);
	}
	
	@Test
	public void testConvertDeployResult() throws Exception {
		String statusDetails = "status details";
		DeployResult deployWSResult = new DeployResult(new Application[] {}, "Success", statusDetails);
		DeployResultImpl deployResult = utils.convertDeployResult(deployWSResult);
		assertEquals(DeployResultStatus.SUCCESS, deployResult.getStatus());
		assertEquals(statusDetails, deployResult.getStatusDetails());
	}
	
	@Test
	public void testGetAsArchivePaths() throws Exception {
		File[] files = new File[] {
				new File("/tmp/test.file"), 
				new File("/home/myfile.txt")
		};
		
		String[] paths = utils.getAsArchivePaths(files);
		
		for (int i = 0; i < paths.length; i++) {
			assertTrue(paths[i].endsWith(files[i].getName()));
		}
	}
	
	@Test(expected = CoreException.class)
	public void testGetAsArchivePaths_InvalidFileName() throws Exception {
		utils.getAsArchivePaths(new File[] { new File("con") });
	}
	
	@Test
	public void testGetAsArchiveFiles() throws Exception {
		File[] files = new File[] {
				new File("resources/test.txt"), 
				new File("resources/epl-v10.html")
		};
		
		ArchiveFile[] archives = utils.getAsArchiveFiles(files);
		
		for (int i = 0; i < archives.length; i++) {
			assertEquals(files[i].getName(), archives[i].getFileName());
			assertEquals(files[i].length(), archives[i].getContent().length);
		}
	}
	
	@Test(expected = CoreException.class)
	public void testGetAsArchiveFiles_NonExistingFile() throws Exception {
		utils.getAsArchiveFiles(new File[] { new File("/tmp/test.file") });
	}

}
