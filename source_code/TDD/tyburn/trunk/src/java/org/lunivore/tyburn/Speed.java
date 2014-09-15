package org.lunivore.tyburn;

/**
 * Controls the speed at which the window control operates.
 * This is normally changed by using a system property that can
 * be easily switched on or off - see PropertyDrivenSpeed. 
 */
public class Speed {

	public static Speed FLAT_OUT = new Speed(0);
	public static Speed FAST_WALK = new Speed(200);
	public static Speed SLOW_WALK = new Speed(500);
	
	private final int speed;
	
	public Speed(int speed) {
		this.speed = speed;
	}

	public void holdBack() {
		if (speed > 0) {
			synchronized (this) {
				try {
					wait(speed);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}


}
