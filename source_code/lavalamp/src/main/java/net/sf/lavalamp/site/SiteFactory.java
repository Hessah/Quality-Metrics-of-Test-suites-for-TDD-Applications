package net.sf.lavalamp.site;


public class SiteFactory {

	public  BuildSite make(SiteProperties properties)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		
		BuildSite site = (BuildSite) Class.forName(properties.getClassName())
				.newInstance();
		site.setProperties(properties);
		Getter getter = (Getter) Class.forName(properties.getGetterClass())
		.newInstance();

		site.setUrlGetter(getter);
		return site;
	}

}
