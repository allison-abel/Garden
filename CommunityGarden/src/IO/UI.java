package IO;

import java.util.Scanner;

import crop.Crop;
import manager.GardenManager;

public class UI {
	public static void main(String args[]) {
		String filename = "files/input.txt";
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Community Garden Helper");
		System.out.println("Please enter:" + "\n1 if you would like to find crops that can grow where you live" + "\n2 to quit\n");
		int choice = Integer.parseInt(input.nextLine());


		if(choice == 1) {
			System.out.println("What zone do you live in?");
			String zone = input.nextLine();
			System.out.println("The zone you live in is " + zone + "\n");
			System.out.println("What month is it?");
			String month = input.nextLine();
			System.out.println("The current month is " + month + "\n");
			GardenManager manager = new GardenManager(zone, month);
			Crop[] cropList = manager.readCropList(filename, zone, month);
			String print = "The following crops can be planted right now\n";
			System.out.println("There are " + cropList.length + " crops in the array\n");
			for(int i = 0; i < cropList.length; i++) {
				System.out.println("in the loop \n");
				System.out.println("Crop list " + cropList[i] + "\n");
				System.out.println("" + cropList[i].getName() + "\n");
				print += cropList[i].getName() + "\n";
				System.out.print("Past the " + i + " getName\n");
			}
			System.out.println(print);
		}
		
		if(choice == 2) {
			System.out.println("Goodbye");
		}

		input.close();
	}
}
