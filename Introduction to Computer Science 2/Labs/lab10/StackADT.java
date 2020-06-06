public interface StackADT<T> {
	public void initializeStack();	// Method to initialize the stack to an empty state.
	public boolean isEmptyStack();	// Method to determine whether the stack is empty.
	public boolean isFullStack();	// Method to determine whether the stack is full.
	public T peek();				// Method to return the top element of the stack.
	public void push(T newItem);	// Method to add newItem to the stack.
	public void pop();				// Method to remove the top element of the stack.
}