public class Client_DLLString {
	public static void main(String[] args) {
		DoubleLinkedList <String> list_1 = new DoubleLinkedList <String> ();
		DoubleLinkedList <String> list_2 = new DoubleLinkedList <String> ();
		String item;
		list_1.insertNode("John");
		list_1.insertNode("Ann");
		list_1.insertNode("Paul");
		list_1.insertNode("Joshua");
		list_1.insertNode("Will");
		list_1.insertNode("Emma");
		list_1.insertNode("Peter");
		list_1.insertNode("Linda");
		list_1.insertNode("Joan");
		list_1.insertNode("David");
		list_1.insertNode("Miriam");
		list_1.insertNode("Leah");
		list_1.insertNode("Jane");
		System.out.println("Inserted in first list the names:\nJohn, Ann, Paul, Joshua, Will, Emma, Peter, Linda, Joan, David, Miriam, Leah, Jane");
		System.out.println("(Testing toString) First list sorted is:\n" + list_1);
		System.out.println("(Testing recursive toString) First list sorted is:\n[head] - " + list_1.recursiveToString());
		System.out.println("(Testing backwards) First list reversed (print) is:\n" + list_1.backwardsString());
		System.out.print("(Testing recursive backwards) First list reversed (print) is:\n" + list_1.recursiveBackwardsString());
		System.out.println(" - [head]");
		System.out.println("Will copy in second list only names that don't start with J. List one destroyed.");
		while (!list_1.isEmptyList()) {
			item = list_1.front();
			list_1.deleteNode(item);
			if (item.charAt(0) != 'J') list_2.insertNode(item);
		}
		System.out.println("Second list should hold names that don't start with J (sorted):\n" + list_2);
		System.out.println("First list should be empty. Nothing printed.\n");
		list_1.print();
		System.out.println("(Testing equals)");
		if (list_1.equals(list_2)) System.out.println("The 2 lists are equals");
		else System.out.println("The 2 lists are NOT equals");
		System.out.print("(Testing copy)\n");
		list_1.copy(list_2);
		System.out.println("First list after copy is:\n" + list_1);
		System.out.print("(Testing reversed copy)\n");
		list_1.reversedCopy(list_2);
		System.out.println("First list as the copy of the second list reversed is:\n" + list_1);
	}
}