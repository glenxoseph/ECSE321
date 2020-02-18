import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReviewSession extends Session{
// getterprivate LargeRoom largeRoom;

@ManyToOne(optional=false)
public LargeRoom getLargeRoom() {
   return this.largeRoom;
}

public void setLargeRoom(LargeRoom largeRoom) {
   this.largeRoom = largeRoom;
}

}
