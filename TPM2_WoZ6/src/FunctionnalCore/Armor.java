package FunctionnalCore;

import javax.swing.Icon;

/**
 * Armor inherits of Item class
 * An armor is represent by a defense (an integer)
 * 
 * @author Paul
 */
public class Armor extends Item {

    private int defense;

    /**
     * Armor'constructor
     * 
     * @param itemName : name of the item (String)
     * @param price : price of the item (integer)
     * @param picture : picture of the item (Icon picture)
     * @param weight : weight of the item (integer)
     * @param defense : defense of the armor (integer)
     */
    public Armor(String itemName, int price, Icon picture, int weight, int defense) {
        super(itemName, price, picture, weight);
        this.defense = defense;
    }

    /**
     * Method getDefense
     * Getter of the attribute defense
     * @return defense (integer)
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Method setDefense
     * Setter of the attribute defense
     * @param defense : value of the armor'defense (integer)
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

}
