package net.sf.lavalamp.site;

import java.io.IOException;

public class DummyRemoteGetter extends  AbstractGetter {

	@Override
	public String get(String url) throws IOException, LoginRequiredException {
		if (url.contains("auth=auth12345")) {
			return "<buildState>Successful</buildState>";
		}
		return "<error>User not authenticated";
	}

	@Override
	public String get(String url, char[] sensitive) throws IOException,
			LoginRequiredException {
		return "<auth>auth12345</auth>";
	}

}
