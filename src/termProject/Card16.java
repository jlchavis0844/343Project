package termProject;

import javax.swing.ImageIcon;

public class Card16 extends Card {
	
	public Card16() {
		super("The Big Game",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{3},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card16.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeCraft(1);
		p.setRNumLocation(20);//teleport to lactation lounge 
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(20);//teleport to lactation lounge 
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		retCA = CardAction.TELEPORT;
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 1 Craft Chip and teleport to the Milk Bar");
		}else{
			fail(p);
			retCA.setResult("and fails; teleport to the Milk Bar");
		}
		return retCA;
	}
	
}
