package termProject;

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
	
	public RoomList getRList(){
		return rList;
	}
}
