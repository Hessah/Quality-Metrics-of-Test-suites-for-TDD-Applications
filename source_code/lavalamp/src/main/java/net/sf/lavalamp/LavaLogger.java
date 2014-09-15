package net.sf.lavalamp;

import java.io.PrintStream;
import java.util.Calendar;
/**
 * Very simple logging class - good enough for now
 * @author Steven Hale
 *
 */
public class LavaLogger {
	private static boolean debug = false;
	private static PrintStream out = System.out;
	private static PrintStream err = System.err;

	public void info(String message) {
		info(Calendar.getInstance(), message);
	}

	public void info(Calendar calendar, String message) {
		out.println(calendar.getTime() + " " + message);
	}
	
	public void error( Throwable e) {
		error(Calendar.getInstance(), e);
	}

	public void error(Calendar calendar, Throwable e) {
		error(calendar, e.getMessage());
		for (StackTraceElement element : e.getStackTrace()) {
			err.println(element);
		}
	}
	
	public void error(Calendar calendar, String message) {
		err.println(calendar.getTime() + " " + message);
	}
	public void error(String message) {
		err.println(message);
	}

	public void debug(String message) {
		debug(Calendar.getInstance(), message);
	}
	
	public void debug(Calendar calendar, String message) {
		if (debug) {
			info(calendar, message);
		}
	}

	public static void setDebug(boolean debug) {
		LavaLogger.debug = debug;
	}

	public static void setOut(PrintStream out) {
		LavaLogger.out = out;
	}
	public static void setErr(PrintStream err) {
		LavaLogger.err = err;
	}

	
}
