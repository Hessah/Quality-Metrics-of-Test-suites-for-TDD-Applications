package org.lunivore.tyburn;

/**
 * Set the system property org.lunivore.tyburn.speed to an integer value
 * to hold back after every action that Tyburn performs by that number 
 * of milliseconds.
 */
public class PropertyDrivenSpeed extends Speed {

	public static final String SPEED_PROPERTY = "org.lunivore.tyburn.speed";

	public PropertyDrivenSpeed() {
		super(System.getProperty(SPEED_PROPERTY) == null ? 0 : Integer.valueOf(System.getProperty(SPEED_PROPERTY)));
	}
}
