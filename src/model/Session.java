/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 89 "model.ump"
// line 209 "model.ump"
public class Session
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Session Attributes
  private int sessionID;
  private int startTime;
  private int endTime;

  //Session Associations
  private Course course;
  private Tutor tutor;
  private Charge c;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Session(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC)
  {
    sessionID = aSessionID;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create session due to course. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTutor = setTutor(aTutor);
    if (!didAddTutor)
    {
      throw new RuntimeException("Unable to create session due to tutor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aC == null || aC.getS() != null)
    {
      throw new RuntimeException("Unable to create Session due to aC. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    c = aC;
  }

  public Session(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, int aValueForC)
  {
    sessionID = aSessionID;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create session due to course. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTutor = setTutor(aTutor);
    if (!didAddTutor)
    {
      throw new RuntimeException("Unable to create session due to tutor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    c = new Charge(aValueForC, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSessionID(int aSessionID)
  {
    boolean wasSet = false;
    sessionID = aSessionID;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(int aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(int aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public int getSessionID()
  {
    return sessionID;
  }

  public int getStartTime()
  {
    return startTime;
  }

  public int getEndTime()
  {
    return endTime;
  }
  /* Code from template association_GetOne */
  public Course getCourse()
  {
    return course;
  }
  /* Code from template association_GetOne */
  public Tutor getTutor()
  {
    return tutor;
  }
  /* Code from template association_GetOne */
  public Charge getC()
  {
    return c;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    if (aCourse == null)
    {
      return wasSet;
    }

    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeSession(this);
    }
    course.addSession(this);
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
      existingTutor.removeSession(this);
    }
    tutor.addSession(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Course placeholderCourse = course;
    this.course = null;
    if(placeholderCourse != null)
    {
      placeholderCourse.removeSession(this);
    }
    Tutor placeholderTutor = tutor;
    this.tutor = null;
    if(placeholderTutor != null)
    {
      placeholderTutor.removeSession(this);
    }
    Charge existingC = c;
    c = null;
    if (existingC != null)
    {
      existingC.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "sessionID" + ":" + getSessionID()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tutor = "+(getTutor()!=null?Integer.toHexString(System.identityHashCode(getTutor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "c = "+(getC()!=null?Integer.toHexString(System.identityHashCode(getC())):"null");
  }
}