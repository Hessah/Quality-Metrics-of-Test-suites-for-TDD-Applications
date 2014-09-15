package net.sf.lavalamp.device;

public class TimeOfDay implements Comparable<TimeOfDay> {
	private Integer hours;
	private Integer minutes;

	public TimeOfDay(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public TimeOfDay(String time) {
		this.hours = new Integer(time.substring(0,2));
		this.minutes = new Integer(time.substring(3,5));
	}

	
	@Override
	public int compareTo(TimeOfDay that) {

		int hourComparison = this.hours.compareTo(that.hours);
		if (hourComparison != 0) {
			return hourComparison;
		}
		return this.minutes.compareTo(that.minutes);
	}

	public Integer getHours() {

		return hours;
	}

	public Integer getMinutes() {

		return minutes;
	}

	@Override
	public String toString() {

		return hours + ":" + minutes;
	}

	@Override
	public int hashCode() {
		
		return new Integer(100 * hours +  minutes).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeOfDay other = (TimeOfDay) obj;
		if (!hours.equals(other.hours))
			return false;
		if (!minutes.equals(other.minutes))
			return false;
		return true;
	}

}
