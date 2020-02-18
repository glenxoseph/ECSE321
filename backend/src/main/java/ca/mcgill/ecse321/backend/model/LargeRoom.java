package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.HashSet;

public class LargeRoom extends Room {
	// getter
	/**
	 * <pre>
	 *           3..3     1..1
	 * LargeRoom ------------------------- Company
	 *           largeRoom        &lt;       company
	 * </pre>
	 */
	private Company company;

	public void setCompany(Company value) {
		this.company = value;
	}

	public Company getCompany() {
		return this.company;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * LargeRoom ------------------------- ReviewSession
	 *           largeRoom        &lt;       reviewSession
	 * </pre>
	 */
	private Set<ReviewSession> reviewSession;

	public Set<ReviewSession> getReviewSession() {
		if (this.reviewSession == null) {
			this.reviewSession = new HashSet<ReviewSession>();
		}
		return this.reviewSession;
	}

}
