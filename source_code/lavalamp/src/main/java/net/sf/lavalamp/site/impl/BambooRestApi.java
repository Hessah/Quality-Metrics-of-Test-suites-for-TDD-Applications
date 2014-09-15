package net.sf.lavalamp.site.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.site.AuthBuildSite;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.LoginRequiredException;

/**
 * Uses rest api available from Bamboo 2.3
 * 
 * @author stehal
 * @see BambooRemoteApi
 * 
 */
public class BambooRestApi extends AuthBuildSite implements Serializable{

	private static final long serialVersionUID = -3039410670557839775L;

	
	@Override
	public String getLastBuildUrl(Build build) throws UnsupportedEncodingException {
		String authType = "";
		authType = setCredentials("?", authType);
		return String.format("%s/rest/api/latest/build/%s/latest%s", url, build
				.getIdentity(), authType);
	}

	protected String setCredentials(String prefix, String authType) {
		if (credentials.get(url) != null) {
			authType = prefix +"os_authType=basic";
			urlGetter.setCredentials(credentials.get(url));
		}
		return authType;
	}

	@Override
	public boolean wasLastBuildSuccessful(Build build)
			throws LoginRequiredException, IOException {
        String lastBuildUrl = getLastBuildUrl(build);
		String response= urlGetter.get(lastBuildUrl);
		if (response.contains("state=\"Successful\"")) {
			return true;
		}
        
		return false;

	}
	
	
}
