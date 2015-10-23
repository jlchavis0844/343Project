package termProject;

import javax.swing.ImageIcon;

/**
 * Card abstract class and attributes
 * @author Sylvia
 *
 */
public abstract class Card {
	private String name;
	private int prereqSkill[]; //holds the skill prerequisites [learning,craft,integrity]
	private int prereqRoom[]; //holds the room prerequisites as room numbers
	private int year; //year in which the card is played
	private ImageIcon img; //card image
	
	/**
	 * Constructor with name, skill prerequisites, room prerequisites, and year
	 * <p>
	 * pass an array for the prereq skills in the following order
	 * learning, craft, integrity. This will be standard for all cards
	 * </p>
	 * @param String name - identifies card
	 * @param int prereqSkill[] - array of skill prerequisites L, C, I
	 * @param int prereqRoom[] - array of room prerequisites
	 * @param year - year in which the card is played
	 */
	Card(String n, int ps[], int pr[], int y, ImageIcon i){
		name = n;
		prereqSkill = ps;
		prereqRoom = pr;
		year = y;
		img = i;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prereqSkill
	 */
	public int[] getPrereqSkill() {
		return prereqSkill;
	}

	/**
	 * @param prereqSkill the prereqSkill to set
	 */
	public void setPrereqSkill(int[] prereqSkill) {
		this.prereqSkill = prereqSkill;
	}

	/**
	 * @return the prereqRoom
	 */
	public int[] getPrereqRoom() {
		return prereqRoom;
	}

	/**
	 * @param prereqRoom the prereqRoom to set
	 */
	public void setPrereqRoom(int[] prereqRoom) {
		this.prereqRoom = prereqRoom;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @return the icon image
	 */
	public ImageIcon getImg() {
		return img;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * abstract class to add to player attributes
	 * @param the player that plays the card
	 */
	public abstract void rewards(Player p);

	/**
	 * abstract class to deduct from player attributes
	 * @param the player that plays the card 
	 */
	public abstract void fail(Player p);
	
	/**
	 * causes the playing of the card and other stuff
	 * @param p the player playing the card
	 * @return if any card action is to be taken
	 */
	public abstract CardAction play(Player p);
	
}
