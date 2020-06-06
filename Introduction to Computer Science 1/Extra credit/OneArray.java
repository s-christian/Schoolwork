// OneArray.java
// Prompts the user to start, asks for an array size, creates the double[] with the size, prompts the user to fill the array,
// prints the average value of the array, prints the array elements, prints a table of array elements with their values and difference from the average,
// prints the even and odd elements of the array along with the average values for the even and odd elements, and loops back to the beginning
// until the user tells the program to quit.

import java.util.Scanner;

public class OneArray {

	private static final Scanner input = new Scanner(System.in);
	private static final int MAX_SIZE = 10;
	
	public static void main(String[] args) {
		
		// Start the program
		start("start");
		input.close();
		
	}
	
	public static void start(String word) {
		
		// Start prompt
		while (true) {
			System.out.print("Do you want to " + word + "? (Y/N) : ");
			String yn = input.nextLine();
			if (yn.equalsIgnoreCase("Y")) {
				break;
			}
			else if (yn.equalsIgnoreCase("N")) {
				System.out.println("Exiting . . .");
				return;
			}
			else {
				System.out.println("ERROR! Wrong input.");
			}
		}
		
		// Get array size from user and validate input
		int size = 0;
		while (true) {
			System.out.print("Enter array size: ");
			if (input.hasNextInt()) {
				int temp = input.nextInt();
				if (temp >= 1 && temp <= MAX_SIZE) {
					size = temp;
					break;
				}
				else {
					System.out.println("ERROR! Size must be between 1 and " + MAX_SIZE);
				}
			}
			else {
				System.out.println("ERROR! Wrong input.");
				input.nextLine();
			}
		}
		
		// Create array with user-specified size
		double[] array = new double[size];
		
		// Have the user populate the array and then print it
		fillArray(array);
		printArray(array);
		
		// Calculate the average value of the array
		double average = computeAverage(array);
		System.out.printf("The average value =\t%.2f\n", average);
		
		// Show the differences between each value and the average
		difference(array, average);
		
		System.out.println();
		
		// Display the even elements
		displayEven(array);
		System.out.println();
		System.out.printf("The sum of the elements with even subscripts =\t%.2f\n", sumEven(array));
		
		System.out.println();
		
		// Display the odd elements
		displayOdd(array);
		System.out.println();
		System.out.printf("The sum of the elements with odd subscripts =\t%.2f\n", sumOdd(array));
		
		System.out.println();
		
		// Start again
		input.nextLine();
		start("continue");
		
	}
	
	public static void fillArray(double[] array) {
		System.out.printf("Now enter %d values:\n", array.length);
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextDouble();
		}
	}
	
	public static void printArray(double[] array) {
		System.out.println("The array elements are:");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\t" + array[i]);
		}
		System.out.println();
	}
	
	public static double computeAverage(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum/array.length;
	}
	
	public static void difference(double[] array, double average) {
		System.out.println("Index\tValue\tValue - avg");
		System.out.println("===========================");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d\t%.2f\t%.2f\n", i, array[i], array[i]-average);
		}
	}
	
	public static void displayEven(double[] array) {
		System.out.println("The elements with even subscripts are:");
		System.out.println("Index\tValue");
		System.out.println("=============");
		for (int i = 0; i < array.length; i+=2) {
			System.out.printf("%d\t%.2f\n", i, array[i]);
		}
	}
	
	public static double sumEven(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i+=2) {
			sum += array[i];
		}
		return sum;
	}
	
	public static void displayOdd(double[] array) {
		System.out.println("The elements with odd subscripts are:");
		System.out.println("Index\tValue");
		System.out.println("=============");
		for (int i = 1; i < array.length; i+=2) {
			System.out.printf("%d\t%.2f\n", i, array[i]);
		}
	}
	
	public static double sumOdd(double[] array) {
		double sum = 0;
		for (int i = 1; i < array.length; i+=2) {
			sum += array[i];
		}
		return sum;
	}
	
}