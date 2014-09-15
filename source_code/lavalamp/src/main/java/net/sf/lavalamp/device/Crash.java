package net.sf.lavalamp.device;

import java.util.List;

public class Crash implements Action {

	@Override
	public void perform(List<String> events, Device device) {
		throw new RuntimeException("error!");

	}

	
}
