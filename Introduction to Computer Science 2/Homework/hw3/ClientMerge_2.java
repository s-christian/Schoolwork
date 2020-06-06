import java.util.Scanner;
public class ClientMerge_2 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		UnorderedLinkedListInt list1 = new UnorderedLinkedListInt();
		UnorderedLinkedListInt list2 = new UnorderedLinkedListInt();
		UnorderedLinkedListInt list3 = new UnorderedLinkedListInt();
		int num;
		System.out.println("Enter integers for the first list(999 to stop)");
		num = input.nextInt();
		while (num != 999) {
			list1.insertLast((Integer) num);
			num = input.nextInt();
		}
		System.out.println("Enter integers for the second list(999 to stop)");
		num = input.nextInt();
		while (num != 999) {
			list2.insertLast((Integer) num);
			num = input.nextInt();
		}
		System.out.print("\nThe first list is: ");
		list1.print();
		System.out.println("\nThe length of the first list is: " + list1.length());
		if (!list1.isEmptyList()) {
			System.out.println("First element/list1: " + list1.front());
			System.out.println("Last element/list1: " + list1.back());
		}
		System.out.print("\nThe second list is: ");
		list2.print();
		System.out.println("\nThe length of the second list is: " + list2.length());
		if (!list2.isEmptyList()) {
			System.out.println("First element/list2: " + list2.front());
			System.out.println("Last element/list2: " + list2.back());
		}
		list3 = list1.merge2(list2);
		System.out.print("\nAfter concatenating the 2 lists, the merged list1 is: ");
		list3.print();
		System.out.println();
		System.out.print("list1.print() : ");
		list1.print();
		System.out.println();
		System.out.print("list2.print() : ");
		list2.print();
		System.out.println();
		System.out.println("\nThe length of the merged list is: " + list3.length());
		if (!list3.isEmptyList()) {
			System.out.println("First element/merged list: " + list3.front());
			System.out.println("Last element/merged list: " + list3.back());
		}
		System.out.print("Enter key for split: ");
		num = input.nextInt();
		list3.split(list1, list2, num);
		System.out.print("\nThe first list after split is: ");
		list1.print();
		System.out.print("\nThe second list after split is: ");
		list2.print();
		System.out.println();
		
		System.out.println();
		
		System.out.println("--- Testing first merge method ---");
		list1.merge1(list2);
		System.out.print("List 1 after list1.merge1(list2) : ");
		list1.print();
		System.out.println();
		System.out.print("list1.print() : ");
		list1.print();
		System.out.println();
		System.out.print("list2.print() : ");
		list2.print();
	}
}