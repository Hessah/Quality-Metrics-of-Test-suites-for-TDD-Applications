package net.sf.lavalamp.device;

public class DummyDevice extends AbstractDevice {

	private static final long serialVersionUID = 2044530715726112242L;

	@Override
	public void init() {
		// do nothing
	}

	@Override
	public String toString() {
		return String.format("dummy device " + this.identity);
	}

}
