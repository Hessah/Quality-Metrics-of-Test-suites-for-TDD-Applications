package net.sf.lavalamp.site;

import java.io.IOException;

import net.sf.lavalamp.LavaLogger;

public class BuildChecker {
	private static final long serialVersionUID = 8983123487221293458L;
	private final transient LavaLogger logger = new LavaLogger();

	public boolean check(Build build, Console console) throws IOException,
			LoginFailedException {

		logger.info("checking " + build.getIdentity());
		BuildSite site = build.getBuildSite();
		try {
			return site.wasLastBuildSuccessful(build);
		} catch (LoginRequiredException e) {
			site.setCredentials(console);
			return checkAgainAfterLoginAttempt(build, site);

		}

	}

	protected boolean checkAgainAfterLoginAttempt(Build build, BuildSite site)
			throws IOException, LoginFailedException {
		try {
			site.login();
			return site.wasLastBuildSuccessful(build);
		} catch (LoginRequiredException e) {
			throw new LoginFailedException(e);
		}
	}

}
