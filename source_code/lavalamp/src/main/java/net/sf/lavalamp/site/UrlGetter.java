package net.sf.lavalamp.site;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.LavaLogger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

public class UrlGetter extends AbstractGetter {
	private final LavaLogger logger = new LavaLogger();

	@Override
	public String get(String url) throws IOException, LoginRequiredException {
		char[] sensitive = {};
		return get(url, sensitive);
	}

	protected String getMaskedUrl(String url, char[] sensitive) {
		if (sensitive != null && sensitive.length > 0) {
			return url + "*****";
		}
		return url;
	}

	@Override
	public String get(String url, char[] sensitive) throws IOException,
			LoginRequiredException {
		logger.debug("getting " + getMaskedUrl(url, sensitive));

		GetMethod method = new GetMethod(url + String.valueOf(sensitive));
		HttpClient client = new HttpClient();
		AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
		setAuthType(method, client, scope);
		try {
			handleStatusCode(method, client.executeMethod(method));
			return  readResponse(method).toString();
		} finally {
			method.releaseConnection();
		}
	}

	private StringBuffer readResponse(GetMethod method)
			throws UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(method
				.getResponseBodyAsStream(), method.getResponseCharSet()));

		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		logger.debug(sb.toString());
		br.close();
		return sb;
	}

	protected void handleStatusCode(GetMethod method, int statusCode)
			throws LoginRequiredException, IOException {
		logger.debug("HttpStatus " + statusCode);
		if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
			throw new LoginRequiredException("Unauthorized " + statusCode);
		}
		if (statusCode == HttpStatus.SC_FORBIDDEN) {
			throw new LoginRequiredException("Forbidden " + statusCode);
		}
		if (statusCode != HttpStatus.SC_OK) {
			throw new IOException("Method failed: " + statusCode + " "
					+ method.getStatusLine());
		}
	}

	protected void setAuthType(GetMethod method, HttpClient client,
			AuthScope scope) {
		if (credentials != null) {
			client.getState().setCredentials(scope, credentials);
			method.setDoAuthentication(true);
		}
	}

}
