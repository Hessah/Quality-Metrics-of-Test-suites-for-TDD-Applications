package net.sf.lavalamp.site;

public class LoginFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	public LoginFailedException() {
		super();
	}
	
	public LoginFailedException(Exception e) {
		super(e);
	}
	public LoginFailedException(String message) {
		super(message);
	}

	
}
