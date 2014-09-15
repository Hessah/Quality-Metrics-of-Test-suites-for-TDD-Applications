package net.sf.lavalamp.site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.lavalamp.LavaLogger;

public class Builds implements Serializable {
	private static final long serialVersionUID = -5036800757512568965L;
	private final List<Build> builds;
	private final transient LavaLogger logger = new LavaLogger();

	public Builds() {
		this.builds = new ArrayList<Build>();
	}

	public void add(Build build) {
		builds.add(build);

	}

	public List<Build> getBuilds() {
		return builds;
	}

	public boolean allSuccessful() {
		for (Build build : builds) {
			boolean successful = build.isSuccessful();
			logger.debug("buildId=" +build.getIdentity() + " successful=" + successful);
			if (!successful) {
				return false;
			}
		}
		return true;
	}

	public Build getBuild(String buildId) throws MissingBuildException {
		for (Build build : builds) {
			if (build.getIdentity().equals(buildId)) {
				logger.debug("found build " + buildId);
				return build;
			}
		}
		throw new MissingBuildException(buildId + " not found");

	}
}
