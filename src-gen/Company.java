import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Company{
private String name;
   
   public void setName(String value) {
this.name = value;
    }
public String getName() {
return this.name;
    }
private int openTime;

public void setOpenTime(int value) {
this.openTime = value;
    }
public int getOpenTime() {
return this.openTime;
    }
private int closeTime;

public void setCloseTime(int value) {
this.closeTime = value;
    }
public int getCloseTime() {
return this.closeTime;
    }
// getterprivate Set<SmallRoom> smallRoom;

@OneToMany(mappedBy="company")
public Set<SmallRoom> getSmallRoom() {
   return this.smallRoom;
}

public void setSmallRoom(Set<SmallRoom> smallRooms) {
   this.smallRoom = smallRooms;
}

// getterprivate Set<LargeRoom> largeRoom;

@OneToMany(mappedBy="company")
public Set<LargeRoom> getLargeRoom() {
   return this.largeRoom;
}

public void setLargeRoom(Set<LargeRoom> largeRooms) {
   this.largeRoom = largeRooms;
}

// getterprivate Set<Room> room1;

@OneToMany(mappedBy="company1", cascade={CascadeType.ALL})
public Set<Room> getRoom1() {
   return this.room1;
}

public void setRoom1(Set<Room> room1s) {
   this.room1 = room1s;
}

// getterprivate Set<User> user;

@OneToMany(mappedBy="company", cascade={CascadeType.ALL})
public Set<User> getUser() {
   return this.user;
}

public void setUser(Set<User> users) {
   this.user = users;
}

private int companyId;

public void setCompanyId(int value) {
this.companyId = value;
    }
public int getCompanyId() {
return this.companyId;
       }
   }
