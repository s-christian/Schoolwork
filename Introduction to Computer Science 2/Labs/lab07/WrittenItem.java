public abstract class WrittenItem extends Item {
	private String author;
	
	public WrittenItem() {
		super();
		author = "";
	}
	public WrittenItem(int id, String title, int copies, String author) {
		super(id, title, copies);
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof WrittenItem) {
			WrittenItem tempWI = (WrittenItem) obj;
			return super.equals(tempWI) && tempWI.author == author;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + "AUTHOR: " + author + "\n";
	}
	
	public void print() {
		super.print();
		System.out.println("AUTHOR: " + author);
	}
}