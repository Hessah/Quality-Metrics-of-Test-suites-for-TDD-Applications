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
package com.sap.netweaver.porta.ide.eclipse.server.runtime;

import static com.sap.netweaver.porta.ide.eclipse.util.FacetUtil.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.server.core.IRuntime;
import org.junit.Test;

public class SapNWRuntimeClasspathProviderTest {
	
	class SapNWRuntime710Mock extends SapNW710Runtime {
		
		private final boolean cache;
		
		private SapNWRuntime710Mock(boolean cache) {
			this.cache = cache;
		}

		@Override
		public boolean doesCacheJars() {
			return cache;
		}

		@Override
		public IPath getCacheLocation() {
			return new Path("/");
		}
		
	}
	
	@Test
	public void testResolveClasspathContainer_NoLocation() throws Exception {
		IFacetedProject project = createMock(IFacetedProject.class);
		IRuntime runtime = createMock(IRuntime.class);
		expect(runtime.getLocation()).andReturn(null);
		
		replay(project, runtime);
		
		IClasspathEntry[] result = new SapNWRuntimeClasspathProvider().resolveClasspathContainer(project, runtime);
		assertEquals(0, result.length);
	}
	
	@Test
	public void testResolveClasspathContainer_Web25_Cache() throws Exception {
		SapNWRuntime sapRuntime = new SapNWRuntime710Mock(true);
		IFacetedProject project = createMock(IFacetedProject.class);
		expect(project.hasProjectFacet(getProjectFacet(DYNAMIC_WEB, "2.5"))).andReturn(true);
		
		IRuntime runtime = createMock(IRuntime.class);
		expect(runtime.getLocation()).andReturn(new Path("/resource/J710"));
		expect(runtime.loadAdapter(SapNWRuntime.class, null)).andReturn(sapRuntime);
		
		replay(project, runtime);
		
		IClasspathEntry[] result = new SapNWRuntimeClasspathProvider().resolveClasspathContainer(project, runtime);
		assertFalse(result.length == 0);
		assertFalse(result[0].getPath().toOSString().contains("j2ee"));
	}
	
	@Test
	public void testResolveClasspathContainer_EJB21_NoCache() throws Exception {
		SapNWRuntime sapRuntime = new SapNWRuntime710Mock(false);
		IFacetedProject project = createMock(IFacetedProject.class);
		expect(project.hasProjectFacet(getProjectFacet(EJB, "2.1"))).andReturn(true);
		expect(project.hasProjectFacet((IProjectFacetVersion) anyObject())).andReturn(false).anyTimes();
		
		IRuntime runtime = createMock(IRuntime.class);
		expect(runtime.getLocation()).andReturn(new Path("/resource/J710"));
		expect(runtime.loadAdapter(SapNWRuntime.class, null)).andReturn(sapRuntime);
		
		replay(project, runtime);
		
		IClasspathEntry[] result = new SapNWRuntimeClasspathProvider().resolveClasspathContainer(project, runtime);
		assertFalse(result.length == 0);
		assertTrue(result[0].getPath().toOSString().contains("j2ee"));
	}
	
	@Test
	public void testResolveClasspathContainer_NoFacet() throws Exception {
		SapNWRuntime sapRuntime = new SapNWRuntime710Mock(false);
		IFacetedProject project = createMock(IFacetedProject.class);
		expect(project.hasProjectFacet((IProjectFacetVersion) anyObject())).andReturn(false).anyTimes();
		
		IRuntime runtime = createMock(IRuntime.class);
		expect(runtime.getLocation()).andReturn(new Path("/resource/J710"));
		expect(runtime.loadAdapter(SapNWRuntime.class, null)).andReturn(sapRuntime);
		
		replay(project, runtime);
		
		IClasspathEntry[] result = new SapNWRuntimeClasspathProvider().resolveClasspathContainer(project, runtime);
		assertEquals(0, result.length);
	}

}
