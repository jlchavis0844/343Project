/**
 * 
 */
package termProject;

import javax.swing.JLabel;

/**
 * @author James
 *
 */
public class CardLabel extends JLabel {
	
	private int currentCard;

	/**
	 * 
	 */
	public CardLabel(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		currentCard = 0;
	}
	
	public void increment(){
		currentCard++;
		if(currentCard == 8){
			currentCard = 0;
		}
	}
	
	public int getCurrent(){
		return currentCard;
	}

}
