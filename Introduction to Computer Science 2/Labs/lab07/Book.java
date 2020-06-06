public class Book extends WrittenItem {
	
	public Book() {
		super();
	}
	public Book(int id, String title, int copies, String author) {
		super(id, title, copies, author);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			return super.equals(obj);
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + "NUMBER OF COPIES: " + getCopies() + "\n";
	}
	
	public void print() {
		super.print();
		System.out.println("NUMBER OF COPIES " + getCopies());
	}
}