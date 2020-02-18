package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.HashSet;

public class Subject {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * Subject ------------------------- Course
	 *           subject        &gt;       course
	 * </pre>
	 */
	private Set<Course> course;

	public Set<Course> getCourse() {
		if (this.course == null) {
			this.course = new HashSet<Course>();
		}
		return this.course;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * Subject ------------------------- Tutor
	 *           subject        &lt;       tutor
	 * </pre>
	 */
	private Set<Tutor> tutor;

	public Set<Tutor> getTutor() {
		if (this.tutor == null) {
			this.tutor = new HashSet<Tutor>();
		}
		return this.tutor;
	}

	private int subjectId;

	public void setSubjectId(int value) {
		this.subjectId = value;
	}

	public int getSubjectId() {
		return this.subjectId;
	}

}
