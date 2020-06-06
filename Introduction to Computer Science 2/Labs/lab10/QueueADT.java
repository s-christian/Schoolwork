public interface QueueADT<T> {
	public void initializeQueue();							// Method to initialize the queue to an empty state.
	public boolean isEmptyQueue();							// Method to determine whether the queue is empty.
	public boolean isFullQueue();							// Method to determine whether the queue is full.
	public T front() throws QueueUnderflowException;		// Method to return the first element of the queue.
	public T back() throws QueueUnderflowException;			// Method to return the last element of the queue.
	public void enqueue(T newItem);							// Method to add newItem to the queue.
	public void dequeue() throws QueueUnderflowException;	// Method to remove the first element of the queue.
}