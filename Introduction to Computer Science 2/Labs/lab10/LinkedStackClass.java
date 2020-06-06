public class LinkedStackClass<T> implements StackADT<T> {
	private class StackNode<T> {
		public T info;
		public StackNode<T> link;
		
		// Constructors
		public StackNode() {
			info = null;
			link = null;
		}
		public StackNode(T value, StackNode<T> ptr) {
			info = value;
			link = ptr;
		}
		
		public String toString() {
			return info.toString();
		}
	}
	
	private StackNode<T> stackTop; //reference variable to top
	
	// Constructor
	public LinkedStackClass() {
		stackTop = null;
	}
	
	public void initializeStack() {
		stackTop = null;
	}
	
	public boolean isEmptyStack() {
		return stackTop == null;
	}
	
	public boolean isFullStack() {
		return false;
	}
	
	public T peek() {
		if (stackTop == null) {
			System.err.println("No top - the stack is empty!");
			return stackTop.info;
		}
		else
			return stackTop.info;
	}
	
	public void push(T newValue) {
		StackNode<T> newNode = new StackNode<T>(newValue, stackTop);
		stackTop = newNode;
	}
	
	public void pop() {
		if (stackTop == null)
			System.err.println("Cannot pop from an empty stack!");
		else
			stackTop = stackTop.link;
	}
}