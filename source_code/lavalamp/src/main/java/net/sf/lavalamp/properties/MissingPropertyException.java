package net.sf.lavalamp.properties;

public class MissingPropertyException extends RuntimeException {
	public MissingPropertyException(String message) {
		super(message);
	}
	
	public MissingPropertyException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = -5863305820688980723L;

}
