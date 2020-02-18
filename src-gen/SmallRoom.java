import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class SmallRoom extends Room{
// getterprivate Company company;

@ManyToOne(optional=false)
public Company getCompany() {
   return this.company;
}

public void setCompany(Company company) {
   this.company = company;
}

// getterprivate Set<TutorSession> tutorSession;

@OneToMany(mappedBy="smallRoom")
public Set<TutorSession> getTutorSession() {
   return this.tutorSession;
}

public void setTutorSession(Set<TutorSession> tutorSessions) {
   this.tutorSession = tutorSessions;
}

}
