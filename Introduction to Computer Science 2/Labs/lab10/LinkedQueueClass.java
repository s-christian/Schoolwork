public class LinkedQueueClass <T> implements QueueADT <T> {
	//Node�Definition:�inner�class�QueueNode 
	protected class QueueNode <T> {
		T info;
		QueueNode <T> link;
		//Default�constructor 
		public QueueNode() {
			info = null;
			link = null;
		}
		//Alternate�constructor 
		public QueueNode(T elem, QueueNode <T> ptr) {
			info = elem;
			link = ptr;
		}
		public String toString() {
			return info.toString();
		}
	}
	
	//Instance�variable�for�class�LinkedQueueClass 
	private QueueNode <T> queueFront; //reference�variable�to�the�first�queue�element 
	private QueueNode <T> queueRear;  //reference�variable�to�the�last�queue�element
	
	//Default�constructor 
	public LinkedQueueClass() {
		queueFront = null;
		queueRear = null;
	}
	
	public void initializeQueue() {
		queueFront = null;
		queueRear = null;
	}
	
	public boolean isEmptyQueue() {
		return (queueFront == null);
	}
	
	public boolean isFullQueue() {
		return false;
	}
	
	public T front() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		return queueFront.info;
	}
	
	public T back() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		return queueRear.info;
	}
	
	public void enqueue(T newItem) {
		QueueNode <T> newNode = new QueueNode<T>(newItem, null); //create�newNode 
		//if�the�queue�was�empty,�after�enqueue�it will�have�one�node 
		if (queueFront == null) {
			queueFront = newNode;
			queueRear = newNode;
		} else { //add�newNode�at�the�end 
			queueRear.link = newNode;
			queueRear = queueRear.link;
		}
	}
	
	public void dequeue() throws QueueUnderflowException {
		if (isEmptyQueue())
			throw new QueueUnderflowException();
		queueFront = queueFront.link; //advance�queueFront 
		//if�the�queue�had�one�node,�after�dequeue�it is�empty 
		if (queueFront == null)
			queueRear = null;
	}
}