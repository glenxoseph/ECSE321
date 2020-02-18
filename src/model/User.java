/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/



// line 27 "model.ump"
// line 140 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String id;
  private String password;

  //User Associations
  private Company c;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aId, String aPassword, Company aC)
  {
    id = aId;
    password = aPassword;
    boolean didAddC = setC(aC);
    if (!didAddC)
    {
      throw new RuntimeException("Unable to create s due to c. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public Company getC()
  {
    return c;
  }
  /* Code from template association_SetOneToMany */
  public boolean setC(Company aC)
  {
    boolean wasSet = false;
    if (aC == null)
    {
      return wasSet;
    }

    Company existingC = c;
    c = aC;
    if (existingC != null && !existingC.equals(aC))
    {
      existingC.removeS(this);
    }
    c.addS(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Company placeholderC = c;
    this.c = null;
    if(placeholderC != null)
    {
      placeholderC.removeS(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "c = "+(getC()!=null?Integer.toHexString(System.identityHashCode(getC())):"null");
  }
}