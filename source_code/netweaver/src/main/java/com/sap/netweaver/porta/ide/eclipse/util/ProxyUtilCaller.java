package com.sap.netweaver.porta.ide.eclipse.util;

import java.lang.reflect.Method;

import com.sap.netweaver.porta.core.ProxyException;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;

public class ProxyUtilCaller {

	public static void handleProxyException(ProxyException e) {
		try {
			Class clazz = Class.forName("com.sap.netweaver.porta.ide.eclipse.util.ProxyUtil");
			Method method = clazz.getMethod("handleProxyException", ProxyException.class);
			method.invoke(null, e);
		} catch (Exception e1) {
			SapNWPlugin.logError("There seems to be a problem with the proxy settings - the host " + e.getHost() + " should be added to the nonProxyHosts list.", null);
		}
	}

}
