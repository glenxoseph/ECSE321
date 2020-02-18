import java.util.Set;
import java.util.HashSet;

public class Tutor extends User {
// getter/**
 * <pre>
 *           0..*     1..1
 * Tutor ------------------------- Subject
 *           tutor        &gt;       subject
 * </pre>
 */
private Subject subject;

public void setSubject(Subject value) {
   this.subject = value;
}

public Subject getSubject() {
   return this.subject;
}

// getter/**
 * <pre>
 *           1..1     0..*
 * Tutor ------------------------- Evaluation
 *           tutor        &lt;       evaluation
 * </pre>
 */
private Set<Evaluation> evaluation;

public Set<Evaluation> getEvaluation() {
   if (this.evaluation == null) {
this.evaluation = new HashSet<Evaluation>();
   }
   return this.evaluation;
}

}
