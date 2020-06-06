// ConsecutiveDigits.java
// Asks for an integer from the user, counts which digit appeared consecutively the most, and prints it to console.

import java.util.Scanner;

public class ConsecutiveDigits {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Get integer and turn it into a string to be parsed
		System.out.print("n = ");
		int n = input.nextInt();
		String digits = "" + n;
		
		// Count the number of consecutive digit occurrences, store the highest count and its associated digit
		int count = 1, tempCount = 1;
		char digit = digits.charAt(0);
		for (int i = 0; i < digits.length()-1; i++) {
			if (digits.charAt(i) == digits.charAt(i+1)) {
				tempCount++;
				if (tempCount > count) {
					count = tempCount;
					digit = digits.charAt(i);
				}
			}
			else { 
				tempCount = 1;
			}
		}
		
		// Print the digit and its count to console
		if (count > 1) { System.out.println("The number of occurrences of the digit " + digit + " in " + digits + " is " + count); }
		
		input.close();
		
	}
	
}