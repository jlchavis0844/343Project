package termProject;

import javax.swing.ImageIcon;

public class Card1 extends Card {
	
	public Card1() {
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
	
}
