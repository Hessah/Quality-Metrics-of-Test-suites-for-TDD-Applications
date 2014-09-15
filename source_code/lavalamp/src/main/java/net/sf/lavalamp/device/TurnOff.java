package net.sf.lavalamp.device;

import java.util.List;

public class TurnOff implements Action {

	@Override
	public void perform(List<String> events, Device devices) {
		events.add(devices + " turned off");
		devices.turnOff();
	}

	
}
