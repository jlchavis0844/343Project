package termProject;

import javax.swing.ImageIcon;

public class Card01 extends Card {
	
	public Card01() {
		super("Meet the Dean",//name
				new int[]{3,3,3},//learning, craft, integrity
				new int[]{12,15},//rooms you can play the card in
				1, //year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card1.png")));//card Icon
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//draw extra game card
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//discard 1 game card
	}

	/**
	 * play function
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.DRAW;
			retCA.setResult("for 5 QP and 1 Game Card");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
	}
	
}
