public class JournalPaper extends WrittenItem {
	private int year;
	
	public JournalPaper() {
		super();
		year = 9999;
	}
	public JournalPaper(int id, String title, int copies, String author, int year) {
		super(id, title, copies, author);
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof JournalPaper) {
			JournalPaper tempJP = (JournalPaper) obj;
			return super.equals(tempJP) && tempJP.year == year;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + "YEAR PUBLISHED: " + year + "\nCOPIES: " + getCopies() + "\n";
	}
	
	public void print() {
		super.print();
		System.out.println("YEAR PUBLISHED: " + year + "\nCOPIES: " + getCopies());
	}
}