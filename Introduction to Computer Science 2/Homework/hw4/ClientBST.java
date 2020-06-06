import java.util.Scanner;

public class ClientBST {
	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer num;
		System.out.print("Enter integers(999 to stop): ");
		num = INPUT.nextInt();
		while (num != 999) {
			bst.insert(num);
			num = INPUT.nextInt();
		}
		System.out.println("Tree Height: " + bst.treeHeight());
		System.out.println("Nodes: " + bst.treeNodeCount());
		System.out.println("Leaves: " + bst.treeLeavesCount());
		System.out.print("Enter value to search for: ");
		num = INPUT.nextInt();
		if (bst.search(num))
			System.out.println(num + " was found in this tree");
		else
			System.out.println(num + " was NOT found in this tree");
		System.out.print("Inorder traversal: ");
		bst.inOrderTraversal();
		System.out.print("\nPreorder traversal: ");
		bst.preOrderTraversal();
		System.out.print("\nPostorder traversal: ");
		bst.postOrderTraversal();
		System.out.print("\nEnter value to be deleted from tree: ");
		num = INPUT.nextInt();
		bst.delete(num);
		System.out.print("\nInorder traversal after removing " + num + ": ");
		bst.inOrderTraversal();
		System.out.print("\nPreorder traversal after removing " + num + ": ");
		bst.preOrderTraversal();
		System.out.print("\nPostorder traversal after removing " + num + ": ");
		bst.postOrderTraversal();
		System.out.println();

		INPUT.close();
	}
}