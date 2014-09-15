package net.sf.lavalamp.site;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.site.Build;

import org.apache.commons.httpclient.UsernamePasswordCredentials;

public interface BuildSite {

	/**
	 * Throws a RuntimeException when the login fails
	 */
	void login() throws LoginRequiredException, LoginFailedException, IOException;

	void setProperties(SiteProperties properties);
	
	boolean wasLastBuildSuccessful(Build build) throws LoginRequiredException,
			IOException;

	String getLastBuildUrl(Build build) throws UnsupportedEncodingException;

	void setUrlGetter(Getter urlGetter);
	Getter getUrlGetter();

	void setCredentials(Console console);
	
	UsernamePasswordCredentials getCredentials();
	
	

}
