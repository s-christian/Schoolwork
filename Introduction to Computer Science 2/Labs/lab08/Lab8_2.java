// Testing the method scaleByK using the Java ArrayList class
import java.util.ArrayList;

public class Lab8_2 {
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList <Integer>();
		list.add(2);
		list.add(4);
		list.add(-2);
		list.add(5);
		list.add(3);
		list.add(0);
		list.add(7);
		System.out.println("The original list is: ");
		print(list);
		System.out.println("The list after method call is: ");
		list = scaleByK(list);
		print(list);
	}
	
	public static ArrayList<Integer> scaleByK(ArrayList <Integer> list) {
		if (list.size() == 0) {
			System.err.println("Cannot scale an empty list.");
			return null;
		}
		else {
			int sum = 0;
			for (int i = 0; i < list.size(); i++)
				if (!(list.get(i) <= 0))
					sum += list.get(i);
			ArrayList <Integer> temp = new ArrayList <Integer> (sum);
			for (int i = 0; i < list.size(); i++)
				for (int num = list.get(i); num > 0; num--)
					temp.add(list.get(i));
			return temp;
		}
	}
	
	public static void print(ArrayList <Integer> someList) {
		for (Integer i : someList)
			System.out.print(i + "  ");
		System.out.println();
	}
}
