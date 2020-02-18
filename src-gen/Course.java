import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course{
private String name;
   
   public void setName(String value) {
this.name = value;
    }
public String getName() {
return this.name;
    }
// getterprivate Set<Session> session;

@OneToMany(mappedBy="course")
public Set<Session> getSession() {
   return this.session;
}

public void setSession(Set<Session> sessions) {
   this.session = sessions;
}

// getterprivate Subject subject;

@ManyToOne(optional=false)
public Subject getSubject() {
   return this.subject;
}

public void setSubject(Subject subject) {
   this.subject = subject;
}

// getterprivate School school;

@ManyToOne(optional=false)
public School getSchool() {
   return this.school;
}

public void setSchool(School school) {
   this.school = school;
}

private int courseId;

public void setCourseId(int value) {
this.courseId = value;
    }
public int getCourseId() {
return this.courseId;
       }
   }
