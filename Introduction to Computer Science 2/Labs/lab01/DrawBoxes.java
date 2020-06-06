import java.util.Scanner;

public class DrawBoxes {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		char start = 'y', boxChar;
		int size;
		
		while (true) {
			System.out.print("Do you want to start (Y/N): ");
			start = input.nextLine().toLowerCase().charAt(0);
			if (start != 'y' && start != 'n') { System.out.print("Invalid input! Only Y or N accepted. "); }
			else if (start == 'n') { 
				input.close();
				return;
			}
			else { break; }
		}
		
		while (true) {
			
			while (true) {
				while (true) {
					System.out.print("How many chars/last row? ");
					if (input.hasNextInt()) { break; }
					else {
						System.out.print("Not an integer! Try again! ");
						input.nextLine();
					}
				}
				size = input.nextInt();
				input.nextLine();
				if (size < 5 || size > 21) { System.out.print("ERROR! Valid range 5 - 21. "); }
				else { break; }
			}
			
			System.out.print("What character? ");
			boxChar = input.nextLine().charAt(0);
		
			System.out.println();
			
			for (int top = 0; top < size; top++) {
				System.out.print(boxChar);
			}
			System.out.println();
			for (int mid = 0; mid < size; mid++) {
				System.out.print(boxChar);
				for (int spaces = 0; spaces < size-2; spaces++) {
					System.out.print(" ");
				}
				System.out.print(boxChar);
				System.out.println();
			}
			for (int bottom = 0; bottom < size; bottom++) {
				System.out.print(boxChar);
			}
			System.out.println();
			
			System.out.println();
			
			while (true) {
				System.out.print("Do you want to continue (Y/N): ");
				start = input.nextLine().toLowerCase().charAt(0);
				if (start != 'y' && start != 'n') { System.out.print("Invalid input! Only Y or N accepted. "); }
				else if (start == 'n') {
					input.close();
					return;
				}
				else { break; }
			}
		
		}
		
	}

}