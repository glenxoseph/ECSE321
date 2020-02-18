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

// getter/**
 * <pre>
 *           1..1     0..*
 * Session ------------------------- Charge
 *           session        &gt;       charge
 * </pre>
 */
private Set<Charge> charge;

public Set<Charge> getCharge() {
   if (this.charge == null) {
this.charge = new HashSet<Charge>();
   }
   return this.charge;
}

// getter/**
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

}
