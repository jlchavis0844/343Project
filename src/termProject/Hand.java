package termProject;

import java.util.Vector;

/**
 * holds the cards of the player
 * @author James
 *
 */
public class Hand extends Deck{
	//private Card cardArr[];
	//private int lastAdded;
	//private ArrayList<Card> cardList;
	
	
	public Hand() {
		super();
		//cardArr = new Card[SIZE];
		//lastAdded = s-1;
	}

	/**
	 * adds the card if there is an empty spot in the hand
	 * @param c that card to add
	 * @return whether the card was added or not
	 */
	public boolean addCard(Card c){
		cardList.add(c);
		return true;//legacy
	}
	
	/**
	 * removes card from this deck and adds card to passed deck
	 * @param c remove this card
	 * @param d add removed card to this deck
	 * @return boolean of whether the card was found and removed.
	 */
	@Override
	public boolean discard(Card c, Deck d){
		boolean tBool = false;//holds whether the remove is successful
		for(int i = 0; i < cardList.size(); i++){//go through the hand
			tBool = cardList.remove(c);
			if(tBool == true){//if the card is found
				d.addCard(c); //add card to discard deck
			}
		}
		return tBool;//return whether the card 
	}

	@Override
	public Card get(int i){
		return cardList.get(i);
	}
	
	/**
	 * returns the index location of the last added card
	 * @return the index number
	 */
	public int getLastAdded(){
		return cardList.size() - 1;
	}
	
	/**
	 * Returns false if one empty spot is found.
	 * @return
	 */
	public boolean isFull(){
		return cardList.size() >= 7;
	}
	
	/**
	 * return a string vector of the card names
	 * @return Vector<String> of card names
	 */
	public Vector<String> getCardNames(){
		Vector<String> myVec = new Vector<>();
		
		for (Card c: cardList){//go through the entire deck
			myVec.add(c.getName());//push name to vector
		}
		return myVec;
		
	}
}
