import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class LargeRoom extends Room{
// getterprivate Company company;

@ManyToOne(optional=false)
public Company getCompany() {
   return this.company;
}

public void setCompany(Company company) {
   this.company = company;
}

// getterprivate Set<ReviewSession> reviewSession;

@OneToMany(mappedBy="largeRoom")
public Set<ReviewSession> getReviewSession() {
   return this.reviewSession;
}

public void setReviewSession(Set<ReviewSession> reviewSessions) {
   this.reviewSession = reviewSessions;
}

}
