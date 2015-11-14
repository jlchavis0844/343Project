package termProject;

import javax.swing.ImageIcon;

public class Card28 extends Card {
	
	public Card28() {
		super("Press the Right Floor",
				new int[]{4,0,0},//learning, craft, integrity
				new int[]{16},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card28.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeCraft(2);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
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
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
