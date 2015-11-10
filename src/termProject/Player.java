package termProject;


/**
 * Player in the game and its attributes
 * @author Sylvia
 *v 1.0
 */
public abstract class Player {
	private String playerName;
	private int learning;
	private int craft;
	private int integrity;
	private int qp;
	private int rNumLocation;
	private int moveCount;
	
	/**
	 * constructor with name, learning, craft, and integrity of the player
	 * @param pName - player name
	 * @param learning - starting learning score
	 * @param craft - starting craft score
	 * @param integrity - starting integrity score
	 */
	public Player(String playerName, int learning, int craft, int integrity){
		this.playerName = playerName;
		this.learning = learning;
		this.craft = craft;
		this.integrity = integrity;
		qp = 0;
		rNumLocation = 17; // all players start the game at ECS308
		moveCount = 0;
	}
	
	/**
	 * set name of the player
	 * @param playerName
	 */
	public void setPName(String playerName){
		this.playerName = playerName;
	}
	
	/**
	 * change the player's learning score
	 * @param learning - a positive or negative learning will be added to learning
	 */
	public void changeLearning(int learning){
		this.learning += learning;
	}
	
	/**
	 * change the player's craft score
	 * @param craft - a positive or negative craft will be added to craft
	 */
	public void changeCraft(int craft){
		this.craft += craft;
	}
	
	/**
	 * change the player's integrity score
	 * @param integrity - a positive or negative value will be added to integrity
	 */
	public void changeIntegrity(int integrity){
		this.integrity += integrity;
	}
	
	/**
	 * change the player's qp score
	 * @param qp - a positive or negative value will be added to qp
	 */
	public void changeQP(int qp){
		this.qp += qp;
		if(this.qp < 0){
			this.qp = 0;
		}
	}
	
	/**
	 * get player name
	 * @return playerName 
	 */
	public String getPName(){
		return playerName;
	}
	
	/**
	 * get learning score
	 * @return learning - learning score
	 */
	public int getLearning(){
		return learning;
	}
	
	/**
	 * get craft score
	 * @return craft 
	 */
	public int getCraft(){
		return craft;
	}
	
	/**
	 * get integrity score
	 * @return integrity 
	 */
	public int getIntegrity(){
		return integrity;
	}
	
	/**
	 * get qp score
	 * @return qp 
	 */
	public int getQP(){
		return qp;
	}
	
	/**
	 * set location 
	 * @param rNum - room number
	 */
	public void setRNumLocation(int rNum){
		rNumLocation = rNum;
	}
	
	/**
	 * get location
	 * @return rNumLocation - room location
	 */
	public int getRNumLocation(){
		return rNumLocation;
	}
	
	/**
	 * get moveCount
	 * @return moveCount - number of moves made during the player's turn
	 */
	public int getMoveCount(){
		return moveCount;
	}
	
	/**
	 * reset moveCount to 0
	 */
	public void resetMoveCount(){ 
		moveCount = 0;
	}
	
	/**
	 * moves the player to a given room number and increments moveCount
	 * @param room - the room to be moved to
	 */
	public void move(int room){
		rNumLocation = room;
		moveCount++;
	}

	public abstract Hand getHand();
}
