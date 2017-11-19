package FunctionnalCore;

import javax.swing.Icon;

/**
 * Abstract class Item
 * Allows managing all types of items (Weapon and Armor classes)
 * @author Paul
 */
abstract class Item {

    private String itemName;
    private int price;
    private Icon picture;
    private int weight;

    /**
     * Constructor of abstract Item class
     * @param itemName : The name of item
     * @param price : The price of item
     * @param picture : The picture of item
     * @param weight : The weight of item
     */
    public Item(String itemName, int price, Icon picture, int weight) {
        this.itemName = itemName;
        this.price = price;
        this.picture = picture;
        this.weight = weight;
    }

    /**
     * Getter of item name
     * @return the name of item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter of item name
     * @param itemName : the new name of item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Getter of item price
     * @return the price of item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter of item price
     * @param price : the new price of item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter of picture icon
     * @return the picture of item
     */
    public Icon getPicture() {
        return picture;
    }

    /**
     * Getter of weight item
     * @return the weight of item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter of weight item
     * @param weight : the new weight of item
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
