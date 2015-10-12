package termProject;

/**
 * creates an array of rooms that will be used by the controller
 * @author James
 * version MVC 1.0
 */
public class RoomList {
	
	Room[] rList;//the array of rooms

	/**
	 * constructor that creates the array of rooms
	 * @param SIZE the size of the array
	 */
	public RoomList(int SIZE){
		rList = new Room[SIZE];//make an array
		
		rList[0] = new Room(50, 50,"George Allen Field",0);//makes the room
		rList[0].addNeighbor(new int[]{1,3,5,4});//loads the neighbors to the room
		rList[1] = new Room(440, 30,"Japanese Garden",1);
		rList[1].addNeighbor(new int[]{0,3,2});
		rList[2] = new Room(1025, 80,"Student Parking",2);
		rList[2].addNeighbor(new int[]{1,3,5});
		rList[3]  = new Room(420, 270, "The Pyramid",3);
		rList[3].addNeighbor(new int[]{0,1,2});
		rList[4]  = new Room(40, 750, "West Walkway",4);
		rList[4].addNeighbor(new int[]{5,12,7});
		rList[5]  = new Room(450, 565,"Rec Center",5);
		rList[5].addNeighbor(new int[]{4,3,0});
		rList[6]  = new Room(1045, 585,"Forbidden Parking",6);
		rList[6].addNeighbor(new int[]{2,5,10});
		rList[7]  = new Room(20, 1720,"Library",7);
		rList[7].addNeighbor(new int[]{8,4});
		rList[8]  = new Room(480, 1780,"LA 5",8);
		rList[8].addNeighbor(new int[]{7,9});
		rList[9]  = new Room(1160, 1670, "Bratwurst Hall",9);
		rList[9].addNeighbor(new int[]{10,8});
		rList[10]  = new Room(1450, 963,"East Walkway",10);
		rList[10].addNeighbor(new int[]{15,9});
		rList[11]  = new Room(170, 875, "Computer Lab",11);
		rList[11].addNeighbor(new int[]{12});
		rList[12]  = new Room(165, 1140,"North Hall",12);
		rList[12].addNeighbor(new int[]{4,11,13,14,16,15});
		rList[13]  = new Room(175, 1330, "Room of Retirement",13);
		rList[13].addNeighbor(new int[]{12});
		rList[14]  = new Room(590, 910,"ECS 302",14);
		rList[14].addNeighbor(new int[]{12});
		rList[15]  = new Room(820, 1150,"South Hall",15);
		rList[15].addNeighbor(new int[]{14,18,19,10,20,17,12});
		rList[16]  = new Room(590, 1390, "Elevators",16);
		rList[16].addNeighbor(new int[]{12});
		rList[17]  = new Room(800, 1375,"ECS 308",17);
		rList[17].addNeighbor(new int[]{15});
		rList[18]  = new Room(1020, 875, "EAT Club",18);
		rList[18].addNeighbor(new int[]{15});
		rList[19]  = new Room(1240, 870, "Conference Room",19);
		rList[19].addNeighbor(new int[]{15});
		rList[20]  = new Room(1200, 1390, "Lactation Lounge",20);
		rList[20].addNeighbor(new int[]{15});
	}
	
	/**
	 * Returns the array of rooms
	 * @return rList an array of rooms
	 */
	public Room[] getRList(){
		return rList;
	}
	
	/**
	 * Returns a room of a given index
	 * @param rIndex - index of rList
	 * @return Room at the index
	 */
	public Room getRoom(int rIndex){
		return rList[rIndex];
	}
	
	
	/**
	 * find and returns a room that matches the given room number
	 * <p>
	 * if no room match is found, it will return ECS 308
	 * </p>
	 * @param n the room number to match to
	 * @return Room that matches the given room number
	 */
	public Room find(int n){
		Room temp = rList[17];//set default room
		for(Room r: rList){//go through array
			if(r.getRoomNum() == n){//if a match is found
				temp = r;//update the temp room
				break;//stop checking since match is found
			}
		}
		return temp;//return room
	}
	
	
	/**
	 * find and returns a room that matches the given room name
	 * <p>
	 * if no room match is found, it will return the info for ECS 308
	 * </p>
	 * @param s the room name to match to
	 * @return Room that matches the given room name
	 */
	public Room find(String s){
		Room temp = rList[17];//sets default room
		for(Room r: rList){//loop through entire array
			if(r.getRoomName() == s){//if a match is found
				temp = r;//update the temp room
				break;//stop checking since match is found
			}
		}
		return temp;
	}
	
	
	/**
	 * takes a string and returns an array of strings of neighbors names
	 * 
	 * @param s String of the room name you want the neighbors for
	 * @return String[] an array of neighboring room names
	 */
	public String[] getNeighborNames(String s){

		int nList[] = find(s).getNeighbors();//load neighbors into this array
		String nNames[] = new String[nList.length];
		
		//find matches between name and numbers
		for(int i = 0; i < nList.length; i++){
			for(int j = 0; j < rList.length; j++){
				if (rList[j].getRoomNum() == nList[i]){
					nNames[i] = rList[j].getRoomName();
				}//end if statement
			}//end inner for loop
		}//end out for loop
		
		return nNames;
	}//end getNames

	/**
	 * takes a string and returns an array of strings of neighbors names
	 * 
	 * @param s String of the room name you want the neighbors for
	 * @return String[] an array of neighboring room names
	 */
	public String[] getNeighborNames(int rIndex){
		
		int nList[] = find(rIndex).getNeighbors();//load neighbors into this array
		String nNames[] = new String[nList.length];
		
		//find matches between name and numbers
		for(int i = 0; i < nList.length; i++){
			for(int j = 0; j < rList.length; j++){
				if (rList[j].getRoomNum() == nList[i]){
					nNames[i] = rList[j].getRoomName();
				}//end if statement
			}//end inner for loop
		}//end out for loop
		
		return nNames;
	}//end getNames
	
	public String[] getNeighborNames(Room r){
		
		int nList[] = r.getNeighbors();//load neighbors into this array
		String nNames[] = new String[nList.length];
		
		//find matches between name and numbers
		for(int i = 0; i < nList.length; i++){
			for(int j = 0; j < rList.length; j++){
				if (rList[j].getRoomNum() == nList[i]){
					nNames[i] = rList[j].getRoomName();
				}//end if statement
			}//end inner for loop
		}//end out for loop
		
		return nNames;
	}
}//end class
