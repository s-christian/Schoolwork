import java.util.Scanner;
import java.util.Random;

public class HW_01_01 {
	
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
		System.out.println("Testing completed.");
	}
	
	public static void menu() {
		int counter = 0;
		while (true) {
			System.out.println("Your options are:");
			System.out.println("-----------------");
				System.out.println("\t1) Add 2 matrices");
				System.out.println("\t2) Subtract 2 matrices");
				System.out.println("\t3) Multiply 2 matrices");
				System.out.println("\t4) Multiply matrix by a constant");
				System.out.println("\t5) Transpose matrix");
				System.out.println("\t6) Matrix trace");
				System.out.println("\t0) EXIT");
			
			while (true) {
				int option = getInt("Please enter your option");
				if (option > 6 || option < 0) {
					System.out.println("Invalid option.");
					continue;
				}
				System.out.println();
				switch (option) {
					case 1 : add(); break;
					case 2 : subtract(); break;
					case 3 : multiply(); break;
					case 4 : multiplyByConstant(); break;
					case 5 : transpose(); break;
					case 6 : trace(); break;
					case 0 : return;
					default: System.out.println("ERROR!"); break;
				}
				break;
			}
			counter++;
			
			System.out.println("\t\t\tCommand number " + counter + " completed.\n");	
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
	
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] generate(int size) {
		int[][] matrix = new int[size][size];
		Random ran = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = ran.nextInt(10) + 1;
			}
		}
		return matrix;
	}
	
	public static void add() {
		int size;
		while (true) {
			size = getInt("Enter the size of square matrices");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int[][] m1 = generate(size);
		int[][] m2 = generate(size);
		int[][] matrix = new int[size][size];
		
		System.out.println("First matrix is:");
		print(m1);
		System.out.println("Second matrix is:");
		print(m2);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		System.out.println("The resulting matrix is:");
		print(matrix);
	}
	
	public static void subtract() {
		int size;
		while (true) {
			size = getInt("Enter the size of square matrices");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int[][] m1 = generate(size);
		int[][] m2 = generate(size);
		int[][] matrix = new int[size][size];
		
		System.out.println("First matrix is:");
		print(m1);
		System.out.println("Second matrix is:");
		print(m2);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = m1[i][j] - m2[i][j];
			}
		}
		
		System.out.println("The resulting matrix is:");
		print(matrix);
	}
	
	public static void multiply() {
		int size;
		while (true) {
			size = getInt("Enter the size of square matrices");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int[][] m1 = generate(size);
		int[][] m2 = generate(size);
		int[][] matrix = new int[size][size];
		
		System.out.println("First matrix is:");
		print(m1);
		System.out.println("Second matrix is:");
		print(m2);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int sum = 0;
				for (int step = 0; step < matrix.length; step++) {
					sum += m1[i][step] * m2[step][j];
				}
				matrix[i][j] = sum;
			}
		}
		
		System.out.println("The resulting matrix is:");
		print(matrix);
	}
	
	public static void multiplyByConstant() {
		int size;
		while (true) {
			size = getInt("Enter the size of the square matrix");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int con = getInt("Enter the multiplication constant");
		int[][] m1 = generate(size);
		int[][] matrix = new int[size][size];
		
		System.out.println("The matrix is:");
		print(m1);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = m1[i][j] * con;
			}
		}
		
		System.out.println("The original matrix multiplied by " + con + " is:");
		print(matrix);
	}
	
	public static void transpose() {
		int size;
		while (true) {
			size = getInt("Enter the size of the square matrix");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int[][] m1 = generate(size);
		int[][] matrix = new int[size][size];
		
		System.out.println("The matrix is:");
		print(m1);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = m1[j][i];
			}
		}
		
		System.out.println("The transposed matrix is:");
		print(matrix);
	}
	
	public static void trace() {
		int size;
		while (true) {
			size = getInt("Enter the size of the square matrix");
			if (size < 0) {
				System.out.println("Integer must be positive.");
				continue;
			}
			break;
		}
		int[][] matrix = generate(size);
		
		System.out.println("The matrix is:");
		print(matrix);
		
		int trace = 0;
		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
		
		System.out.println("The trace for this matrix is: " + trace);
	}
	
}