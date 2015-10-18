package termProject;
import java.util.ArrayList;
import termProject.Card;

/**
 * a deck holds a certain amount of cards
 * @author James
 *
 */

public class Deck {
	ArrayList<Card> cardList;
	
	public Deck(){
		cardList = new ArrayList<Card>();
	}
	
	public boolean addCard(Card c){
		return cardList.add(c);
		
	}
	
	/**
	 * Removes a card from this deck
	 * @param c the card to discard
	 * @param d the deck to discard into (card goes here)
	 * @return if the card passed was found and discarded (T/F)
	 */
	public boolean discard(Card c, Deck d){
		d.addCard(c);//add to discard deck/hand
		return cardList.remove(c);//remove from current
	}
	
	/**
	 * returns the size of the deck, how many cards in the deck
	 * @return
	 */
	public int getSize(){
		return cardList.size();
	}

	/**
	 * returns the 
	 * @param i the index of the card wanted
	 * @return card at the given index
	 */
	public Card get(int i){
		return cardList.get(i);
	}
}
