package net.sf.lavalamp.application;

import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.LavaLogger;

/**
 * Base class for application runners.
 * 
 * @author Steven Hale
 * 
 */
public abstract class DefaultApplication implements Application {
	protected ApplicationProperties properties;
	protected static final String TICK = ".";
	protected Console console;

	/**
	 * Initializes the application
	 */
	@Override
	public void init() throws Exception {
		LavaLogger.setDebug(properties.isDebug());
	}

	@Override
	public void setProperties(ApplicationProperties properties) {
		this.properties = properties;

	}
	@Override
	public void setConsole(Console console) {
		this.console = console;
	}
}