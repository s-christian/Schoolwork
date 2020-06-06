// FrequentFlierClass.java 
// This program reads a file containing pairs of ticket classes and miles. Using the data in the file,
// the program calculates and displays the number of frequent flier miles obtained.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FrequentFlierClass {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileRead = new Scanner(new File("frequentflier.txt"));
		// Print the number of frequent flier miles
		System.out.println(frequentFlier(fileRead));
		fileRead.close();
	}
	
	public static int frequentFlier(Scanner fileRead) {
		// Calculate the number of frequent flier miles based upon ticket class and number of miles, keeping a running total until EOF
		int ffMiles = 0;
		while (fileRead.hasNext()) {
			String ticket = fileRead.next();
			int miles = fileRead.nextInt();
			int modifier = 1;
			if (ticket.equals("coach")) {
				modifier = 1;
			}
			else if (ticket.equals("firstclass")) {
				modifier = 2;
			}
			else if (ticket.equals("discount")) {
				modifier = 0;
			}
			ffMiles += miles * modifier;
		}
		return ffMiles;
	}
	
}