package FunctionnalCore;

import javax.swing.Icon;

/**
 *
 * @author Paul
 */
public class Weapon extends Item {

    private int damage;

    public Weapon(String itemName, int price, Icon picture, int weight, int damage) {
        super(itemName, price, picture, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
