package termProject;

import javax.swing.ImageIcon;

public class Card45 extends Card {

	public Card45() {
		super("CECS 285",
				new int[]{0,0,5},//learning, craft, integrity
				new int[]{18},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card45.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeCraft(2);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//lose a game card
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
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails");
		}
		return retCA;
	}

}
