package com.hotelreservation.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderUtil {

	public static List<String> consumeInputFile() {
		List<String> inputs = new ArrayList<String>();
		try {
			File myObj = new File("C:\\develop\\input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				inputs.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return inputs;
	}
}
