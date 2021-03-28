package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import crop.Crop;

public class CropListReader {
	static int cropsSize = 0;

	public static Crop[] readCropsFromFile(String filepath) {
		Crop[] crops = new Crop[100];
		File file = new File(filepath);
		Scanner scan = null;

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
		String line;
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			System.out.print("Line is: " + line + "\n");
			Crop crop = processLine(line);
			crops[cropsSize] = crop;
			cropsSize++;
		}
		
		scan.close();
		return crops;
	}
	
	public static int getCropsSize() {
		return cropsSize;
	}
	
	
	private static Crop processLine(String line) {
		Scanner lineReader = new Scanner(line);
		lineReader.useDelimiter(",");
		String name = lineReader.next();
		System.out.println("Crop name is: " + name );
		String[] zones = new String[24];
		int numZones = 0;
		String next = lineReader.next();
		while (Character.isDigit(next.charAt(0))) {
			System.out.println("Next value: " + next + "\n");
			zones[numZones] = next;
			numZones++;
			next = lineReader.next();
		}
		System.out.println("The number of zones is " + numZones + "\n");
		String[] monthsSow = new String[12];
		int numMonths = 0;
		while (!Character.isDigit(next.charAt(0))) {
			System.out.println("Next value: " + next + " on loop " + numMonths + "\n");
			monthsSow[numMonths] = next;
			numMonths++;
			next = lineReader.next();
		}
		System.out.println("The number of months is " + numMonths + "\n");
		int week = Integer.parseInt(next);
		System.out.println("Next value: " + next + "\n");
		String[] monthsHarvest = findMonthsHarvest(monthsSow, week, numMonths);
		Crop crop = new Crop(name, zones, monthsSow, monthsHarvest, numZones, numMonths);
		lineReader.close();
		return crop;
	}

	private static String[] findMonthsHarvest(String[] monthsSow, int week, int numMonths) {
		System.out.println("Got to harvest method\n");
		String[] monthsHarvest = new String[numMonths];
		int monthNum = 0;
		for (int i = 0; i < numMonths; i++) {
			System.out.println("The month I'm looking for is " + monthsSow[i] + "\n");
			if (monthsSow[i].equals("January")) {
				monthNum = 0;
			} else if (monthsSow[i].equals("February")) {
				monthNum = 1;
			} else if (monthsSow[i].equals("March")) {
				monthNum = 2;
			} else if (monthsSow[i].equals("April")) {
				System.out.println("Recognize the month is April\n");
				monthNum = 3;
			} else if (monthsSow[i].equals("May")) {
				monthNum = 4;
			} else if (monthsSow[i].equals("June")) {
				monthNum = 5;
			} else if (monthsSow[i].equals("July")) {
				monthNum = 6;
			} else if (monthsSow[i].equals("August")) {
				monthNum = 7;
			} else if (monthsSow[i].equals("September")) {
				monthNum = 8;
			} else if (monthsSow[i].equals("October")) {
				monthNum = 9;
			} else if (monthsSow[i].equals("November")) {
				monthNum = 10;
			} else if (monthsSow[i].equals("December")) {
				monthNum = 11;
			}
			monthsHarvest[i] = newMonth(week, numMonths, monthNum);
			System.out.println("The month for harvest of crop " + i + " is " + monthsHarvest[i] + "\n");
		}
			
		return monthsHarvest;
	}
	
	public static String newMonth(int week, int numMonths, int monthNum) {
		int numMonthsAdd = week / 4;
		System.out.println("The number of months to add is " + numMonthsAdd + "\n");
		int newMonth = (numMonthsAdd + monthNum) % 12;
		System.out.println("The new month is " + newMonth +"\n");

		for (int i = 0; i < numMonths; i++) {
			if (newMonth == 0) {
				return "January";
			} else if (newMonth == 1) {
				return "February";
			} else if (newMonth == 2) {
				return "March";
			} else if (newMonth == 3) {
				return "April";
			} else if (newMonth == 4) {
				return "May";
			} else if (newMonth == 5) {
				return "June";
			} else if (newMonth == 6) {
				return "July";
			} else if (newMonth == 7) {
				return "August";
			} else if (newMonth == 8) {
				return "September";
			} else if(newMonth == 9) {
				return "October";
			} else if(newMonth == 10) {
				return "November";
			} else if(newMonth == 11) {
				return "December";
			}
		}
		return "No";
	}
}
