package net.sf.lavalamp.site.impl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.sf.lavalamp.site.Build;

/**
 * Uses rest api available from Bamboo 3.0
 * 
 * @author stehal
 * @see BambooRemoteApi
 * 
 */
public class Bamboo3RestApi extends BambooRestApi implements Serializable{

	
	private static final long serialVersionUID = 5927934388909830940L;
	
	@Override
	public String getLastBuildUrl(Build build) throws UnsupportedEncodingException {
		String authType = "";
		authType = setCredentials("&", authType);
		
		return String.format("%s/rest/api/latest/result/%s?expand=results%s.result%s", url,  build
				.getIdentity(), URLEncoder.encode("[0]", "UTF-8"),authType);
	}

	
	
}
