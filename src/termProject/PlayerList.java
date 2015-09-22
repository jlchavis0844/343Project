package termProject;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.*;


/**
 * Class to build players and player markers and provide a list of players
 * 
 * <p>
 * This class builds 3 hard coded players (Player) and then builds 3 hardcoded
 * player markers (JLabel). The players are then stored in an array of players
 * and the player makers are stored in an array of JLabels. These arrays are 
 * returned to GameBoard via getPlayerList and getMarkers. movePlayer
 * moves a player to a desired room
 * </p>
 * @author James
 *
 */
public class PlayerList {

	Player players[];
	JLabel pMarkers[];
	JLabel playerMarker0;
	JLabel playerMarker1;
	JLabel playerMarker2;
	
	/**
	 * Default constructor for the PlayerList class
	 */
	public PlayerList(){
		players = new Player[3];//make an array 3 spaces long
		
		//make 3 players and store in array
		players[0] = new Player("James", 10,10,10);
		players[1] = new Player("Sylvia", 10,10,10);
		players[2] = new Player("Solidus", 10,10,10);
		
		//Make 3 playerMarkers
		playerMarker0 = new JLabel("player1");
		playerMarker0.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/graphics/player1.jpg")));
		playerMarker0.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, null, null, null));
		playerMarker0.setBounds(800, 1375, 55, 60);
		
		playerMarker1 = new JLabel("player2");
		playerMarker1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		playerMarker1.setForeground(Color.RED);
		playerMarker1.setBounds(800, 1375+60, 300, 30);
		
		playerMarker2 = new JLabel("player3");
		playerMarker2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		playerMarker2.setForeground(Color.RED);
		playerMarker2.setBounds(800, 1375+90, 300, 30);
		
		//load player markers into an array
		pMarkers = new JLabel[]{playerMarker0, playerMarker1, playerMarker2};
	}
	
	/**
	 * Returns an array that holds all the players
	 * 
	 * @return Player[] of all players
	 */
	public Player[] getPlayerList(){
		return players;
	}
	
	/**
	 * returns an array of all the player markers
	 * 
	 * @return Jlabel[] of all the playerMarkers
	 */
	public JLabel[] getMarkers(){
		return pMarkers;
	}
	
/**
 * moves a player to a room given the name of the room and the player
 * by relocating the player's label to the rooms coordinates
 * 
 * @param p Player to be moved
 * @param r Room to be moved to
 * @return the Room that the player was moved to
 */
	@SuppressWarnings("unchecked")
	public void movePlayer(Player p, Room r){
		
		if( p.getPName()== "James"){//update location of the appropriate players label
			playerMarker0.setLocation(r.getX(),r.getY());
		} else if(p.getPName() == "Sylvia"){
			playerMarker1.setLocation(r.getX(),r.getY()+60);
		} else {
			playerMarker2.setLocation(r.getX(),r.getY()+90);
		}
		
		p.setRNumLocation(r.getRoomNum());//updates player room location
	}
	
}//end class
