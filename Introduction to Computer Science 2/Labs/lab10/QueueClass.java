public class QueueClass<T> implements QueueADT<T> {
	private int maxQueueSize;
	private int count;
	private int queueFront;
	private int queueRear;
	private T[] list; // Array of references to the objects that store queue elements
	
	public QueueClass() {
		maxQueueSize = 100;
		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
		list = (T[]) new Object[maxQueueSize];
	}
	public QueueClass(int queueSize) {
		if (queueSize <= 0) {
			System.err.println("The size must be positive.");
			System.err.println("Creating an array with size 100.");
			maxQueueSize = 100;
		}
		else
			maxQueueSize = queueSize;
		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
		list = (T[]) new Object[maxQueueSize];
	}
	
	public void initializeQueue() {
		for (int i = queueFront; i < queueRear; i = (i + 1) % maxQueueSize)
			list[i] = null;
		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
	}
	
	public boolean isEmptyQueue() {
		return count == 0;
	}
	
	public boolean isFullQueue() {
		return count == maxQueueSize;
	}
	
	public T front() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		return (T) list[queueFront];
	}
	
	public T back() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		return (T) list[queueRear];
	}
	
	public void enqueue(T newItem) {
		if (isFullQueue())
			System.err.println("Cannot enqueue in a full queue!");
		else {
			queueRear = (queueRear + 1) % maxQueueSize; // circular array
			count++;
			list[queueRear] = newItem;
		}
	}
	
	public void dequeue() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		count--;
		list[queueFront] = null;
		queueFront = (queueFront + 1) % maxQueueSize; // circular array
	}
}