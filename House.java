/* This is a stub for the House class */
import java.util.ArrayList;

import java.util.Scanner;

public class House extends Building {
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;  
  private boolean hasElevator;

/**
 * Constructor for House Object 
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param hasElevator
 */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator){
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for boolean saying whether or not house has dining room
   * @return whether or not the house has a dining room as boolean
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Accessor for boolean saying whether or not house has elevator
   * @return whether or not the house has an elevator as boolean
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

/**
 * Accessor for number of residents
 * @return size of residents list
 */
  public int nResidents(){
    return this.residents.size();
  }

/**
 * Adds resident to house
 * @param name
 */
  public void moveIn(String name){
    if(this.residents.contains(name) == false){
      this.residents.add(name);
    } else {
      throw new RuntimeException("Resident already lives here!");
    }
  }
  /**
   * Adds you to house
   */
  public void moveIn(){
    System.out.println("You want to move in? Great!");
    if(this.residents.contains("me") == false){
      this.residents.add("me");
      System.out.println("You have moved in! You are saved as 'me'.");
    } else {
      throw new RuntimeException("You already live here!");
    }
  }

  /**
   * removes resident from house
   * @param name
   * @return resident's name
   */
  public String moveOut(String name){ 
    if(this.residents.contains(name)){
      this.residents.remove(name);
      return name;
    } else {
      throw new RuntimeException("Resident not found!");
    }
  }

  /**
   * removes you from house
   */
  public void moveOut(){ 
    System.out.println("You're moving out?! How sad...");
    if(this.residents.contains("me")){
      this.residents.remove("me");
      System.out.println("You've moved out...");
    } else {
      throw new RuntimeException("You don't live here!");
    }
  }

/**
 * Says whether or not person is a resident of house 
 * @param person
 * @return boolean of whether or not person is a resident
 */
  public boolean isResident(String person){
      return this.residents.contains(name);
    } 

/**
 * Show user options
 */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(name) or moveIn()\n + moveOut(name) or moveOut()\n + nResidents() \n + isResident(name)");
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
    if(this.hasElevator == false){
      if (floorNum > this.activeFloor++ || floorNum < this.activeFloor--){
        throw new RuntimeException("This house does not have an elevator, you can only travel to adjecent floors."); 
      }
    } else {
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  }

  public static void main(String[] args) {
    House house = new House("Dani's House", "Address", 3, true, false);
    house.showOptions();
    house.moveIn();
    System.out.println(house.nResidents());
    house.moveOut();
    System.out.println(house.nResidents());
  }
}