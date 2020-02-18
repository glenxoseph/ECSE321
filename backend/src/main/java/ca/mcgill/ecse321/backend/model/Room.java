package ca.mcgill.ecse321.backend.model;
public class Room {
	private int roomId;

	public void setRoomId(int value) {
		this.roomId = value;
	}

	public int getRoomId() {
		return this.roomId;
	}

	private boolean ifFree;

	public void setIfFree(boolean value) {
		this.ifFree = value;
	}

	public boolean isIfFree() {
		return this.ifFree;
	}

	private int capacity;

	public void setCapacity(int value) {
		this.capacity = value;
	}

	public int getCapacity() {
		return this.capacity;
	}

	// getter
	/**
	 * <pre>
	 *           13..13     1..1
	 * Room ------------------------- Company
	 *           room1        &lt;       company1
	 * </pre>
	 */

	private Company company1;

	public void setCompany1(Company value) {
		this.company1 = value;
	}

	public Company getCompany1() {
		return this.company1;
	}

}
