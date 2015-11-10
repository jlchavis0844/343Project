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
	 * AI player moves to a random neighboring room 0-3 times
	 * and plays a card.
	 * @return Vector<String> describing AI choices
	 */
	public Vector<String> aiPlay(){
		Vector<String> consoleMsg = new Vector<>(); 
		Player tPlayer = pList.getCurrent(); 
		int moves = random(4); //how many moves the AI makes
		switch(moves){
			case 0:
				// play card in current room
				consoleMsg.add(aiPlayCard(tPlayer));
				break;
			case 1:
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(aiPlayCard(tPlayer));
				break;
			case 2:
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(aiPlayCard(tPlayer));
				break;
			case 3:
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(moveRandom(tPlayer));
				consoleMsg.add(aiPlayCard(tPlayer));
				break;
		}
		pList.setNextPlayer();
		return consoleMsg;
	}
	
	/**
	 * Iterate through the live deck to find a card
	 * where the AI room location satisfies the room prerequisite.
	 * If not found, play the last card in the deck.
	 * @return String message describing card action
	 */
	public String aiPlayCard(Player p){
		String message; 
		int currentRoom = p.getRNumLocation(); 
		Card currentCard = null; 
		
		for(int i = 0; i < liveDeck.getCardCount(); i++){ 
			currentCard = liveDeck.get(i);
			if(currentCard.roomCheck(currentRoom)){ 
				break;
			}
		}
		
		String playCard = currentCard.getName();
		String aiName = p.getPName();
		message = "AI player "+aiName+" plays "+playCard+"\n";
		
		//CardAction as a result from card play
		CardAction cAction = currentCard.play(p);	
		switch (cAction){
			case DISCARD:
				Card pCard = liveDeck.get(random(liveDeck.getCardCount()));
				liveDeck.discard(pCard, discardDeck);
				message += "AI player "+aiName+" discards "+pCard.getName()+"\n";
				break;	
			case DRAW:
				// nothing happens
				message += "AI player "+aiName+" draws a card\n";
				break;	
			case PICK:
				int choice = random(3);	
				if(choice == 0){ 
					p.changeIntegrity(1);
					message += "AI player "+aiName+" chooses Integrity Chip\n";
				}
				else if(choice == 1){
					p.changeCraft(1);
					message += "AI player "+aiName+" chooses Craft Chip\n";
				}
				else{ 
					p.changeLearning(1);
					message += "AI player "+aiName+" chooses Learning Chip\n";
				}
				break;
			case TELEPORT:
				Room tRoom = rList.find(p.getRNumLocation());
				pList.movePlayer(p, tRoom);
				message += "AI player " +aiName+" teleports to "+tRoom.getRoomName() + "\n";
				break;
			default:
				System.out.println("");
				break;
		}
		
		return message;
	}
	
	/**
	 * Move player to a random neighboring room
	 * @param p
	 * @return String describing AI movement
	 */
	public String moveRandom(Player p){
		int rIndex = p.getRNumLocation(); //room number of current room location
		String neighbors[] = rList.getNeighborNames(rIndex); //String array of neighbors list
		rIndex = random(neighbors.length); //random index of neighbor array
		Room tRoom = rList.find(neighbors[rIndex]); //save selected room
		p.move(tRoom.getRoomNum()); //move player to the selected room
		
		String message;
		message = "AI player "+p.getPName()+" moves to "+tRoom.getRoomName();
		return message;
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
		md.add(new Card01());
		md.add(new Card02());
		md.add(new Card03());
		md.add(new Card04());
		md.add(new Card05());
		md.add(new Card06());
		md.add(new Card07());
		md.add(new Card08());
		md.add(new Card09());
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
	
	/**
	 * get the deck of discarded cards
	 * 
	 */
	public Deck getDiscardDeck(){
		return discardDeck;
	}
	
	/**
	 * places the top card into given hand
	 * @param h hand to place the card in
	 */
	public void drawCard(Hand h){
		Card tempCard = liveDeck.get(random(liveDeck.getSize()));
		liveDeck.discard(tempCard, h);
	}
	
	/**
	 * returns the deck of currently available cards
	 * @return
	 */
	public Deck getLiveDeck(){
		return liveDeck;
	}
	
	public ArrayList<Card> getMasterDeck(){
		return masterDeck;
	}
}
