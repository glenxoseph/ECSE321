import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TutorSession extends Session{
// getterprivate SmallRoom smallRoom;

@ManyToOne(optional=false)
public SmallRoom getSmallRoom() {
   return this.smallRoom;
}

public void setSmallRoom(SmallRoom smallRoom) {
   this.smallRoom = smallRoom;
}

}
