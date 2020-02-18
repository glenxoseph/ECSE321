/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 59 "model.ump"
// line 170 "model.ump"
public class Subject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Subject Attributes
  private String name;

  //Subject Associations
  private List<Tutor> tutors;
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Subject(String aName)
  {
    name = aName;
    tutors = new ArrayList<Tutor>();
    courses = new ArrayList<Course>();
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
  /* Code from template association_GetMany */
  public Tutor getTutor(int index)
  {
    Tutor aTutor = tutors.get(index);
    return aTutor;
  }

  public List<Tutor> getTutors()
  {
    List<Tutor> newTutors = Collections.unmodifiableList(tutors);
    return newTutors;
  }

  public int numberOfTutors()
  {
    int number = tutors.size();
    return number;
  }

  public boolean hasTutors()
  {
    boolean has = tutors.size() > 0;
    return has;
  }

  public int indexOfTutor(Tutor aTutor)
  {
    int index = tutors.indexOf(aTutor);
    return index;
  }
  /* Code from template association_GetMany */
  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTutors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Tutor addTutor(String aId, String aPassword, Company aC)
  {
    return new Tutor(aId, aPassword, aC, this);
  }

  public boolean addTutor(Tutor aTutor)
  {
    boolean wasAdded = false;
    if (tutors.contains(aTutor)) { return false; }
    Subject existingSubject = aTutor.getSubject();
    boolean isNewSubject = existingSubject != null && !this.equals(existingSubject);
    if (isNewSubject)
    {
      aTutor.setSubject(this);
    }
    else
    {
      tutors.add(aTutor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTutor(Tutor aTutor)
  {
    boolean wasRemoved = false;
    //Unable to remove aTutor, as it must always have a subject
    if (!this.equals(aTutor.getSubject()))
    {
      tutors.remove(aTutor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTutorAt(Tutor aTutor, int index)
  {  
    boolean wasAdded = false;
    if(addTutor(aTutor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTutors()) { index = numberOfTutors() - 1; }
      tutors.remove(aTutor);
      tutors.add(index, aTutor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTutorAt(Tutor aTutor, int index)
  {
    boolean wasAdded = false;
    if(tutors.contains(aTutor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTutors()) { index = numberOfTutors() - 1; }
      tutors.remove(aTutor);
      tutors.add(index, aTutor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTutorAt(aTutor, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Course addCourse(String aName, School aS, School aSchool)
  {
    return new Course(aName, this, aS, aSchool);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    Subject existingSubject = aCourse.getSubject();
    boolean isNewSubject = existingSubject != null && !this.equals(existingSubject);
    if (isNewSubject)
    {
      aCourse.setSubject(this);
    }
    else
    {
      courses.add(aCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a subject
    if (!this.equals(aCourse.getSubject()))
    {
      courses.remove(aCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCourseAt(Course aCourse, int index)
  {  
    boolean wasAdded = false;
    if(addCourse(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(courses.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=tutors.size(); i > 0; i--)
    {
      Tutor aTutor = tutors.get(i - 1);
      aTutor.delete();
    }
    for(int i=courses.size(); i > 0; i--)
    {
      Course aCourse = courses.get(i - 1);
      aCourse.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}