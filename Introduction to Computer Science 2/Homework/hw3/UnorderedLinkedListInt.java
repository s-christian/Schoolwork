public class UnorderedLinkedListInt extends LinkedListIntClass { //Default constructor
	public UnorderedLinkedListInt() {
		super();
	}
	
	public boolean search(int searchItem) {
		LinkedListIntNode current = first; //variable to traverse the list
		while (current != null)
			if (current.info == searchItem)
				return true;
			else
				current = current.link;
		return false;
	}
	
	public void insertFirst(int newItem) {
		LinkedListIntNode newNode = new LinkedListIntNode (newItem, first);
		first = newNode;
		if (last == null)
			last = newNode;count++;
	}
	
	public void insertLast(int newItem) {
		LinkedListIntNode newNode = new LinkedListIntNode(newItem, null);
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.link = newNode;
			last = newNode;
		}
		count++;
	}
	
	public void deleteNode(int deleteItem) {
		LinkedListIntNode current; //variable to traverse the list
		LinkedListIntNode trailCurrent; //variable just before current
		boolean found; //Case 1; the list is empty
		if (first == null) System.err.println("Cannot delete from an empty list.");
		else { //Case 2: the node to be deleted is first
			if (first.info == deleteItem) {
				first = first.link;
				if (first == null) //the list had only one node
					last = null;
				count--;
			}
			else { //search the list for the given info
				found = false;trailCurrent = first; //trailCurrent points to first node
				current = first.link; //current points to second node
				while (current != null && !found) {
					if (current.info == deleteItem) found = true;
					else {
						trailCurrent = current;current = current.link;
					}
				} //Case 3; if found, delete the node
				if (found) {
					count--;
					trailCurrent.link = current.link;
					if (last == current) //node to be deleted was the last node
						last = trailCurrent;
				}
				else System.out.println("Item to be deleted is not in the list.");
			}
		}
	}
	
	public int findSum() {
		LinkedListIntIterator iter = iterator();
		int sum = 0;
		while (iter.hasNext())
			sum += iter.next();
		return sum;
	}
	
	public int findMin() {
		if (isEmptyList()) return 0;
		LinkedListIntIterator iter = iterator();
		int min = first.info;
		while (iter.hasNext())
			if (iter.next() < min)
				min = iter.previous.info;
		return min;
	}
	
	public String toString() {
		String list = "[";
		LinkedListIntIterator iter = iterator();
		while (iter.hasNext() && iter.current.link != null) {
			list += iter.next() + ", ";
		}
		list += last + "]";
		return list;
	}
	
	public void merge1(UnorderedLinkedListInt list) {
		LinkedListIntNode current = list.first;
		while (current != null) {
			this.insertLast(current.info);
			current = current.link;
		}
	}
	
	public UnorderedLinkedListInt merge2(UnorderedLinkedListInt list) {
		UnorderedLinkedListInt temp = (UnorderedLinkedListInt) clone();
		temp.merge1(list);
		return temp;
	}
	
	public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key) {
		list1.initializeList();
		list2.initializeList();
		LinkedListIntNode current = first;
		while (current != null) {
			if (current.info <= key)
				list1.insertLast(current.info);
			else
				list2.insertLast(current.info);
			current = current.link;
		}
	}
}