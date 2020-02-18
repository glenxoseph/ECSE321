import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Tutor extends User{
// getterprivate Subject subject;

@ManyToOne(optional=false)
public Subject getSubject() {
   return this.subject;
}

public void setSubject(Subject subject) {
   this.subject = subject;
}

// getterprivate Set<Evaluation> evaluation;

@OneToMany(mappedBy="tutor")
public Set<Evaluation> getEvaluation() {
   return this.evaluation;
}

public void setEvaluation(Set<Evaluation> evaluations) {
   this.evaluation = evaluations;
}

}
