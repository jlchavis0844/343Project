package termProject;

import javax.swing.ImageIcon;

public class Card19 extends Card {
	
	public Card19() {
		super("Meet the Dean",//name
				new int[]{3,3,3},//learning, craft, integrity
				new int[]{12,15},1,//rooms you can play the card in
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card1.png")));		
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
