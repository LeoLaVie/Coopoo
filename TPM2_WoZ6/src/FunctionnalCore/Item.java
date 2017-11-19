package FunctionnalCore;

import javax.swing.Icon;

/**
 *
 * @author Paul
 */
abstract class Item {

    private String itemName;
    private int price;
    private Icon picture;
    private int weight;

    public Item(String itemName, int price, Icon picture, int weight) {
        this.itemName = itemName;
        this.price = price;
        this.picture = picture;
        this.weight = weight;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Icon getPicture() {
        return picture;
    }

    public void setPicture(Icon picture) {
        this.picture = picture;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
