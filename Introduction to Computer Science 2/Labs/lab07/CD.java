public class CD extends MediaItem {
	private String artist;
	private String genre;
	
	public CD() {
		super();
		artist = "";
		genre = "";
	}
	public CD(int id, String title, int copies, double runtime, String artist, String genre) {
		super(id, title, copies, runtime);
		this.artist = artist;
		this.genre = genre;
	}
	
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof CD) {
			CD tempCD = (CD) obj;
			return super.equals(tempCD) && tempCD.artist == artist && tempCD.genre == genre;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + String.format("ARTIST: %s\nGENRE: %s\nRUNTIME: %.1f minutes\nNUMBER OF COPIES: %d\n", artist, genre, getRuntime(), getCopies());
	}
	
	public void print() {
		super.print();
		System.out.printf("ARTIST: %s\nGENRE: %s\nRUNTIME: %.1f minutes\nNUMBER OF COPIES: %d\n", artist, genre, getRuntime(), getCopies());
	}
}