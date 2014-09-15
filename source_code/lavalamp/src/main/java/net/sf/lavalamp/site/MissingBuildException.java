package net.sf.lavalamp.site;

public class MissingBuildException extends Exception {
	
	private static final long serialVersionUID = -5854305820688980723L;
	public MissingBuildException(String message) {
		super(message);
	}
	
	public MissingBuildException(String message, Throwable e) {
		super(message, e);
	}

	

}
