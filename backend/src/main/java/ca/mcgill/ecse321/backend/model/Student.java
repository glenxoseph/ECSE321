package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.HashSet;

public class Student extends User {
	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * Student ------------------------- Evaluation
	 *           student        &gt;       evaluation
	 * </pre>
	 */
	private Set<Evaluation> evaluation;

	public Set<Evaluation> getEvaluation() {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		return this.evaluation;
	}

	private Set<Session> sessions;
	
	public Set<Session> getSession() {
		if (this.sessions == null) {
			this.sessions = new HashSet<Session>();
		}
		return this.sessions;
	}
	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * Student ------------------------- School
	 *           student        &lt;       school
	 * </pre>
	 */
	private School school;

	public void setSchool(School value) {
		this.school = value;
	}

	public School getSchool() {
		return this.school;
	}
	
	
}
