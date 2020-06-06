//Class: OrderedArrayList extends 
//Super class: ArrayListClass 
public class OrderedArrayList extends ArrayListClass{ 

	public OrderedArrayList() { 
		super(); 
	}
	public OrderedArrayList(int size) { 
		super(size); 
	} 
	//implementation for abstract methods defined in ArrayListClass
	//ordered list --> binary search 
	public int search(int item) { 
		int first = 0; 
		int last = length - 1; 
		int middle = -1;
		while (first <= last)	{ 
			middle = (first + last) / 2; 
			if (list[middle] == item) 
				return middle; 
			else 
				if (list[middle] > item) 
					last = middle - 1; 
				else 
					first = middle + 1; 
		} 
		return -1; 
	}
	public void insert(int item) { 
		int loc;  
		if (length == 0)						//list is empty 
			list[length++] = item;	//insert item and increment length 
		else if (length == maxSize) //list is full 
			System.err.println("Cannot insert in a full list."); 
		else { 
			for (loc = 0; loc < length; loc++)
				if (list[loc] >= item)
					break; 
			//starting at the end, shift right 
			for (int i = length; i > loc; i--) 
				list[i] = list[i - 1]; 
			list[loc] = item; //insert in place
			length++; 
		} 
	}
	/* Another version for insert: 
	public void insert(int item) { 
			int loc; 
			boolean found = false; 
			if (length == 0)						//list is empty 
					list[length++] = item;	//insert item and increment length 
			else if (length == maxSize) //list is full 
					System.err.println("Cannot insert in a full list."); 
			else { 
					int i = length - 1; 
					while (i >= 0 && list[i] > item) { 
							list[i + 1] = list[i]; 
							i--; 
					} 
					list[i + 1] = item;	// Insert item 
					length++; 
		 } 
	} */
	public void insertAt(int location, int item)	{ 
		if (location < 0 || location >= maxSize) 
			System.err.println("The position of the item to be inserted is out of range."); 
		else if (length == maxSize)	//the list is full 
			System.err.println("Cannot insert in a full list."); 
		else { 
			System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert)."); 
			insert(item); 
		} 
	}
	public void insertEnd(int item) { 
		if (length == maxSize)	//the list is full 
			System.err.println("Cannot insert in a full list."); 
		else { 
			System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert)."); 
			insert(item); 
		} 
	}
	public void replaceAt(int location, int item) { 
		//the list is sorted! 
		//is actually removing the element at location and inserting item in place 
		if (location < 0 || location >= length) 
			 System.err.println("The position of the item to be replaced is out of range."); 
		else { 
			removeAt(location);//method in ArrayListClass 
			insert(item); 
		} 
	}
	public void remove(int item) {
		int loc;
		if (length == 0)
			System.err.println("Cannot delete from an empty list.");
		else {
			loc = search(item);
			if (loc != -1)
				removeAt(loc); //method in ArrayListClass
			else
				System.out.println("The item to be deleted is not in the list.");
		}
	}
	/*Another version for remove: 
	public void remove(T item) { 
			int loc; 
			if (length == 0) 
					System.err.println("Cannot delete from an empty list."); 
			else	{ 
					loc = search(item); 
					if (loc != -1) { 
							for(int i = loc; i < length - 1; i++) 
									list[i] = list[i + 1]; //shift left 
							length--; 
					} 
					else 
							System.out.println("The item to be deleted is not in the list."); 
			} 
	} */ 
	public void removeDuplicates() {
		if (length <= 1)
			System.err.println("Cannot remove duplicates if there is only 1 or no elements.");
		else {
			OrderedArrayList temp = new OrderedArrayList();
			for (int i = 0; i < length-1; i++) {
				if (list[i] != list[i+1])
					temp.insert(list[i]);
			}
			temp.insert(list[length-1]);
			length = temp.length;
			list = temp.list;
		}	
	}
}