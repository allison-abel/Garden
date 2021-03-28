package crop;

public class Crop {
	String name;
	String[] zones;
	String[] monthsSow;
	String[] monthsHarvest;
	int numZones;
	int numMonths;
	
	public Crop(String name, String[] zones, String[] monthsSow, String[] monthsHarvest, int numZones, int numMonths) {
		setName(name);
		setZones(zones);
		setMonthsSow(monthsSow);
		setMonthsHarvest(monthsHarvest);
		setNumZones(numZones);
		setNumMonths(numMonths);
	}
	
	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}
	
	public int getNumMonths() {
		return numMonths;
	}

	public void setNumZones(int numZones) {
		this.numMonths = numZones;
	}
	
	public int getNumZones() {
		return numZones;
	}

	public void setName(String name) {
		if(name.isBlank()) {
			throw new IllegalArgumentException("name cannot be blank");
		}
		this.name = name;
	}
	
	public String getName() {
		System.out.println(name + "\n");
		return name;
	}
	
	public void setZones(String[] zones) {
		this.zones = zones;
	}
	
	public String[] getZones() {
		return zones;
	}
	
	public void setMonthsSow(String[] monthsSow) {
		this.monthsSow = monthsSow;
	}
	
	public String[] getMonthsSow() {
		return monthsSow;
	}

	public void setMonthsHarvest(String[] monthsHarvest) {
		this.monthsHarvest = monthsHarvest;
	}
	
	public String[] getMonthsHarvest() {
		return monthsHarvest;
	}

	public String toString() {
		String result = "The crop " + getName() + " in zone(s) ";
		for(int i = 0; i < getZones().length; i++) {
			if(getZones()[i] != null) {
				if(i != getZones().length - 1) {
					result += getZones()[i] + ", ";
				}
				else {
					result += getZones()[i] + " ";
				}
			}
		}
		result += "can be planted in the month(s) ";
		for(int i = 0; i < getMonthsSow().length; i++) {
			if(getMonthsSow()[i] != null) {
				if(i != getMonthsSow().length - 1) {
					result += getMonthsSow()[i] + ", ";
				}
				else {
					result += getMonthsSow()[i] + " ";
				}
			}
		}
		result += "and can be harvested in month(s) ";
		for(int i = 0; i < getMonthsHarvest().length; i++) {
			if(getMonthsHarvest()[i] != null) {
				if(i != getMonthsHarvest().length - 1) {
					result += getMonthsHarvest()[i] + ", ";
				}
				else {
					result += getMonthsHarvest()[i] + ".";
				}
			}
		}
		return result;
	}


}
