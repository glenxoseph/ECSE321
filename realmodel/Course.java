import java.util.Set;
import java.util.HashSet;

public class Course {
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
 * Course ------------------------- Session
 *           course        &gt;       session
 * </pre>
 */
private Set<Session> session;

public Set<Session> getSession() {
   if (this.session == null) {
this.session = new HashSet<Session>();
   }
   return this.session;
}

// getter
/**
 * <pre>
 *           0..*     1..1
 * Course ------------------------- Subject
 *           course        &lt;       subject
 * </pre>
 */
private Subject subject;

public void setSubject(Subject value) {
   this.subject = value;
}

public Subject getSubject() {
   return this.subject;
}

// getter
/**
 * <pre>
 *           0..*     1..1
 * Course ------------------------- School
 *           course        &lt;       school
 * </pre>
 */
private School school;

public void setSchool(School value) {
   this.school = value;
}

public School getSchool() {
   return this.school;
}

private int courseId;

public void setCourseId(int value) {
   this.courseId = value;
}

public int getCourseId() {
   return this.courseId;
}

}
