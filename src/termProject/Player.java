package termProject;


/**
 * Player in the game and its attributes
 * @param String playerName - identifies the player by name
 * @param learning - learning score
 * @param int craft - craft score
 * @param int integrity - integrity score
 * @param int qp - Quality Points score
 * @param int rNumLocation - room number location
 * @author Sylvia
 *v 1.0
 */
public class Player {
	private String playerName;
	private int learning;
	private int craft;
	private int integrity;
	private int qp;
	private int rNumLocation;
	
	/**
	 * constructor with name, learning, craft, and integrity of the player
	 * @param pName - player name
	 * @param learning - starting learning score
	 * @param craft - starting craft score
	 * @param integrity - starting integrity score
	 */
	public Player(String pName, int learning, int craft, int integrity){
		playerName = pName;
		this.learning = learning;
		this.craft = craft;
		this.integrity = integrity;
		qp = 0;
		rNumLocation = 17; // all players start the game at ECS308
	}
	
	/**
	 * set name of the player
	 * @param pName - player name
	 */
	public void setPName(String pName){
		playerName = pName;
	}
	
	/**
	 * set learning score
	 * @param learning - learning score
	 */
	public void setLearning(int learning){
		this.learning = learning;
	}
	
	/**
	 * set craft score
	 * @param craft - craft score
	 */
	public void setCraft(int craft){
		this.craft = craft;
	}
	
	/**
	 * set integrity score
	 * @param integrity - integrity score
	 */
	public void setIntegrity(int integrity){
		this.integrity = integrity;
	}
	
	/**
	 * set qp score
	 * @param qp - qp score
	 */
	public void setQP(int qp){
		this.qp = qp;
	}
	
	/**
	 * get player name
	 * @return playerName - player name
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
	 * @return craft - craft score
	 */
	public int getCraft(){
		return craft;
	}
	
	/**
	 * get integrity score
	 * @return integrity - integrity score
	 */
	public int getIntegrity(){
		return integrity;
	}
	
	/**
	 * get qp score
	 * @return qp - qp score
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

}
