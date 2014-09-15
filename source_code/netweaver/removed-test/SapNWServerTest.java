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
package com.sap.netweaver.porta.ide.eclipse.server;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jst.server.core.IEnterpriseApplication;
import org.eclipse.jst.server.core.IWebModule;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleType;
import org.eclipse.wst.server.core.util.IStaticWeb;
import org.junit.Test;

import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.ide.eclipse.tests.junitcompatibility.AssertArrays;
import com.sap.netweaver.porta.ide.eclipse.util.FacetUtil;

public class SapNWServerTest {
	
	@Test
	public void testGetModuleRootURL_Null() throws Exception {
		SapNWServer server = new SapNWServer();
		URL url = server.getModuleRootURL(null, "my-host", 8080);
		assertEquals(url.toString(), "http://my-host:8080");
	}
	
	@Test
	public void testGetModuleRootURL_DynamicWeb() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.DYNAMIC_WEB);
		IWebModule web = createStrictMock(IWebModule.class);
		expect(web.getContextRoot()).andReturn("my-app");
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		expect(module.loadAdapter(IWebModule.class, null)).andReturn(web);
		
		replay(module, moduleType, web);
		
		SapNWServer server = new SapNWServer();
		URL url = server.getModuleRootURL(module, "my-host", 8080);
		assertEquals(url.toString(), "http://my-host:8080/my-app");
	}
	
	@Test
	public void testGetModuleRootURL_StaticWeb() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.STATIC_WEB);
		IStaticWeb web = createStrictMock(IStaticWeb.class);
		expect(web.getContextRoot()).andReturn("my-app");
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		expect(module.loadAdapter(IStaticWeb.class, null)).andReturn(web);
		
		replay(module, moduleType, web);
		
		SapNWServer server = new SapNWServer();
		URL url = server.getModuleRootURL(module, "my-host", 80);
		assertEquals(url.toString(), "http://my-host/my-app");
	}
	
	@Test
	public void testGetModuleRootURL_Exception() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.DYNAMIC_WEB);
		IWebModule web = createStrictMock(IWebModule.class);
		expect(web.getContextRoot()).andThrow(new NullPointerException());
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		expect(module.loadAdapter(IWebModule.class, null)).andReturn(web);
		
		replay(module, moduleType, web);
		
		SapNWServer server = new SapNWServer();
		URL url = server.getModuleRootURL(module, "my-host", 8080);
		assertNull(url);
	}
	
	@Test
	public void testGetChildModules_EAR() throws Exception {
		IModule module1 = createMock(IModule.class);
		IModule module2 = createMock(IModule.class);
		IModule[] modules = new IModule[] { module1, module2 };
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IEnterpriseApplication ear = createStrictMock(IEnterpriseApplication.class);
		expect(ear.getModules()).andReturn(modules);
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		expect(module.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear);
		
		replay(module, moduleType, ear, module1, module2);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getChildModules(new IModule[] { module });
		AssertArrays.assertArrayEquals(modules, result);
	}
	
	@Test
	public void testGetChildModules_WAR() throws Exception {
		IModule module1 = createMock(IModule.class);
		IModule module2 = createMock(IModule.class);
		IModule[] modules = new IModule[] { module1, module2 };
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.DYNAMIC_WEB).anyTimes();
		IWebModule war = createStrictMock(IWebModule.class);
		expect(war.getModules()).andReturn(modules);
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		expect(module.loadAdapter(IWebModule.class, null)).andReturn(war);
		
		replay(module, moduleType, war, module1, module2);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getChildModules(new IModule[] { module });
		AssertArrays.assertArrayEquals(modules, result);
	}
	
	@Test
	public void testGetChildModules_EJB() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType);
		
		replay(module, moduleType);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getChildModules(new IModule[] { module });
		assertEquals(result.length, 0);
	}
	
	@Test
	public void testGetRootModules_NoEARs() throws Exception {
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getRootModules(null, new IModule[] {});
		assertEquals(0, result.length);
	}
	
	@Test
	public void testGetRootModules_TwoEARs_NoContaining() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType).anyTimes();
		IModule childModule1 = createStrictMock(IModule.class);
		IModule childModule2 = createStrictMock(IModule.class);
		IEnterpriseApplication ear1 = createStrictMock(IEnterpriseApplication.class);
		expect(ear1.getModules()).andReturn(new IModule[] { childModule1 });
		IEnterpriseApplication ear2 = createStrictMock(IEnterpriseApplication.class);
		expect(ear2.getModules()).andReturn(new IModule[] { childModule2, childModule1 });
		IModule earModule1 = createStrictMock(IModule.class);
		expect(earModule1.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear1);
		IModule earModule2 = createStrictMock(IModule.class);
		expect(earModule2.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear2);
		
		replay(moduleType, module, childModule1, childModule2, earModule1, earModule2, ear1, ear2);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getRootModules(module, new IModule[] { earModule1, earModule2 });
		assertEquals(0, result.length);
	}
	
	@Test
	public void testGetRootModules_TwoEARs_FirstContaining() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType).anyTimes();
		IModule childModule1 = createStrictMock(IModule.class);
		IModule childModule2 = createStrictMock(IModule.class);
		IEnterpriseApplication ear1 = createStrictMock(IEnterpriseApplication.class);
		expect(ear1.getModules()).andReturn(new IModule[] { module });
		IEnterpriseApplication ear2 = createStrictMock(IEnterpriseApplication.class);
		expect(ear2.getModules()).andReturn(new IModule[] { childModule2, childModule1 });
		IModule earModule1 = createStrictMock(IModule.class);
		expect(earModule1.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear1);
		IModule earModule2 = createStrictMock(IModule.class);
		expect(earModule2.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear2);
		
		replay(moduleType, module, childModule1, childModule2, earModule1, earModule2, ear1, ear2);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getRootModules(module, new IModule[] { earModule1, earModule2 });
		AssertArrays.assertArrayEquals(new IModule[] { earModule1 }, result);
	}
	
	@Test
	public void testGetRootModules_TwoEARs_BothContaining() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule module = createStrictMock(IModule.class);
		expect(module.getModuleType()).andReturn(moduleType).anyTimes();
		IModule childModule1 = createStrictMock(IModule.class);
		IModule childModule2 = createStrictMock(IModule.class);
		IEnterpriseApplication ear1 = createStrictMock(IEnterpriseApplication.class);
		expect(ear1.getModules()).andReturn(new IModule[] { module });
		IEnterpriseApplication ear2 = createStrictMock(IEnterpriseApplication.class);
		expect(ear2.getModules()).andReturn(new IModule[] { childModule2, module, childModule1 });
		IModule earModule1 = createStrictMock(IModule.class);
		expect(earModule1.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear1);
		IModule earModule2 = createStrictMock(IModule.class);
		expect(earModule2.loadAdapter(IEnterpriseApplication.class, null)).andReturn(ear2);
		
		replay(moduleType, module, childModule1, childModule2, earModule1, earModule2, ear1, ear2);
		
		SapNWServer server = new SapNWServer();
		IModule[] result = server.getRootModules(module, new IModule[] { earModule1, earModule2 });
		AssertArrays.assertArrayEquals(new IModule[] { earModule1, earModule2 }, result);
	}
	
	@Test
	public void testCanModifyModules_addNull_RemoveNull() throws Exception {
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(null, null);
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addEmpty_RemoveEmpty() throws Exception {
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] {}, new IModule[] {});
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addEAR_RemoveEAR() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleType).anyTimes();
		
		replay(ear, moduleType);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ear }, new IModule[] { ear });
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addWAR_RemoveWAR() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.DYNAMIC_WEB).anyTimes();
		IModule war = createStrictMock(IModule.class);
		expect(war.getModuleType()).andReturn(moduleType).anyTimes();
		
		replay(war, moduleType);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { war }, new IModule[] { war });
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addEAR_RemoveWAR() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeWAR = createStrictMock(IModuleType.class);
		expect(moduleTypeWAR.getId()).andReturn(FacetUtil.DYNAMIC_WEB).anyTimes();
		IModule war = createStrictMock(IModule.class);
		expect(war.getModuleType()).andReturn(moduleTypeWAR).anyTimes();
		
		replay(war, ear, moduleTypeWAR, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ear }, new IModule[] { war });
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addWAR_RemoveEAR() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeWAR = createStrictMock(IModuleType.class);
		expect(moduleTypeWAR.getId()).andReturn(FacetUtil.DYNAMIC_WEB).anyTimes();
		IModule war = createStrictMock(IModule.class);
		expect(war.getModuleType()).andReturn(moduleTypeWAR).anyTimes();
		
		replay(war, ear, moduleTypeWAR, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { war }, new IModule[] { ear });
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addEARWAR_RemoveEmpty() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeWAR = createStrictMock(IModuleType.class);
		expect(moduleTypeWAR.getId()).andReturn(FacetUtil.DYNAMIC_WEB).anyTimes();
		IModule war = createStrictMock(IModule.class);
		expect(war.getModuleType()).andReturn(moduleTypeWAR).anyTimes();
		
		replay(war, ear, moduleTypeWAR, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ear, war }, new IModule[] { });
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testCanModifyModules_addEJB_RemoveEJB() throws Exception {
		IModuleType moduleType = createStrictMock(IModuleType.class);
		expect(moduleType.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule ejb = createStrictMock(IModule.class);
		expect(ejb.getModuleType()).andReturn(moduleType).anyTimes();
		
		replay(ejb, moduleType);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ejb }, new IModule[] { ejb });
		assertEquals(IStatus.ERROR, status.getSeverity());
	}
	
	@Test
	public void testCanModifyModules_addEAR_RemoveEJB() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeEJB = createStrictMock(IModuleType.class);
		expect(moduleTypeEJB.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule ejb = createStrictMock(IModule.class);
		expect(ejb.getModuleType()).andReturn(moduleTypeEJB).anyTimes();
		
		replay(ejb, ear, moduleTypeEJB, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ear }, new IModule[] { ejb });
		assertEquals(IStatus.ERROR, status.getSeverity());
	}
	
	@Test
	public void testCanModifyModules_addEJB_RemoveEAR() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeEJB = createStrictMock(IModuleType.class);
		expect(moduleTypeEJB.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule ejb = createStrictMock(IModule.class);
		expect(ejb.getModuleType()).andReturn(moduleTypeEJB).anyTimes();
		
		replay(ejb, ear, moduleTypeEJB, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ejb }, new IModule[] { ear });
		assertEquals(IStatus.ERROR, status.getSeverity());
	}
	
	@Test
	public void testCanModifyModules_addEAREJB_RemoveEmpty() throws Exception {
		IModuleType moduleTypeEAR = createStrictMock(IModuleType.class);
		expect(moduleTypeEAR.getId()).andReturn(FacetUtil.ENTERPRISE_APPLICATION).anyTimes();
		IModule ear = createStrictMock(IModule.class);
		expect(ear.getModuleType()).andReturn(moduleTypeEAR).anyTimes();
		IModuleType moduleTypeEJB = createStrictMock(IModuleType.class);
		expect(moduleTypeEJB.getId()).andReturn(FacetUtil.EJB).anyTimes();
		IModule ejb = createStrictMock(IModule.class);
		expect(ejb.getModuleType()).andReturn(moduleTypeEJB).anyTimes();
		
		replay(ejb, ear, moduleTypeEJB, moduleTypeEAR);
		
		SapNWServer server = new SapNWServer();
		IStatus status = server.canModifyModules(new IModule[] { ear, ejb }, new IModule[] { });
		assertEquals(IStatus.ERROR, status.getSeverity());
	}
	
	@Test
	public void testGetServerCore() throws Exception {
		SapNWServer server = new SapNWServer(true);
		Server serverCore = server.getServerCore("localhost", 66);
		assertNotNull(serverCore);
	}

}
