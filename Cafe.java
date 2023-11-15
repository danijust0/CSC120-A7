

/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

/**
 * Constructor for Cafe Object
 * @param name
 * @param address
 * @param nFloors
 * @param nCoffeeOunces
 * @param nSugarPackets
 * @param nCreams
 * @param nCups
 */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");

    }

    /**
     * Sells a coffee with specified size, sugar, and cream. Removes appropriate number of materials used
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
    if (this.nCoffeeOunces - size <= 0 || this.nSugarPackets - nSugarPackets <= 0 || this.nCreams - nCreams <= 0 || this.nCups - 1 <= 0) {
        throw new RuntimeException("insufficient materials");
    } else {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        }
    }
    /**
     * Sells a coffee with specified size, default sugar, and default cream. Removes appropriate number of materials used
     * @param size
     */
    public void sellCoffee(int size){
        if (this.nCoffeeOunces - size <= 0 || this.nCups - 1 <= 0) {
            throw new RuntimeException("insufficient materials");
        } else {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= 2;
            this.nCreams -= 1;
            this.nCups -= 1;
        }
    }


/**
 * Restocks materials in specific quantities
 * @param nCoffeeOunces
 * @param nSugarPackets
 * @param nCreams
 * @param nCups
 */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += 1;
    }

/**
 * Restocks materials in default quantities
 */
    private void restock(){
        this.nCoffeeOunces += 20;
        this.nSugarPackets += 20;
        this.nCreams += 20;
        this.nCups += 10;
        System.out.println("Restocking default quantities...");
        System.out.println("Coffee: " + this.nCoffeeOunces + " oz.\nSugar Packets: " + this.nSugarPackets + "\nCreams: " + this.nCreams +"\nCups: " + this.nCups);
        System.out.println("done!");
    }

/**
 * Show user options
 */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(size, nSugars, nCreams) or sellCoffee() \n + restock(nOunces, nSugars, nCreams, nCups) or restock()");
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
            throw new RuntimeException("This building does not have an elevator, you can only travel to adjecent floors using the STAIRS."); 
    } else {
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
  }

  public static void main(String[] args) {
    Cafe cafe = new Cafe("cafe","address", 5,0,0, 0,0);
    cafe.showOptions();
  }


}
