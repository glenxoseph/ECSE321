import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Session{
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
	// getterprivate Set<Charge> charge;

	@OneToMany(mappedBy="session", cascade={CascadeType.ALL})
	public Set<Charge> getCharge() {
		return this.charge;
	}

	public void setCharge(Set<Charge> charges) {
		this.charge = charges;
	}

	// getterprivate Course course;

	@ManyToOne(optional=false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
