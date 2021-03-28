package IO;

import java.util.Scanner;

import crop.Crop;
import manager.GardenManager;

public class UI {
	public static void main(String args[]) {
		String filename = "files/input.txt";
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Community Garden Helper");
		System.out.println(
				"Please enter:" + "\n1 if you would like to learn about crops that can grow where you live" + "\n2 to quit\n");
		int choice = Integer.parseInt(input.nextLine());

		if (choice == 1) {
			System.out.println("What zone do you live in?");
			String zone = input.nextLine();
			System.out.println("What month is it?");
			String month = input.nextLine();
			GardenManager manager = new GardenManager(zone, month);
			Crop[] cropList = manager.readCropList(filename, zone, month);
			System.out.println("The following crop(s) can be planted in " + month + " in zone " + zone + ":");
			for (int i = 0; i < GardenManager.getReturnCropSize(); i++) {
				System.out.println(cropList[i].getName().toUpperCase() + ", which will be ready to be harvested in "
						+ cropList[i].getMonthsHarvest()[GardenManager.getMonthPosition()] + "\n");
			}

		}

		if (choice == 2) {
			System.out.println("Goodbye");
		}

		input.close();
	}
}
