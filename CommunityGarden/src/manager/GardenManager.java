package manager;

import IO.CropListReader;
import crop.Crop;
import user.User;

public class GardenManager {
	Crop crop;
	User user;
	
	public GardenManager(String zone, String month) {
		user = new User(zone, month);
	}
	
	public Crop[] readCropList(String filename, String zone, String month) {
		Crop[] crops = CropListReader.readCropsFromFile(filename);
		Crop[] returnCrops = new Crop[CropListReader.getCropsSize()];
		int k = 0;
		for(int i = 0; i < CropListReader.getCropsSize(); i++) {
			System.out.println("In loop for readCropList\n");
			for(int j = 0; j < crops[i].getNumZones(); j++) {
				System.out.println("The number of zones for crop " + i + " is " + crops[i].getNumZones());
				for(int l = 0; l < crops[i].getNumMonths(); l++) {
					if(crops[i].getZones()[j] == zone && (crops[i].getMonthsHarvest()[l] == month || crops[i].getMonthsSow()[l] == month)) {
						returnCrops[k] = crops[i];
					}
				}
			}
			k++;
		}
		return returnCrops;
	}
	
	public String cropInformation() {
		return crop.toString();
	}
}
