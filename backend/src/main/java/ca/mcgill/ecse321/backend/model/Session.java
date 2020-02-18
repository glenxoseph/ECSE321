package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.HashSet;

public class Session {
	
	private int sessionId;

	public void setSessionId(int value) {
		this.sessionId = value;
	}

	public int getSessionId() {
		return this.sessionId;
	}

	private int startTime;

	public void setStartTime(int value) {
		this.startTime = value;
	}

	public int getStartTime() {
		return this.startTime;
	}

	private int endTime;

	public void setEndTime(int value) {
		this.endTime = value;
	}

	public int getEndTime() {
		return this.endTime;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     1..1
	 * Session ------------------------- Charge
	 *           session        &gt;       charge
	 * </pre>
	 */
	private Charge charge;
	
	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	public Charge getCharge() {
		return this.charge;
	}

	private Set<Student> students;
	
	public Set<Student> getStudents() {
		if (this.students == null) {
			this.students= new HashSet<Student>();
		}
		return this.students;
	}
	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * Session ------------------------- Course
	 *           session        &lt;       course
	 * </pre>
	 */
	private Course course;

	public void setCourse(Course value) {
		this.course = value;
	}

	public Course getCourse() {
		return this.course;
	}
	
	private Tutor tutor;
	
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public Tutor getTutor() {
		return this.tutor;
	}
	

}
