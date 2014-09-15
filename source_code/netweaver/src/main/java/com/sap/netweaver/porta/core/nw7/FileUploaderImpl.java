/*******************************************************************************
 * Copyright (c) 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev (SAP AG) - initial API and implementation
 *******************************************************************************/
package com.sap.netweaver.porta.core.nw7;

import static com.sap.netweaver.porta.core.nw7.FaultReasons.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.NoWSGateException;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class FileUploaderImpl implements FileUploader {
	
	private String url;
	private HttpClient client;
	private AuthScope authScope;

	public FileUploaderImpl(String host, int port) {
		url = String.format("http://%s:%d/DeployWS/FileUpload", host, port);
		client = null;
		authScope = new AuthScope(host, port, "DeployWS Basic Authentication Area");
	}

	public void setCredentials(String user, String password) {
		client = new HttpClient();
		client.getParams().setAuthenticationPreemptive(true);
		client.getState().setCredentials(authScope, new UsernamePasswordCredentials(user, password));
	}

	public String[] upload(File[] archives) throws CoreException {
		// check if there are any credentials already set
		if (client == null) {
			// trigger the mechanism for requesting user for credentials
			throw new NotAuthorizedException(FAULT_UNAUTHORIZED.getFaultReason());
		}
		
		PostMethod method = null;
		try {
			Part[] parts = new Part[archives.length];
			for (int i = 0; i < archives.length; i++) {
				parts[i] = new FilePart(archives[i].getName(), archives[i]);
			}
			
			method = new PostMethod(url);
			method.setDoAuthentication(true);
			method.setRequestEntity(new MultipartRequestEntity(parts, method.getParams()));
			
			int statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
				throw new NotAuthorizedException(FAULT_INVALID_CREDENTIALS.getFaultReason());
			} else if (statusCode == HttpStatus.SC_FORBIDDEN) {
				throw new NotAuthorizedException(FAULT_PERMISSION_DENIED.getFaultReason());
			} else if (statusCode == HttpStatus.SC_NOT_FOUND) {
				throw new NoWSGateException(null, url);
			} else if (statusCode != HttpStatus.SC_OK) {
				throw new CoreException(method.getStatusText());
			}
			
			InputStream responseStream = method.getResponseBodyAsStream();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(responseStream));
			String line;
			List<String> paths = new ArrayList<String>();
			while ((line = responseReader.readLine()) != null) {
				paths.add(line);
			}
			responseReader.close();
			responseStream.close();
			
			return paths.toArray(new String[] {});
		} catch (HttpException e) {
			throw new CoreException(e);
		} catch (IOException e) {
			throw new CoreException(e);
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
	}

}
