/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 65 "model.ump"
// line 202 "model.ump"
public class Course
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Attributes
  private String name;

  //Course Associations
  private Subject subject;
  private School s;
  private School school;
  private List<Session> sessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course(String aName, Subject aSubject, School aS, School aSchool)
  {
    name = aName;
    boolean didAddSubject = setSubject(aSubject);
    if (!didAddSubject)
    {
      throw new RuntimeException("Unable to create course due to subject. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aS == null || aS.getC() != null)
    {
      throw new RuntimeException("Unable to create Course due to aS. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    s = aS;
    boolean didAddSchool = setSchool(aSchool);
    if (!didAddSchool)
    {
      throw new RuntimeException("Unable to create course due to school. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sessions = new ArrayList<Session>();
  }

  public Course(String aName, Subject aSubject, String aNameForS, SchoolType aSchooltypeForS, School aSchool)
  {
    name = aName;
    boolean didAddSubject = setSubject(aSubject);
    if (!didAddSubject)
    {
      throw new RuntimeException("Unable to create course due to subject. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    s = new School(aNameForS, aSchooltypeForS, this);
    boolean didAddSchool = setSchool(aSchool);
    if (!didAddSchool)
    {
      throw new RuntimeException("Unable to create course due to school. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sessions = new ArrayList<Session>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public Subject getSubject()
  {
    return subject;
  }
  /* Code from template association_GetOne */
  public School getS()
  {
    return s;
  }
  /* Code from template association_GetOne */
  public School getSchool()
  {
    return school;
  }
  /* Code from template association_GetMany */
  public Session getSession(int index)
  {
    Session aSession = sessions.get(index);
    return aSession;
  }

  public List<Session> getSessions()
  {
    List<Session> newSessions = Collections.unmodifiableList(sessions);
    return newSessions;
  }

  public int numberOfSessions()
  {
    int number = sessions.size();
    return number;
  }

  public boolean hasSessions()
  {
    boolean has = sessions.size() > 0;
    return has;
  }

  public int indexOfSession(Session aSession)
  {
    int index = sessions.indexOf(aSession);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSubject(Subject aSubject)
  {
    boolean wasSet = false;
    if (aSubject == null)
    {
      return wasSet;
    }

    Subject existingSubject = subject;
    subject = aSubject;
    if (existingSubject != null && !existingSubject.equals(aSubject))
    {
      existingSubject.removeCourse(this);
    }
    subject.addCourse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSchool(School aSchool)
  {
    boolean wasSet = false;
    if (aSchool == null)
    {
      return wasSet;
    }

    School existingSchool = school;
    school = aSchool;
    if (existingSchool != null && !existingSchool.equals(aSchool))
    {
      existingSchool.removeCourse(this);
    }
    school.addCourse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Session addSession(int aSessionID, int aStartTime, int aEndTime, Tutor aTutor, Charge aC)
  {
    return new Session(aSessionID, aStartTime, aEndTime, this, aTutor, aC);
  }

  public boolean addSession(Session aSession)
  {
    boolean wasAdded = false;
    if (sessions.contains(aSession)) { return false; }
    Course existingCourse = aSession.getCourse();
    boolean isNewCourse = existingCourse != null && !this.equals(existingCourse);
    if (isNewCourse)
    {
      aSession.setCourse(this);
    }
    else
    {
      sessions.add(aSession);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSession(Session aSession)
  {
    boolean wasRemoved = false;
    //Unable to remove aSession, as it must always have a course
    if (!this.equals(aSession.getCourse()))
    {
      sessions.remove(aSession);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSessionAt(Session aSession, int index)
  {  
    boolean wasAdded = false;
    if(addSession(aSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSessions()) { index = numberOfSessions() - 1; }
      sessions.remove(aSession);
      sessions.add(index, aSession);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSessionAt(Session aSession, int index)
  {
    boolean wasAdded = false;
    if(sessions.contains(aSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSessions()) { index = numberOfSessions() - 1; }
      sessions.remove(aSession);
      sessions.add(index, aSession);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSessionAt(aSession, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Subject placeholderSubject = subject;
    this.subject = null;
    if(placeholderSubject != null)
    {
      placeholderSubject.removeCourse(this);
    }
    School existingS = s;
    s = null;
    if (existingS != null)
    {
      existingS.delete();
    }
    School placeholderSchool = school;
    this.school = null;
    if(placeholderSchool != null)
    {
      placeholderSchool.removeCourse(this);
    }
    for(int i=sessions.size(); i > 0; i--)
    {
      Session aSession = sessions.get(i - 1);
      aSession.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "subject = "+(getSubject()!=null?Integer.toHexString(System.identityHashCode(getSubject())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "s = "+(getS()!=null?Integer.toHexString(System.identityHashCode(getS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "school = "+(getSchool()!=null?Integer.toHexString(System.identityHashCode(getSchool())):"null");
  }
}