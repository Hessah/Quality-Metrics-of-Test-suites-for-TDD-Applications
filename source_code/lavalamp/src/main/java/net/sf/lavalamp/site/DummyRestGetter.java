package net.sf.lavalamp.site;

import java.io.IOException;

public class DummyRestGetter extends AbstractGetter {

	@Override
	public String get(String url) throws IOException, LoginRequiredException {
		if (url.contains("os_authType=basic")) {
			return "state=\"Successful\"";
		}
		throw new LoginRequiredException();
	}

	@Override
	public String get(String url, char[] sensitive) throws IOException,
			LoginRequiredException {
		return "<auth>auth12345</auth>";
	}

	

}
