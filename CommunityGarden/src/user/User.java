package user;

public class User {
	String zone;
	String month;
	//String zone;
	
	public User(String zone, String month) {
		setZone(zone);
		setMonth(month);
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

