package ca.mcgill.ecse321.backend.model;
public class ReviewSession extends Session {
	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * ReviewSession ------------------------- LargeRoom
	 *           reviewSession        &gt;       largeRoom
	 * </pre>
	 */
	private LargeRoom largeRoom;

	public void setLargeRoom(LargeRoom value) {
		this.largeRoom = value;
	}

	public LargeRoom getLargeRoom() {
		return this.largeRoom;
	}

}
