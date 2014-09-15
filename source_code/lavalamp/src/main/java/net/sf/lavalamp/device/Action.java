package net.sf.lavalamp.device;

import java.util.List;

/**
 * An action for a device
 * @author stehal
 *
 */
public interface Action {
	
	/**
	 * Performs this action for the device
	 * @param events list of events used to record a number of actions
	 * @param device
	 */
	void perform(List<String> events, Device device);
	

}
