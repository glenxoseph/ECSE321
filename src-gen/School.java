import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class School{
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
// getterprivate Set<Student> student;

@OneToMany(mappedBy="school")
public Set<Student> getStudent() {
   return this.student;
}

public void setStudent(Set<Student> students) {
   this.student = students;
}

// getterprivate Set<Course> course;

@OneToMany(mappedBy="school", cascade={CascadeType.ALL})
public Set<Course> getCourse() {
   return this.course;
}

public void setCourse(Set<Course> courses) {
   this.course = courses;
}

private int schoolId;

public void setSchoolId(int value) {
this.schoolId = value;
    }
public int getSchoolId() {
return this.schoolId;
       }
   }
