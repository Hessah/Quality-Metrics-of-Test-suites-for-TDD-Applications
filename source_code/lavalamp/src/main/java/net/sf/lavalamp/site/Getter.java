package net.sf.lavalamp.site;

import java.io.IOException;

import org.apache.commons.httpclient.UsernamePasswordCredentials;

public interface Getter {

	String get(String url) throws IOException, LoginRequiredException;

	String get(String url, char[] sensitive) throws IOException,
			LoginRequiredException;

	void setCredentials(UsernamePasswordCredentials credentials);

	

}