package termProject;
/**
 * Enumerated class for the Chips in the game
 * Learning, Crafting, Integrity
 * toString() overloaded
 * @author James
 *
 */
public enum Chips{
	LEARNING("Learning"), CRAFTING("Crafting"), INTEGRITY("Integrity");
	
	private final String nameStr;//holds the string value
	
	//constructor
	Chips(String s){
		nameStr = s;//assign the string name
	}
	
	/**
	 * Overrides toString() for printing out 
	 */
	@Override
	public String toString(){
		return nameStr;
	}
}