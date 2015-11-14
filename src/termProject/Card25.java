package termProject;

import javax.swing.ImageIcon;

public class Card25 extends Card {
	
	public Card25() {
		super("Fall in the Pond",
				new int[]{3,0,0},//learning, craft, integrity
				new int[]{1},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card25.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeIntegrity(1);
		p.changeCraft(1);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(20);//teleport to Milk Bar
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 1 Integrity Chip and 1 Craft Chip");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Milk Bar");
		}
		return retCA;
	}
	
}
