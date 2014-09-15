package net.sf.lavalamp.site;

import java.io.IOException;
import java.io.Serializable;

import net.sf.lavalamp.LavaLogger;

public abstract class AbstractBuildSite implements BuildSite, Serializable {
	private static final long serialVersionUID = -2273732257420207602L;

	protected String url;

	protected transient Getter urlGetter;

	protected transient LavaLogger logger = new LavaLogger();
	
	@Override
	public void login( ) throws LoginRequiredException,LoginFailedException, IOException {
		// do nothing
	}

	@Override
	public void setUrlGetter(Getter urlGetter) {
		this.urlGetter = urlGetter;
	}
	
	@Override
	public Getter  getUrlGetter() {
		return this.urlGetter;
	}

	@Override
	public void setProperties(SiteProperties serverProperties) {
		url = serverProperties.getUrl();
		
	}
	
	@Override
	public String toString() {
		return String.format("build site %s", url);
	}

}
