package ca.mcgill.ecse321.backend.model;
public class User {
	private String userName;

	public void setUserName(String value) {
		this.userName = value;
	}

	public String getUserName() {
		return this.userName;
	}

	private String password;

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * User ------------------------- Company
	 *           user        &lt;       company
	 * </pre>
	 */
	private Company company;

	public void setCompany(Company value) {
		this.company = value;
	}

	public Company getCompany() {
		return this.company;
	}

	private int userId;

	public void setUserId(int value) {
		this.userId = value;
	}

	public int getUserId() {
		return this.userId;
	}

}
