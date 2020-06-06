public abstract class MediaItem extends Item {
	private double runtime;
	
	public MediaItem() {
		super();
		runtime = 0;
	}
	public MediaItem(int id, String title, int copies, double runtime) {
		super(id, title, copies);
		this.runtime = runtime;
	}
	
	public double getRuntime() {
		return runtime;
	}
	
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof MediaItem) {
			MediaItem tempMI = (MediaItem) obj;
			return super.equals(tempMI) && tempMI.runtime == runtime;
		}
		return false;
	}
}