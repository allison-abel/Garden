package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import crop.Crop;

public class CropListReader {
	@SuppressWarnings("null")
	public static Crop[] readCropsFromFile(String filepath) {
		int i = 0;
		Crop[] crops = null;
		Crop crop = null;
		File file = new File(filepath);
		Scanner scan = null;

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			crop = processLine(line);
			crops[i] = crop;
		}
		scan.close();
		return crops;
	}

	@SuppressWarnings("null")
	private static Crop processLine(String line) {
		Scanner lineReader = new Scanner(line);
		lineReader.useDelimiter(",");
		String name = lineReader.next();
		String[] zones = null;
		String next = lineReader.next();
		int i = 0;
		while (next == "2a" || next == "2b" || next == "3a" || next == "3b" || next == "4a" || next == "4b"
				|| next == "5a" || next == "5b" || next == "6a" || next == "6b" || next == "7a" || next == "7b"
				|| next == "8a" || next == "8b" || next == "9a" || next == "9b" || next == "10a" || next == "10b"
				|| next == "11a" || next == "11b" || next == "12a" || next == "12b" || next == "13a" || next == "13b") {
			zones[i] = next;
			i++;
		}
		int j = 0;
		String[] monthsSow = null;
		next = lineReader.next();
		while (next != "!") {
			monthsSow[j] = next;
			j++;
		}
		int week = Integer.parseInt(next);
		String[] monthsHarvest = findMonthsHarvest(monthsSow, week);

		Crop crop = new Crop(name, zones, monthsSow, monthsHarvest);
		lineReader.close();
		return crop;
	}

	@SuppressWarnings("null")
	private static String[] findMonthsHarvest(String[] monthsSow, int week) {
		String[] monthsHarvest = null;
		int monthNum = 0;
		for (int i = 0; i < monthsSow.length; i++) {
			if (monthsSow[i] == "January") {
				monthNum = 0;
			} else if (monthsSow[i] == "February") {
				monthNum = 1;
			} else if (monthsSow[i] == "March") {
				monthNum = 2;
			} else if (monthsSow[i] == "April") {
				monthNum = 3;
			} else if (monthsSow[i] == "May") {
				monthNum = 4;
			} else if (monthsSow[i] == "June") {
				monthNum = 5;
			} else if (monthsSow[i] == "July") {
				monthNum = 6;
			} else if (monthsSow[i] == "August") {
				monthNum = 7;
			} else if (monthsSow[i] == "September") {
				monthNum = 8;
			} else if (monthsSow[i] == "October") {
				monthNum = 9;
			} else if (monthsSow[i] == "November") {
				monthNum = 10;
			} else if (monthsSow[i] == "December") {
				monthNum = 11;
			}
		}
		int numMonths = week / 4;
		int newMonth = (numMonths + monthNum) % 12;

		for (int i = 0; i < monthsSow.length; i++) {
			if (newMonth == 0) {
				monthsHarvest[i] = "January";
			} else if (newMonth == 1) {
				monthsHarvest[i] = "February";
			} else if (newMonth == 2) {
				monthsHarvest[i] = "March";
			} else if (newMonth == 3) {
				monthsHarvest[i] = "April";
			} else if (newMonth == 4) {
				monthsHarvest[i] = "May";
			} else if (newMonth == 5) {
				monthsHarvest[i] = "June";
			} else if (newMonth == 6) {
				monthsHarvest[i] = "July";
			} else if (newMonth == 7) {
				monthsHarvest[i] = "August";
			} else if (newMonth == 8) {
				monthsHarvest[i] = "September";
			} else if(newMonth == 9) {
				monthsHarvest[i] = "October";
			} else if(newMonth == 10) {
				monthsHarvest[i] = "November";
			} else if(newMonth == 11) {
				monthsHarvest[i] = "December";
			}
		}

		return monthsHarvest;
	}
}
