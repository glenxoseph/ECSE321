/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 17 "model.ump"
// line 133 "model.ump"
public class Evaluation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Evaluation Attributes
  private User sender;
  private User receiver;
  private float numEval;
  private String litEval;

  //Evaluation Associations
  private Student student;
  private Tutor tutor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Evaluation(User aSender, User aReceiver, float aNumEval, String aLitEval, Student aStudent, Tutor aTutor)
  {
    sender = aSender;
    receiver = aReceiver;
    numEval = aNumEval;
    litEval = aLitEval;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create evaluation due to student. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTutor = setTutor(aTutor);
    if (!didAddTutor)
    {
      throw new RuntimeException("Unable to create evaluation due to tutor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSender(User aSender)
  {
    boolean wasSet = false;
    sender = aSender;
    wasSet = true;
    return wasSet;
  }

  public boolean setReceiver(User aReceiver)
  {
    boolean wasSet = false;
    receiver = aReceiver;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumEval(float aNumEval)
  {
    boolean wasSet = false;
    numEval = aNumEval;
    wasSet = true;
    return wasSet;
  }

  public boolean setLitEval(String aLitEval)
  {
    boolean wasSet = false;
    litEval = aLitEval;
    wasSet = true;
    return wasSet;
  }

  public User getSender()
  {
    return sender;
  }

  public User getReceiver()
  {
    return receiver;
  }

  public float getNumEval()
  {
    return numEval;
  }

  public String getLitEval()
  {
    return litEval;
  }
  /* Code from template association_GetOne */
  public Student getStudent()
  {
    return student;
  }
  /* Code from template association_GetOne */
  public Tutor getTutor()
  {
    return tutor;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStudent(Student aStudent)
  {
    boolean wasSet = false;
    if (aStudent == null)
    {
      return wasSet;
    }

    Student existingStudent = student;
    student = aStudent;
    if (existingStudent != null && !existingStudent.equals(aStudent))
    {
      existingStudent.removeEvaluation(this);
    }
    student.addEvaluation(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTutor(Tutor aTutor)
  {
    boolean wasSet = false;
    if (aTutor == null)
    {
      return wasSet;
    }

    Tutor existingTutor = tutor;
    tutor = aTutor;
    if (existingTutor != null && !existingTutor.equals(aTutor))
    {
      existingTutor.removeEvaluation(this);
    }
    tutor.addEvaluation(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Student placeholderStudent = student;
    this.student = null;
    if(placeholderStudent != null)
    {
      placeholderStudent.removeEvaluation(this);
    }
    Tutor placeholderTutor = tutor;
    this.tutor = null;
    if(placeholderTutor != null)
    {
      placeholderTutor.removeEvaluation(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "numEval" + ":" + getNumEval()+ "," +
            "litEval" + ":" + getLitEval()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sender" + "=" + (getSender() != null ? !getSender().equals(this)  ? getSender().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "receiver" + "=" + (getReceiver() != null ? !getReceiver().equals(this)  ? getReceiver().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tutor = "+(getTutor()!=null?Integer.toHexString(System.identityHashCode(getTutor())):"null");
  }
}