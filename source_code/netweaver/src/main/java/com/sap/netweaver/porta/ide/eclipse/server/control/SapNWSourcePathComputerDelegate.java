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
package com.sap.netweaver.porta.ide.eclipse.server.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.debug.core.sourcelookup.containers.FolderSourceContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerUtil;

public class SapNWSourcePathComputerDelegate implements ISourcePathComputerDelegate {

	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		List<IRuntimeClasspathEntry> classpaths = new ArrayList<IRuntimeClasspathEntry>();
		classpaths.addAll(Arrays.asList(JavaRuntime.computeUnresolvedSourceLookupPath(configuration)));
		List<ISourceContainer> sourceFolderList = new ArrayList<ISourceContainer>();
		
		IServer server = ServerUtil.getServer(configuration);
		if (server != null) {
			List<IJavaProject> list = new ArrayList<IJavaProject>();
			IModule[] modules = server.getModules();
			for (IModule module : modules) {
				processModule(module, server, monitor, list, sourceFolderList);
			}
			int size = list.size();
			IJavaProject[] projects = new IJavaProject[size];
			list.toArray(projects);
			
			for (IJavaProject project : projects)
				classpaths.addAll(Arrays.asList(JavaRuntime.computeUnresolvedRuntimeClasspath(project)));
		}

		IRuntimeClasspathEntry[] entries = new IRuntimeClasspathEntry[classpaths.size()];
		classpaths.toArray(entries);

		IRuntimeClasspathEntry[] resolved = JavaRuntime.resolveSourceLookupPath(entries, configuration);
		ISourceContainer[] sourceContainers = JavaRuntime.getSourceContainers(resolved);
		
		if (!sourceFolderList.isEmpty()) {
			ISourceContainer[] combinedSourceContainers = new ISourceContainer[sourceContainers.length + sourceFolderList.size()];
			sourceFolderList.toArray(combinedSourceContainers);
			System.arraycopy(sourceContainers, 0, combinedSourceContainers, sourceFolderList.size(), sourceContainers.length);
			sourceContainers = combinedSourceContainers;
		}

		return sourceContainers;
	}

	private void processModule(IModule module, IServer server, IProgressMonitor monitor, 
			List<IJavaProject> javaProjectList, List<ISourceContainer> sourceFolderList) {
		IModule[] childModules = server.getChildModules(new IModule[] { module }, monitor);
		for (IModule childModule : childModules) {
			processModule(childModule, server, monitor, javaProjectList, sourceFolderList);
		}
		
		IProject project = module.getProject();
		if (project != null) {
			IFolder moduleFolder = project.getFolder(module.getName());
			if (moduleFolder.exists()) {
				sourceFolderList.add(new FolderSourceContainer(moduleFolder, true));
			}
			
			try {
				if (project.hasNature(JavaCore.NATURE_ID)) {
					IJavaProject javaProject = (IJavaProject) project.getNature(JavaCore.NATURE_ID);
					if (!javaProjectList.contains(javaProject))
						javaProjectList.add(javaProject);
				}
			} catch (Exception e) {
				// ignore
			}
		}
	}

}
