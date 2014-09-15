package net.sf.lavalamp.site;

public class Console {
	public char[] readPassword(String fmt, Object... args) {
		return System.console().readPassword(fmt, args);
	}
	public String readLine(String fmt, Object... args) {
		return System.console().readLine(fmt, args);
	}

}
