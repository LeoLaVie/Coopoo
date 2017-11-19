package FunctionnalCore;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class Inventory {

    private ArrayList<Item> inventory;
    private int size;

    public Inventory(int size) {
        this.size = size;
        this.inventory = new ArrayList<>();
    }
    
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLengthInv() {
        return this.inventory.size();
    }

    public int getTotalOccupedSize(){
        int totalWeight = 0;
        for (Item item : inventory) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    public void addObject(Item i) {
        if (getLengthInv() != size) {
            this.inventory.add(i);
        }
    }

    public void deleteObject(Item i) {
        for (int j = 0; j < getLengthInv(); j++) {
            if (this.inventory.get(j).equals(i)) {
                this.inventory.remove(j);
                break;
            }
        }
    }

    public boolean checkInv(Item itemResearch) {
        for (int j = 0; j < getLengthInv(); j++) {
            if (this.inventory.get(j).equals(itemResearch)) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(int numObject) {
        return this.inventory.get(numObject);
    }

}
