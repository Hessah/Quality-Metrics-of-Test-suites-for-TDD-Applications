package net.sf.lavalamp.device;

import java.util.List;

public class TurnOn implements Action {

	@Override
	public void perform(List<String> events, Device device) {
		events.add(device + " turned on");
		device.turnOn();

	}

	
}
