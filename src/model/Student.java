/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 49 "model.ump"
// line 160 "model.ump"
public class Student extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Associations
  private List<Evaluation> evaluations;
  private School school;
  private List<ReviewSession> reviewSessions;
  private List<TutorSession> tutorSessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aId, String aPassword, Company aC, School aSchool)
  {
    super(aId, aPassword, aC);
    evaluations = new ArrayList<Evaluation>();
    boolean didAddSchool = setSchool(aSchool);
    if (!didAddSchool)
    {
      throw new RuntimeException("Unable to create student due to school. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    reviewSessions = new ArrayList<ReviewSession>();
    tutorSessions = new ArrayList<TutorSession>();
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
  public School getSchool()
  {
    return school;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEvaluations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Evaluation addEvaluation(User aSender, User aReceiver, float aNumEval, String aLitEval, Tutor aTutor)
  {
    return new Evaluation(aSender, aReceiver, aNumEval, aLitEval, this, aTutor);
  }

  public boolean addEvaluation(Evaluation aEvaluation)
  {
    boolean wasAdded = false;
    if (evaluations.contains(aEvaluation)) { return false; }
    Student existingStudent = aEvaluation.getStudent();
    boolean isNewStudent = existingStudent != null && !this.equals(existingStudent);
    if (isNewStudent)
    {
      aEvaluation.setStudent(this);
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
    //Unable to remove aEvaluation, as it must always have a student
    if (!this.equals(aEvaluation.getStudent()))
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
      existingSchool.removeStudent(this);
    }
    school.addStudent(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReviewSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addReviewSession(ReviewSession aReviewSession)
  {
    boolean wasAdded = false;
    if (reviewSessions.contains(aReviewSession)) { return false; }
    reviewSessions.add(aReviewSession);
    if (aReviewSession.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aReviewSession.addStudent(this);
      if (!wasAdded)
      {
        reviewSessions.remove(aReviewSession);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeReviewSession(ReviewSession aReviewSession)
  {
    boolean wasRemoved = false;
    if (!reviewSessions.contains(aReviewSession))
    {
      return wasRemoved;
    }

    int oldIndex = reviewSessions.indexOf(aReviewSession);
    reviewSessions.remove(oldIndex);
    if (aReviewSession.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aReviewSession.removeStudent(this);
      if (!wasRemoved)
      {
        reviewSessions.add(oldIndex,aReviewSession);
      }
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTutorSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TutorSession addTutorSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC, SmallRoom aSmallRoom)
  {
    return new TutorSession(aSessionID, aStartTime, aEndTime, aCourse, aTutor, aC, this, aSmallRoom);
  }

  public boolean addTutorSession(TutorSession aTutorSession)
  {
    boolean wasAdded = false;
    if (tutorSessions.contains(aTutorSession)) { return false; }
    Student existingStudent = aTutorSession.getStudent();
    boolean isNewStudent = existingStudent != null && !this.equals(existingStudent);
    if (isNewStudent)
    {
      aTutorSession.setStudent(this);
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
    //Unable to remove aTutorSession, as it must always have a student
    if (!this.equals(aTutorSession.getStudent()))
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
    for(int i=evaluations.size(); i > 0; i--)
    {
      Evaluation aEvaluation = evaluations.get(i - 1);
      aEvaluation.delete();
    }
    School placeholderSchool = school;
    this.school = null;
    if(placeholderSchool != null)
    {
      placeholderSchool.removeStudent(this);
    }
    ArrayList<ReviewSession> copyOfReviewSessions = new ArrayList<ReviewSession>(reviewSessions);
    reviewSessions.clear();
    for(ReviewSession aReviewSession : copyOfReviewSessions)
    {
      aReviewSession.removeStudent(this);
    }
    for(int i=tutorSessions.size(); i > 0; i--)
    {
      TutorSession aTutorSession = tutorSessions.get(i - 1);
      aTutorSession.delete();
    }
    super.delete();
  }

}