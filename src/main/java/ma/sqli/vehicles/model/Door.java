package ma.sqli.vehicles.model;

public class Door {

	private boolean opened;
	private int id;

	public Door(int id, boolean opened) {
		super();
		this.opened = opened;
		this.id = id;
	}

	/**
	 * @return the opened
	 */
	public boolean isOpened() {
		return opened;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public void open() {
		opened = true;
	}
	
	public void close() {
		opened = false;
	}
	
}
