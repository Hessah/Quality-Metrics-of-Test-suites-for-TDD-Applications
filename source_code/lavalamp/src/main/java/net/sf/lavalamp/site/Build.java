package net.sf.lavalamp.site;

import java.io.Serializable;

/**
 * An identified build on a build server
 */
public class Build  implements Serializable{
	
	private static final long serialVersionUID = -1924673982176690L;
	private final String identity;
    private boolean isSuccessful = true;
    private BuildSite buildSite;
	public BuildSite getBuildSite() {
		return buildSite;
	}
	public void setBuildSite(BuildSite buildServer) {
		this.buildSite = buildServer;
	}
	public String getIdentity() {
		return identity;
	}
	public boolean isSuccessful() {
		return isSuccessful;
	}
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public Build(String identity) {
		this.identity = identity;
	}
	public String toString() {
		String colour= "<font color='red'>";
		String successful = "failed";
		if (isSuccessful) {
			successful = "successful";
			colour= "<font color='green'>";
		}
		return String.format("%s build %s %s (%s)</font>", colour, identity, successful, buildSite);
	}
	

}
