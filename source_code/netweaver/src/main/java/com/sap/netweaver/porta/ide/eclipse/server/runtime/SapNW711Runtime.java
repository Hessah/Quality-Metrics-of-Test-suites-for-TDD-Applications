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
package com.sap.netweaver.porta.ide.eclipse.server.runtime;

public class SapNW711Runtime extends SapNWRuntime {

	private static final String[] CLASSPATH_JAVAEE_5 = {
		"j2ee/cluster/bin/ext/activation_api_ri/lib/activation.jar", 
		"j2ee/cluster/bin/ext/javax~annotation~api/lib/annotation-api-1.0.jar",
		"j2ee/cluster/bin/ext/j2eeca/lib/connector.jar", 
		"j2ee/cluster/bin/ext/ec~java~jsf~api/lib/ec~java~jsf~api_api.jar", 
		"j2ee/cluster/bin/ext/ec~java~jsf~api/lib/ec~java~jsf~tld.jar", 
		"j2ee/cluster/bin/ext/ejb_api/lib/ejb-3_0-api.jar", 
		"j2ee/cluster/bin/ext/tc~je~jacc~plb/lib/jacc-1_1-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~deployment14_api/lib/javaee_deployment-1_2-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~javax77/lib/javax77.jar",
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/lib/jaxm-api.jar", 
		"j2ee/cluster/bin/ext/jaxb20_api/lib/jaxb-api.jar", 
		"j2ee/cluster/bin/ext/jaxr_api/lib/jaxr-api.jar", 
		"j2ee/cluster/bin/ext/jaxrpc_api/lib/jaxrpc-api.jar", 
		"j2ee/cluster/bin/ext/jaxws_api/lib/jaxws-api.jar", 
		"j2ee/cluster/bin/ext/jms_api/lib/jms.jar", 
		"j2ee/cluster/bin/ext/ec~java~jstl/lib/jstl-1_2.jar", 
		"j2ee/cluster/bin/system/jta.jar", 
		"j2ee/cluster/bin/ext/jws_api/lib/jsr181-api.jar",
		"j2ee/cluster/bin/ext/mail_api_ri/lib/mail.jar", 
		"j2ee/cluster/bin/ext/javax~persistence~api/persistence-api-1.0.jar", 
		"j2ee/cluster/bin/ext/saaj13_api/lib/saaj-api.jar",
		"j2ee/cluster/bin/ext/servlet/lib/servlet.jar", 
		"j2ee/cluster/bin/ext/stax_api/lib/jsr173_1.0_api.jar"
	};
	
	private static final String[] CLASSPATH_J2EE_14 = {
		"j2ee/cluster/bin/ext/activation_api_ri/lib/activation.jar", 
		"j2ee/cluster/bin/ext/j2eeca/lib/connector.jar", 
		"j2ee/cluster/bin/ext/ejb20/lib/ejb20.jar", 
		"j2ee/cluster/bin/ext/tc~je~jacc~plb/lib/jacc-1_1-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~deployment14_api/lib/javaee_deployment-1_2-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~javax77/lib/javax77.jar",
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/lib/jaxm-api.jar", 
		"j2ee/cluster/bin/ext/jaxr_api/lib/jaxr-api.jar", 
		"j2ee/cluster/bin/ext/jaxrpc_api/lib/jaxrpc-api.jar", 
		"j2ee/cluster/bin/ext/jms_api/lib/jms.jar", 
		"j2ee/cluster/bin/system/jta.jar", 
		"j2ee/cluster/bin/ext/mail_api_ri/lib/mail.jar",
		"j2ee/cluster/bin/ext/saaj13_api/lib/saaj-api.jar",
		"j2ee/cluster/bin/ext/servlet/lib/servlet.jar"
	};

	@Override
	public String[] getJavaEE5Classpath() {
		return CLASSPATH_JAVAEE_5;
	}

	@Override
	public String[] getJ2EE14Classpath() {
		return CLASSPATH_J2EE_14;
	}

}
