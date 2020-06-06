public abstract class Item {
	private int id;
	private String title;
	private int copies;
	
	public Item() {
		id = 0;
		title = "";
		copies = 0;
	}
	public Item(int id, String title, int copies) {
		this.id = id;
		this.title = title;
		this.copies = copies;
	}
	
	public int getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getCopies() {
		return copies;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			Item tempItem = (Item) obj;
			return tempItem.id == id && tempItem.title == title && tempItem.copies == copies;
		}
		return false;
	}
	
	public String toString() {
		return String.format("ID: %d\nTITLE: %s\n", id, title);
	}
	
	public void print() {
		System.out.printf("ID: %d\nTITLE: %s\n", id, title);
	}
	
	public void checkIn() {
		copies++;
	}
	public void checkOut() {
		if (copies > 0) copies--;
		else System.out.println("Cannot check out \"" + title + "\": No copies available!");
	}
	
	public void addItem() {
		copies++;
	}
}