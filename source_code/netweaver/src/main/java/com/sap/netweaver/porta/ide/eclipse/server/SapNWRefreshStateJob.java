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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.control.SapNWServerBehavior;

public class SapNWRefreshStateJob extends Job {

	public SapNWRefreshStateJob() {
		super("Refresh SAP NetWeaver server state");
		setSystem(true);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			// enumerate all servers available
			IServer[] existingServers = ServerCore.getServers();
			for (IServer server : existingServers) {
				SapNWServerBehavior behavior = (SapNWServerBehavior) server.loadAdapter(SapNWServerBehavior.class, null);
				// check if this is a SAP NetWeaver server
				if (behavior != null) {
					// refresh server's state
					try {
						behavior.refreshServerState();
					} catch (Exception e) {
						SapNWPlugin.logError("Error on refreshing server state", e);
					}
				}
			}
		} finally {
			// TODO make this period configurable
			// reschedule
			schedule(3000);
		}
		return Status.OK_STATUS;
	}

}
