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
package com.sap.netweaver.porta.core.nw7;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sap.netweaver.porta.core.Server;

public class ServerFactory {

	/**
	 * Constant for the <b>host</b> property used for creating a </code>Server</code>
	 * instance.
	 * 
	 * <p>
	 * The <b>host</b> property specifies the host address where the SAP
	 * NetWeaver Application Server system is running.
	 * </p>
	 */
	public static final String HOST = "host";

	/**
	 * Constant for the <b>instance.number</b> property used for creating a
	 * </code>Server</code> instance.
	 * 
	 * <p>
	 * The <b>instance.number</b> property specifies a valid instance number of
	 * the SAP NetWeaver Application Server system.
	 * </p>
	 */
	public static final String INSTANCE_NUMBER = "instance.number";

	private static Map<MapKey, Server> map = new HashMap<MapKey, Server>();
	
	public static Server createServer(Properties props) {
		String host = props.getProperty(HOST, "localhost");
		String instanceNumber = props.getProperty(INSTANCE_NUMBER, "0");
		int instNr = Integer.parseInt(instanceNumber);

		MapKey key = new MapKey(host, instanceNumber);
		Server server;

		synchronized (map) {
			server = map.get(key);
			if (server == null) {
				server = new ServerImpl(host, instNr);
				map.put(key, server);
			}
		}

		return server;
	}

	private static final class MapKey {

		private String key;

		private MapKey(String host, String instNr) {
			key = "<<<" + host + ">>>$<<<" + instNr + ">>>";
		}

		public boolean equals(Object o) {
			if (o instanceof MapKey) {
				return this.key.equals(((MapKey) o).key);
			}
			return false;
		}

		public int hashCode() {
			return key.hashCode();
		}

	}

}
