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
package com.sap.netweaver.porta.ide.eclipse.util;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.net.proxy.IProxyData;
import org.eclipse.core.net.proxy.IProxyService;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.netweaver.porta.core.ProxyException;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;

public class ProxyUtil {
	
	public static void handleProxyException(ProxyException e) {
		// log warning the host cannot be resolved
		SapNWPlugin.logWarning(e.getMessage(), e);
		
		// try to configure the host to bypass proxy settings
		// get the proxy service
		IProxyService proxyService = getProxyService();
		
		// check if the proxy settings are enabled
		try {
			if (proxyService != null && proxyService.isProxiesEnabled()) {
				// get the host that cannot be resolved
				String host = e.getHost();
				
				// retrieve the list of currently configured hosts that bypass the proxy settings
				String[] nonProxiedHosts = proxyService.getNonProxiedHosts();
				ArrayList<String> nonProxiedHostsList = new ArrayList<String>();
				Collections.addAll(nonProxiedHostsList, nonProxiedHosts);
				
				// check if the host is already configured to bypass the proxy settings
				if (!nonProxiedHostsList.contains(host)) {
					// the host is not configured to bypass the proxy settings
					// add it to the list of hosts that bypass the proxy settings
					nonProxiedHostsList.add(host);
					nonProxiedHosts = nonProxiedHostsList.toArray(new String[] {});
					try {
						// set the new list of hosts that bypass the proxy settings
						proxyService.setNonProxiedHosts(nonProxiedHosts);
						// call the below to trigger applying the new proxy settings
						workaroundBug284540(proxyService);
						// log info that the proxy settings were changed
						SapNWPlugin.logInfo("Host " + host + " configured to bypass proxy settings. ", null);
					} catch (CoreException e1) {
						SapNWPlugin.logError("Error on adding host " + host + " to bypass proxy settings. ", e1);
					}
				}
			} else {
				// no proxy settings available - there should be network problems
				SapNWPlugin.logError("There are no proxy settings available. Either the host " + e.getHost() + " is no more available on the network, or the SAP services are stopped completely on that host. ", null);
			}
		} finally {
			ungetProxyService();
		}
	}
	
	private static IProxyService getProxyService() {
		Bundle bundle = Platform.getBundle(SapNWPlugin.PLUGIN_ID);
		if (bundle == null) return null;
		
		BundleContext bundleContext = bundle.getBundleContext();
		if (bundleContext == null) return null;
		
		ServiceReference serviceReference = bundleContext.getServiceReference(IProxyService.class.getName());
		if (serviceReference == null) return null;
		
		IProxyService proxyService = (IProxyService) bundleContext.getService(serviceReference);
		return proxyService;
	}
	
	private static void ungetProxyService() {
		Bundle bundle = Platform.getBundle(SapNWPlugin.PLUGIN_ID);
		if (bundle == null) return;
		
		BundleContext bundleContext = bundle.getBundleContext();
		if (bundleContext == null) return;
		
		ServiceReference serviceReference = bundleContext.getServiceReference(IProxyService.class.getName());
		if (serviceReference == null) return;
		
		bundleContext.ungetService(serviceReference);
	}

	/*
	 * See https://bugs.eclipse.org/284540 for more details
	 */
	private static void workaroundBug284540(IProxyService proxyService) throws CoreException {
		IProxyData[] proxyData = proxyService.getProxyData();
		int httpProxyPort = 0;
		for (IProxyData data : proxyData) {
			if (IProxyData.HTTP_PROXY_TYPE.equals(data.getType())) {
				httpProxyPort = data.getPort();
				data.setPort(0);
			}
		}
		proxyService.setProxyData(proxyData);
		for (IProxyData data : proxyData) {
			if (IProxyData.HTTP_PROXY_TYPE.equals(data.getType())) {
				data.setPort(httpProxyPort);
			}
		}
		proxyService.setProxyData(proxyData);
	}

}
