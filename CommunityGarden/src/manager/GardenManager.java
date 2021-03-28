package manager;

import IO.CropListReader;
import crop.Crop;
import user.User;

public class GardenManager {
	Crop crop;
	User user;
	static int returnCropSize = 0;
	static int monthPosition = 0;
	
	public GardenManager(String zone, String month) {
		user = new User(zone, month);
	}
	
	public Crop[] readCropList(String filename, String zone, String month) {
		Crop[] crops = CropListReader.readCropsFromFile(filename);
		Crop[] returnCrops = new Crop[CropListReader.getCropsSize()];
		for(int i = 0; i < CropListReader.getCropsSize(); i++) {
			for(int j = 0; j < crops[i].getNumZones(); j++) {
				for(int l = 0; l < crops[i].getNumMonths(); l++) {
					if((crops[i].getZones()[j].equals(zone)) && (crops[i].getMonthsSow()[l].equals(month))) {
						returnCrops[returnCropSize] = crops[i];
						returnCropSize++;
						monthPosition = l;
					}
				}
			}
		}
		return returnCrops;
	}
	
	public String cropInformation() {
		return crop.toString();
	}
	
	public static int getReturnCropSize() {
		return returnCropSize;
	}
	
	public static int getMonthPosition() {
		return monthPosition;
	}

}
