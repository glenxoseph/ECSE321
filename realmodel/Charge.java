
public class Charge {
private int value;

public void setValue(int value) {
   this.value = value;
}

public int getValue() {
   return this.value;
}

// getter
/**
 * <pre>
 *           0..*     1..1
 * Charge ------------------------- Session
 *           charge        &lt;       session
 * </pre>
 */
private Session session;

public void setSession(Session value) {
   this.session = value;
}

public Session getSession() {
   return this.session;
}

private int chargeId;

public void setChargeId(int value) {
   this.chargeId = value;
}

public int getChargeId() {
   return this.chargeId;
}

}
