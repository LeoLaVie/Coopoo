package Interface;

 import java.awt.*;
 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.*;

///////////////////////////////////////////////////////////////

/*
* The class Home allows to show the first picture when we start the game.
*/
public class InterfaceMain extends JFrame implements ActionListener {
    
   private final JButton butChar1;
   private final JButton butChar2;
   private final JButton butChar3;
   private final JButton butStart;
   private final JButton butChange;
   //////////////////
   private final JPanel panelBut1 = new JPanel();
   private final JLabel labBut1 = new JLabel ("War",JLabel.CENTER);
   private final JPanel pBut1 = new JPanel();
   private final JPanel panelBut2 = new JPanel();
   private final JLabel labBut2 = new JLabel ("Rogue",JLabel.CENTER);
   private final JPanel pBut2 = new JPanel();
   private final JPanel panelBut3 = new JPanel();
   private final JLabel labBut3 = new JLabel ("Wizard",JLabel.CENTER);
   private final JPanel pBut3 = new JPanel();
   
   //////////////////
   private final JPanel panelJoueur = new JPanel();
   private final JPanel panelBottom = new JPanel();
   private final JPanel myMainPanel = new JPanel();
   private final JPanel panelStart = new JPanel();
   private final JPanel panelChange = new JPanel();
   
    //////////////////
   private final JLabel label,labTitle;
    //////////////////
   private final Icon pic1,pic2,pic3;
   
   private JTextField fieldName;

   ///////////////////
   private String playerClass;
   private String playerName;
   

   
///////////////////////////////////////////////////////////////
   
   /*
   The constructor of the class game is composed of button, panel for each herol and label.
   
   */
   public InterfaceMain (){
       
       this.setTitle("World Of Zuul");// Titre
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //-----------------------------------------------------------------------
        labTitle = new JLabel("World Of Zuul",JLabel.CENTER);
        labTitle.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,45));
        labTitle.setForeground(Color.red);
        

   
       //-----------------------------------------------------------------------
       
       //1er label de la frame 
       label = new JLabel ("Choose your player and click on start to begin your game!",JLabel.CENTER);
       label.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
       label.setForeground(Color.white);
       JLabel label2 = new JLabel(" ");
       label2.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
       
       JPanel panLabel = new JPanel(new BorderLayout());
       panLabel.add(labTitle,BorderLayout.NORTH);
       panLabel.add(label,BorderLayout.CENTER);
       panLabel.add(label2,BorderLayout.SOUTH);
       panLabel.setOpaque(false);

       ///////////////////
       //Panel player 1
       labBut1.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
       labBut1.setForeground(Color.white);
       pic1 = new ImageIcon(getClass().getResource("../Pictures/War.png"));
       butChar1 = new JButton (pic1);
       butChar1.setPreferredSize(new Dimension(96,96));
       panelBut1.setLayout(new BorderLayout());
       pBut1.add(butChar1);
       pBut1.setOpaque(false);
       panelBut1.add(pBut1,BorderLayout.CENTER);
       panelBut1.add(labBut1,BorderLayout.NORTH);
       panelBut1.setOpaque(false);
       ///////////////////
       
       //Panel player 2
       labBut2.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
       labBut2.setForeground(Color.white);
       pic2 = new ImageIcon(getClass().getResource("../Pictures/Rogue.png"));
       butChar2 = new JButton (pic2);
       butChar2.setPreferredSize(new Dimension(96,96));
       panelBut2.setLayout(new BorderLayout());
       pBut2.add(butChar2);
       pBut2.setOpaque(false);
       panelBut2.add(pBut2,BorderLayout.CENTER);
       panelBut2.add(labBut2,BorderLayout.NORTH);
       panelBut2.setOpaque(false);
       ///////////////////
       
       //Panel player 3
       labBut3.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
       labBut3.setForeground(Color.white);
       pic3 = new ImageIcon(getClass().getResource("../Pictures/Wizard.png"));
       butChar3 = new JButton (pic3);
       butChar3.setPreferredSize(new Dimension(96,96));
       panelBut3.setLayout(new BorderLayout());
       pBut3.add(butChar3);
       pBut3.setOpaque(false);
       panelBut3.add(pBut3,BorderLayout.CENTER);
       panelBut3.add(labBut3,BorderLayout.NORTH);
       panelBut3.setOpaque(false);
       
       ///////////////////
       
       JLabel labelName = new JLabel("Enter your name :  ");
       labelName.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
       labelName.setForeground(Color.white);
       fieldName = new JTextField(15);
       JPanel panelName = new JPanel();
       panelName.add(labelName);
       panelName.add(fieldName);
       panelName.setOpaque(false);
       
       
       //////////////////
       
       /// BOTTOM : Boutons start and change
        butStart = new JButton();
        butStart.setPreferredSize(new Dimension(200,60));
        butStart.setIcon(new ImageIcon(getClass().getResource("../Pictures/boutton_game.png")));
        butStart.setText("Start Game");
        butStart.setForeground(Color.black);
        butStart.setDisabledIcon(new ImageIcon(getClass().getResource("../Pictures/boutton_game.png")));
        butStart.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
        butStart.setVerticalTextPosition(SwingConstants.CENTER);
        butStart.setHorizontalTextPosition(SwingConstants.CENTER);
       
        butChange = new JButton();
        butChange.setPreferredSize(new Dimension(200,60));
        butChange.setIcon(new ImageIcon(getClass().getResource("../Pictures/boutton_game.png")));
        butChange.setText("Change player");
        butChange.setForeground(Color.black);
        butChange.setDisabledIcon(new ImageIcon(getClass().getResource("../Pictures/boutton_game.png")));
        butChange.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
        butChange.setVerticalTextPosition(SwingConstants.CENTER);
        butChange.setHorizontalTextPosition(SwingConstants.CENTER);
       
        
       /////////////////// 
       //Panel Joueur contain all buttons and label of players
       panelJoueur.setLayout(new GridLayout(1,3));
       panelJoueur.add(panelBut1);
       panelJoueur.add(panelBut2);
       panelJoueur.add(panelBut3);
       panelJoueur.setOpaque(false);
       
       JPanel panelCenter = new JPanel();
       panelCenter.setLayout(new BorderLayout());
       panelCenter.add(panelJoueur,BorderLayout.CENTER);
       panelCenter.add(panelName,BorderLayout.SOUTH);
       panelCenter.setOpaque(false);
       
       
       panelBottom.setLayout(new GridLayout(1,2));
       panelBottom.add(panelStart);
       panelBottom.add(panelChange);
       panelBottom.setOpaque(false);
       
       panelStart.add(butStart);
       panelStart.setOpaque(false);
       panelChange.add(butChange);
       panelChange.setOpaque(false);
       
       myMainPanel.setLayout(new BorderLayout());
       myMainPanel.add(panLabel,BorderLayout.NORTH);
       myMainPanel.add(panelCenter,BorderLayout.CENTER);
       myMainPanel.add(panelBottom,BorderLayout.SOUTH);
       myMainPanel.setOpaque(false);
     
       
       //Action definition for every buttons
       butChar1.addActionListener(this); 
       butChar2.addActionListener(this);
       butChar3.addActionListener(this);
       butStart.addActionListener(this);
       butChange.addActionListener(this);
       
       butStart.setEnabled(false);
       butChange.setEnabled(false);
       Container c = new JLabel(makeImage());
       c.setLayout(new FlowLayout());
       c.add(myMainPanel);
       c.setPreferredSize(new Dimension(800,800));
       c.setMaximumSize(new Dimension(800,800));
       c.setMinimumSize(new Dimension(800,800));
       this.add(c);
       this.setResizable(false);
       this.setPreferredSize(new Dimension(1000,550));
       this.setMaximumSize(new Dimension(1000,550));
       this.setMinimumSize(new Dimension(1000,550));
       this.setLocationRelativeTo(null);
       this.setVisible(true);        
   }
   
   
   
   /*
   The method makeImage allows to return the background of the home panel of the game. 
   */
   
   private ImageIcon makeImage(){
       return new ImageIcon(getClass().getResource("../Pictures/fond1.PNG"));    
   }
   
   
   /*
   The method actionPerformed allows to make action in fonction of the button 
   clicked by the player.
   */
   
   @Override
   public void actionPerformed(ActionEvent e)
   
  {
      // When the user click on Marion's picture, the button Start and Change 
      //become accessible but all the other hero button become unaccessible 
      
      if (e.getSource() == butChar1)    //Marion
      {
          playerClass="War";
          butStart.setEnabled(true);
          butChange.setEnabled(true);
          butChar2.setEnabled(false);
          butChar3.setEnabled(false);
      }
      else if (e.getSource() == butChar2) // Marin
      {
          playerClass="Rogue";
          butStart.setEnabled(true);
          butChange.setEnabled(true);
          butChar1.setEnabled(false);
          butChar3.setEnabled(false);
      }
      else if (e.getSource() == butChar3) // Paul
      {
          playerClass="Wizard";
          butStart.setEnabled(true);
          butChange.setEnabled(true);
          butChar1.setEnabled(false);
          butChar2.setEnabled(false);
      }
      
      else if (e.getSource() == butStart)
      {
         playerName = fieldName.getText();
         new InterfaceGame(playerClass,playerName);
         this.dispose();
      }
      
      else if (e.getSource() == butChange)
      {
          butStart.setEnabled(false);
          butChange.setEnabled(false);
          butChar1.setEnabled(true);
          butChar2.setEnabled(true);
          butChar3.setEnabled(true);
      }
  }
}

