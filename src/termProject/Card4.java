package termProject;

import javax.swing.ImageIcon;

public class Card4 extends Card {
	
	public Card4() {
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
		//lose 1 card
		p.changeQP(-2);
	}
	
}
