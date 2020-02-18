import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation{
private User sender;
   
   public void setSender(User value) {
this.sender = value;
    }
public User getSender() {
return this.sender;
    }
private int numEval;

public void setNumEval(int value) {
this.numEval = value;
    }
public int getNumEval() {
return this.numEval;
    }
private String litEval;

public void setLitEval(String value) {
this.litEval = value;
    }
public String getLitEval() {
return this.litEval;
    }
// getterprivate Student student;

@ManyToOne(optional=false)
public Student getStudent() {
   return this.student;
}

public void setStudent(Student student) {
   this.student = student;
}

// getterprivate Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private int evalId;

public void setEvalId(int value) {
this.evalId = value;
    }
public int getEvalId() {
return this.evalId;
       }
   }
