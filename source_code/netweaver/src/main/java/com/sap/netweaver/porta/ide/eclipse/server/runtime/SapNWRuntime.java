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

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.server.core.model.RuntimeDelegate;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.util.StatusUtil;

public abstract class SapNWRuntime extends RuntimeDelegate {

	public static final String PROPERTY_CACHE_JARS = "cache_jars";
	
	private Map<File, IStatus> cachedClasspathValidation = new HashMap<File, IStatus>(); 
	
	public abstract String[] getJavaEE5Classpath();
	
	public abstract String[] getJ2EE14Classpath();

	@Override
	public IStatus validate() {
		IStatus status = super.validate();
		
		if (!StatusUtil.hasErrorMessage(status)) {
			status = StatusUtil.merge(status, validateName(getRuntime().getName()));
		}
		
		if (!status.matches(IStatus.ERROR)) {
			status = StatusUtil.merge(status, validateClasspath(getRuntime().getLocation().toFile()));
		}
		
		return status;
	}

	IStatus validateName(String name) {
		return ResourcesPlugin.getWorkspace().validateName(name, IResource.FOLDER);
	}

	IStatus validateClasspath(File javaInstanceDir) {
		// check the cache first
		if (cachedClasspathValidation.containsKey(javaInstanceDir)) {
			return cachedClasspathValidation.get(javaInstanceDir);
		}
		
		// this check is not cache, make it now
		Set<String> relativeJarPaths = new HashSet<String>();
		relativeJarPaths.addAll(Arrays.asList(getJ2EE14Classpath()));
		relativeJarPaths.addAll(Arrays.asList(getJavaEE5Classpath()));
		IStatus status = validateJarsAvailability(javaInstanceDir, relativeJarPaths);
		
		// save the status in the cache
		cachedClasspathValidation.put(javaInstanceDir, status);
		
		return status;
	}
	
	private IStatus validateJarsAvailability(File javaInstanceDir, Collection<String> jarPaths) {
		for (String jarPath : jarPaths) {
			File jar = new File(javaInstanceDir, jarPath);
			if (!jar.exists()) {
				return new Status(Status.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "File does not exist: " + jar.getAbsolutePath(), null);
			}
		}
		return Status.OK_STATUS;
	}

	public boolean doesCacheJars() {
		return getAttribute(PROPERTY_CACHE_JARS, true);
	}
	
	public void setCacheJars(boolean value) {
		setAttribute(PROPERTY_CACHE_JARS, value);
	}
	
	public IPath getCacheLocation() {
		return SapNWPlugin.getDefault().getStateLocation().append(getRuntime().getId());
	}
	
}
