/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 79 "model.ump"
// line 219 "model.ump"
public class SmallRoom extends Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SmallRoom Associations
  private Company company;
  private List<TutorSession> tutorSessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SmallRoom(int aNumber, boolean aIfFree, Company aC, Company aCompany)
  {
    super(aNumber, aIfFree, aC);
    boolean didAddCompany = setCompany(aCompany);
    if (!didAddCompany)
    {
      throw new RuntimeException("Unable to create smallRoom due to company. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    tutorSessions = new ArrayList<TutorSession>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Company getCompany()
  {
    return company;
  }
  /* Code from template association_GetMany */
  public TutorSession getTutorSession(int index)
  {
    TutorSession aTutorSession = tutorSessions.get(index);
    return aTutorSession;
  }

  public List<TutorSession> getTutorSessions()
  {
    List<TutorSession> newTutorSessions = Collections.unmodifiableList(tutorSessions);
    return newTutorSessions;
  }

  public int numberOfTutorSessions()
  {
    int number = tutorSessions.size();
    return number;
  }

  public boolean hasTutorSessions()
  {
    boolean has = tutorSessions.size() > 0;
    return has;
  }

  public int indexOfTutorSession(TutorSession aTutorSession)
  {
    int index = tutorSessions.indexOf(aTutorSession);
    return index;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setCompany(Company aCompany)
  {
    boolean wasSet = false;
    //Must provide company to smallRoom
    if (aCompany == null)
    {
      return wasSet;
    }

    //company already at maximum (10)
    if (aCompany.numberOfSmallRooms() >= Company.maximumNumberOfSmallRooms())
    {
      return wasSet;
    }
    
    Company existingCompany = company;
    company = aCompany;
    if (existingCompany != null && !existingCompany.equals(aCompany))
    {
      boolean didRemove = existingCompany.removeSmallRoom(this);
      if (!didRemove)
      {
        company = existingCompany;
        return wasSet;
      }
    }
    company.addSmallRoom(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTutorSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TutorSession addTutorSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC, Student aStudent)
  {
    return new TutorSession(aSessionID, aStartTime, aEndTime, aCourse, aTutor, aC, aStudent, this);
  }

  public boolean addTutorSession(TutorSession aTutorSession)
  {
    boolean wasAdded = false;
    if (tutorSessions.contains(aTutorSession)) { return false; }
    SmallRoom existingSmallRoom = aTutorSession.getSmallRoom();
    boolean isNewSmallRoom = existingSmallRoom != null && !this.equals(existingSmallRoom);
    if (isNewSmallRoom)
    {
      aTutorSession.setSmallRoom(this);
    }
    else
    {
      tutorSessions.add(aTutorSession);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTutorSession(TutorSession aTutorSession)
  {
    boolean wasRemoved = false;
    //Unable to remove aTutorSession, as it must always have a smallRoom
    if (!this.equals(aTutorSession.getSmallRoom()))
    {
      tutorSessions.remove(aTutorSession);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTutorSessionAt(TutorSession aTutorSession, int index)
  {  
    boolean wasAdded = false;
    if(addTutorSession(aTutorSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTutorSessions()) { index = numberOfTutorSessions() - 1; }
      tutorSessions.remove(aTutorSession);
      tutorSessions.add(index, aTutorSession);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTutorSessionAt(TutorSession aTutorSession, int index)
  {
    boolean wasAdded = false;
    if(tutorSessions.contains(aTutorSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTutorSessions()) { index = numberOfTutorSessions() - 1; }
      tutorSessions.remove(aTutorSession);
      tutorSessions.add(index, aTutorSession);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTutorSessionAt(aTutorSession, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Company placeholderCompany = company;
    this.company = null;
    if(placeholderCompany != null)
    {
      placeholderCompany.removeSmallRoom(this);
    }
    for(int i=tutorSessions.size(); i > 0; i--)
    {
      TutorSession aTutorSession = tutorSessions.get(i - 1);
      aTutorSession.delete();
    }
    super.delete();
  }

}