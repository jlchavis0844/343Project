package termProject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Color;
import javax.swing.border.*;


/**
 * Class to build players and player markers and provide a list of players
 * 
 * <p>
 * This class builds 3 hard coded players (Player) and then builds 3 hardcoded
 * player markers (JLabel). The players are then stored in an array of players
 * and the player makers are stored in an array of JLabels. These arrays are 
 * returned to GameView via getPlayerList and getMarkers. movePlayer
 * moves a player to a desired room
 * </p>
 * @author James
 *
 * <p>
 * Appended class with integer human and current to track the array index
 * of the human player and the current player in play. setNextPlayer increments
 * current to indicate the next player in the array's turn in the game.
 * </p>
 * @author Sylvia
 */
public class PlayerList {

	private Player players[];
	private JLabel pMarkers[];
	private JLabel playerMarker0;
	private JLabel playerMarker1;
	private JLabel playerMarker2;
	private int human; 
	private int current; 
	
	/**
	 * Default constructor for the PlayerList class
	 */
	public PlayerList(){
		players = new Player[3];//make an array 3 spaces long
		
		//make 3 players and store in array
		players[0] = new Player("James", 10,10,10);
		players[1] = new Player("Sylvia", 10,10,10);
		players[2] = new Player("Dr. Hoffman", 10,10,10);
		
		//Make 3 playerMarkers
		playerMarker0 = new JLabel("player1");
		playerMarker0.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/player1.jpg")));
		playerMarker0.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, null, null, null));
		playerMarker0.setBounds(800, 1375, 55, 60);
		
		playerMarker1 = new JLabel("player2");
		playerMarker1.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/player2.jpg")));
		playerMarker1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, null, null, null));;
		playerMarker1.setBounds(800, 1375+60, 53, 60);
		
		playerMarker2 = new JLabel("player3");
		playerMarker2.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/hoffman.jpg")));
		playerMarker2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, null));
		playerMarker2.setBounds(800, 1375+120, 48, 60);
		
		//load player markers into an array
		pMarkers = new JLabel[]{playerMarker0, playerMarker1, playerMarker2};
		
		//decide which player is the human
		human = (new Random()).nextInt(3);// random number 0-2
		
		//the human player goes first
		current = human;
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
	public void movePlayer(Player p, Room r){
		
		if( p.getPName()== "James"){//update location of the appropriate players label
			playerMarker0.setLocation(r.getX(),r.getY());
		} else if(p.getPName() == "Sylvia"){
			playerMarker1.setLocation(r.getX(),r.getY()+60);
		} else {
			playerMarker2.setLocation(r.getX(),r.getY()+120);
		}
		
		p.setRNumLocation(r.getRoomNum());//updates player room location
	}
	
	/**
	 * get array index of the player used as the user player
	 * @return human - Player of the human character
	 */
	public Player getHuman() {
		return players[human];
	}
	
	/**
	 * get array index of the current player in play
	 * @return current - Player that is the current Player
	 */
	public Player getCurrent() {
		return players[current];
	}

	/**
	 * set array index of the current player in play
	 * @param current - index of the current player in players[]
	 */
	public void setCurrent(int current) {
		this.current = current;
	}
	
	/**
	 * increment current, set to 0 if out of bounds of players[]
	 */
	public void setNextPlayer(){
		if(++current >= players.length) current = 0;//check if player index out of bounds, set to first if so
	}
	
}//end class
