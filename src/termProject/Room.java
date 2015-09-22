package termProject;

import java.awt.Point;
import java.util.ArrayList;

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
	 * @param x, y - location on GameBoard
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
}//end class
