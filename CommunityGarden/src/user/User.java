package user;

public class User {
	String location;
	String month;
	String zone;
	
	public User(String location, String month, String zone) {
		setLocation(location);
		setMonth(month);
		setZone(zone);
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getMonth() {
		return month;
	}
	
	private void setZone(String zone) {
		this.zone = zone;
	}
	
	public String getZone() {
		return zone;
	}
}

