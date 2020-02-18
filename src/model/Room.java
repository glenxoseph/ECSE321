/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 72 "model.ump"
// line 176 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private int number;
  private boolean ifFree;

  //Room Associations
  private Company c;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(int aNumber, boolean aIfFree, Company aC)
  {
    number = aNumber;
    ifFree = aIfFree;
    if (aC == null || aC.getR() != null)
    {
      throw new RuntimeException("Unable to create Room due to aC. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    c = aC;
  }

  public Room(int aNumber, boolean aIfFree, String aNameForC, int aOpenTimeForC, int aCloseTimeForC)
  {
    number = aNumber;
    ifFree = aIfFree;
    c = new Company(aNameForC, aOpenTimeForC, aCloseTimeForC, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setIfFree(boolean aIfFree)
  {
    boolean wasSet = false;
    ifFree = aIfFree;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public boolean getIfFree()
  {
    return ifFree;
  }
  /* Code from template association_GetOne */
  public Company getC()
  {
    return c;
  }

  public void delete()
  {
    Company existingC = c;
    c = null;
    if (existingC != null)
    {
      existingC.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "ifFree" + ":" + getIfFree()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "c = "+(getC()!=null?Integer.toHexString(System.identityHashCode(getC())):"null");
  }
}