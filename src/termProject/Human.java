package termProject;


/**
 * Child class of Player
 * @author Sylvia
 *v 1.0
 */
public class Human extends Player{
	
	String type;
	
	public Human(String pName, int learning, int craft, int integrity){
		super(pName, learning, craft, integrity);
		type = "human";
	}
	
	public void startTurn(){
		
	}
	
	
}
