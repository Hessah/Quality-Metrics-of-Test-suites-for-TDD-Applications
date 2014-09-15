package net.sf.lavalamp.site;

import java.io.Serializable;

public class SiteProperties implements Serializable {
	
	private static final long serialVersionUID = 3890403764672416848L;
	private String className;
	private String getterClass = "net.sf.lavalamp.site.UrlGetter";
	private String url;	
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "\n\t\t\tserver=" + className + ", url=" + url + " getter=" + getterClass;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public void setGetterClass(String getterClass) {
		this.getterClass = getterClass;
	}

	public String getGetterClass() {
		return getterClass;
	}
}
