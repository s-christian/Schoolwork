public class LinkedQueueClassClient {
	public static void main(String[] args) {
		LinkedQueueClass <Integer> intQueue = new LinkedQueueClass <Integer> ();
		LinkedQueueClass <Integer> tempQueue = new LinkedQueueClass <Integer> ();
		Integer queueItem;
		intQueue.enqueue(37);
		intQueue.enqueue(10);
		intQueue.enqueue(20);
		intQueue.enqueue(27);
		System.out.print("After�enqueue�(37,�10,�20,�27)�the�front�is:�" + intQueue.front());
		System.out.println("�and�the�back�is:�" + intQueue.back());
		System.out.println("The�original�queue�is:");
		while (!intQueue.isEmptyQueue()) {
			queueItem = intQueue.front();
			System.out.print(queueItem + "�");
			tempQueue.enqueue(queueItem);
			intQueue.dequeue();
		}
		System.out.println("\nAfter�print,�the�original�queue�is�empty,�temp�queue is the copy of the original."); 
		System.out.println("The�copy�queue�is:");
		while (!tempQueue.isEmptyQueue()) {
			queueItem = tempQueue.front();
			System.out.print(queueItem + "�");
			intQueue.enqueue(queueItem);
			tempQueue.dequeue();
		}
		System.out.println("\nAfter�print,�the�copy�queue�is�empty,�the�original queue was rebuilt."); 
		System.out.println("Can�use�the�original�queue�in�the�remaining�program.");
	}
}