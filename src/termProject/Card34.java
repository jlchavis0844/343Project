package termProject;

import javax.swing.ImageIcon;

public class Card34 extends Card {
	
	public Card34() {
		super("Card 34",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{},//rooms you can play the card in
				0,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card34.png")));		
	}

	@Override
	public void rewards(Player p) {
		//p.changeQP(10);
	}

	@Override
	public void fail(Player p) {
		//lose 1 card
		p.changeQP(-2);
	}
	
}
