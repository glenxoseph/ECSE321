/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 84 "model.ump"
// line 224 "model.ump"
public class LargeRoom extends Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LargeRoom Associations
  private Company company;
  private List<ReviewSession> reviewSessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LargeRoom(int aNumber, boolean aIfFree, Company aC, Company aCompany)
  {
    super(aNumber, aIfFree, aC);
    boolean didAddCompany = setCompany(aCompany);
    if (!didAddCompany)
    {
      throw new RuntimeException("Unable to create largeRoom due to company. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    reviewSessions = new ArrayList<ReviewSession>();
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
  public ReviewSession getReviewSession(int index)
  {
    ReviewSession aReviewSession = reviewSessions.get(index);
    return aReviewSession;
  }

  public List<ReviewSession> getReviewSessions()
  {
    List<ReviewSession> newReviewSessions = Collections.unmodifiableList(reviewSessions);
    return newReviewSessions;
  }

  public int numberOfReviewSessions()
  {
    int number = reviewSessions.size();
    return number;
  }

  public boolean hasReviewSessions()
  {
    boolean has = reviewSessions.size() > 0;
    return has;
  }

  public int indexOfReviewSession(ReviewSession aReviewSession)
  {
    int index = reviewSessions.indexOf(aReviewSession);
    return index;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setCompany(Company aCompany)
  {
    boolean wasSet = false;
    //Must provide company to largeRoom
    if (aCompany == null)
    {
      return wasSet;
    }

    //company already at maximum (3)
    if (aCompany.numberOfLargeRooms() >= Company.maximumNumberOfLargeRooms())
    {
      return wasSet;
    }
    
    Company existingCompany = company;
    company = aCompany;
    if (existingCompany != null && !existingCompany.equals(aCompany))
    {
      boolean didRemove = existingCompany.removeLargeRoom(this);
      if (!didRemove)
      {
        company = existingCompany;
        return wasSet;
      }
    }
    company.addLargeRoom(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReviewSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ReviewSession addReviewSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC)
  {
    return new ReviewSession(aSessionID, aStartTime, aEndTime, aCourse, aTutor, aC, this);
  }

  public boolean addReviewSession(ReviewSession aReviewSession)
  {
    boolean wasAdded = false;
    if (reviewSessions.contains(aReviewSession)) { return false; }
    LargeRoom existingLargeRoom = aReviewSession.getLargeRoom();
    boolean isNewLargeRoom = existingLargeRoom != null && !this.equals(existingLargeRoom);
    if (isNewLargeRoom)
    {
      aReviewSession.setLargeRoom(this);
    }
    else
    {
      reviewSessions.add(aReviewSession);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReviewSession(ReviewSession aReviewSession)
  {
    boolean wasRemoved = false;
    //Unable to remove aReviewSession, as it must always have a largeRoom
    if (!this.equals(aReviewSession.getLargeRoom()))
    {
      reviewSessions.remove(aReviewSession);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReviewSessionAt(ReviewSession aReviewSession, int index)
  {  
    boolean wasAdded = false;
    if(addReviewSession(aReviewSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReviewSessions()) { index = numberOfReviewSessions() - 1; }
      reviewSessions.remove(aReviewSession);
      reviewSessions.add(index, aReviewSession);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReviewSessionAt(ReviewSession aReviewSession, int index)
  {
    boolean wasAdded = false;
    if(reviewSessions.contains(aReviewSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReviewSessions()) { index = numberOfReviewSessions() - 1; }
      reviewSessions.remove(aReviewSession);
      reviewSessions.add(index, aReviewSession);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReviewSessionAt(aReviewSession, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Company placeholderCompany = company;
    this.company = null;
    if(placeholderCompany != null)
    {
      placeholderCompany.removeLargeRoom(this);
    }
    for(int i=reviewSessions.size(); i > 0; i--)
    {
      ReviewSession aReviewSession = reviewSessions.get(i - 1);
      aReviewSession.delete();
    }
    super.delete();
  }

}