/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 98 "model.ump"
// line 182 "model.ump"
public class ReviewSession extends Session
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReviewSession Associations
  private List<Student> students;
  private LargeRoom largeRoom;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReviewSession(int aSessionID, int aStartTime, int aEndTime, Course aCourse, Tutor aTutor, Charge aC, LargeRoom aLargeRoom)
  {
    super(aSessionID, aStartTime, aEndTime, aCourse, aTutor, aC);
    students = new ArrayList<Student>();
    boolean didAddLargeRoom = setLargeRoom(aLargeRoom);
    if (!didAddLargeRoom)
    {
      throw new RuntimeException("Unable to create reviewSession due to largeRoom. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Student getStudent(int index)
  {
    Student aStudent = students.get(index);
    return aStudent;
  }

  public List<Student> getStudents()
  {
    List<Student> newStudents = Collections.unmodifiableList(students);
    return newStudents;
  }

  public int numberOfStudents()
  {
    int number = students.size();
    return number;
  }

  public boolean hasStudents()
  {
    boolean has = students.size() > 0;
    return has;
  }

  public int indexOfStudent(Student aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }
  /* Code from template association_GetOne */
  public LargeRoom getLargeRoom()
  {
    return largeRoom;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    students.add(aStudent);
    if (aStudent.indexOfReviewSession(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStudent.addReviewSession(this);
      if (!wasAdded)
      {
        students.remove(aStudent);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStudent(Student aStudent)
  {
    boolean wasRemoved = false;
    if (!students.contains(aStudent))
    {
      return wasRemoved;
    }

    int oldIndex = students.indexOf(aStudent);
    students.remove(oldIndex);
    if (aStudent.indexOfReviewSession(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStudent.removeReviewSession(this);
      if (!wasRemoved)
      {
        students.add(oldIndex,aStudent);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStudentAt(Student aStudent, int index)
  {  
    boolean wasAdded = false;
    if(addStudent(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudentAt(Student aStudent, int index)
  {
    boolean wasAdded = false;
    if(students.contains(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudentAt(aStudent, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setLargeRoom(LargeRoom aLargeRoom)
  {
    boolean wasSet = false;
    if (aLargeRoom == null)
    {
      return wasSet;
    }

    LargeRoom existingLargeRoom = largeRoom;
    largeRoom = aLargeRoom;
    if (existingLargeRoom != null && !existingLargeRoom.equals(aLargeRoom))
    {
      existingLargeRoom.removeReviewSession(this);
    }
    largeRoom.addReviewSession(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Student> copyOfStudents = new ArrayList<Student>(students);
    students.clear();
    for(Student aStudent : copyOfStudents)
    {
      aStudent.removeReviewSession(this);
    }
    LargeRoom placeholderLargeRoom = largeRoom;
    this.largeRoom = null;
    if(placeholderLargeRoom != null)
    {
      placeholderLargeRoom.removeReviewSession(this);
    }
    super.delete();
  }

}