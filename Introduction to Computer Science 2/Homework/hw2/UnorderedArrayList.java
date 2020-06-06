// Class: UnorderedArrayList extends
// Super class: ArrayListClass
public class UnorderedArrayList extends ArrayListClass {

	public UnorderedArrayList() {
		super();
	}
	public UnorderedArrayList(int size) {
		super(size);
	}
	// Bubble Sort
	public void bubbleSort() {
		for (int pass = 0; pass < length - 1; pass++) {
			for (int i = 0; i < length - 1; i++) {
				if (list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	// implementation for abstract methods defined in ArrayListClass
	// unordered list --> linear search
	public int search(int searchItem) {
		for(int i = 0; i < length; i++)
			if(list[i] == searchItem)
				return i;
		return -1;
	}
	public void insertAt(int location, int insertItem) {
		if (location < 0 || location >= maxSize)
			System.err.println("The position of the item to be inserted is out of range.");
		else if (length >= maxSize)
			System.err.println("Cannot insert in a full list.");
		else {
			for (int i = length; i > location; i--)
				list[i] = list[i - 1]; //shift right
			list[location] = insertItem;
			length++;
		}
	}
	public void insertEnd(int insertItem) {
		if (length >= maxSize)
			System.err.println("Cannot insert in a full list.");
		else {
			list[length] = insertItem;
			length++;
		}
	}
	public void replaceAt(int location, int repItem) {
		if (location < 0 || location >= length)
			System.err.println("The location of the item to be replaced is out of range.");
		else
			list[location] = repItem;
	}
	public void remove(int removeItem) {
		int i;
		if (length == 0)
			System.err.println("Cannot delete from an empty list.");
		else {
			i = search(removeItem);
			if (i != -1)
				removeAt(i);
			else
				System.out.println("Cannot delete! The item to be deleted is not in the list.");
		}
	}
	public void scaleByK() {
		if (length == 0)
			System.err.println("Cannot scale an empty list.");
		else {
			int sum = 0;
			for (int i = 0; i < length; i++)
				if (!(list[i] <= 0))
					sum += list[i];
			UnorderedArrayList temp = new UnorderedArrayList(sum);
			for (int i = 0; i < length; i++)
				for (int num = list[i]; num > 0; num--)
					temp.insertEnd(list[i]);
			length = temp.length;
			list = temp.list;
		}
	}
	
	public UnorderedArrayList merge(Object obj) {
		if (obj instanceof UnorderedArrayList) {
			UnorderedArrayList temp = (UnorderedArrayList) obj;
			UnorderedArrayList merged = new UnorderedArrayList(maxSize + temp.maxSize);
			for (int i = 0; i < length; i++) {
				merged.insertEnd(list[i]);
			}
			for (int i = 0; i < temp.length; i++) {
				merged.insertEnd(temp.list[i]);
			}
			return merged;
		}
		System.out.println("Cannot merge with a non-UnorderedArrayList object!");
		return null;
	}
	
	public UnorderedArrayList[] split(int key) {
		UnorderedArrayList list1 = new UnorderedArrayList(length);
		UnorderedArrayList list2 = new UnorderedArrayList(length);
		for (int i = 0; i < length; i++) {
			if (list[i] <= key)
				list1.insertEnd(list[i]);
			else
				list2.insertEnd(list[i]);
		}
		UnorderedArrayList[] lists = {list1, list2};
		return lists;
	}
}