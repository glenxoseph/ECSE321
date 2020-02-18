package ca.mcgill.ecse321.backend.model;

import java.util.Set;
import java.util.HashSet;

public class Company {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private int openTime;

	public void setOpenTime(int value) {
		this.openTime = value;
	}

	public int getOpenTime() {
		return this.openTime;
	}

	private int closeTime;

	public void setCloseTime(int value) {
		this.closeTime = value;
	}

	public int getCloseTime() {
		return this.closeTime;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     10..10
	 * Company ------------------------- SmallRoom
	 *           company        &gt;       smallRoom
	 * </pre>
	 **/
	private Set<SmallRoom> smallRoom;

	public Set<SmallRoom> getSmallRoom() {
		if (this.smallRoom == null) {
			this.smallRoom = new HashSet<SmallRoom>();
		}
		return this.smallRoom;
	}

	// getter
	/**
	* <pre>
	*           1..1     3..3
	* Company ------------------------- LargeRoom
	*           company        &gt;       largeRoom
	* </pre>
	*/
	private Set<LargeRoom> largeRoom;

	public Set<LargeRoom> getLargeRoom() {
		if (this.largeRoom == null) {
			this.largeRoom = new HashSet<LargeRoom>();
		}
		return this.largeRoom;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     13..13
	 * Company ------------------------- Room
	 *           company1        &gt;       room1
	 * </pre>
	 */
	private Set<Room> room1;

	public Set<Room> getRoom1() {
		if (this.room1 == null) {
			this.room1 = new HashSet<Room>();
		}
		return this.room1;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * Company ------------------------- User
	 *           company        &gt;       user
	 * </pre>
	 */
	private Set<User> user;

	public Set<User> getUser() {
		if (this.user == null) {
			this.user = new HashSet<User>();
		}
		return this.user;
	}

	private int companyId;

	public void setCompanyId(int value) {
		this.companyId = value;
	}

	public int getCompanyId() {
		return this.companyId;
	}
}