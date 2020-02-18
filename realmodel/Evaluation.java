
public class Evaluation {
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

// getter/**
 * <pre>
 *           0..*     1..1
 * Evaluation ------------------------- Student
 *           evaluation        &lt;       student
 * </pre>
 */
private Student student;

public void setStudent(Student value) {
   this.student = value;
}

public Student getStudent() {
   return this.student;
}

// getter/**
 * <pre>
 *           0..*     1..1
 * Evaluation ------------------------- Tutor
 *           evaluation        &gt;       tutor
 * </pre>
 */
private Tutor tutor;

public void setTutor(Tutor value) {
   this.tutor = value;
}

public Tutor getTutor() {
   return this.tutor;
}

private int evalId;

public void setEvalId(int value) {
   this.evalId = value;
}

public int getEvalId() {
   return this.evalId;
}

}
