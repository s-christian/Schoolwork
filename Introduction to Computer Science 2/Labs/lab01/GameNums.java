import java.util.Scanner;

public class GameNums {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int num;
		
		while (true) {
			
			System.out.print("Enter a 2-digit number. The digits should be different. Zero to stop: ");
			while (!input.hasNextInt()) {
				System.out.print("Not an integer, try again: ");
				input.nextLine();
			}
			num = input.nextInt();
			if (num == 0) { break; }
			
			if ((num / 10 == 0) || (num / 10 >= 10) || ((num % 10) == (num / 10))) {
				System.out.println("NOT good for your game!");
			}
			else {
				System.out.println("Good for your game! Play!");
			}
			
			input.nextLine();
			
		}
		
		input.close();
		
	}
	
}