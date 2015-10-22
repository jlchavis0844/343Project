package termProject;

import javax.swing.ImageIcon;

public class Card8 extends Card {
	
	public Card8() {
		super("Research Compilers",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{7},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card8.png")));		
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
