import java.util.Scanner;

public class Christian_Q02 {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedStackClass<Integer> stack = new LinkedStackClass<Integer>();
		
		System.out.print("Enter integers (999 to stop): ");
		int x = input.nextInt();
		while (x != 999) {
			stack.push(x);
			x = input.nextInt();
		}
		
		System.out.println("The original stack printed in direct order (bottom to top) is:");
		printStack(stack);
		System.out.println();
		System.out.println("The stack printed in reverse order (top to bottom) is:");
		printBackStack(stack);
		System.out.println();
		System.out.println("The stack stores " + countItems(stack) + " items.");
		System.out.println("The top is: " + stack.peek());
		System.out.println("The second item (below top) is: " + getSecond(stack));
		System.out.print("Enter value to be removed from stack: ");
		int r = input.nextInt();
		removeItem(stack, r);
		System.out.println("The stack after removing every occurrence of " + r + " is:");
		printStack(stack);
		System.out.println();
		reverseStack(stack);
		System.out.println("Reversed the stack. The new stack printed in direct order is:");
		printStack(stack);
		System.out.println();
		
		System.out.println();
		
		QueueClass<Integer> queue = new QueueClass<Integer>();
		for (int i = 3; i <= 30; i+=3)
			queue.enqueue(i);
		System.out.println("The queue is:");
		printQueue(queue);
		System.out.println();
		reverseQueue(queue);
		System.out.println("The reversed queue is:");
		printQueue(queue);		
	}
	
	public static void printBackStack(LinkedStackClass<Integer> intStack) {
		LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
		while (!intStack.isEmptyStack()) {
			System.out.print(intStack.peek() + " ");
			temp.push(intStack.peek());
			intStack.pop();
		}
		while (!temp.isEmptyStack()) {
			intStack.push(temp.peek());
			temp.pop();
		}
	}
	
	public static void printStack(LinkedStackClass<Integer> intStack) {
		LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
		while (!intStack.isEmptyStack()) {
			temp.push(intStack.peek());
			intStack.pop();
		}
		while (!temp.isEmptyStack()) {
			System.out.print(temp.peek() + " ");
			intStack.push(temp.peek());
			temp.pop();
		}
	}
	
	public static Integer getSecond(LinkedStackClass<Integer> intStack) {
		int fst = intStack.peek();
		intStack.pop();
		int sec = intStack.peek();
		intStack.push(fst);
		return sec;
	}
	
	public static int countItems(LinkedStackClass<Integer> intStack) {
		LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
		int count = 0;
		while (!intStack.isEmptyStack()) {
			temp.push(intStack.peek());
			intStack.pop();
			count++;
		}
		while (!temp.isEmptyStack()) {
			intStack.push(temp.peek());
			temp.pop();
		}
		return count;
	}
	
	public static void removeItem(LinkedStackClass<Integer> intStack, Integer n) {
		LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
		while (!intStack.isEmptyStack()) {
			if (intStack.peek() != n)
				temp.push(intStack.peek());
			intStack.pop();
		}
		while (!temp.isEmptyStack()) {
			intStack.push(temp.peek());
			temp.pop();
		}
	}
	
	public static void reverseStack(LinkedStackClass<Integer> s) {
		QueueClass<Integer> q = new QueueClass<Integer>();
		while (!s.isEmptyStack()) {
			q.enqueue(s.peek());
			s.pop();
		}
		while (!q.isEmptyQueue()) {
			s.push(q.front());
			q.dequeue();
		}
	}
	
	public static void reverseQueue(QueueClass<Integer> q) {
		LinkedStackClass<Integer> s = new LinkedStackClass<Integer>();
		while (!q.isEmptyQueue()) {
			s.push(q.front());
			q.dequeue();
		}
		while (!s.isEmptyStack()) {
			q.enqueue(s.peek());
			s.pop();
		}
	}
	
	public static void printQueue(QueueClass<Integer> q) {
		QueueClass<Integer> temp = new QueueClass<Integer>();
		while (!q.isEmptyQueue()) {
			System.out.print(q.front() + "�");
			temp.enqueue(q.front());
			q.dequeue();
		}
		while (!temp.isEmptyQueue()) {
			q.enqueue(temp.front());
			temp.dequeue();
		}
	}
}