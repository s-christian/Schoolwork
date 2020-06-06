import java.util.Scanner;

public class ComplexClient {
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Test primary methods
		menu();
		System.out.println("Testing completed.");
		
		// Finish testing all untested functionality
		System.out.println();
		
		System.out.println("Miscellaneous testing:");
		System.out.println("----------------------");
		ComplexNumber test = new ComplexNumber(5, 10);
		System.out.println("- Testing getters -");
		System.out.println("test.getReal() : " + test.getReal());
		System.out.println("test.getImaginary() : " + test.getImaginary());
		System.out.println();
		System.out.println("- Testing getCopy() -");
		ComplexNumber temp = new ComplexNumber();
		System.out.println("test = " + test.toString());
		System.out.println("temp = " + temp.toString());
		System.out.println("test = temp.getCopy()");
		test = temp.getCopy();
		System.out.println("test = " + test.toString());
		System.out.println();
		System.out.println("- Testing copy() - ");
		ComplexNumber newTemp = new ComplexNumber(20, 20);
		System.out.println("test = " + test.toString());
		System.out.println("newTemp = " + newTemp.toString());
		System.out.println("test.copy(newTemp)");
		test.copy(newTemp);
		System.out.println("test = " + test.toString());
		System.out.println();
		System.out.println("- Testing print() -");
		test.print();
		temp.print();
		newTemp.print();
	}
	
	public static void menu() {
		int counter = 0;
		while (true) {
			System.out.println("Your options for Complex arithmetic are:");
			System.out.println("----------------------------------------");
				System.out.println(" 1) Add 2 complex numbers");
				System.out.println(" 2) Subtract 2 complex numbers");
				System.out.println(" 3) Multiply 2 complex numbers");
				System.out.println(" 4) Divide 2 complex numbers");
				System.out.println(" 5) Absolute value of a complex number");
				System.out.println(" 6) Compare 2 complex numbers");
				System.out.println(" 0) EXIT");
			
			int option;
			while (true) {
				option = getInt("Please enter your option");
				if (option > 6 || option < 0) {
					System.out.println("Invalid option.");
				} else break;
			}
			
			if (option == 0) return;
			else start(option);
			
			counter++;
			
			System.out.println("   Command number " + counter + " completed.\n");	
		}	
	}
	
	public static int getInt(String text) {
		int num;
		while (true) {
			System.out.print(text+": ");
			if (INPUT.hasNextInt()) {
				num = INPUT.nextInt();
				INPUT.nextLine();
				return num;
			}
			System.out.println("ERROR! Integer required.");
			INPUT.nextLine();
		}
	}
	
	public static void start(int option) {
		ComplexNumber compNum1, compNum2 = null;
		if (option != 5) {
			compNum1 = getCompNum();
			compNum2 = getCompNum();
			System.out.print("First complex number is: ");
			System.out.println(compNum1.toString());
			System.out.print("Second complex number is: ");
			System.out.println(compNum2.toString());
		}
		else {
			compNum1 = getCompNum();
			System.out.print("The complex number is: ");
			System.out.println(compNum1.toString());
		}
		
		switch (option) {
			case 1 : compNum1.add(compNum2); break;
			case 2 : compNum1.subtract(compNum2); break;
			case 3 : compNum1.multiply(compNum2); break;
			case 4 : compNum1.divide(compNum2); break;
			case 5 : compNum1.cAbs(); break;
			case 6 : if (compNum1.equals(compNum2))
					 	System.out.println("The complex numbers are equal.");
					 else
						System.out.println("The complex numbers are NOT equal.");
					 break;
			default: System.err.println("ERROR! Option not within available scope!"); break;
		}
	}
	
	public static ComplexNumber getCompNum() {
		double r, i;
		while (true) {
			System.out.print("Enter complex number (real imaginary): ");
			if (INPUT.hasNextDouble()) {
				r = INPUT.nextDouble();
				if (INPUT.hasNextDouble()) {
					i = INPUT.nextDouble();
					INPUT.nextLine();
					break;
				}
			}
			System.out.println("Must provide number of type double.");
			INPUT.nextLine();
		}
		return new ComplexNumber(r, i);
	}
}