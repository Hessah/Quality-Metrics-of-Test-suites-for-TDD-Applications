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

public class SapNW710Runtime extends SapNWRuntime {
	
	private static final String[] CLASSPATH_JAVAEE_5 = {
		"j2ee/cluster/bin/ext/mail-activation-iaik/activation.jar", 
		"j2ee/cluster/bin/ext/javax~annotation~api/annotation-api-1.0.jar",
		"j2ee/cluster/bin/ext/j2eeca/connector.jar", 
		"j2ee/cluster/bin/ext/ec~java~jsf/lib/ec~java~jsf_api.jar", 
		"j2ee/cluster/bin/ext/ec~java~jsf/lib/ec~java~jsf~tld.jar", 
		"j2ee/cluster/bin/ext/ejb_api/ejb-3_0-api.jar", 
		"j2ee/cluster/bin/ext/tc~je~jacc~plb/jacc-1_1-fr-class.zip", 
		"j2ee/deployment/lib/javaee_deployment-1_2-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~javax77/javax77.jar",
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxm-api.jar",
		"j2ee/cluster/bin/ext/jaxb20/jaxb-api.jar", 
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxr-api.jar", 
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxrpc-api.jar",
		"j2ee/cluster/bin/ext/jaxws_api/jaxws-api.jar", 
		"j2ee/cluster/bin/ext/jms/jms.jar", 
		"j2ee/cluster/bin/ext/ec~java~jstl/jstl-1_2.jar", 
		"j2ee/cluster/bin/system/jta.jar", 
		"j2ee/cluster/bin/ext/jws_api/jsr181-api.jar",
		"j2ee/cluster/bin/ext/mail-activation-iaik/mail.jar", 
		"j2ee/cluster/bin/ext/javax~persistence~api/persistence-api-1.0.jar",
		"j2ee/cluster/bin/ext/saaj13/saaj-api.jar", 
		"j2ee/cluster/bin/ext/servlet/servlet.jar", 
		"j2ee/cluster/bin/ext/stax_api/jsr173_1.0_api.jar"
	};
	
	private static final String[] CLASSPATH_J2EE_14 = {
		"j2ee/cluster/bin/ext/mail-activation-iaik/activation.jar", 
		"j2ee/cluster/bin/ext/j2eeca/connector.jar", 
		"j2ee/cluster/bin/ext/ejb20/ejb20.jar", 
		"j2ee/cluster/bin/ext/tc~je~jacc~plb/jacc-1_1-fr-class.zip", 
		"j2ee/deployment/lib/javaee_deployment-1_2-fr-class.jar", 
		"j2ee/cluster/bin/ext/tc~je~javax77/javax77.jar",
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxm-api.jar",
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxr-api.jar", 
		"j2ee/cluster/bin/ext/tc~bl~base_webservices_lib/jaxrpc-api.jar",
		"j2ee/cluster/bin/ext/jms/jms.jar", 
		"j2ee/cluster/bin/system/jta.jar", 
		"j2ee/cluster/bin/ext/mail-activation-iaik/mail.jar", 
		"j2ee/cluster/bin/ext/saaj13/saaj-api.jar",
		"j2ee/cluster/bin/ext/servlet/servlet.jar"
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
