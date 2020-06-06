public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
	//Double linked list node class
	public class DoubleLinkedListNode<T> {
		T info;
		DoubleLinkedListNode<T> next;
		DoubleLinkedListNode<T> back;
		
		public DoubleLinkedListNode() {
			info = null;
			next = null;
			back = null;
		}
		public DoubleLinkedListNode(T info, DoubleLinkedListNode<T> back, DoubleLinkedListNode<T> next) {
			this.info = info;
			this.back = back;
			this.next = next;
		}
		
		public String toString() {
			return info.toString();
		}
	}
	
	protected int count;  //number of nodes
	protected DoubleLinkedListNode<T> first; //reference to first node
	protected DoubleLinkedListNode<T> last;  //reference to last node
	
	public DoubleLinkedList() {
		count = 0;
		first = null;
		last = null;
	}
	
	public void initializeList() {
		count = 0;
		first = null;
		last = null;
	}

	public boolean isEmptyList() {
		return count==0;
	}

	public T front() {
		return first.info;
	}

	public T back() {
		return last.info;
	}

	public int length() {
		return count;
	}

	public void print() {
		DoubleLinkedListNode<T> current = first;
		while (current != null) {
			System.out.print(current.info + " ");
			current = current.next;
		}
	}

	public void reversePrint() {
		DoubleLinkedListNode<T> current = last;
		while (current != null) {
			System.out.print(current.info + " ");
			current = current.back;
		}
	}

	public boolean search(T searchItem) {
		Comparable<T> compFirst = (Comparable<T>) first.info;
		Comparable<T> compLast = (Comparable<T>) last.info;
		//If searchItem is outside the scope of the list, return false
		if (compLast.compareTo(searchItem) < 0 || compFirst.compareTo(searchItem) > 0)
			return false;
		
		//Set starting point at either first or last node, depending on which is closer to searchItem
		DoubleLinkedListNode<T> current = (Math.abs(compFirst.compareTo(searchItem)) <= Math.abs(compLast.compareTo(searchItem)))? first : last;
		if (current == first) { //start at front
			while (current != null) {
				if (current.info == searchItem)
					return true;
				current = current.next;
			}
		}
		else if (current == last) { //start at back
			while (current != null) {
				if (current.info == searchItem)
					return true;
				current = current.back;
			}
		}
		else
			System.err.println("Error in search method!");
		return false;
	}

	public void insertNode(T insertItem) {
		DoubleLinkedListNode<T> current = first;	  //variable to traverse the list
		DoubleLinkedListNode<T> trailCurrent = first; //variable just before current
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(insertItem, null, null); //create the new node
		boolean found = false;
		//Case 1 : The list is empty, create its first node
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else { //search the list
			while (current != null && !found) { //begin search
				Comparable<T> temp = (Comparable<T>) current.info;
				if (temp.compareTo(insertItem) >= 0)
				   found = true;
				else {
				   trailCurrent = current;
				   current = current.next;
				}
			}
			//Case 2 : Insert at FIRST
			if (current == first) {
				newNode.next = first;
				first.back = newNode;
				first = newNode;
			}
			//Case 3 : Insert at LAST
			else if (current == null) {
				newNode.back = last;
				last.next = newNode;
				last = newNode;
			}
			//Case 4 : Insert somewhere in between
			else {
				newNode.back = trailCurrent;
				newNode.next = current;
				trailCurrent.next = newNode;
				current.back = newNode;
			}
		}
		count++;
	}

	public void deleteNode(T deleteItem) {
		DoubleLinkedListNode<T> current;	  //variable to traverse the list
		DoubleLinkedListNode<T> trailCurrent; //variable just before current
		boolean found = false;
		//Case 1 : List is empty
		if (first == null)
			System.err.println("Cannot delete from an empty list.");
		//Case 2 : deleteItem is not in list
		else if (!search(deleteItem))
			System.err.println("Item is not in list.");
		else {
			//Case 3 : deleteItem is the FIRST item in the list
			if (first.info == deleteItem) {
				first = first.next;
				if (first == null)
					last = null;
				else
					first.back = null;
				count--;
			}
			//Case 4 : deleteItem is the LAST item in the list
			else if (last.info == deleteItem) {
				last = last.back;
				last.next = null;
				count--;
			}
			//Case 5: deleteItem is somewhere in between
			else { //search the list for the node with the given info
				Comparable<T> compFirst = (Comparable<T>) first.info;
				Comparable<T> compLast = (Comparable<T>) last.info;
				//Set the first node traversal to first or last depending on which is closer in value to deleteItem
				trailCurrent = (Math.abs(compFirst.compareTo(deleteItem)) <= Math.abs(compLast.compareTo(deleteItem)))? first : last;
				//Set the second node traversal to the next node relative to trailCurrent
				if (trailCurrent == first) {
					current = trailCurrent.next;
					while (current != null && !found) {
						if (current.info == deleteItem) {
							found = true;
							trailCurrent.next = current.next;
							current.next.back = trailCurrent;
							count--;
						}
						else {
							trailCurrent = current;
							current = current.next;
						}
					}
				}
				else if (trailCurrent == last) {
					current = trailCurrent.back;
					while (current != null && !found) {
						if (current.info == deleteItem) {
							found = true;
							trailCurrent.back = current.back;
							current.back.next = trailCurrent;
							count--;
						}
						else {
							trailCurrent = current;
							current = current.back;
						}
					}
				}
				else if (trailCurrent != first && trailCurrent != last)
					System.err.println("Error with trailCurrent value!");
				else
					System.err.println("Other error!");
			}
		}
	}
	
	public String toString() {
		String list = "[head] - ";
		DoubleLinkedListNode<T> current = first;
		//If list is empty, return "null"
		if (current == null)
			return "null";
		//If list has only one item, return the first item
		if (current.next == null)
			return list + current.info + " - [tail]";
		
		//When list has two or more elements, concatenate their values into a comma-separated String
		//String list = "";
		while (current.next != null) {
			list += current.info + " - ";
			current = current.next;
		}
		return list + current.info + " - [tail]";
	}
	
	public String recursiveToString() {
		return recString(first) + " - [tail]";
	}
	
	public String recString(DoubleLinkedListNode<T> node) {
		if (node.next != null)
			return node.info + " - " + recString(node.next);
		else
			return "" + node.info;
	}
	
	public String backwardsString() {
		String list = "[tail] - ";
		DoubleLinkedListNode<T> current = last;
		//If list is empty, return "null"
		if (current == null)
			return "null";
		//If list has only one item, return the first item
		if (current.back == null)
			return list + current.info + " - [tail]";
		
		//When list has two or more elements, concatenate their values into a comma-separated String
		while (current.back != null) {
			list += current.info + " - ";
			current = current.back;
		}
		return list + current.info + " - [head]";
	}
	
	public String recursiveBackwardsString() {
		return "[tail] - " + recBackString(last);
	}
	
	public String recBackString(DoubleLinkedListNode<T> node) {
		if (node.back != null)
			return node.info + " - " + recBackString(node.back);
		else
			return "" + node.info;
	}
	
	public void copy(DoubleLinkedList<T> otherList) {
		initializeList();
		if (otherList.first != null) {
			DoubleLinkedListNode<T> current = otherList.first;
			while (current != null) {
				insertNode(current.info);
				current = current.next;
			}
			first = otherList.first;
			last = otherList.last;
		}
	}
	
	public void reversedCopy(DoubleLinkedList<T> otherList) {
		initializeList();
		if (otherList.first != null) {
			DoubleLinkedListNode<T> otherCurrent = otherList.last;
			first = new DoubleLinkedListNode<T>(otherCurrent.info, null, null);
			DoubleLinkedListNode<T> current = first;
			otherCurrent = otherCurrent.back;
			while (otherCurrent != null) {
				current.next = new DoubleLinkedListNode<T>(otherCurrent.info, current, null);
				current = current.next;
				otherCurrent = otherCurrent.back;
			}
			last = otherList.first;
			count = otherList.count;
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof DoubleLinkedList) {
			DoubleLinkedList<T> temp = (DoubleLinkedList<T>) obj;
			if (count != temp.count)
				return false;
			DoubleLinkedListNode<T> current = first;
			DoubleLinkedListNode<T> tempCurrent = temp.first;
			while (current != null && tempCurrent != null) {
				if (current.info != tempCurrent.info)
					return false;
				current = current.next;
				tempCurrent = tempCurrent.next;
			}
			return true;
		}
		return false;
	}
}