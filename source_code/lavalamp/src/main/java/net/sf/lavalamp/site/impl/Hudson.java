package net.sf.lavalamp.site.impl;

import java.io.IOException;
import java.io.Serializable;

import net.sf.lavalamp.site.AuthBuildSite;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.LoginRequiredException;

public class Hudson extends AuthBuildSite implements Serializable {

	private static final long serialVersionUID = -8206817273748385973L;

	public static final String URL_LASTBUILD = "/job";

	@Override
	public String getLastBuildUrl(Build build) {

		return String.format("%s%s/%s/lastBuild/buildNumber", url,
				URL_LASTBUILD, build.getIdentity());
	}

	public String getLastSuccessfulBuildUrl(Build build) {

		return String.format("%s%s/%s/lastSuccessfulBuild/buildNumber", url,
				URL_LASTBUILD, build.getIdentity());
	}

	@Override
	public boolean wasLastBuildSuccessful(Build build)
			throws LoginRequiredException, IOException {
		if (credentials.get(url) != null) {
			urlGetter.setCredentials(credentials.get(url));
		}
		String lastBuildNumber = urlGetter.get(getLastBuildUrl(build));
		String lastSuccessfulBuildNumber = urlGetter
				.get(getLastSuccessfulBuildUrl(build));
		if (lastBuildNumber.equals(lastSuccessfulBuildNumber)) {
			return true;
		}

		return false;

	}

}
