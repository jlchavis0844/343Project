package termProject;

import javax.swing.ImageIcon;

public class Card1 extends Card {
	
	public Card1() {
		super("Meet the Dean",
				new int[]{3,3,3},
				new int[]{12,15},1,
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card1.jpg")));		
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
