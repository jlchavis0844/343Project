package termProject;

import javax.swing.ImageIcon;

public class Card19 extends Card {
	
	public Card19() {
		super("KIN 253",
				new int[]{0,0,4},//learning, craft, integrity
				new int[]{0},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card19.png")));
				replaceable = true;
	}

	@Override
	public void rewards(Player p) {
		p.changeCraft(2);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(13);//teleport to RoR
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 2 Craft Chips");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Room of Retirement");
		}
		return retCA;
	}
	
}
