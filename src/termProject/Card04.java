package termProject;

import javax.swing.ImageIcon;

public class Card04 extends Card {
	
	public Card04() {
		super("Goodbye, Professor",
				new int[]{6,6,6},//learning, craft, integrity
				new int[]{13},//rooms you can play the card in
				1, //year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card4.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(10);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//lose 1 card
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 10 QP");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
		
	}
	
}
