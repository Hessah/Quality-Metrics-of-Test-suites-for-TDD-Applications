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

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.model.PublishOperation;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.NoWSGateException;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.ui.dialogs.NoWSGateDialog;
import com.sap.netweaver.porta.ide.eclipse.server.ui.dialogs.PublishProblemDialog;

public class SapNWPublishOperation extends PublishOperation {
	
	protected SapNWServerBehavior serverControl;
	protected IModule[] module;
	protected int kind;
	protected int deltaKind;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public int getKind() {
		return REQUIRED;
	}

	public SapNWPublishOperation(SapNWServerBehavior serverControl, int kind,
			IModule[] module, Integer deltaKind) {
		super("Publish to server", "Publish module to the SAP NetWeaver server");
		this.serverControl = serverControl;
		this.kind = kind;
		this.module = module;
		this.deltaKind = deltaKind;
	}

	@Override
	public void execute(IProgressMonitor monitor, IAdaptable info) throws CoreException {
		try {
			if (kind == IServer.PUBLISH_CLEAN) {
				unpublish(monitor);
				publish(monitor);
			} else if (deltaKind == ServerBehaviourDelegate.REMOVED) {
				unpublish(monitor);
			} else {
				publish(monitor);
		    }
		} catch (final NoWSGateException e) {
			// open the wiki page with installation instruction
			new UIJob("Show Error in UI") {
				public IStatus runInUIThread(IProgressMonitor monitor) {
					new NoWSGateDialog(Display.getDefault().getActiveShell(), e).open();
					return Status.OK_STATUS;
				}
			}.schedule();
			// throw CoreException to fail the publish operation
			MultiStatus multi = new MultiStatus(SapNWPlugin.PLUGIN_ID, 0, e.getLocalizedMessage(), e.getCause());
			multi.add(new Status(IStatus.WARNING, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Endpoint: " + e.getEndpoint(), null));
			throw new CoreException(multi);
		} catch (final PublishException e) {
			new UIJob("Show Error in UI") {
				public IStatus runInUIThread(IProgressMonitor monitor) {
					new PublishProblemDialog(Display.getDefault().getActiveShell(), e).open();
					return Status.OK_STATUS;
				}
			}.schedule();
			// throw CoreException to fail the publish operation
			MultiStatus multi = new MultiStatus(SapNWPlugin.PLUGIN_ID, 0, e.getLocalizedMessage(), e.getCause());
			multi.add(new Status(IStatus.WARNING, SapNWPlugin.PLUGIN_ID, IStatus.OK, e.getDeployResult().getStatusDetails(), null));
			throw new CoreException(multi);
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, e.getLocalizedMessage(), e));
		}
	}

	private void publish(IProgressMonitor monitor) throws CoreException, com.sap.netweaver.porta.core.CoreException {
		if (monitor != null && monitor.isCanceled()) {
			// the module will not be published - remove it from the module list
			removeFromModuleList();
			return;
		}
			
		try {
			File archiveFile = assembleModule(monitor);
			
			if (monitor != null) {
				monitor.subTask(String.format("Deploying archive '%s'.", archiveFile.getName()));
			}
			
			serverControl.publish(archiveFile);
		} catch (CoreException e) {
			// error during publish - check if the module was actually published
			updateModuleListAfterPublish();
			// re-throw the exception
			throw e;
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			// error during publish - check if the module was actually published
			updateModuleListAfterPublish();
			// re-throw the exception
			throw e;
		}
	}
	
	private void unpublish(IProgressMonitor monitor) throws CoreException, com.sap.netweaver.porta.core.CoreException {
		if (monitor != null && monitor.isCanceled()) {
			// the module will not be published - return it back to the module list
			addToModuleList();
			return;
		}
		
		try {
			String moduleName = module[0].getName(); 
			
			if (monitor != null) {
				monitor.subTask(String.format("Undeploying module '%s'.", moduleName));
			}
			
			serverControl.unpublish(moduleName);
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			// error during unpublish - check if the module was actually unpublished
			updateModuleListAfterUnpublish();
			// re-throw the exception
			throw e;
		}
	}

	private File assembleModule(IProgressMonitor monitor) throws CoreException {
		try {
			ModuleExportOperation operation = new ModuleExportOperation(module[0]);
			operation.execute(monitor, null);
			return operation.getArchiveFile();
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Module assembly failed", e));
		}
	}
	
	private void updateModuleListAfterPublish() throws CoreException {
		// this update should be done only for newly published module, not for republished
		if (deltaKind != ServerBehaviourDelegate.ADDED)
			return;
		
		boolean published;
		try {
			published = isPublished();
		} catch (com.sap.netweaver.porta.core.CoreException e1) {
			// not possible to retrieve published applications
			// most possibly the publish operation did no effect
			published = false;
		}

		if (!published) {
			removeFromModuleList();
		}
	}
	
	private void updateModuleListAfterUnpublish() throws CoreException {
		// this update should be done only for fully unpublished module, not for cleaned
		if (deltaKind != ServerBehaviourDelegate.REMOVED)
			return;
		
		boolean published;
		try {
			published = isPublished();
		} catch (com.sap.netweaver.porta.core.CoreException e1) {
			// not possible to retrieve published applications
			// most possibly the unpublish operation did no effect
			published = true;
		}
		
		if (published) {
			addToModuleList();
		}
	}
	
	private boolean isPublished() throws com.sap.netweaver.porta.core.CoreException {
		Application[] publishedApps = serverControl.getPublishedApplications();
		String name = module[0].getName();
		
		for (Application app : publishedApps) {
			if (name.equals(app.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	private void addToModuleList() throws CoreException {
		// this update should be done only for fully unpublished module, not for cleaned
		if (deltaKind != ServerBehaviourDelegate.REMOVED)
			return;
		
		IServerWorkingCopy wc = serverControl.getServer().createWorkingCopy();
		wc.modifyModules(module, null, null);
		wc.save(true, null);
	}
	
	private void removeFromModuleList() throws CoreException {
		// this update should be done only for newly published module, not for republished
		if (deltaKind != ServerBehaviourDelegate.ADDED)
			return;
			
		IServerWorkingCopy wc = serverControl.getServer().createWorkingCopy();
		wc.modifyModules(null, module, null);
		wc.save(true, null);
	}
	
}
