import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Room{
private int roomId;
   
   public void setRoomId(int value) {
this.roomId = value;
    }
public int getRoomId() {
return this.roomId;
    }
private boolean ifFree;

public void setIfFree(boolean value) {
this.ifFree = value;
    }
public boolean isIfFree() {
return this.ifFree;
    }
private int capacity;

public void setCapacity(int value) {
this.capacity = value;
    }
public int getCapacity() {
return this.capacity;
    }
// getterprivate Company company1;

@ManyToOne(optional=false)
public Company getCompany1() {
   return this.company1;
}

public void setCompany1(Company company1) {
   this.company1 = company1;
}

}
