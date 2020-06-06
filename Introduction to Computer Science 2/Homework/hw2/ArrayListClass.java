// Class: ArrayListClass implements
// Interface: ArrayListADT
public abstract class ArrayListClass implements ArrayListADT {
	protected int length;  //to store the length of the list
	protected int maxSize; //to store the maximum size of the list
	protected int[] list;  //array to hold the list elements
	//Default constructor
	public ArrayListClass() {
		maxSize = 100;
		length = 0;
		list = new int[maxSize];
	}
	//Alternate Constructor
	public ArrayListClass(int size) {
		if(size <= 0) {
			System.err.println("The array size must be positive. Creating an array of size 100.");
			maxSize = 100;
		}
		else
			maxSize = size;
		length = 0;
		list = new int[maxSize];
	}
	public boolean isEmpty() {
		return (length == 0);
	}
	public boolean isFull() {
		return (length == maxSize);
	}
	public int listSize() {
		return length;
	}
	public int maxListSize() {
		return maxSize;
	}
	public void print() {
		for (int i = 0; i < length; i++)
			System.out.print(list[i] + "  ");
		System.out.println();
	}
	public boolean isItemAtEqual(int location, int item) {
		if (location < 0 || location >= length) {
			System.err.println("The location of the item to be compared is out of range.");
			return false;
		}
		return list[location] == item;
	}
	public void clearList() {
		for (int i = 0; i < length; i++)
			list[i] = 0;
		length = 0;
		System.gc(); //invoke the Java garbage collector
	}
	public void removeAt(int location) {
		if (location < 0 || location >= length)
			System.err.println("The location of the item to be removed is out of range.");
		else {
			for(int i = location; i < length - 1; i++)
				 list[i] = list[i + 1];
			length--;
		}
	}
	public int retrieveAt(int location) {
		if (location < 0 || location >= length) {
			System.err.println("The location of the item to be retrieved is out of range.");
			return 0;
		}
		else
			return list[location];
	}
	public abstract void insertAt(int location, int insertItem);
	public abstract void insertEnd(int insertItem);
	public abstract void replaceAt(int location, int repItem);
	public abstract int search(int searchItem);
	public abstract void remove(int removeItem);
}