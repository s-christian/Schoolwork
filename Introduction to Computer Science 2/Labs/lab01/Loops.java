public class Loops {

	public static void main(String[] args) {
		
		//1
		int x1 = 100;
		while(x1 > 0) {
			System.out.print(x1 / 10 + " ");
			x1 /= 2;
		}
		System.out.println();
		
		//2
		int x2 = 2;
		do {
			System.out.print(x2 + " ");
			x2 *= x2;
		} while(x2 < 200);
		System.out.println();
		
		//3
		/* Infinite loop
		int x3 = 250;
		while(x3 % 3 != 0) {
			System.out.print(x3 + " ");
		}
		System.out.println();
		*/
		
		//4
		int x4 = 10;
		while(x4 < 10) {
			System.out.print(x4 + " ");
			x4--;
		}
		System.out.println();
		
		//5
		int x5 = 1;
		while(x5 < 100) {
			System.out.print(x5 + " ");
			x5 += 10;
		}
		System.out.println();
		
		//6
		for(int i = 0; i <= 2; i++) {			// Executes 3 times
			for(int j = 1; j <= 4; j++) {		// Executes 4 times
				for (int k = 1; k <=5; k++) {	// Executes 5 times
					System.out.print("*");
				}
				System.out.print("#");
			}
			System.out.println();
		}
		
	}
	
}