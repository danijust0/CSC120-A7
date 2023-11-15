/* This is a stub for the Library class */
import java.rmi.dgc.VMID;
import java.util.Hashtable;

public class Library extends Building  {
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

/**
 * Constructor for Library Object
 * @param name
 * @param address
 * @param nFloors
 */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

  /**
   * Accessor for boolean saying whether or not house has elevator
   * @return whether or not the house has an elevator as boolean
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

/**
 * Adds Book to Library Collection Hasthable
 * @param title
 */
  public void addTitle(String title){
    if(this.collection.contains(title)){
      throw new RuntimeException("This book already exists in the system!");
    } else {
      this.collection.put(title, true);
    }
  }

/**
 * Adds Book to Library Collection Hasthable with unknown title
 * @param title
 */
public void addTitle(){
    this.collection.put("UNKNOWN by UNKNOWN", true);
  }
  
/**
 * Removes books from library collection hashtable
 * @param title
 * @return title fo book removes
 */
  public String removeTitle(String title){
    if(!this.collection.contains(title)){
      throw new RuntimeException("This book does not exist in the system!");
    } else {
      this.collection.remove(title, true);
      return title;
    }
  }

  /**
   * changes book value to false
   * @param title
   */
  public void checkOut(String title){
    if(!this.collection.get(title)){
      throw new RuntimeException("This book is not in the system!");
  } else {
    this.collection.replace(title, false);
  }
}
/**
 * Changes book value to true 
 * @param title
 */
  public void returnBook(String title){
    if(this.collection.get(title)){
      throw new RuntimeException("This book has already been returned!");
  } else {
    this.collection.replace(title, true);
    }
  }

/**
 * Says whether or not book is in collection
 * @param title
 * @return boolean representing book's status 
 */
  public boolean containsTitle(String title){
     return this.collection.contains(title);
  }

 /**
  * Says whether or not book is available to borrow
  * @param title
  * @return boolean representing book status
  */
  public boolean isAvailable(String title){
    return this.collection.get(title);
  }

/**
 * Print's titles in library collection 
 */
  public void printCollection(){
    System.out.println(collection.keySet());
    }

/**
 * Print's titles in library collection. Option to print with book availabilities.
 */
  public void printCollection(boolean with_status){
    if (with_status){
      System.out.println(collection.toString());
    } else {
      System.out.println(collection.keySet());
      }
  }

/**
 * Show user options
 */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection() or printCollection(true or false))");
  }

  /** Let user move between floors
   * @param floorNum
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (floorNum > this.activeFloor++ || floorNum < this.activeFloor--){
      throw new RuntimeException("This library does not have an elevator, you can only travel to adjecent floors.");
    } else {
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
    }
  }


  public static void main(String[] args) {
    Library myLib = new Library("libby","adress",5,true);
    myLib.addTitle("Book by Author");
    myLib.addTitle("Another Book by Another Author");
    myLib.printCollection();

  }
  
}