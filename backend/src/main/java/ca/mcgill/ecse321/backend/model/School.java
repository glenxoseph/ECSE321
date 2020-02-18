package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.HashSet;

public class School {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private SchoolType schoolType;

	public void setSchoolType(SchoolType value) {
		this.schoolType = value;
	}

	public SchoolType getSchoolType() {
		return this.schoolType;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * School ------------------------- Student
	 *           school        &gt;       student
	 * </pre>
	 */
	private Set<Student> student;

	public Set<Student> getStudent() {
		if (this.student == null) {
			this.student = new HashSet<Student>();
		}
		return this.student;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * School ------------------------- Course
	 *           school        &gt;       course
	 * </pre>
	 */
	private Set<Course> course;

	public Set<Course> getCourse() {
		if (this.course == null) {
			this.course = new HashSet<Course>();
		}
		return this.course;
	}

	private int schoolId;

	public void setSchoolId(int value) {
		this.schoolId = value;
	}

	public int getSchoolId() {
		return this.schoolId;
	}

}
