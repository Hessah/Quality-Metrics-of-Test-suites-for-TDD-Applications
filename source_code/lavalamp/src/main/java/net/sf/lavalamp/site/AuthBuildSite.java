package net.sf.lavalamp.site;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.UsernamePasswordCredentials;

public abstract class AuthBuildSite extends AbstractBuildSite implements
		Serializable {
	private static final long serialVersionUID = -4344369506957410641L;

	protected transient static Map<String, UsernamePasswordCredentials> credentials = new HashMap<String, UsernamePasswordCredentials>();

	@Override
	public void setCredentials(Console console) {
		String username = console.readLine("username for " + url + " :");
		char[] password = console.readPassword(
				"Password for %s (username %s):", url, username);
		credentials.put(url, new UsernamePasswordCredentials(username, String
				.valueOf(password)));
	}

	public UsernamePasswordCredentials getCredentials() {
		return credentials.get(url);
	}
	
	public void  clearCredentials() {
		 credentials.clear();
	}
	
	public void setCredentials(String url, UsernamePasswordCredentials credentials) {
		AuthBuildSite.credentials.put(url, credentials);
		
	}
}
