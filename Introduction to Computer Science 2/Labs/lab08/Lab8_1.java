public class Lab8_1 {
	public static final int SIZE = 100;
	public static void main(String[] args) {
		UnorderedArrayList list = new UnorderedArrayList(SIZE);
		list.insertEnd(2);
		list.insertEnd(4);
		list.insertEnd(-2);
		list.insertEnd(5);
		list.insertEnd(3);
		list.insertEnd(0);
		list.insertEnd(7);
		System.out.println("The original list is: ");
		list.print();
		System.out.println("The list after method call is: ");
		list.scaleByK();
		list.print();
	}
}