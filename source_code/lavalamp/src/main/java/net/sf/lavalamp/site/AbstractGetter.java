package net.sf.lavalamp.site;

import org.apache.commons.httpclient.UsernamePasswordCredentials;

public abstract class AbstractGetter implements Getter {
	protected UsernamePasswordCredentials credentials;


	@Override
	public void setCredentials(UsernamePasswordCredentials credentials) {
		this.credentials = credentials;
	}
}
