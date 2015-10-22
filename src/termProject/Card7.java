package termProject;

import javax.swing.ImageIcon;

public class Card7 extends Card {
	
	public Card7() {
		super("Lunch at Bratwurst Hall",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{9},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card7.png")));		
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
