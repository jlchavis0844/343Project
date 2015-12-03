package termProject;

import java.util.ArrayList;//masterDeck
import java.util.Random;//for Random #
import java.util.Vector;//return string vector

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
	private Deck liveDeck;//curent playable cards
	private Deck discardDeck;//discarded(already played cards)
	private ArrayList<Card> masterDeck;//everycard

	/**
	 * Default constructor for the GameModel class
	 */
	public GameModel(){
		pList = new PlayerList();//make a list of players - pList
		rList = new RoomList(21);//make a list of rooms - rList
		liveDeck = new Deck();//for the current cards
		discardDeck = new Deck();//used cards
		
		//start building master deck
		masterDeck = new ArrayList<Card>();//all cards
		makeMasterDeck(masterDeck);//load all cards
		
		//load current deck for the beginning of the game
		loadRound1(liveDeck);
		buildPlayerHand(pList.getHuman());//load cards into players hand
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
		checkDeck();//make sure there are cards in live deck
		Vector<String> consoleMsg = new Vector<>(); //for printing to the console.
		Player tPlayer = pList.getCurrent(); //for tracking
		int moves = random(4); //how many moves the AI makes
		//determine how many moves before playing card
		switch(moves){
			case 0:
				// play card in current room
				consoleMsg.add(aiPlayCard(tPlayer));
				break;
			case 1:
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(aiPlayCard(tPlayer));//play card
				break;
			case 2:
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(aiPlayCard(tPlayer));//play card
				break;
			case 3:
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(moveRandom(tPlayer));//move once
				consoleMsg.add(aiPlayCard(tPlayer));//play card
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
		String message;//message to print to console
		String playCard;//name of the card played
		String aiName;//name of the ai player
		String result;//result of playing the card
		int currentRoom = p.getRNumLocation();//room number of the current location 
		Card currentCard = null; 
		
		//find a card in the liveDeck that satisfies room prereq
		for(int i = 0; i < liveDeck.getCardCount(); i++){ 
			currentCard = liveDeck.get(i);
			if(currentCard.roomCheck(currentRoom)){ 
				break;
			}
		}
		
		CardAction cAction = currentCard.play(p);//CardAction as a result from card play
		liveDeck.discard(currentCard, discardDeck);//remove the played card from the liveDeck
		
		playCard = currentCard.getName();//name of the card played
		aiName = p.getPName();//name of the ai player
		result = cAction.getResult();//result of playing the card
		message = "AI player "+aiName+" plays "+playCard+" "+result;
		
		switch (cAction){
			case DISCARD:
				Card pCard = liveDeck.get(random(liveDeck.getCardCount()));//select a random card from the deck
				liveDeck.discard(pCard, discardDeck);//discard the random card
				message += "\nAI player "+aiName+" discards "+pCard.getName();
				break;	
			case DRAW:
				// nothing happens
				message += "\nAI player "+aiName+" draws a card";
				break;
			case DRAW2:
				// nothing happens
				message += "\nAI player "+aiName+" draws 2 cards";
				break;	
			case PICK:
				if(cAction.getExcluded()==null){ //choice of 3 chips
					int choice = random(3);	//random number 0-2
					if(choice == 0){ 
						p.changeIntegrity(1);
						message += "\nAI player "+aiName+" chooses Integrity Chip";
					}
					else if(choice == 1){
						p.changeCraft(1);
						message += "\nAI player "+aiName+" chooses Craft Chip";
					}
					else{ 
						p.changeLearning(1);
						message += "\nAI player "+aiName+" chooses Learning Chip";
					}
				} else { //choice of 2 chips
					int choice = random(2); //random number 0-1
					if(cAction.getExcluded()=="integrity"){ //craft or learning
						if(choice==0){
							p.changeCraft(1);
							message += "\nAI player "+aiName+" chooses Craft Chip";
						} else {
							p.changeLearning(1);
							message += "\nAI player "+aiName+" chooses Learning Chip";
						}
					}
					else if(cAction.getExcluded()=="craft"){ //integrity or learning
						if(choice==0){
							p.changeIntegrity(1);
							message += "\nAI player "+aiName+" chooses Integrity Chip";
						} else {
							p.changeLearning(1);
							message += "\nAI player "+aiName+" chooses Learning Chip";
						}
					}
					else{ //integrity or craft
						if(choice==0){
							p.changeIntegrity(1);
							message += "\nAI player "+aiName+" chooses Integrity Chip";
						} else {
							p.changeCraft(1);
							message += "\nAI player "+aiName+" chooses Craft Chip";
						}
					}
				}
				break;
			case TELEPORT:
				Room tRoom = rList.find(p.getRNumLocation());
				pList.movePlayer(p, tRoom);
				message += "\nAI player " +aiName+" teleports to "+tRoom.getRoomName();
				break;
			default:
				System.out.println("");
				break;
		}
		cAction.setExcluded(null);//reset excluded chip
		cAction = null;//reset cardAction after the card is played
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
		//p.move(tRoom.getRoomNum()); //move player to the selected room
		pList.movePlayer(p, tRoom);//moves AI player to tRoom
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
		//load all year one cards from master deck into d
		for(int i = 0; i < masterDeck.size(); i++){
			if(masterDeck.get(i).getYear() == 1){
				d.addCard(masterDeck.get(i));
			}
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
		md.add(new Card41());
		md.add(new Card42());
		md.add(new Card43());
		md.add(new Card44());
		md.add(new Card45());
		md.add(new Card46());
		md.add(new Card47());
		md.add(new Card48());
		md.add(new Card49());
		md.add(new Card50());
		md.add(new Card51());
		md.add(new Card52());
	}
	
	/**
	 * builds a player's hand
	 * 
	 * <p>
	 * Takes 5 cards from the live deck at random index locations
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
	
	/**
	 * Check if the liveDeck is empty. If so, take the cards from
	 * discardDeck and reshuffle. Set liveDeck to a new empty Deck.
	 */
	public void checkDeck(){
		if(liveDeck.getSize() == 0){
			liveDeck = discardDeck;
			liveDeck.shuffle();
			discardDeck = new Deck();
			System.out.println("reloading decks\n");
		}
	}
	
	/**
	 * Check if the total QP of all players has reached 60.
	 * If Round 1 is complete, empty the liveDeck, discardDeck,
	 * and human player's hand; start Round 2.
	 */
	public void checkRound1(){
		if(pList.getTotalQP() >= 60){
			liveDeck = new Deck();
			discardDeck = new Deck();
			pList.getHuman().emptyHand();
			loadRound2(liveDeck);
		}
		
	}
	
	/**
	 * Load Round 2 cards to liveDeck and new hand to human player
	 */
	public void loadRound2(Deck d){
		for (int i = 0; i < masterDeck.size(); i++){
			if(!masterDeck.get(i).isReplaceable()){
				d.addCard(masterDeck.get(i));//add index i to Deck d
			}
		}
		buildPlayerHand(pList.getHuman());//load cards into players hand	
	}
	
}
