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
package com.sap.netweaver.porta.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The <code>ServerFactory</code> is used to create instances of the 
 * <code>Server</code> interface that represent physical SAP NetWeaver Application
 * Server systems.
 * 
 * <p>
 * The factory requires a set of <code>Properties</code> to create a
 * <code>Server</code> instance. These properties determine the correct
 * implementation object that will be created. The <code>Server</code>
 * interface hides the specifics of the implementation and provides only an
 * abstract interface to operate with the physical system.
 * </p>
 * 
 * <p>
 * Another goal of the <code>ServerFactory</code> is to optimize the creation
 * of <code>Server</code> instances. The factory remembers all created
 * <code>Server</code> instances with their corresponding properties. If, on a
 * further call to create a <code>Server</code> instance, the same properties
 * are given, then the factory returns the <code>Server</code> instance that
 * has already been created. This way duplicate instances to one and the same
 * physical system are avoided. Users of the factory do not need to persist
 * the <code>Server</code> instances created from the factory, because they
 * can be obtained again from the factory using the same set of properties.
 * </p>
 * 
 * @see Server
 */
public class ServerFactory {

	/**
	 * Constant for the <b>server.type</b> property used for creating a
	 * </code>Server</code> instance.
	 * 
	 * <p>
	 * The <b>server.type</b> property specifies the version of the SAP
	 * NetWeaver Application Server system.
	 * </p>
	 */
	public static final String SERVER_TYPE = "server.type";

	/*
	 * A map where discovered server types and their factory classes are
	 * registered.
	 */
	private final static Map<String, String> map = new HashMap<String, String>();

	/*
	 * Browse through the JARs in the classpath to discover server types.
	 */
	static {
		try {
			// Retrieve a list of all porta.properties files in the default
			// package of the JARs in the classpath
			Enumeration<URL> resources = ServerFactory.class.getClassLoader().getResources("porta.properties");
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				
				// load the porta.properties file
				Properties props = new Properties();
				props.load(url.openStream());
				
				// retrieve the server.type property
				String type = props.getProperty(SERVER_TYPE);
				
				// retrieve the server.factory property
				String factory = props.getProperty("server.factory");
				
				// register the discovered server type in the map
				if (type != null && factory != null) {
					map.put(type, factory);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates an instance of the <code>Server</code> interface that represents
	 * a physical SAP NetWeaver Application Server system.
	 * 
	 * <p>
	 * It is mandatory to specify the <code>ServerType</code> property. It
	 * determines the type of the implementation type that will be created for
	 * the <code>Server</code> interface. The valid property value for a
	 * specific implementation type could be obtained from the
	 * </code>porta.properties</code> file in the implementation JAR.
	 * </p>
	 * 
	 * </p> Other required properties are specific to the selected server type.
	 * Consult the java doc of the server factory class in the implementation
	 * JAR. </p>
	 * 
	 * @param props
	 *            - a set of properties that determines the implementation
	 *            object that will be returned as instance of the
	 *            <code>Server</code> interface
	 * 
	 * @return instance of the <code>Server</code> interface.
	 * 
	 * @throws IllegalArgumentException
	 *             - if a required property is missing, or a property value is
	 *             invalid or not supported
	 * @throws CoreException
	 *             - if a problem happens while creating the <code>Server</code>
	 *             instance
	 * 
	 * @see #SERVER_TYPE
	 */
	public static Server createServer(Properties properties) throws CoreException {
		if (properties == null) {
			throw new NullPointerException("properties cannot be null");
		}
		
		String type = properties.getProperty(SERVER_TYPE);
		if (type == null) {
			throw new IllegalArgumentException(String.format("%s property missing", SERVER_TYPE));
		}
		
		String factory = map.get(type);
		if (factory == null) {
			throw new IllegalArgumentException(String.format("%s is not supported server type. Supported types are: %s. ", type, map.keySet()));
		}
		
		try {
			Class<?> factoryClass = Class.forName(factory);
			Method method = factoryClass.getMethod("createServer", new Class[] { Properties.class });
			return (Server) method.invoke(null, properties);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}
	
}
