package FunctionnalCore;

import java.util.ArrayList;

/**
 * Inventory Class
 * Allows managing a list of item and have a size
 * @author Paul
 */
public class Inventory {

    private ArrayList<Item> inventory;
    private int size;

    /**
     * Constructor of Inventory class
     * The arrayList is empty by default
     * @param size : the max size of inventory
     */
    public Inventory(int size) {
        this.size = size;
        this.inventory = new ArrayList<>();
    }
    
    /**
     * Getter of ArrayList of item
     * @return : the list off all items contain into the inventory of player
     */
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }
    
    /**
     * Getter of inventory max size
     * @return : the max size of inventory
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter of max size of inventory
     * @param size : the new max size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Function which allows return the number of item into the inventory
     * @return : the number of item into the inventory
     */
    public int getLengthInv() {
        return this.inventory.size();
    }

    /**
     * Allows calculating the total weight of all item in the inventory
     * @return the total weight of all item
     */
    public int getTotalOccupedSize(){
        int totalWeight = 0;
        for (Item item : inventory) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    /**
     * Allows adding a new item in the inventory
     * Constrainte : it is possible to add a new object only if the max size is not reached
     * @param i : an item given
     */
    public void addObject(Item i) {
        if (getLengthInv() != size) {
            this.inventory.add(i);
        }
    }

    /**
     * Allows delete a given object from the inventory
     * The loop will be exited when the item will be deleted
     * @param i : the given item object
     */
    public void deleteObject(Item i) {
        for (int j = 0; j < getLengthInv(); j++) {
            if (this.inventory.get(j).equals(i)) {
                this.inventory.remove(j);
                break;
            }
        }
    }

    /**
     * Function checkInv : allows check if an item exists or not in the inventory
     * @param itemResearch : a given item
     * @return True if the object is into the inventory and False if not
     */
    public boolean checkInv(Item itemResearch) {
        for (int j = 0; j < getLengthInv(); j++) {
            if (this.inventory.get(j).equals(itemResearch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the object for a given index number
     * @param numObject : the index of an item
     * @return the item at a given position
     */
    public Item getItem(int numObject) {
        return this.inventory.get(numObject);
    }

}
