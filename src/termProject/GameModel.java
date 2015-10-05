package termProject;

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
	
}
