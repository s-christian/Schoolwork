import java.util.NoSuchElementException;

public abstract class LinkedListIntClass implements LinkedListIntADT, Cloneable {
	
	protected LinkedListIntNode first;
	protected LinkedListIntNode last;
	protected int count;
	
	public LinkedListIntClass() {
		first = null;
		last = null;
		count = 0;
	}
	
	public boolean isEmptyList() {
		return first == null;
	}
	
	public void initializeList() {
		first = null;
		last = null;
		count = 0;
	}
	
	public void print() {
		LinkedListIntNode current; //variable to traverse the list
		current = first;
		while (current != null) { //while more data to print
			System.out.print(current.info + " ");
			current = current.link;
		}
	}
	
	public int length() {
		return count;
	}
	
	public int front() {
		return first.info;
	}
	
	public int back() {
		return last.info;
	}
	
	public Object clone() {
		LinkedListIntClass copy = null;
		try {
			copy = (LinkedListIntClass) super.clone();
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Copy = " + copy);
			return null;
		}
		
		//If the list is not empty clone each node of the list.
		if (first != null) {
			//Clone the first node
			copy.first = (LinkedListIntNode) first.clone();
			copy.last = copy.first;
			LinkedListIntNode current;
			if (first != null)
				current = first.link;
			else
				current = null;
			//Clone the remaining nodes of the list
			while (current != null) {
				copy.last.link = (LinkedListIntNode) current.clone();
				copy.last = copy.last.link;
				current = current.link;
			}
		}
		return copy;
	}
	
	//Method to return an iterator of the list.
	public LinkedListIntIterator iterator() {
		return new LinkedListIntIterator();
	}
	
	public abstract boolean search(int searchItem);
	public abstract void insertFirst(int newItem);
	public abstract void insertLast(int newItem);
	public abstract void deleteNode(int deleteItem);
	
	// end of main class
	
	
	// LinkedListIntNode Class
	
	class LinkedListIntNode implements Cloneable {
		public int info;
		public LinkedListIntNode link;
		
		public LinkedListIntNode() {
			info = 0;
			link = null;
		}
		public LinkedListIntNode(int elem, LinkedListIntNode ptr) {
			info = elem;
			link = ptr;
		}
		
		public Object clone() {
			LinkedListIntNode copy = null;
			try {
				copy = (LinkedListIntNode) super.clone();			
			}			
			catch (CloneNotSupportedException e) {				
				return null;			
			}			
			return copy;
		}
		
		public String toString() {			
			return ""+info;		
		}	
	}
	
	
	
	// LinkedListIntIterator Class
	
	public class LinkedListIntIterator {
		protected LinkedListIntNode current;  //points to the current node in list
		protected LinkedListIntNode previous; //points to the node before the current node
		
		//Default constructor
		public LinkedListIntIterator() {
			current = (LinkedListIntNode) first;
			previous = null;		
		}
		
		//Method to reset the iterator to the first node
		public void reset() {
			current = (LinkedListIntNode) first;
			previous = null;		
		}
		
		//return a reference to current and advance iterator to next node
		public int next() {
			if (!hasNext())
				throw new NoSuchElementException();
			LinkedListIntNode temp = current;
			previous = current;
			current = current.link;			
			return temp.info;		
		}
		
		public boolean hasNext() {
			return (current != null);
		}
		
		//remove the node currently pointed to by the iterator.
		public void remove() {
			if (current == null)
				throw new NoSuchElementException();
			if (current == first) {
				first = first.link;
				current = (LinkedListIntNode) first;
				previous = null;				
				if (first == null)
					last = null;			
			}			
			else {
				previous.link = current.link;				
				if (current == last) {
					last = first;					
					while (last.link != null)
						last = last.link;				
				}
				current = current.link;			
			}
			count--;		
		}
		
		public String toString() {			
			return ""+current.info;		
		}	
	}
	
}