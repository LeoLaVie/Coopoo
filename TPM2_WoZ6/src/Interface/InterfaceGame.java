package Interface;

import FunctionnalCore.Armor;
import FunctionnalCore.Player;
import FunctionnalCore.Weapon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Paul
 */
public class InterfaceGame extends JFrame{
    
    private Player player;
    private JPanel arrayPanel[];
    //private Weapon weapon1,weapon2;
    
    
    public InterfaceGame(String playerClass, String playerName){
       this.setTitle("World Of Zuul");// Titre
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGame(playerClass, playerName);
        
        /// Player informations
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Player Skills");
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        titlePanel.add(titleLabel);
        
        
       //// Picture Player
       JLabel playerPic = new JLabel();
       playerPic.setIcon(this.player.getPic());
       
       // Player Info
       JPanel infoPanel = new JPanel(new GridLayout(6,2));
       JLabel nameLabel = new JLabel("Player Name : ");
       nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(nameLabel);
       infoPanel.add(new JLabel(this.player.getPlayerName()));
       JLabel classLabel = new JLabel("Player Class : ");
       classLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(classLabel);
       infoPanel.add(new JLabel(playerClass));
       JLabel healthLabel = new JLabel("Health : ");
       healthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(healthLabel);
       infoPanel.add(new JLabel(String.valueOf(this.player.getHealth())));
       JLabel moneyLabel = new JLabel("Money : ");
       moneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(moneyLabel);
       infoPanel.add(new JLabel(String.valueOf(this.player.getMoney())));
       JLabel strLabel = new JLabel("Total Strength : ");
       strLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(strLabel);
       infoPanel.add(new JLabel(String.valueOf(this.player.getTotalStr())+"("+
               String.valueOf(this.player.getStrength())+"+"+
               String.valueOf(this.player.getWeaponEquipped().getDamage())+")"));
       JLabel defLabel = new JLabel("Total Defense : ");
       defLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       infoPanel.add(defLabel);
       infoPanel.add(new JLabel(String.valueOf(this.player.getTotalDef())+"("+
               String.valueOf(this.player.getDefense())+"+"+
               String.valueOf(this.player.getArmorEquipped().getDefense())+")"));
       
       // Head Panel (picture + info)
       JPanel headPanel = new JPanel(new BorderLayout());
       headPanel.add(titlePanel, BorderLayout.NORTH);
       headPanel.add(playerPic, BorderLayout.WEST);
       headPanel.add(infoPanel, BorderLayout.CENTER);
       
       // Inventory Panel
       JPanel headInvPanel = new JPanel(new BorderLayout());
       JLabel invLabel = new JLabel("Inventory ("+this.player.getInventory().getTotalOccupedSize()+
               "/"+this.player.getInventory().getSize()+")");
       invLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       invLabel.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
       headInvPanel.add(invLabel);
       
       // Items
       JPanel itemTabPanel = new JPanel(new GridLayout(1,5));
       itemTabPanel.add(new JLabel("Picture"));
       itemTabPanel.add(new JLabel("Name"));
       itemTabPanel.add(new JLabel("Effect"));
       itemTabPanel.add(new JLabel("Weight"));
       itemTabPanel.add(new JLabel("Price"));
       int nbItem = this.player.getInventory().getLengthInv();
       arrayPanel = new JPanel[nbItem];
        for (int i = 0; i < nbItem; i++) {
            arrayPanel[i] = new JPanel(new GridLayout(1,5));
            if (this.player.getInventory().getItem(i) instanceof Weapon) {
                arrayPanel[i].add(new JLabel(((Weapon)this.player.getInventory().getItem(i)).getPicture()));
                arrayPanel[i].add(new JLabel(((Weapon)this.player.getInventory().getItem(i)).getItemName()));
                arrayPanel[i].add(new JLabel(String.valueOf(((Weapon)this.player.getInventory().getItem(i)).getDamage())));
                arrayPanel[i].add(new JLabel(String.valueOf(((Weapon)this.player.getInventory().getItem(i)).getWeight())));
                arrayPanel[i].add(new JLabel(String.valueOf(((Weapon)this.player.getInventory().getItem(i)).getPrice())));
            }else if (this.player.getInventory().getItem(i) instanceof Armor) {
                arrayPanel[i].add(new JLabel(((Armor)this.player.getInventory().getItem(i)).getPicture()));
                arrayPanel[i].add(new JLabel(((Armor)this.player.getInventory().getItem(i)).getItemName()));
                arrayPanel[i].add(new JLabel(String.valueOf(((Armor)this.player.getInventory().getItem(i)).getDefense())));
                arrayPanel[i].add(new JLabel(String.valueOf(((Armor)this.player.getInventory().getItem(i)).getWeight())));
                arrayPanel[i].add(new JLabel(String.valueOf(((Armor)this.player.getInventory().getItem(i)).getPrice())));
            }
        }
       JPanel invTabPanel = new JPanel(new GridLayout(nbItem+1,5));
       invTabPanel.add(itemTabPanel);
        for (int i = 0; i < nbItem; i++) {
            invTabPanel.add(arrayPanel[i]);
        }
        
        JPanel inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.add(headInvPanel, BorderLayout.NORTH);
       inventoryPanel.add(invTabPanel, BorderLayout.CENTER);
       
       
       
       
       JPanel globalPanel = new JPanel(new GridLayout(2,1));
       globalPanel.add(headPanel);
       globalPanel.add(inventoryPanel);
       
       this.add(globalPanel);
       this.setResizable(false);
       this.setPreferredSize(new Dimension(1000,550));
       this.setMaximumSize(new Dimension(1000,550));
       this.setMinimumSize(new Dimension(1000,550));
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    
    public void initGame(String playerClass, String playerName){
        int strenght,defense,bagSize,money;
        Weapon weapon1,weapon2;
        Armor armor1;
        Icon weapon1Pic,weapon2Pic,armor1Pic,playerPic;
        if (playerClass.equals("War")) {
            strenght = 15;
            defense = 12;
            bagSize = 30;
            money = 50;
            weapon1Pic = new ImageIcon(getClass().getResource("../Pictures/epee2.png"));
            weapon1 = new Weapon("Sword", 25, weapon1Pic, 5, 12);
            weapon2Pic = new ImageIcon(getClass().getResource("../Pictures/hache4.png"));
            weapon2 = new Weapon("Axe", 20, weapon2Pic, 5, 10);
            armor1Pic = new ImageIcon(getClass().getResource("../Pictures/armure4.png"));
            armor1 = new Armor("Iron Armor", 120, armor1Pic, 13, 30);
            playerPic = new ImageIcon(getClass().getResource("../Pictures/War.png"));
        }else if(playerClass.equals("Rogue")){
            strenght = 10;
            defense = 7;
            bagSize = 100;
            money = 350;
            weapon1Pic = new ImageIcon(getClass().getResource("../Pictures/couteau1.png"));
            weapon1 = new Weapon("Dagger", 10, weapon1Pic, 2, 5);
            weapon2Pic = new ImageIcon(getClass().getResource("../Pictures/masse2.png"));
            weapon2 = new Weapon("Mass", 20, weapon2Pic, 4, 7);
            armor1Pic = new ImageIcon(getClass().getResource("../Pictures/armure3.png"));
            armor1 = new Armor("Leather Armor", 75, armor1Pic, 8, 12);
            playerPic = new ImageIcon(getClass().getResource("../Pictures/Rogue.png"));
        }else{ // playerClass.equals("Wizard")
            strenght = 5;
            defense = 10;
            bagSize = 60;
            money = 125;
            weapon1Pic = new ImageIcon(getClass().getResource("../Pictures/baton2.png"));
            weapon1 = new Weapon("Stick", 40, weapon1Pic, 6, 11);
            weapon2Pic = new ImageIcon(getClass().getResource("../Pictures/lance1.png"));
            weapon2 = new Weapon("Spear", 25, weapon2Pic, 5, 8);
            armor1Pic = new ImageIcon(getClass().getResource("../Pictures/armure2.png"));
            armor1 = new Armor("Light Armor", 30, armor1Pic, 3, 6);
            playerPic = new ImageIcon(getClass().getResource("../Pictures/Wizard.png"));
        }
        
        this.player = new Player(playerName, bagSize, strenght, defense, weapon1, armor1, money, playerPic);
        this.player.getInventory().addObject(weapon1);
        this.player.getInventory().addObject(weapon2);
        this.player.getInventory().addObject(armor1);
    }
}
