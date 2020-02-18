/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4699.c01737e00 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 115 "model.ump"
public class Company
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Company Attributes
  private String name;
  private int openTime;
  private int closeTime;

  //Company Associations
  private List<SmallRoom> smallRooms;
  private List<LargeRoom> largeRooms;
  private List<User> s;
  private Room r;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Company(String aName, int aOpenTime, int aCloseTime, Room aR)
  {
    name = aName;
    openTime = aOpenTime;
    closeTime = aCloseTime;
    smallRooms = new ArrayList<SmallRoom>();
    largeRooms = new ArrayList<LargeRoom>();
    s = new ArrayList<User>();
    if (aR == null || aR.getC() != null)
    {
      throw new RuntimeException("Unable to create Company due to aR. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    r = aR;
  }

  public Company(String aName, int aOpenTime, int aCloseTime, int aNumberForR, boolean aIfFreeForR)
  {
    name = aName;
    openTime = aOpenTime;
    closeTime = aCloseTime;
    smallRooms = new ArrayList<SmallRoom>();
    largeRooms = new ArrayList<LargeRoom>();
    s = new ArrayList<User>();
    r = new Room(aNumberForR, aIfFreeForR, this);
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

  public boolean setOpenTime(int aOpenTime)
  {
    boolean wasSet = false;
    openTime = aOpenTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setCloseTime(int aCloseTime)
  {
    boolean wasSet = false;
    closeTime = aCloseTime;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getOpenTime()
  {
    return openTime;
  }

  public int getCloseTime()
  {
    return closeTime;
  }
  /* Code from template association_GetMany */
  public SmallRoom getSmallRoom(int index)
  {
    SmallRoom aSmallRoom = smallRooms.get(index);
    return aSmallRoom;
  }

  public List<SmallRoom> getSmallRooms()
  {
    List<SmallRoom> newSmallRooms = Collections.unmodifiableList(smallRooms);
    return newSmallRooms;
  }

  public int numberOfSmallRooms()
  {
    int number = smallRooms.size();
    return number;
  }

  public boolean hasSmallRooms()
  {
    boolean has = smallRooms.size() > 0;
    return has;
  }

  public int indexOfSmallRoom(SmallRoom aSmallRoom)
  {
    int index = smallRooms.indexOf(aSmallRoom);
    return index;
  }
  /* Code from template association_GetMany */
  public LargeRoom getLargeRoom(int index)
  {
    LargeRoom aLargeRoom = largeRooms.get(index);
    return aLargeRoom;
  }

  public List<LargeRoom> getLargeRooms()
  {
    List<LargeRoom> newLargeRooms = Collections.unmodifiableList(largeRooms);
    return newLargeRooms;
  }

  public int numberOfLargeRooms()
  {
    int number = largeRooms.size();
    return number;
  }

  public boolean hasLargeRooms()
  {
    boolean has = largeRooms.size() > 0;
    return has;
  }

  public int indexOfLargeRoom(LargeRoom aLargeRoom)
  {
    int index = largeRooms.indexOf(aLargeRoom);
    return index;
  }
  /* Code from template association_GetMany */
  public User getS(int index)
  {
    User aS = s.get(index);
    return aS;
  }

  public List<User> getS()
  {
    List<User> newS = Collections.unmodifiableList(s);
    return newS;
  }

  public int numberOfS()
  {
    int number = s.size();
    return number;
  }

  public boolean hasS()
  {
    boolean has = s.size() > 0;
    return has;
  }

  public int indexOfS(User aS)
  {
    int index = s.indexOf(aS);
    return index;
  }
  /* Code from template association_GetOne */
  public Room getR()
  {
    return r;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfSmallRoomsValid()
  {
    boolean isValid = numberOfSmallRooms() >= minimumNumberOfSmallRooms() && numberOfSmallRooms() <= maximumNumberOfSmallRooms();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfSmallRooms()
  {
    return 10;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSmallRooms()
  {
    return 10;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfSmallRooms()
  {
    return 10;
  }
  /* Code from template association_AddMNToOnlyOne */
  public SmallRoom addSmallRoom(int aNumber, boolean aIfFree, Company aC)
  {
    if (numberOfSmallRooms() >= maximumNumberOfSmallRooms())
    {
      return null;
    }
    else
    {
      return new SmallRoom(aNumber, aIfFree, aC, this);
    }
  }

  public boolean addSmallRoom(SmallRoom aSmallRoom)
  {
    boolean wasAdded = false;
    if (smallRooms.contains(aSmallRoom)) { return false; }
    if (numberOfSmallRooms() >= maximumNumberOfSmallRooms())
    {
      return wasAdded;
    }

    Company existingCompany = aSmallRoom.getCompany();
    boolean isNewCompany = existingCompany != null && !this.equals(existingCompany);

    if (isNewCompany && existingCompany.numberOfSmallRooms() <= minimumNumberOfSmallRooms())
    {
      return wasAdded;
    }

    if (isNewCompany)
    {
      aSmallRoom.setCompany(this);
    }
    else
    {
      smallRooms.add(aSmallRoom);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSmallRoom(SmallRoom aSmallRoom)
  {
    boolean wasRemoved = false;
    //Unable to remove aSmallRoom, as it must always have a company
    if (this.equals(aSmallRoom.getCompany()))
    {
      return wasRemoved;
    }

    //company already at minimum (10)
    if (numberOfSmallRooms() <= minimumNumberOfSmallRooms())
    {
      return wasRemoved;
    }
    smallRooms.remove(aSmallRoom);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfLargeRoomsValid()
  {
    boolean isValid = numberOfLargeRooms() >= minimumNumberOfLargeRooms() && numberOfLargeRooms() <= maximumNumberOfLargeRooms();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfLargeRooms()
  {
    return 3;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLargeRooms()
  {
    return 3;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfLargeRooms()
  {
    return 3;
  }
  /* Code from template association_AddMNToOnlyOne */
  public LargeRoom addLargeRoom(int aNumber, boolean aIfFree, Company aC)
  {
    if (numberOfLargeRooms() >= maximumNumberOfLargeRooms())
    {
      return null;
    }
    else
    {
      return new LargeRoom(aNumber, aIfFree, aC, this);
    }
  }

  public boolean addLargeRoom(LargeRoom aLargeRoom)
  {
    boolean wasAdded = false;
    if (largeRooms.contains(aLargeRoom)) { return false; }
    if (numberOfLargeRooms() >= maximumNumberOfLargeRooms())
    {
      return wasAdded;
    }

    Company existingCompany = aLargeRoom.getCompany();
    boolean isNewCompany = existingCompany != null && !this.equals(existingCompany);

    if (isNewCompany && existingCompany.numberOfLargeRooms() <= minimumNumberOfLargeRooms())
    {
      return wasAdded;
    }

    if (isNewCompany)
    {
      aLargeRoom.setCompany(this);
    }
    else
    {
      largeRooms.add(aLargeRoom);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLargeRoom(LargeRoom aLargeRoom)
  {
    boolean wasRemoved = false;
    //Unable to remove aLargeRoom, as it must always have a company
    if (this.equals(aLargeRoom.getCompany()))
    {
      return wasRemoved;
    }

    //company already at minimum (3)
    if (numberOfLargeRooms() <= minimumNumberOfLargeRooms())
    {
      return wasRemoved;
    }
    largeRooms.remove(aLargeRoom);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfS()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addS(String aId, String aPassword)
  {
    return new User(aId, aPassword, this);
  }

  public boolean addS(User aS)
  {
    boolean wasAdded = false;
    if (s.contains(aS)) { return false; }
    Company existingC = aS.getC();
    boolean isNewC = existingC != null && !this.equals(existingC);
    if (isNewC)
    {
      aS.setC(this);
    }
    else
    {
      s.add(aS);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeS(User aS)
  {
    boolean wasRemoved = false;
    //Unable to remove aS, as it must always have a c
    if (!this.equals(aS.getC()))
    {
      s.remove(aS);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSAt(User aS, int index)
  {  
    boolean wasAdded = false;
    if(addS(aS))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfS()) { index = numberOfS() - 1; }
      s.remove(aS);
      s.add(index, aS);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSAt(User aS, int index)
  {
    boolean wasAdded = false;
    if(s.contains(aS))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfS()) { index = numberOfS() - 1; }
      s.remove(aS);
      s.add(index, aS);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSAt(aS, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=smallRooms.size(); i > 0; i--)
    {
      SmallRoom aSmallRoom = smallRooms.get(i - 1);
      aSmallRoom.delete();
    }
    for(int i=largeRooms.size(); i > 0; i--)
    {
      LargeRoom aLargeRoom = largeRooms.get(i - 1);
      aLargeRoom.delete();
    }
    while (s.size() > 0)
    {
      User aS = s.get(s.size() - 1);
      aS.delete();
      s.remove(aS);
    }
    
    Room existingR = r;
    r = null;
    if (existingR != null)
    {
      existingR.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "openTime" + ":" + getOpenTime()+ "," +
            "closeTime" + ":" + getCloseTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "r = "+(getR()!=null?Integer.toHexString(System.identityHashCode(getR())):"null");
  }
}