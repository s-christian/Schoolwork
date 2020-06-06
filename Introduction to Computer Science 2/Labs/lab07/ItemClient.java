public class ItemClient {
	
	public static void main(String[] args) {
		// Testing Books
		Book b1 = new Book();
		Book b2 = new Book(123456, "To kill a mocking bird", 5, "Harper Lee");
		
		System.out.println("----- PRINTING BOOKS -----");
		System.out.println("Printing Book 1 (empty):\n" + b1);
		System.out.println("Printing Book 2 (full):\n" + b2);
		
		b1.checkOut();
		b2.checkOut();
		System.out.println("After the Books were checked OUT, the number of copies changed. The new info is:");
		System.out.println();
		System.out.println("Printing Book 1 (empty):\n" + b1);
		System.out.println("Printing Book 2 (full):\n" + b2);
		
		b1.checkIn();
		b2.checkIn();
		System.out.println("After the Books were checked IN, the number of copies changed. The new info is:");
		System.out.println();
		System.out.println("Printing Book 1 (empty):\n" + b1);
		System.out.println("Printing Book 2 (full):\n" + b2);
		
		// Testing Videos
		Video v1 = new Video();
		Video v2 = new Video(1111, "The Godfather", 3, 215, "Francis Ford Coppola", "drama", 1981);
		
		System.out.println("----- PRINTING VIDEOS -----");
		System.out.println("Printing Video 1 (empty):\n" + v1);
		System.out.println("Printing Video 2 (full):\n" + v2);
		
		v1.checkOut();
		v2.checkOut();
		System.out.println("After the Videos were checked out, the number of copies changed. The new info is:");
		System.out.println();
		System.out.println("Printing Video 1 (empty):\n" + v1);
		System.out.println("Printing Video 2 (full):\n" + v2);
		
		System.out.println("Video 2 addItem()");
		v2.addItem();
		System.out.println();
		
		System.out.println("Printing Video 2 (full):\n" + v2);
		
		// Testing CDs
		CD c1 = new CD();
		CD c2 = new CD(123, "Test CD", 9, 64.98, "Test Artist", "electronic");
		
		System.out.println("----- PRINTING CDS -----");
		System.out.println("Printing CD 1 (empty):\n" + c1);
		System.out.println("Printing CD 2 (full):\n" + c2);
		
		System.out.printf("CD 1 getRuntime() = %.1f\n", c1.getRuntime());
		System.out.printf("CD 2 getRuntime() = %.1f\n", c2.getRuntime());
		System.out.println("CD 2 setRuntime(40)");
		c2.setRuntime(40);
		System.out.printf("CD 2 getRuntime() = %.1f\n", c2.getRuntime());
		System.out.println();
		
		System.out.printf("CD 1 equals(CD 2)? : " + c1.equals(c2) + "\n");
		System.out.println();
		
		System.out.println("CD 1 print():");
		c1.print();
		System.out.println();
		System.out.println("CD 2 print(): ");
		c2.print();
		System.out.println();
		
		// Testing JournalPapers
		JournalPaper j1 = new JournalPaper();
		JournalPaper j2 = new JournalPaper(19, "1984", 84, "George Orwell", 1984);
		
		System.out.println("----- PRINTING JOURNALPAPERS -----");
		System.out.println("Printing JournalPaper 1 (empty):\n" + j1);
		System.out.println("Printing JournalPaper 2 (full):\n" + j2);
		
		System.out.println("JournalPaper 2 setAuthor(\"Hello\")");
		j2.setAuthor("Hello");
		System.out.println("JournalPaper 2 getAuthor() = " + j2.getAuthor());
		System.out.println();
		
		JournalPaper j3 = new JournalPaper(19, "1984", 84, "George Orwell", 1984);
		System.out.println("Printing JournalPaper 3 (new full):\n" + j3);
		
		System.out.println("JournalPaper 2 equals(JournalPaper 3)? : " + j2.equals(j3) + "\n");
		System.out.println("JournalPaper 3 setAuthor(\"Hello\")");
		j3.setAuthor("Hello");
		System.out.println("JournalPaper 2 equals(JournalPaper 3)? : " + j2.equals(j3) + "\n");
		System.out.println();
	}
	
}