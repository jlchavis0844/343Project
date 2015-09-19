package termProject;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Room that players can move to 
 * @param ArrayList<Integers> neighbors - array to hold list of neighbors
 * @param int roomNum - identifies specific rooms using a number
 * @param int String roomName - Abstracted room identifier
 * @param int x starting room x location
 * @param int y starting room y location
 * @author James
 *v 1.0
 */
public class Room {
	private ArrayList<Integer> neighbors;
	private int roomNum;
	private String roomName;
	private int x;
	private int y;

	/**
	 * constructor with name and number for the room
	 * @param rName - name of the rooms
	 * @param rNum - number of the room
	 */
	public Room(int x, int y, String rName, int rNum){
		this.x = x;
		this.y = y;
		roomName = rName;
		roomNum = rNum;
		neighbors = new ArrayList<Integer>();
	}
	
	/**
	 * set name of room
	 * @param rName - room name
	 */
	public void setRName(String rName){
		roomName = rName;
	}
	
	public void setRNum(int rNum){
		roomNum = rNum;
	}
	
	public int getRoomNum(){
		return roomNum;
	}
	
	public void addNeighbor(int nRooms[]){
		neighbors.clear();
		for (int i: nRooms){
			neighbors.add(i);
		}
	}
	
	public String getRoomName(){
		return roomName;
	}
	
	public ArrayList<Integer> getNeighbors(){
		return neighbors;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setLocation(Point p){
		x = (int)p.getX();
		y = (int)p.getY();
	}
}//end class
