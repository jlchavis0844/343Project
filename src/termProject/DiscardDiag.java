package termProject;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

/**
 * Calling an instance of this class adds the chosen chip to the players total
 * @author James
 *
 */
public class DiscardDiag extends JFrame{

	private static final long serialVersionUID = 1L;
	JDialog d1;//the dialog component
	DiagListener listener;//the listener for the 3 buttons
	Player tempPlayer;//the player that is picking
	boolean picked;//whether or not a chip has been picked
	Vector<JButton> btnVec; //holds all the buttons
	Deck discardDeck;
	String message;
	
/**
 * The constructor for the dialog
 * @param p Player that will be picking the chip
 */
	public DiscardDiag(Player p, Deck discard) {
		picked = false;//has the chip been picked
		discardDeck = discard;// discard deck
		tempPlayer = p;//the player
		
		while(!picked){//while no choice has been made
	        d1=new JDialog(this,"Discard Dialog",true);//make dialog with frame
	        listener = new DiagListener();//create button listener
	        
			setTitle("Choose card to discard");//title of the Jframe
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//dispose of the frame
	        JDialog.setDefaultLookAndFeelDecorated(true);//make it blue
	        
	        // Set size
	        int handSize = p.getHand().getSize();
	        d1.setSize(handSize*210,400);
	        setSize(handSize*210,400);
	        //absolute layout for Frame
	        getContentPane().setLayout(null);
	        d1.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));//grid layout for the dialog
	        
	        JPanel panel = new JPanel();//panel to hold buttons
	        panel.setLayout(null);//absolute layout
	        d1.getContentPane().add(panel);//add components
	        
	        btnVec = new Vector<>(); 
	        Card tCard;
	        for(int i =0; i < handSize; i++){//for as many cards that are in the hand
	        	tCard = p.getHand().get(i);//holds this card
	        	btnVec.add(new JButton(tCard.getName()));//make new button
	        	btnVec.get(i).setIcon(tCard.getImg());// set card icon
	        	btnVec.get(i).setBounds(20+i*200,20,200,270);//place the card
	        	btnVec.get(i).addActionListener(listener);//add an action listener
	        	panel.add(btnVec.get(i));//add the button to the panel
	        }
	        
	        //Label of the jdialog
	        JLabel label = new JLabel("Choose a card");
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	        label.setBounds(20, 300, 250, 14);
	        panel.add(label);
	        
	        //fire it up
	        d1.setVisible(true);
		}
	}
	
	/**
	 * returns the message to printout to the console
	 * @return message
	 */
	public String getMessage(){
		if (message == null){
			return "Error";
		} else return message;
	}
	 
	/**
	 * listener class to parse button events assign chip
	 * @author James
	 *
	 */
	private class DiagListener implements ActionListener {
	      @Override
		public void actionPerformed(ActionEvent e) {
	    	  int index = -1;
	    	  JButton tButton = (JButton)e.getSource();
	    	  for(int i = 0; i < btnVec.size(); i++){
	    		  if(btnVec.get(i).equals(tButton)){
	    			  index = i;
	    			  break;
	    		  }
	    	  }
	    	  if (index == -1){
	    		  System.err.println("Card not found");
	    	  } else {
	    	  picked = true;
	    	  tempPlayer.getHand().discard(tempPlayer.getHand().get(index),discardDeck);
	    	  setVisible(false);//hide
    		  dispose();//close
    		  message =tempPlayer.getPName() + " discards \""
    		  +tempPlayer.getHand().get(index).getName()+ "\"";
	    	  }
	      }
	}
}


