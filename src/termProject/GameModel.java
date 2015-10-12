package termProject;

import java.util.Random;
import java.util.Vector;

/**
 * Class that builds the model
 *<p>
 * consists of mostly the playerList and the RoomList.
 * @author James
 *
 */
public class GameModel {
	private PlayerList pList;//construct and contain all our players
	private RoomList rList;//construct and contain all the rooms
	
	/**
	 * Default constructor for the GameModel class
	 */
	public GameModel(){
		pList = new PlayerList();
		rList = new RoomList(21);
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
	
	public void playTurn(){
		//pList.getCurrent().startTurn();
	}
	
	public Vector<String> aiPlay(){
		Vector<String> consoleMsg = new Vector<String>();
		String tempStr;
		whileLoop://labels the while loop as 'whileLoop'
		while(pList.getCurrent().getMoveCount() < 3){
			int choice = random(2);//random number 0-1
			if(choice == 0){
				int currentRNum = pList.getCurrent().getRNumLocation();//current room number
				int numNeighbors = rList.getNeighborNames(currentRNum).length;//number of neighbors
				int neighborIndexChoice = random(numNeighbors);//random index of neighbors[]
				int rNumChoice = rList.getRoom(currentRNum).getNeighbor(neighborIndexChoice);//chosen room number
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
		}
	//TODO: Delete this once AI has been sorted after iteration #1
		if(pList.getCurrent().getMoveCount() == 3){//playCard() when out of moves
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
	
}
