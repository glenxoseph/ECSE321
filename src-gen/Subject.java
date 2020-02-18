import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Subject{
private String name;
   
   public void setName(String value) {
this.name = value;
    }
public String getName() {
return this.name;
    }
// getterprivate Set<Course> course;

@OneToMany(mappedBy="subject")
public Set<Course> getCourse() {
   return this.course;
}

public void setCourse(Set<Course> courses) {
   this.course = courses;
}

// getterprivate Set<Tutor> tutor;

@OneToMany(mappedBy="subject")
public Set<Tutor> getTutor() {
   return this.tutor;
}

public void setTutor(Set<Tutor> tutors) {
   this.tutor = tutors;
}

private int subjectId;

public void setSubjectId(int value) {
this.subjectId = value;
    }
public int getSubjectId() {
return this.subjectId;
       }
   }
