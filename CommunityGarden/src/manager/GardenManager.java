package manager;

import crop.Crop;
import user.User;

public class GardenManager {
	Crop crop;
	User user;
	
	public GardenManager(String name, String[] zones, String[] monthsSow, String[] monthsHarvest, String location, String month, String zone) {
		user = new User(location, month, zone);
		crop = new Crop(name, zones, monthsSow, monthsHarvest);
	}
}
