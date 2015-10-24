package termProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JTextArea;


/**
 * Class that builds the model
 * <p>
 * consists of mostly the playerList and the RoomList.
 * </p>
 * @author James
 *
 */
public class GameModel {
	private PlayerList pList;//construct and contain all our players
	private RoomList rList;//construct and contain all the rooms
	private Deck liveDeck;
	private Deck discardDeck;
	private ArrayList<Card> masterDeck;

	/**
	 * Default constructor for the GameModel class
	 */
	public GameModel(){
		pList = new PlayerList();
		rList = new RoomList(21);
		liveDeck = new Deck();
		discardDeck = new Deck();
		
		//start building master deck
		masterDeck = new ArrayList<Card>();
		makeMasterDeck(masterDeck);
		
		//load current deck for the beginning of the game
		loadRound1(liveDeck);
		buildPlayerHand(pList.getHuman());	
	}

	/**
	 * @return the pList
	 */
	public PlayerList getpList() {
		return pList;
	}

	/**
	 * @param pList the pList to set
	 */
	public void setpList(PlayerList pList) {
		this.pList = pList;
	}

	/**
	 * @return the rList
	 */
	public RoomList getrList() {
		return rList;
	}

	/**
	 * @param rList the rList to set
	 */
	public void setrList(RoomList rList) {
		this.rList = rList;
	}
	
	/**
	 * AI player will either move to a random neighboring room or play card.
	 * The player can move up to 3 times and must end turn by playing card.
	 * @return String describing AI movement
	 */
	public Vector<String> aiPlay(){
		Vector<String> consoleMsg = new Vector<String>();
		String tempStr;
		int choice;
		int currentRNum;
		int numNeighbors;
		int neighborIndexChoice;
		int rNumChoice;
		
		whileLoop://labels the while loop as 'whileLoop'
		while(pList.getCurrent().getMoveCount() < 3){
			choice = random(2);//random number 0-1
			if(choice == 0){
				currentRNum = pList.getCurrent().getRNumLocation();//current room number
				numNeighbors = rList.getNeighborNames(currentRNum).length;//number of neighbors
				neighborIndexChoice = random(numNeighbors);//random index of neighbors[]
				rNumChoice = rList.getRoom(currentRNum).getNeighbor(neighborIndexChoice);//chosen room number
				pList.movePlayer(pList.getCurrent(), rList.getRoom(rNumChoice));//moves the player
				tempStr = "moving AI player "+pList.getCurrent().getPName() + " to " + rList.getRoom(rNumChoice).getRoomName();//store output message
				System.out.println(tempStr);//print to console
				consoleMsg.add(tempStr); //add to string vector
			}
			else{
				tempStr = "AI player "+pList.getCurrent().getPName() + " plays their card";
				System.out.println(tempStr);//print to console for tracking
				consoleMsg.add(tempStr);//stores console message
				//call playCard() method
				break whileLoop; // exit while loop after game card is played
			}
		}//end of whileLoop
		
	//TODO: Delete this once AI has been sorted after iteration #1
		if(pList.getCurrent().getMoveCount() == 3){//playCard() when out of moves
			tempStr = "AI player "+pList.getCurrent().getPName() + " plays their card";
			System.out.println(tempStr);//print to console for tracking
			consoleMsg.add(tempStr);//stores console message
			//call playCard() method
		}
		pList.setNextPlayer();//advance to next player
		
		return consoleMsg;
	}
	
	/**
	 * generate a random integer from 0 to (length-1)
	 * @param length - range of the random number
	 * @return random integer 
	 */
	public int random(int length){
		return (new Random()).nextInt(length);
	}
	
	/**
	 * refreshes the infoBox
	 * <p>
	 * calling this method updates all the player info for the infoBox in the GameView.
	 * This is called once in the main at the start of the program and after every AI turn
	 * </p>
	 * @param infoBox The JTextArea that holds the information of the players in the view
	 */
	public void updateInfo(JTextArea infoBox){
		Player tempArr[] = pList.getPlayerList();// holds all the players
		String tempStr; // holds the message to be out put
		
		infoBox.setText("\t\tLearning\tCraft\tIntegrity\tQuality Points\n");//header row
		for(Player p: tempArr){//Dr. Hoffman is too long for a double tab
			if (p.getPName() == "Dr. Hoffman"){//check if dr hoffman
			tempStr = p.getPName() + "\t";
			} else {
				tempStr = p.getPName() + "\t\t";
			}
			tempStr += p.getLearning() + "\t\t";//adds the various chips to the output message
			tempStr += p.getCraft() + "\t";
			tempStr += p.getIntegrity()+ "\t\t";
			tempStr += p.getQP() + "\n";
			infoBox.append(tempStr);//add message
			System.out.println(tempStr);//send to console
		}
		//additional info not really needed now
		infoBox.append("\nCards in Deck :" + liveDeck.getCardCount()+ "\t Discards out of play:" + discardDeck.getCardCount() + "\n");
		Player tPlay = pList.getHuman();
		rList.getRoom(tPlay.getRNumLocation()).getRoomName();
		tempStr = "You are " + tPlay.getPName();
		tempStr += " and you are in " + rList.getRoom(tPlay.getRNumLocation()).getRoomName();
		infoBox.append(tempStr);
		System.out.println(tempStr);
		
		
	}
	
	/**
	 * loads a certain block of cards from the master deck into given deck
	 * @param d Deck where the cards will be copied to
	 */
	public void loadRound1(Deck d){
	//round 1 will be the first 4 cards (0-3) for test purposes
		int key = 40; //easier to change later
		for (int i = 0; i < key; i++){
			d.addCard(masterDeck.get(i));//add index i to Deck d
		}
	}
	
	/**
	 * loads cards into the master deck, makes constructor cleaner
	 * @param md masterdeck to load into
	 */
	private void makeMasterDeck(ArrayList<Card> md){
		md.add(new Card1());
		md.add(new Card2());
		md.add(new Card3());
		md.add(new Card4());
		md.add(new Card5());
		md.add(new Card6());
		md.add(new Card7());
		md.add(new Card8());
		md.add(new Card9());
		md.add(new Card10());
		md.add(new Card11());
		md.add(new Card12());
		md.add(new Card13());
		md.add(new Card14());
		md.add(new Card15());
		md.add(new Card16());
		md.add(new Card17());
		md.add(new Card18());
		md.add(new Card19());
		md.add(new Card20());
		md.add(new Card21());
		md.add(new Card22());
		md.add(new Card23());
		md.add(new Card24());
		md.add(new Card25());
		md.add(new Card26());
		md.add(new Card27());
		md.add(new Card28());
		md.add(new Card29());
		md.add(new Card30());
		md.add(new Card31());
		md.add(new Card32());
		md.add(new Card33());
		md.add(new Card34());
		md.add(new Card35());
		md.add(new Card36());
		md.add(new Card37());
		md.add(new Card38());
		md.add(new Card39());
		md.add(new Card40());
	}
	
	/**
	 * builds a player's hand
	 * 
	 * <p>
	 * Takes 8 cards from the live deck at random index locations
	 * and places them into a player's hand using discard() method
	 * </p>
	 * @param p
	 */
	public void buildPlayerHand(Player p){
		Hand playerHand = p.getHand();//establish a temp hand
		Card tCard = null;//temp card
		boolean tBool;
		
		for(int i = 0; i < 5; i++){
			tCard = liveDeck.get(random(liveDeck.getSize()));//get a card from random index
			System.out.println("adding " + tCard.getName() + " to hand of " + p.getPName());//tracking
			tBool = liveDeck.discard(tCard,playerHand);//discard temp card from livedeck and add to hand
			System.out.println("adding card work? :" + tBool);
		}
		
	}
	
	public Deck getDiscardDeck(){
		return discardDeck;
	}
	
	
	public void drawCard(Hand h){
		Card tempCard = liveDeck.get(random(liveDeck.getSize()));
		liveDeck.discard(tempCard, h);
	}
	
	public Deck getLiveDeck(){
		return liveDeck;
	}
}
