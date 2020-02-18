import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student extends User{
// getterprivate Set<Evaluation> evaluation;

@OneToMany(mappedBy="student")
public Set<Evaluation> getEvaluation() {
   return this.evaluation;
}

public void setEvaluation(Set<Evaluation> evaluations) {
   this.evaluation = evaluations;
}

// getterprivate School school;

@ManyToOne(optional=false)
public School getSchool() {
   return this.school;
}

public void setSchool(School school) {
   this.school = school;
}

}
