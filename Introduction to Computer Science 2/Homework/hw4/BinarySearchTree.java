public class BinarySearchTree<T> extends BinaryTree<T> {
	BinarySearchTree() {
		super();
	}
	
	public boolean search(T item) {
		return recSearch(root, item);
	}
	//helper method for search
	public boolean recSearch(BinaryTreeNode<T> n, T item) {
		if (n == null)
			return false;
		else {
			Comparable<T> temp = (Comparable<T>) n.info;
			if (temp.compareTo(item) == 0)
				return true;
			else if (temp.compareTo(item) > 0)
				return recSearch(n.lLink, item);
			else
				return recSearch(n.rLink, item);
		}
	}
	
	public void insert(T item) {
		root = recInsert(root, item);
	}
	//helper method for insert
	public BinaryTreeNode<T> noRecInsert(BinaryTreeNode<T> n, T item) {
		// I could not figure this out at all
		return recInsert(n, item);
		/*
		Comparable<T> temp = (Comparable<T>) item;
		BinaryTreeNode<T> node = new BinaryTreeNode<T>(item);
		BinaryTreeNode<T> x = n;
		BinaryTreeNode<T> y = null;
		while (n != null) {
			y = x;
			if (temp.compareTo(x.info) < 0)
				x = x.lLink;
			else
				x = x.rLink;
		}
		if (y == null)
			y = node;
		else if (temp.compareTo(y.info) < 0)
			y.lLink = node;
		else
			y.rLink = node;
		return y;
		*/
	}
	//helper method for insert
	public BinaryTreeNode<T> recInsert(BinaryTreeNode<T> n, T item) {
		if (n == null) //this spot is empty, create a new node
			n = new BinaryTreeNode<T>(item);
		else {
			Comparable<T> temp = (Comparable<T>) n.info;
			if (temp.compareTo(item) == 0)
				System.err.println(item + " already present in tree!");
			else if (temp.compareTo(item) > 0)
				n.lLink = recInsert(n.lLink, item);
			else
				n.rLink = recInsert(n.rLink, item);
		}
		return n;
	}
	
	public void delete(T item) {
		root = recDelete(root, item);
	}
	//helper method for delete
	public BinaryTreeNode<T> noRecDelete(BinaryTreeNode<T> n, T item) {
		// I couldn't figure this out either
		return recDelete(n, item);
	}
	//helper method for delete
	public BinaryTreeNode<T> recDelete(BinaryTreeNode<T> n, T item) {
		if (n == null) {
			System.err.println("Cannot delete from an empty tree!");
			return null;
		}
		else {
			Comparable<T> temp = (Comparable<T>) n.info;
			if (temp.compareTo(item) > 0)
				n.lLink = recDelete(n.lLink, item);
			if (temp.compareTo(item) < 0)
				n.rLink = recDelete(n.rLink, item);
			else if (n.lLink != null && n.rLink != null) {
				n.info = findMin(n.rLink).info;
				n.rLink = removeMin(n.rLink);
			}
			else if (n.lLink != null)
				n = n.lLink;
			else if (n.rLink != null)
				n = n.rLink;
			else
				n = null;
			return n;
		}
	}
	//helper method for recDelete
	protected BinaryTreeNode<T> findMin(BinaryTreeNode<T> n) {
		if (n != null)
			while (n.lLink != null)
				n = n.lLink;
		return n;
	}
	//helper method for recDelete
	protected BinaryTreeNode<T> removeMin(BinaryTreeNode<T> n) {
		if (n.lLink == null)
			return n.rLink;
		n.lLink = removeMin(n.lLink);
		return n;
	}
	
}