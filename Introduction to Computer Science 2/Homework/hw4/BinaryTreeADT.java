public interface BinaryTreeADT<T> extends Cloneable {
	public Object clone();
	public boolean isEmpty();
	public void inOrderTraversal();
	public void preOrderTraversal();
	public void postOrderTraversal();
	public int treeHeight();
	public int treeNodeCount();
	public int treeLeavesCount();
	public void destroyTree();
	public boolean search(T item);
	public void insert(T item);
	public void delete(T item);
}