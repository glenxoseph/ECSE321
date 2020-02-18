import java.util.Set;
import java.util.HashSet;

public class SmallRoom extends Room {
// getter/**
 * <pre>
 *           10..10     1..1
 * SmallRoom ------------------------- Company
 *           smallRoom        &lt;       company
 * </pre>
 */
private Company company;

public void setCompany(Company value) {
   this.company = value;
}

public Company getCompany() {
   return this.company;
}

// getter/**
 * <pre>
 *           1..1     0..*
 * SmallRoom ------------------------- TutorSession
 *           smallRoom        &lt;       tutorSession
 * </pre>
 */
private Set<TutorSession> tutorSession;

public Set<TutorSession> getTutorSession() {
   if (this.tutorSession == null) {
this.tutorSession = new HashSet<TutorSession>();
   }
   return this.tutorSession;
}

}
