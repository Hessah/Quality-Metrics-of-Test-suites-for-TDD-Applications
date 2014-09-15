package net.sf.lavalamp.properties;

public class Off {
	private String start = "00:00";
	private String end = "00:00";

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "[start=" + start +  ", end=" + end + "]";
	}
}
