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
	
	public OrderedArrayList merge(Object obj) {
		if (obj instanceof OrderedArrayList) {
			OrderedArrayList temp = (OrderedArrayList) obj;
			OrderedArrayList merged = new OrderedArrayList(maxSize + temp.maxSize);
			// Variables for independently traversing both arrays
			int count1 = 0, count2 = 0;
			// Traverse both arrays, comparing and inserting smallest value, until one array has reached its end
			while (count1 < length && count2 < temp.length) {
				if (list[count1] < temp.list[count2])
					merged.list[merged.length++] = list[count1++];
				else
					merged.list[merged.length++] = temp.list[count2++];
			}
			// Fill with remaining values from non-depleted array
			while (count1 < length)
				merged.list[merged.length++] = list[count1++];
			while (count2 < temp.length)
				merged.list[merged.length++] = temp.list[count2++];
			// Return merged array
			return merged;
		}
		System.out.println("Cannot merge with a non-OrderedArrayList object!");
		return null;
	}
	
	public OrderedArrayList[] split(int key) {
		// Find where to "cut" the array
		int index = length;
		for (int i = 0; i < length; i++)
			if (list[i] > key) {
				index = i;
				break;
			}
		// Create 2 separate lists
		OrderedArrayList list1 = new OrderedArrayList(index);
		OrderedArrayList list2 = new OrderedArrayList(length-index);
		// Fill list 1
		for (int i = 0; i < index; i++)
			list1.list[list1.length++] = list[i];
		// Fill list 2
		for (int i = index; i < length; i++)
			list2.list[list2.length++] = list[i];
		// Return both lists
		OrderedArrayList[] lists = {list1, list2};
		return lists;
	}
}