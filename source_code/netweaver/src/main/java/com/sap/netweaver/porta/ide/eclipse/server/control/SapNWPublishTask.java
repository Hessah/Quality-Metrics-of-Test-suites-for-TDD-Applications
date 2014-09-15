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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.DeletedModule;
import org.eclipse.wst.server.core.model.PublishOperation;
import org.eclipse.wst.server.core.model.PublishTaskDelegate;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

import com.sap.netweaver.porta.ide.eclipse.util.SapNWServerUtil;

public class SapNWPublishTask extends PublishTaskDelegate {

	public PublishOperation[] getTasks(IServer server, int kind, List modules, List kindList) {
		if (modules == null)
			return null;
		
		SapNWServerBehavior serverControl = (SapNWServerBehavior) server.loadAdapter(SapNWServerBehavior.class, null);

		// find all root modules that needs to be deployed or removed
		Map<String, IModule> rootModulesForRemove = new HashMap<String, IModule>();
		Map<IModule, Integer> rootModules = new HashMap<IModule, Integer>();
		int size = modules.size();
		
		// cycle through root modules first
		for (int i = 0; i < size; i++) {
			IModule[] module = (IModule[]) modules.get(i);
			Integer deltaKind = (Integer) kindList.get(i);
			
			// check if deployable root module
			if (isDeployable(module) && isRoot(module)) {
				if (isRemoved(deltaKind)) {
					rootModulesForRemove.put(module[0].getId(), module[0]);
				} else if (isChanged(deltaKind)) {
					rootModules.put(module[0], deltaKind);
				}
			}
		}
		
		// cycle through submodules
		for (int i = 0; i < size; i++) {
			IModule[] module = (IModule[]) modules.get(i);
			Integer deltaKind = (Integer) kindList.get(i);
			
			// check if is deployable submodule
			if (isDeployable(module) && !isRoot(module) && isChanged(deltaKind)) {
				if (isRemoved(deltaKind) && !moduleExists(module[0])) {
					if(!rootModulesForRemove.keySet().contains(module[0].getId())) {
						rootModulesForRemove.put(module[0].getId(), module[0]);
					}
				} else {
					if (!rootModules.containsKey(module[0]) && !rootModulesForRemove.containsValue(module[0])) {
						rootModules.put(module[0], ServerBehaviourDelegate.CHANGED);
					}
				}
			}
		}
		
		// construct publish operations
		PublishOperation[] operations = new PublishOperation[rootModulesForRemove.size() + rootModules.size()];
		int i = 0;
		for (IModule module : rootModulesForRemove.values()) {
			operations[i++] = new SapNWPublishOperation(serverControl, kind, new IModule[] { module }, ServerBehaviourDelegate.REMOVED);
		}
		for (IModule module : rootModules.keySet()) {
			int deltaKind = rootModules.get(module);
			operations[i++] = new SapNWPublishOperation(serverControl, kind, new IModule[] { module }, deltaKind);
		}
		
		return operations;
	}

	/*
	 * Use this method instead of IMethod.exists() API for compatibility with
	 * Callisto, Europa and Ganymede.
	 */
	private boolean moduleExists(IModule module) {
		return !(module instanceof DeletedModule);
	}
	
	private boolean isDeployable(IModule[] module) {
		return SapNWServerUtil.isDeployableModule(module[0]);
	}
	
	private boolean isRoot(IModule[] module) {
		return module.length == 1;
	}
	
	private boolean isChanged(int deltaKind) {
		return deltaKind != ServerBehaviourDelegate.NO_CHANGE;
	}
	
	private boolean isRemoved(int deltaKind) {
		return deltaKind == ServerBehaviourDelegate.REMOVED;
	}
	
}
