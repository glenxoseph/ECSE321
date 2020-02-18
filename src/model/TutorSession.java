/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 105 "model.ump"
// line 192 "model.ump"
public class TutorSession extends Session
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TutorSession Associations
  private Student student;
  private SmallRoom smallRoom;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TutorSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC, Student aStudent, SmallRoom aSmallRoom)
  {
    super(aSessionID, aStartTime, aEndTime, aCourse, aTutor, aC);
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create tutorSession due to student. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddSmallRoom = setSmallRoom(aSmallRoom);
    if (!didAddSmallRoom)
    {
      throw new RuntimeException("Unable to create tutorSession due to smallRoom. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Student getStudent()
  {
    return student;
  }
  /* Code from template association_GetOne */
  public SmallRoom getSmallRoom()
  {
    return smallRoom;
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
      existingStudent.removeTutorSession(this);
    }
    student.addTutorSession(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSmallRoom(SmallRoom aSmallRoom)
  {
    boolean wasSet = false;
    if (aSmallRoom == null)
    {
      return wasSet;
    }

    SmallRoom existingSmallRoom = smallRoom;
    smallRoom = aSmallRoom;
    if (existingSmallRoom != null && !existingSmallRoom.equals(aSmallRoom))
    {
      existingSmallRoom.removeTutorSession(this);
    }
    smallRoom.addTutorSession(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Student placeholderStudent = student;
    this.student = null;
    if(placeholderStudent != null)
    {
      placeholderStudent.removeTutorSession(this);
    }
    SmallRoom placeholderSmallRoom = smallRoom;
    this.smallRoom = null;
    if(placeholderSmallRoom != null)
    {
      placeholderSmallRoom.removeTutorSession(this);
    }
    super.delete();
  }

}