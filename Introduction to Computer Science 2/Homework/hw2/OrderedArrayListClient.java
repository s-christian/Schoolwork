import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderedArrayListClient {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String path1, path2;
		Scanner read1, read2, read1add, read2add;
		while (true) {
			System.out.print("Please input the name of the file to be opened for first list: ");
			path1 = input.nextLine();
			
			try {
				read1 = new Scanner(new File(path1));
				read1add = new Scanner(new File(path1));
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found at specified path! Reenter.");
				continue;
			}
			
			System.out.print("Please input the name of the file to be opened for second list: ");
			path2 = input.nextLine();
			try {
				read2 = new Scanner(new File(path2));
				read2add = new Scanner(new File(path2));
				break;
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found at specified path! Reenter.");
			}
		}
		
		int count1 = 0, count2 = 0;
		while (read1.hasNext()) {
			if (read1.hasNextInt()) {
				count1++;
			}
			read1.next();
		}
		while (read2.hasNext()) {
			if (read2.hasNextInt()) {
				count2++;
			}
			read2.next();
		}
		
		OrderedArrayList list1 = new OrderedArrayList(count1);
		OrderedArrayList list2 = new OrderedArrayList(count2);
		
		while (read1add.hasNext()) {
			if (read1add.hasNextInt()) {
				list1.insert(read1add.nextInt());
			}
			else read1add.next();
		}
		while (read2add.hasNext()) {
			if (read2add.hasNextInt()) {
				list2.insert(read2add.nextInt());
			}
			else read2add.next();
		}
		
		OrderedArrayList merged = list1.merge(list2);
		
		System.out.println("The first list is:");
		list1.print();
		System.out.println("The second list is:");
		list2.print();
		System.out.println("The merged list is:");
		merged.print();
		
		int key;
		while (true) {
			System.out.print("Enter key for split: ");
			if (input.hasNextInt()) {
				key = input.nextInt();
				input.nextLine();
				break;
			}
			System.out.println("ERROR! Integer required.");
			input.nextLine();
		}
		input.close();
		
		OrderedArrayList[] lists = merged.split(key);
		list1 = lists[0];
		list2 = lists[1];
		
		System.out.println("The first list after split is:");
		list1.print();
		System.out.println("The second list after split is:");
		list2.print();
	}
	
}