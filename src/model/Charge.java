/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 11 "model.ump"
// line 124 "model.ump"
public class Charge
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Charge Attributes
  private int value;

  //Charge Associations
  private Session s;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Charge(int aValue, Session aS)
  {
    value = aValue;
    if (aS == null || aS.getC() != null)
    {
      throw new RuntimeException("Unable to create Charge due to aS. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    s = aS;
  }

  public Charge(int aValue, int aSessionIDForS, int aStartTimeForS, int aEndTimeForS, Course aCourseForS, Tutor aTutorForS)
  {
    value = aValue;
    s = new Session(aSessionIDForS, aStartTimeForS, aEndTimeForS, aCourseForS, aTutorForS, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValue(int aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public int getValue()
  {
    return value;
  }
  /* Code from template association_GetOne */
  public Session getS()
  {
    return s;
  }

  public void delete()
  {
    Session existingS = s;
    s = null;
    if (existingS != null)
    {
      existingS.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "value" + ":" + getValue()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "s = "+(getS()!=null?Integer.toHexString(System.identityHashCode(getS())):"null");
  }
}