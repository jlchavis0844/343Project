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
		masterDeck.add(new Card1());
		masterDeck.add(new Card2());
		masterDeck.add(new Card3());
		masterDeck.add(new Card4());
		/*
		masterDeck.add(new Card5());
		masterDeck.add(new Card6());
		masterDeck.add(new Card7());
		masterDeck.add(new Card8());
		masterDeck.add(new Card9());
		masterDeck.add(new Card10());
		*/
		
		//load current deck for the beginning of the game
		loadRound1(liveDeck);
				
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
		infoBox.append("\nCards in Deck :" + "\t Discards out of play: \n");
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
		int key = 0; //easier to change later
		for (int i = 0; i < key; i++){
			d.addCard(masterDeck.get(i));//add index i to Deck d
		}
	}
}
