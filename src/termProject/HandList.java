package termProject;

import java.util.Vector;

/**
 * Builds a vector of strings of card names for a LJist to use
 * @author James
 *
 */
public class HandList {
	private Vector<String> nameVec;
	private int handSize;
	private Card cCard;
	private String cardName;

	public HandList(Hand h) {
		handSize = h.getSize();
		nameVec = new Vector<String>();
		
		for(int i = 0; i < handSize; i++){
			cCard = h.get(i);
			if(cCard == null){
				cardName = "Empty";
			} else {
				cardName = cCard.getName();
			}
			nameVec.add(cardName);
		}	
	}

	/**
	 * Returns the vector of string which are the names of the cards
	 * @return vector containing names
	 */
	public Vector<String> getNames(){
		return nameVec;
	}
}
