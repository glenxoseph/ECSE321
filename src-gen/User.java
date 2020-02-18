import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User{
private String userName;
   
   public void setUserName(String value) {
this.userName = value;
    }
public String getUserName() {
return this.userName;
    }
private String password;

public void setPassword(String value) {
this.password = value;
    }
public String getPassword() {
return this.password;
    }
// getterprivate Company company;

@ManyToOne(optional=false)
public Company getCompany() {
   return this.company;
}

public void setCompany(Company company) {
   this.company = company;
}

private int userId;

public void setUserId(int value) {
this.userId = value;
    }
public int getUserId() {
return this.userId;
       }
   }
