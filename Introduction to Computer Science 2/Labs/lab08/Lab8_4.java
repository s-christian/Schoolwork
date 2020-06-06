// Testing the method removeDuplicates using the Java ArrayList class
import java.util.ArrayList;

public class Lab8_4 {
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList <Integer>();
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(5);
		list.add(5);
		list.add(8);
		list.add(9);
		list.add(9);
		System.out.println("The original list is: ");
		print(list);
		System.out.println("The list after method call is: ");
		list = removeDuplicates(list);
		print(list);
	}
	
	public static ArrayList<Integer> removeDuplicates(ArrayList <Integer> list) {
		if (list.size() <= 1) {
			System.err.println("Cannot remove duplicates if there is only 1 or no elements.");
			return null;
		}
		else {
			ArrayList <Integer> temp = new ArrayList <Integer> ();
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i) != list.get(i+1))
					temp.add(list.get(i));
			}
			temp.add(list.get(list.size()-1));
			return temp;
		}
	}
	
	public static void print(ArrayList <Integer> someList) {
		for (Integer i : someList)
			System.out.print(i + "  ");;
		System.out.println();
	}
}