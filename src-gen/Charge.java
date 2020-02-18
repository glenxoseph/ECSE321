import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Charge{
private int value;
   
   public void setValue(int value) {
this.value = value;
    }
public int getValue() {
return this.value;
    }
// getterprivate Session session;

@ManyToOne(optional=false)
public Session getSession() {
   return this.session;
}

public void setSession(Session session) {
   this.session = session;
}

private int chargeId;

public void setChargeId(int value) {
this.chargeId = value;
    }
public int getChargeId() {
return this.chargeId;
       }
   }
