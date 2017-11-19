package FunctionnalCore;

import javax.swing.Icon;

/**
 *
 * @author Paul
 */
public class Armor extends Item {

    private int defense;

    public Armor(String itemName, int price, Icon picture, int weight, int defense) {
        super(itemName, price, picture, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

}
