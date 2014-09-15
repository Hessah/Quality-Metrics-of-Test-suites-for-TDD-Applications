package net.sf.lavalamp.application;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.site.Console;

/**
 * Lavalamp starts here.
 * 
 * Example:   <code>java -jar lavalamp-x.x.x-jar-with-dependencies.jar lavalamp.yml</code>
 * 
 * @author Steven Hale
 * 
 */
public class UniversalRunner {
	
	
	protected static final String USAGE = "Usage: java -jar [lavalamp_jar_file] [yml_properties_file]";

	public void run(String[] args, Application application, Console console, LavaLogger logger)
			throws Exception {
		if (args.length != 1) {
			logger.error(USAGE);
			return;
		}
		ApplicationProperties applicationProperties = new ApplicationPropertiesLoader().load(args[0]);
		
		application.setProperties(applicationProperties);
		application.init();
		application.setConsole(console);
		
		logger.debug(applicationProperties.toString());
		
		application.exec(logger, new Pause());
		
	}

	/**
	 * @param args
	 *            name of the properties (in yaml format). See 
	 *           testweb.yml for examples.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Application app = new WebRun();
		new UniversalRunner().run(args, app, new Console(),
				new LavaLogger());

	}

}
