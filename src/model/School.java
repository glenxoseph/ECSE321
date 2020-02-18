/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 39 "model.ump"
// line 152 "model.ump"
public class School
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum SchoolType { CEGEP, HighSchool, University }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //School Attributes
  private String name;
  private SchoolType schooltype;

  //School Associations
  private List<Student> students;
  private List<Course> courses;
  private Course c;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public School(String aName, SchoolType aSchooltype, Course aC)
  {
    name = aName;
    schooltype = aSchooltype;
    students = new ArrayList<Student>();
    courses = new ArrayList<Course>();
    if (aC == null || aC.getS() != null)
    {
      throw new RuntimeException("Unable to create School due to aC. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    c = aC;
  }

  public School(String aName, SchoolType aSchooltype, String aNameForC, Subject aSubjectForC, School aSchoolForC)
  {
    name = aName;
    schooltype = aSchooltype;
    students = new ArrayList<Student>();
    courses = new ArrayList<Course>();
    c = new Course(aNameForC, aSubjectForC, this, aSchoolForC);
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

  public boolean setSchooltype(SchoolType aSchooltype)
  {
    boolean wasSet = false;
    schooltype = aSchooltype;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public SchoolType getSchooltype()
  {
    return schooltype;
  }
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
  /* Code from template association_GetOne */
  public Course getC()
  {
    return c;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Student addStudent(String aId, String aPassword, Company aC)
  {
    return new Student(aId, aPassword, aC, this);
  }

  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    School existingSchool = aStudent.getSchool();
    boolean isNewSchool = existingSchool != null && !this.equals(existingSchool);
    if (isNewSchool)
    {
      aStudent.setSchool(this);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(Student aStudent)
  {
    boolean wasRemoved = false;
    //Unable to remove aStudent, as it must always have a school
    if (!this.equals(aStudent.getSchool()))
    {
      students.remove(aStudent);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Course addCourse(String aName, Subject aSubject, School aS)
  {
    return new Course(aName, aSubject, aS, this);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    School existingSchool = aCourse.getSchool();
    boolean isNewSchool = existingSchool != null && !this.equals(existingSchool);
    if (isNewSchool)
    {
      aCourse.setSchool(this);
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
    //Unable to remove aCourse, as it must always have a school
    if (!this.equals(aCourse.getSchool()))
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
    for(int i=students.size(); i > 0; i--)
    {
      Student aStudent = students.get(i - 1);
      aStudent.delete();
    }
    for(int i=courses.size(); i > 0; i--)
    {
      Course aCourse = courses.get(i - 1);
      aCourse.delete();
    }
    Course existingC = c;
    c = null;
    if (existingC != null)
    {
      existingC.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "schooltype" + "=" + (getSchooltype() != null ? !getSchooltype().equals(this)  ? getSchooltype().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "c = "+(getC()!=null?Integer.toHexString(System.identityHashCode(getC())):"null");
  }
}