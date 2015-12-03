package termProject;


/**
 * Child class of Player
 * @author Sylvia
 *v 1.0
 */
public class AI extends Player{
	
	String type;
	
	public AI(String pName, int learning, int craft, int integrity){
		super(pName, learning, craft, integrity);
		type = "ai";
	}

	@Override
	public Hand getHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emptyHand() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
