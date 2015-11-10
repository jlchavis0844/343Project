package termProject;
import java.util.ArrayList;
import java.util.Random;

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
	
	/**
	 * counts how many active cards are in the deck
	 * @return number of Card objects in deck
	 */
	public int getCardCount(){
		int i = 0;
		for (Card c: cardList){
			if(c instanceof Card){
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Returns false if one empty spot is found.
	 * @return
	 */
	public boolean isFull(){
		for(Card c: cardList){
			if(c == null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * shuffles the current cards in the current
	 * 
	 * <p>
	 * creates a temp ArrayList and loads a random 
	 * card into it until current cardList is empty,
	 * temp ArrayList then over-writes cardList 
	 * </p>
	 */
	public void shuffle(){
		ArrayList<Card> tList = new ArrayList<>();//temp ArrayList
		
		while (!cardList.isEmpty()){//while the current cardList is not empty
			//remove from card list and place into temp list
			tList.add(cardList.remove(new Random().nextInt(cardList.size())));
		}
		
		cardList = tList;//over write the cardList (current) with temp (new, shuffled)
	}
}
