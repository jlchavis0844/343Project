package termProject;

import java.util.ArrayList;

/**
 * Room that players can move to 
 * @params ArrayList<Integers> neighbors - array to hold list of neighbors
 * @params int roomNum - identifies specific rooms using a number
 * @params int String roomName - Abstracted room identifier
 * @author James
 *v 1.0
 */
public class Room {
	private ArrayList<Integer> neighbors;
	private int roomNum;
	private String roomName;

	/**
	 * constructor with name and number for the room
	 * @param rName - name of the rooms
	 * @param rNum - number of the room
	 */
	public Room(String rName, int rNum){
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
		for (int i = 0; i < nRooms.length; i++){
			neighbors.add(nRooms[i]);
		}
	}
	
	public String getRoomName(){
		return roomName;
	}
	
	public ArrayList<Integer> getNeighbors(){
		return neighbors;
	}
	
	
	
}//end class
