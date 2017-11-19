package FunctionnalCore;

import javax.swing.Icon;

/**
 *
 * @author Paul
 */
public class Player {

    private final String playerName;
    private Inventory inventory;
    private int health;
    private int strength;
    private int defense;
    private Weapon weaponEquipped;
    private Armor armorEquipped;
    private int money;
    private Icon pic;

    public Player(String playerName, int sizeInv, int strength, int defense, Weapon weaponEquipped, Armor armorEquipped, int money, Icon pic) {
        this.health = 100;
        if (playerName.equals("")) {
            playerName = "WoZPlayer";
        }
        this.playerName = playerName;
        this.inventory = new Inventory(sizeInv);
        this.strength = strength;
        this.defense = defense;
        this.weaponEquipped = weaponEquipped;
        this.armorEquipped = armorEquipped;
        this.money = money;
        this.pic = pic;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void loseHealth(int numberLost) {
        if (this.health + numberLost < 0) {
            setHealth(0);
        } else {
            setHealth(this.health + numberLost);
        }
    }

    public void gainHP(int numberGain) {
        if (this.health + numberGain > 100) {
            setHealth(100);
        } else {
            setHealth(this.health + numberGain);
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Weapon getWeaponEquipped() {
        return weaponEquipped;
    }

    public void setWeaponEquipped(Weapon weaponEquipped) {
        if (this.inventory.checkInv(weaponEquipped)) {
            this.weaponEquipped = weaponEquipped;
        } else {
            this.weaponEquipped = null;
        }
    }

    public Armor getArmorEquipped() {
        return armorEquipped;
    }

    public void setArmorEquipped(Armor armorEquipped) {
        if (this.inventory.checkInv(armorEquipped)) {
            this.armorEquipped = armorEquipped;
        } else {
            this.armorEquipped = null;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int newMoney) {
        if ((this.money + newMoney) < 0) {
            newMoney = 0;
        }
        this.money = newMoney;
    }

    public Icon getPic() {
        return pic;
    }

    public void setPic(Icon pic) {
        this.pic = pic;
    }

    public int getTotalStr() {
        if (this.weaponEquipped != null) {
            return (this.strength + this.weaponEquipped.getDamage());
        } else {
            return this.strength;
        }
    }

    public int getTotalDef() {
        if (this.armorEquipped != null) {
            return (this.defense + this.armorEquipped.getDefense());
        } else {
            return this.defense;
        }
    }

}
