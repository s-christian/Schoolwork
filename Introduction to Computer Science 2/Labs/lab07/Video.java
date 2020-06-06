public class Video extends MediaItem {
	private String director;
	private String genre;
	private int year;
	
	public Video() {
		super();
		director = "";
		genre = "";
		year = 9999;
	}
	public Video(int id, String title, int copies, double runtime, String director, String genre, int year) {
		super(id, title, copies, runtime);
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
	
	public String getDirector() {
		return director;
	}
	public String getGenre() {
		return genre;
	}
	public int getYear() {
		return year;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Video) {
			Video tempVideo = (Video) obj;
			return super.equals(tempVideo) && tempVideo.director == director && tempVideo.genre == genre && tempVideo.year == year;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + String.format("DIRECTOR: %s\nGENRE: %s\nYEAR RELEASED: %d\nRUNTIME: %.1f minutes\nNUMBER OF COPIES: %d\n", director, genre, year, getRuntime(), getCopies());
	}
	
	public void print() {
		super.print();
		System.out.printf("DIRECTOR: %s\nGENRE: %s\nYEAR RELEASED: %d\nRUNTIME: %.1f minutes\nNUMBER OF COPIES: %d\n", director, genre, year, getRuntime(), getCopies());
	}
}