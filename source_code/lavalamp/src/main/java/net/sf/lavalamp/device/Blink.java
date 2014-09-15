package net.sf.lavalamp.device;

import java.util.List;

import net.sf.lavalamp.Pause;

public class Blink implements Action {
	private Pause pause = new Pause();
	private final Action turnOn = new TurnOn();
	private final Action turnOff = new TurnOff();

	@Override
	public void perform(List<String> events, Device device) {
		for (int i = 0; i < 5; i++) {
			try {
				int milliseconds = 500;
				pause.sleep(milliseconds);
				turnOff.perform(events, device);
				pause.sleep(milliseconds);
				turnOn.perform(events, device);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void setPause(Pause pause) {
		this.pause = pause;
	}

}
