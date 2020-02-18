/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 54 "model.ump"
// line 165 "model.ump"
public class Tutor extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tutor Associations
  private List<Evaluation> evaluations;
  private Subject subject;
  private List<Session> sessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tutor(String aId, String aPassword, Company aC, Subject aSubject)
  {
    super(aId, aPassword, aC);
    evaluations = new ArrayList<Evaluation>();
    boolean didAddSubject = setSubject(aSubject);
    if (!didAddSubject)
    {
      throw new RuntimeException("Unable to create tutor due to subject. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sessions = new ArrayList<Session>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Evaluation getEvaluation(int index)
  {
    Evaluation aEvaluation = evaluations.get(index);
    return aEvaluation;
  }

  public List<Evaluation> getEvaluations()
  {
    List<Evaluation> newEvaluations = Collections.unmodifiableList(evaluations);
    return newEvaluations;
  }

  public int numberOfEvaluations()
  {
    int number = evaluations.size();
    return number;
  }

  public boolean hasEvaluations()
  {
    boolean has = evaluations.size() > 0;
    return has;
  }

  public int indexOfEvaluation(Evaluation aEvaluation)
  {
    int index = evaluations.indexOf(aEvaluation);
    return index;
  }
  /* Code from template association_GetOne */
  public Subject getSubject()
  {
    return subject;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEvaluations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Evaluation addEvaluation(User aSender, User aReceiver, float aNumEval, String aLitEval, Student aStudent)
  {
    return new Evaluation(aSender, aReceiver, aNumEval, aLitEval, aStudent, this);
  }

  public boolean addEvaluation(Evaluation aEvaluation)
  {
    boolean wasAdded = false;
    if (evaluations.contains(aEvaluation)) { return false; }
    Tutor existingTutor = aEvaluation.getTutor();
    boolean isNewTutor = existingTutor != null && !this.equals(existingTutor);
    if (isNewTutor)
    {
      aEvaluation.setTutor(this);
    }
    else
    {
      evaluations.add(aEvaluation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEvaluation(Evaluation aEvaluation)
  {
    boolean wasRemoved = false;
    //Unable to remove aEvaluation, as it must always have a tutor
    if (!this.equals(aEvaluation.getTutor()))
    {
      evaluations.remove(aEvaluation);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEvaluationAt(Evaluation aEvaluation, int index)
  {  
    boolean wasAdded = false;
    if(addEvaluation(aEvaluation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvaluations()) { index = numberOfEvaluations() - 1; }
      evaluations.remove(aEvaluation);
      evaluations.add(index, aEvaluation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEvaluationAt(Evaluation aEvaluation, int index)
  {
    boolean wasAdded = false;
    if(evaluations.contains(aEvaluation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvaluations()) { index = numberOfEvaluations() - 1; }
      evaluations.remove(aEvaluation);
      evaluations.add(index, aEvaluation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEvaluationAt(aEvaluation, index);
    }
    return wasAdded;
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
      existingSubject.removeTutor(this);
    }
    subject.addTutor(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Session addSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Charge aC)
  {
    return new Session(aSessionID, aStartTime, aEndTime, aCourse, this, aC);
  }

  public boolean addSession(Session aSession)
  {
    boolean wasAdded = false;
    if (sessions.contains(aSession)) { return false; }
    Tutor existingTutor = aSession.getTutor();
    boolean isNewTutor = existingTutor != null && !this.equals(existingTutor);
    if (isNewTutor)
    {
      aSession.setTutor(this);
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
    //Unable to remove aSession, as it must always have a tutor
    if (!this.equals(aSession.getTutor()))
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
    for(int i=evaluations.size(); i > 0; i--)
    {
      Evaluation aEvaluation = evaluations.get(i - 1);
      aEvaluation.delete();
    }
    Subject placeholderSubject = subject;
    this.subject = null;
    if(placeholderSubject != null)
    {
      placeholderSubject.removeTutor(this);
    }
    for(int i=sessions.size(); i > 0; i--)
    {
      Session aSession = sessions.get(i - 1);
      aSession.delete();
    }
    super.delete();
  }

}