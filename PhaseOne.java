import javax.swing.*;
import java.awt.*;
   
public class Assig5 
{
   // Data
   static final int NUM_CARD_IMAGES = 57;
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
      
   // Constructs each file name and associates the card image with an icon object
   static void loadCardIcons()
   {
      for (int val = 0; val <= 14; val++)
      {
         for (int suit = 0; suit < 4; suit++)
         {
            if(val == 14)
            {
               icon[suit + (4 * val)] = new ImageIcon("images/BK.gif");
               break;
            }
            else
            {
               icon[suit + (4 * val)] = new ImageIcon("images/" + 
               turnIntIntoCardValue(val) + turnIntIntoCardSuit(suit) + ".gif");
            }
         }
      }
   }
   
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
      String val = "A23456789TJQKX";
      return val.substring(k, k + 1);
   }
   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
      String suit = "CDHS";
      return suit.substring(j, j + 1);
   }
   
   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;
      
      // prepare the image icon array
      loadCardIcons();
      
      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
      frmMyWindow.setLayout(layout);
      
      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);
      
      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}
