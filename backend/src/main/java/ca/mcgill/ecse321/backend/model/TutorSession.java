package ca.mcgill.ecse321.backend.model;
public class TutorSession extends Session {
	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * TutorSession ------------------------- SmallRoom
	 *           tutorSession        &gt;       smallRoom
	 * </pre>
	 */
	private SmallRoom smallRoom;

	public void setSmallRoom(SmallRoom value) {
		this.smallRoom = value;
	}

	public SmallRoom getSmallRoom() {
		return this.smallRoom;
	}

}
