package net.sf.lavalamp.site.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.lavalamp.site.AuthBuildSite;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;

/**
 * Uses the remote api (superceded by rest api in Bamboo 2.3 and deprecated in 2.5)
 * 
 * @author stehal
 * @see BambooRestApi
 * 
 */
@Deprecated
public class BambooRemoteApi extends AuthBuildSite  {
	private static final long serialVersionUID = -5856767171663531516L;
	
	private static Map<String,String> keys = new HashMap<String,String>();
	
	public static final String URL_LOGIN = "/api/rest/login.action";
	public static final String URL_LASTBUILD = "/api/rest/getLatestBuildResults.action";
	
	
	@Override
	public void login() throws IOException, LoginRequiredException, LoginFailedException {
		logger.debug("login");
		String response = urlGetter.get(getLoginUrl(credentials.get(url).getUserName()), credentials.get(url).getPassword().toCharArray());
		if (response.contains("<error>")) {
			throw new LoginFailedException(response);
		}
		keys.put(url, findAuth(response));

	}

	protected String findAuth(String response) {
		Pattern pattern = Pattern.compile("<auth>(.*)</auth>");
		Matcher matcher = pattern.matcher(response);
		matcher.find();
		return matcher.group(1);
	}

	protected String getLoginUrl(String userid) {
		return String.format("%s%s?username=%s&password=", url, URL_LOGIN,
				userid);
	}

	
	public String getLastBuildUrl(Build build) {
		return String.format("%s%s?buildKey=%s&auth=%s", url, URL_LASTBUILD,
				build.getIdentity(), keys.get(url));
	}

	@Override
	public boolean wasLastBuildSuccessful(Build build)
			throws LoginRequiredException, IOException {
		return wasBuildSuccessful(urlGetter.get(getLastBuildUrl(build)));
	}

	public String getAuthenticationKey() {
		return keys.get(url);
	}

	public boolean wasBuildSuccessful(String response)
			throws LoginRequiredException {
		if (response.contains("<buildState>Successful</buildState>")) {
			return true;
		}
		if (response.contains("<error>User not authenticated")) {
			throw new LoginRequiredException();
		}

		return false;
	}

}
