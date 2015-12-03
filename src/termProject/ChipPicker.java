package termProject;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

/**
 * Calling an instance of this class adds the chosen chip to the players total
 * @author James
 *
 */
public class ChipPicker extends JFrame{

	private static final long serialVersionUID = 1L;
	JDialog d1;//the dialog component
	DiagListener listener;//the listener for the 3 buttons
	Player tempPlayer;//the player that is picking
	Chips chosenChip;//the chip that is picked
	String message;//the message to write to the console
	boolean picked;//whether or not a chip has been picked
	
/**
 * The constructor for the dialog
 * @param p Player that will be picking the chip
 */
	public ChipPicker(Player p, String excluded) {
		picked = false;//has the chip been picked
		
		while(!picked){//while no choice has been made

			tempPlayer = p;//assign player
	        d1=new JDialog(this,"Chip Chooser",true);//make dialog with frame
	        listener = new DiagListener();//create button listener
	        
			setTitle("Chip Chooser");//title of the Jframe
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//dispose of the frame
	        JDialog.setDefaultLookAndFeelDecorated(true);//make it blue
	        
	        // Set size
	        d1.setSize(400,532);
	        setSize(400,532);
	        //absolute layout for Frame
	        getContentPane().setLayout(null);
	        d1.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));//grid layout for the dialog
	        
	        JPanel panel = new JPanel();//panel to hold puttons
	        panel.setLayout(null);//absolute layout
	        d1.getContentPane().add(panel);//add components
	        
	        //integrity button
	        JButton button = new JButton(Chips.INTEGRITY.toString());
	        button.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/Integ.png")));
	        button.setBounds(80, 5, 250, 130);
	        button.addActionListener(listener);
	        panel.add(button);
	        
	        //learning button
	        JButton button_1 = new JButton(Chips.LEARNING.toString());
	        button_1.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/learn.png")));
	        button_1.setBounds(80, 139, 250, 130);
	        button_1.addActionListener(listener);
	        panel.add(button_1);
	        
	        //crafting button
	        JButton button_2 = new JButton(Chips.CRAFTING.toString());
	        button_2.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/crafting.png")));
	        button_2.setBounds(80, 273, 250, 130);
	        button_2.addActionListener(listener);
	        panel.add(button_2);
	        
	        //Label of the jdialog
	        JLabel label = new JLabel("Choose A Chip");
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	        label.setBounds(80, 413, 250, 14);
	        panel.add(label);
	        
	        if (excluded != null){ //disable one chip button
		        switch(excluded){
		        case "integrity":
		        	button.setEnabled(false);
		        	break;
		        case "learning":
		        	button_1.setEnabled(false);
		        	break;
		        case "craft":
		        	button_2.setEnabled(false);
		        	break;
		        default:
		        	System.out.println("Error with excluded\n");
		        	break;
		        }
	        }
	        
	        //fire it up
	        d1.setVisible(true);
		}
	}
	
	/**
	 * returns the message to be written to the console
	 * <p><b>
	 * Warning!:</b> the chip has already been added to player
	 * </p>
	 * @return String message detailing player and chip
	 */
	public String getChoiceStr(){
		return message;
	}
	
	/**
	 * returns the Chips enum chosen
	 * <p><b>
	 * Warning!:</b> the chip has already been added to player
	 * 
	 * </p>
	 * @return Chips enum of the chip name
	 */
	public Chips getChoiceChip(){
		return chosenChip;
	}
	 
	/**
	 * listener class to parse button events assign chip
	 * @author James
	 *
	 */
	private class DiagListener implements ActionListener {
	      @Override
		public void actionPerformed(ActionEvent e) {
	    	  //check for which chip
	    	  if(e.getActionCommand() == Chips.INTEGRITY.toString()){
	    		  chosenChip = Chips.INTEGRITY;//assign chosen chip
	    		  tempPlayer.changeIntegrity(1);//increment chip count
	    	  } else if(e.getActionCommand() == Chips.CRAFTING.toString()){
	    		  chosenChip = Chips.CRAFTING;
	    		  tempPlayer.changeCraft(1);
	    	  } else {
	    		  chosenChip = Chips.LEARNING;
	    		  tempPlayer.changeLearning(1);
	    	  }
	    	  picked = true;//break main while loop
	    	  setVisible(false);//hide
    		  dispose();//close
	    	  message = "Added 1 " + chosenChip + " to " + tempPlayer.getPName();//return message
	    	  System.out.println(message);//print to system
	      }
	}
}


