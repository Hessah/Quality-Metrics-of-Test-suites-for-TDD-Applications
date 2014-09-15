package net.sf.lavalamp.site;

import java.io.Serializable;

import net.sf.lavalamp.properties.MissingPropertyException;
import net.sf.lavalamp.site.SiteProperties;

public class BuildProperties implements Serializable{
	private static final long serialVersionUID = -4234650442682237966L;
	private String build;
	private SiteProperties siteProperties;

	
	public void check() {
		if (build == null) {
			throw new MissingPropertyException(
					"build must be specified in properties file");
		}
	}
	
	@Override
	public String toString() {
		return "\n\t\tbuildId=" + build  + ",  " 
				+ siteProperties ;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public SiteProperties getSiteProperties() {
		return siteProperties;
	}

	public void setSiteProperties(SiteProperties siteProperties) {
		this.siteProperties = siteProperties;
	}

}
