public class Lab8_3 {
	public static void main(String[] args) {
		OrderedArrayList list = new OrderedArrayList();
		list.insert(8);
		list.insert(2);
		list.insert(2);
		list.insert(9);
		list.insert(5);
		list.insert(9);
		list.insert(2);
		list.insert(9);
		list.insert(2);
		list.insert(5);
		System.out.println("The original list is: ");
		list.print();
		System.out.println("The list after method call is: ");
		list.removeDuplicates();
		list.print();
	}
}