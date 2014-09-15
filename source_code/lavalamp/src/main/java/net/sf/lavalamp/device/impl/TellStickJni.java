package net.sf.lavalamp.device.impl;

import net.sf.lavalamp.device.AbstractDevice;

import com.sun.jna.Native;

/**
 * Uses jni to control any tellstick compatable devices.
 * 
 * @author Steven Hale
 * 
 */
public class TellStickJni extends AbstractDevice {
	
	private static final long serialVersionUID = -7520529496059026042L;
	private transient TellStickLibrary library;
	
	public void setLibrary(TellStickLibrary library) {
		this.library = library;
	}
	
	public void turnOff() {
		super.turnOff();
		boolean result = library.devTurnOff(new Integer(identity));
		if (!result) {
			throw new RuntimeException("Tellstick " + identity + " could not be turned off");
		}
	}

	public void init() {
		library = (TellStickLibrary) Native.loadLibrary(("TellUsbD101"),
				TellStickLibrary.class);
	}

	
	public void turnOn() {
		super.turnOn();
		boolean result = library.devTurnOn(new Integer(identity));
		if (!result) {
			throw new RuntimeException("Tellstick " + identity + " could not be turned on");
		}
	}

	

}
