package termProject;

/**
 * holds the cards of the player
 * @author James
 *
 */
public class Hand{
	Card cardArr[];
	int SIZE;
	
	public Hand(int s) {
		SIZE = s;
		cardArr = new Card[SIZE];
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
	public boolean discardCard(Card c, Deck d){
		for(int i = 0; i < cardArr.length; i++){//go through the hand
			if(cardArr[i].equals(c)){//check if the current card is what we are looking for
				d.addCard(cardArr[i]);//add to discard deck
				cardArr[i] = null;//set card's spot to null
				return true;//card was discarded
			}
		}
		return false;//card was not discarded
	}
	
	public Card[] getHand(){
		return cardArr;
	}
}
