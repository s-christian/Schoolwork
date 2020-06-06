public abstract class BinaryTree<T> implements BinaryTreeADT<T> {
	// BinaryTreeNode Class
	protected class BinaryTreeNode<T> implements Cloneable {
		public T info;
		public BinaryTreeNode<T> lLink;
		public BinaryTreeNode<T> rLink;
		
		public BinaryTreeNode() {
			info = null;
			lLink = null;
			rLink = null;
		}
		public BinaryTreeNode(T item) {
			info = item;
			lLink = null;
			rLink = null;
		}
		public BinaryTreeNode(T item, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
			info = item;
			lLink = left;
			rLink = right;
		}
		
		public Object clone() {
			BinaryTreeNode<T> copy = null;
			try {
				copy = (BinaryTreeNode<T>) super.clone();
			}
			catch (CloneNotSupportedException e) {
				System.err.println("Error cloning node!");
				return null;
			}
			return copy;
		}
		
		public String toString() {
			return info.toString();
		}
	}
	
	// BinaryTree Class
	protected BinaryTreeNode<T> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public Object clone() {
		BinaryTree<T> copy = null;
		try {
			copy = (BinaryTree<T>) super.clone();
		}
		catch (CloneNotSupportedException e) {
			System.err.println("Error cloning tree!");
			return null;
		}
		if (root != null)
			copy.root = copyTree(root);
		return copy;
	}
	//helper method for clone
	private BinaryTreeNode<T> copyTree(BinaryTreeNode<T> n) {
		BinaryTreeNode<T> temp;
		if (n == null)
			return null;
		else {
			temp = (BinaryTreeNode<T>) n.clone();
			temp.lLink = copyTree(temp.lLink);
			temp.rLink = copyTree(temp.rLink);
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void inOrderTraversal() {
		inOrderNoRec(root);
	}
	//helper method for inOrderTraversal
	private void inOrderNoRec(BinaryTreeNode<T> n) {
		LinkedStackClass<BinaryTreeNode<T>> stack = new LinkedStackClass<>();
		while (!stack.isEmptyStack() || n != null) {
			if (n != null) {
				stack.push(n);
				n = n.lLink;
			}
			else {
				BinaryTreeNode<T> temp = stack.peek();
				stack.pop();
				System.out.print(temp.info + " ");
				n = temp.rLink;
			}
		}
	}
	//helper method for inOrderTraversal
	private void inOrder(BinaryTreeNode<T> n) {
		if (n != null) {
			inOrder(n.lLink);
			System.out.print(n.info + " ");
			inOrder(n.rLink);
		}
	}
	
	public void preOrderTraversal() {
		preOrderNoRec(root);
	}
	//helper method for preOrderTraversal
	private void preOrderNoRec(BinaryTreeNode<T> n) {
		LinkedStackClass<BinaryTreeNode<T>> stack = new LinkedStackClass<>();
		stack.push(n);
		while (!stack.isEmptyStack()) {
			BinaryTreeNode<T> current = stack.peek();
			stack.pop();
			System.out.print(current.info + " ");
			if (current.rLink != null)
				stack.push(current.rLink);
			if (current.lLink != null)
				stack.push(current.lLink);
		}
	}
	//helper method for preOrderTraversal
	private void preOrder(BinaryTreeNode<T> n) {
		if (n != null) {
			System.out.print(n.info + " ");
			preOrder(n.lLink);
			preOrder(n.rLink);
		}
	}
	
	public void postOrderTraversal() {
		postOrderNoRec(root);
	}
	//helper method for inOrderTraversal
	private void postOrderNoRec(BinaryTreeNode<T> n) {
		LinkedStackClass<BinaryTreeNode<T>> stack = new LinkedStackClass<>();
		stack.push(n);
		while(!stack.isEmptyStack()) {
			BinaryTreeNode<T> current = stack.peek();
			if (current.lLink == null && current.rLink == null) {
				System.out.print(current + " ");
				stack.pop();
			}
			else {
				if (current.rLink != null) {
					stack.push(current.rLink);
					current.rLink = null;
				}
				if (current.lLink != null) {
					stack.push(current.lLink);
					current.lLink = null;
				}
			}
		}
	}
	//helper method for postOrderTraversal
	private void postOrder(BinaryTreeNode<T> n) {
		if (n != null) {
			postOrder(n.lLink);
			postOrder(n.rLink);
			System.out.print(n.info + " ");
		}
	}
	
	public int treeHeight() {
		return height(root);
	}
	//helper method called by treeHeight
	protected int height(BinaryTreeNode<T> n) {
		if (n == null)
			return 0;
		else if (n.lLink == null && n.rLink == null)
			return 0;
		else
			return 1 + Math.max(height(n.lLink), height(n.rLink)); 
	}
	
	public int treeNodeCount() {
		return nodeCount(root);
	}
	//helper method for treeNodeCount
	protected int nodeCount(BinaryTreeNode<T> n) {
		if (n == null)
			return 0;
		else
			return 1 + nodeCount(n.lLink) + nodeCount(n.rLink); 
	}
	
	public int treeLeavesCount() {
		return leavesCountNoRec(root);
		//return leavesCount(root);
	}
	protected int leavesCountNoRec(BinaryTreeNode<T> n) {
		if (n == null)
			return 0;
		int count = 0;
		LinkedStackClass<BinaryTreeNode<T>> stack = new LinkedStackClass<>();
		stack.push(n);
		while (!stack.isEmptyStack()) {
			BinaryTreeNode<T> temp = stack.peek();
			stack.pop();
			if (temp.lLink != null)
				stack.push(temp.lLink);
			if (temp.rLink != null)
				stack.push(temp.rLink);
			if (temp.lLink == null && temp.rLink == null)
				count++;
		}
		return count;
	}
	//helper method for treeLeavesCount
	protected int leavesCount(BinaryTreeNode<T> n) {
		if (n == null)
			return 0;
		else if (n.lLink == null && n.rLink == null) //leaf, no children
			return 1;
		else
			return leavesCount(n.lLink) + leavesCount(n.rLink); //at this point the node must have at least one child
	}
	
	public void destroyTree() {
		root = null;
	}
	
	//abstract methods
	public abstract boolean search(T item);
	public abstract void insert(T item);
	public abstract void delete(T item);
}