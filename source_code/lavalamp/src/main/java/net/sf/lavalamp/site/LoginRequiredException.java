package net.sf.lavalamp.site;

public class LoginRequiredException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginRequiredException() {
		super();
	}
	public LoginRequiredException(String message) {
		super(message);
	}
}
