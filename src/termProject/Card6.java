package termProject;

import javax.swing.ImageIcon;

public class Card6 extends Card {
	
	public Card6() {
		super("Math 122",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{7},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card6.png")));		
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
