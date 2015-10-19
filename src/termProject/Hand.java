package termProject;

/**
 * holds the cards of the player
 * @author James
 *
 */
public class Hand extends Deck{
	private Card cardArr[];
	private int SIZE;
	private int lastAdded;
	
	public Hand(int s) {
		SIZE = s;
		cardArr = new Card[SIZE];
		lastAdded = s-1;
	}

	/**
	 * adds the card if there is an empty spot in the hand
	 * @param c that card to add
	 * @return whether the card was added or not
	 */
	public boolean addCard(Card c){
		for(int i = 0; i < cardArr.length; i++){//go through the array
			if(!(cardArr[i] instanceof Card)){//if current spot is not a card
				cardArr[i] = c;//assign this card to the empty spot
				lastAdded = i;
				return true;//return true, card was added
			}
		}
		return false;//no card was added, return false
	}
	
	/**
	 * removes card from this deck and adds card to passed deck
	 * @param c remove this card
	 * @param d add removed card to this deck
	 * @return boolean of whether the card was found and removed.
	 */
	@Override
	public boolean discard(Card c, Deck d){
		for(int i = 0; i < cardArr.length; i++){//go through the hand
			if(cardArr[i] != null){
				if(cardArr[i].equals(c)){//check if the current card is what we are looking for
					d.addCard(cardArr[i]);//add to discard deck
					cardArr[i] = null;//set card's spot to null
					return true;//card was discarded
				}
			}
		}
		return false;//card was not discarded
	}
	
	/**
	 * returns the size of the hand
	 */
	@Override
	public int getSize(){
		return SIZE;
	}
	
	@Override
	public Card get(int i){
		return cardArr[i];
	}
	
	/**
	 * Returns false if one empty spot is found.
	 * @return
	 */
	public boolean isFull(){
		for(Card c: cardArr){
			if(c == null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * returns the index location of the last added card
	 * @return the index number
	 */
	public int getLastAdded(){
		return lastAdded;
	}
}
