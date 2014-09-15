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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.core.TaskModel;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;
import org.eclipse.wst.server.ui.wizard.WizardFragment;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;

public class SapNWServerWizardFragment extends WizardFragment {

	protected IWizardHandle wizard;
	protected SapNWServerComposite comp;

	public SapNWServerWizardFragment() {
		// do nothing
	}

	public boolean hasComposite() {
		return true;
	}
	
	public Composite createComposite(Composite parent, IWizardHandle wizard) {
		this.wizard = wizard;
		comp = new SapNWServerComposite(parent, wizard);
		return comp;
	}

	public boolean isComplete() {
		IServerWorkingCopy server = getServer();
		if (server == null)
			return false;
		
		return comp.isPinged() && wizard.getMessageType() != IMessageProvider.ERROR;
	}
	
	public void enter() {
		if (comp != null) {
			comp.setServer(getServer());
		}
	}
	
	private IServerWorkingCopy getServer() {
		return (IServerWorkingCopy) getTaskModel().getObject(TaskModel.TASK_SERVER);
	}

	public void performFinish(IProgressMonitor monitor) throws CoreException {
		SapNWServer sapServer = (SapNWServer) getServer().loadAdapter(SapNWServer.class, monitor);
		try {
			String systemName = sapServer.getServerCore().getSystemName();
			getServer().setName(getUniqueServerName(systemName));
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.logError(String.format("Cannot retrieve system name for server [%s:%d]. ", sapServer.getServer().getHost(), sapServer.getInstanceNumber()), e);
		}
	}
	
	private String getUniqueServerName(String prefix) {
		String uniqueName = null;
		
		// enumerate all servers names
		IServer[] existingServers = ServerCore.getServers();
		Collection<String> serverNames = new HashSet<String>(existingServers.length);
		for (IServer server : existingServers) {
			serverNames.add(server.getName());
		}
		
		// check if the given prefix is unique
		int index = 1;
		if (!serverNames.contains(prefix))		
			uniqueName = prefix;
		
		// attempt to construct unique name using the pattern "prefix (index)"
		while (uniqueName == null) {
			index++;
			String candidate = String.format("%s (%d)", prefix, index);
			if (!serverNames.contains(candidate))
				uniqueName = candidate;
		}
	
		return uniqueName;
	}

}
