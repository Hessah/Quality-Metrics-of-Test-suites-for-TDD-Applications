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
package com.sap.netweaver.porta.ide.eclipse.server.ui.wizard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.TaskModel;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;
import org.eclipse.wst.server.ui.wizard.WizardFragment;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.runtime.SapNWRuntime;

public class SapNWRuntimeWizardFragment extends WizardFragment {

	protected SapNWRuntimeComposite comp;

	public SapNWRuntimeWizardFragment() {
		// do nothing
	}

	public boolean hasComposite() {
		return true;
	}
	
	public Composite createComposite(Composite parent, IWizardHandle wizard) {
		comp = new SapNWRuntimeComposite(parent, wizard);
		return comp;
	}

	public boolean isComplete() {
		IRuntimeWorkingCopy runtime = getRuntime();
		if (runtime == null)
			return false;
		
		IStatus status = runtime.validate(null);
		
		return (status == null || status.getSeverity() != IStatus.ERROR);
	}
	
	public void enter() {
		if (comp != null) {
			comp.setRuntime(getRuntime());
		}
	}
	
	private IRuntimeWorkingCopy getRuntime() {
		return (IRuntimeWorkingCopy) getTaskModel().getObject(TaskModel.TASK_RUNTIME);
	}
	
	public void performFinish(IProgressMonitor monitor) throws CoreException {
		SapNWRuntime sapRuntime = (SapNWRuntime) getRuntime().loadAdapter(SapNWRuntime.class, monitor);
		if (sapRuntime.doesCacheJars()) {
			
			// create the cache directory
			File cacheDirectory = new File(sapRuntime.getCacheLocation().toOSString());
			if (!cacheDirectory.exists() && !cacheDirectory.mkdirs()) {
				throw new CoreException(new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Could not create cache directory", null));
			}
			
			// copy the jar files
			File javaInstanceDir = getRuntime().getLocation().toFile();
			Set<String> relativeJarPaths = new HashSet<String>();
			relativeJarPaths.addAll(Arrays.asList(sapRuntime.getJ2EE14Classpath()));
			relativeJarPaths.addAll(Arrays.asList(sapRuntime.getJavaEE5Classpath()));
			
			if (monitor != null) {
				monitor.beginTask("Copying ", relativeJarPaths.size());
			}
			
			copyJars(javaInstanceDir, cacheDirectory, relativeJarPaths, monitor);			
		}
	}

	private void copyJars(File javaInstanceDir, File cacheDirectory, Collection<String> jarPaths, IProgressMonitor monitor) throws CoreException {
		for (String jarPath : jarPaths) {
			File srcJar = new File(javaInstanceDir, jarPath);
			File destJar = new File(cacheDirectory, srcJar.getName());
			
			if (monitor != null) {
				monitor.subTask(srcJar.getAbsolutePath());
			}
			
			try {
				copyFile(srcJar, destJar);
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Could not copy jar file " + srcJar.getAbsolutePath(), null));
			}
			
			if (monitor != null) {
				monitor.worked(1);
			}
		}
	}
	
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel srcChannel = null;
		FileChannel destChannel = null;
		try {
			srcChannel = new FileInputStream(srcFile).getChannel();
			destChannel = new FileOutputStream(destFile).getChannel();
			destChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} finally {
			if (srcChannel != null) {
				srcChannel.close();
			}
			if (destChannel != null) {
				destChannel.close();
			}
		}
	}

}
