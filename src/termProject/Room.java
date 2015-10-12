package termProject;

import java.awt.Point;

/**
 * Room that players can move to 
 * @param ArrayList<Integers> neighbors - array to hold list of neighbors
 * @param int roomNum - identifies specific rooms using a number
 * @param String roomName - Abstracted room identifier
 * @param int x starting room x location
 * @param int y starting room y location
 * @author James
 *v 1.0
 */
public class Room {
	private int[] neighbors;
	private int roomNum;
	private String roomName;
	private int x;
	private int y;

	/**
	 * constructor with location, name, and number for the room
	 * @param x, y - location on GameView
	 * @param rName - name of the room
	 * @param rNum - number of the room
	 */
	public Room(int x, int y, String rName, int rNum){
		this.x = x;
		this.y = y;
		roomName = rName;
		roomNum = rNum;
	}
	
	/**
	 * set name of room
	 * @param rName - room name
	 */
	public void setRName(String rName){
		roomName = rName;
	}
	
	/**
	 * set room number
	 * @param rNum - room number
	 */
	public void setRNum(int rNum){
		roomNum = rNum;
	}
	
	/**
	 * get room name
	 * @return roomName - room name
	 */
	public String getRoomName(){
		return roomName;
	}
	
	/**
	 * get room number
	 * @return roomNum - room number
	 */
	public int getRoomNum(){
		return roomNum;
	}
	
	/**
	 * add neighbor room numbers to ArrayList
	 * @param nRooms[] - array of neighbors room number
	 */
	public void addNeighbor(int nRooms[]){
		neighbors = nRooms;
	}
	
	/**
	 * get neighbor room numbers
	 * @return neighbors - int[] of neighbors room number
	 */
	public int[] getNeighbors(){
		return neighbors;
	}
	
	/**
	 * get neighbor room number of a given index
	 * @param nIndex - index of neighbors[]
	 * @return room number of the neighbor 
	 */
	public int getNeighbor(int nIndex){
		return neighbors[nIndex];
	}
	
	/**
	 * get x location
	 * @return x - x coordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * get y location
	 * @return y - y coordinate
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * set location 
	 * @param p - x and y coordinate
	 */
	public void setLocation(Point p){
		x = (int)p.getX();
		y = (int)p.getY();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + roomNum;
		return result;
	}

	/**
	 * Eclipse generated equals method for comparing rooms
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		if (roomNum != other.roomNum)
			return false;
		return true;
	}
}//end class
