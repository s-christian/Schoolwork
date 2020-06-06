import java.util.Scanner;

public class HW_01_02 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			int size;
			while (true) {
				System.out.print("Enter the size of magic square (positive & odd): ");
				if (input.hasNextInt()) {
					size = input.nextInt();
					input.nextLine();
					if (size < 0 || size%2 != 1 ) {
						System.out.println("INPUT ERROR!!! Invalid size.");
						continue;
					}
					break;
				}
				System.out.println("INPUT ERROR!!! Not an integer.");
				input.nextLine();
			}
			
			int[][] magicSquare = createMagicSquare(new int[size][size]);
			System.out.println("The magic square with size = " + size + " is:\n");
			print(magicSquare);
			System.out.printf("The %dx%d magic square adds up to %d\n\n", size, size, sumMagicSquare(magicSquare));
			
			String choice;
			while (true) {
				System.out.print("Do you want to continue (Y/N): ");
				choice = input.next().toLowerCase();
				if (!choice.startsWith("y") && !choice.startsWith("n")) {
					System.out.println("Invalid input.");
				}
				else { break; }
			}
			if (choice.startsWith("n")) {
				break;
			}
		}
		
		System.out.println("testing completed");
		input.close();
	}
	
	public static int[][] createMagicSquare(int[][] m) {
		for (int i = 0, j = (m.length-1)/2, counter = 1; counter <= (m.length * m.length); i--, j++, counter++) {
			if (i == -1 && j == m.length) {
				i = 1;
				j = m.length-1;
			}
			else if (i < 0) {
				i = m.length-1;
			}
			else if (j > m.length-1) {
				j = 0;
			}
			else if (m[i][j] != 0) {
				i += 2;
				j -= 1;
			}
			if (i == m.length) { i = 0; }
			if (j == m.length) { j = 0; } 
			m[i][j] = counter;
		}
		return m;
	}
	
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.printf("%5d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int sumMagicSquare(int[][] matrix) {
		int sumDiags = 0, sumRows = 0, sumCols = 0;
		for (int i = 0; i < matrix.length; i++) {
			sumDiags += matrix[i][i];
			sumRows += matrix[0][i];
			sumCols += matrix[i][0];
		}
		return (sumDiags == sumRows && sumRows == sumCols)? sumDiags : -1;
	}
	
}