package termProject;

import javax.swing.ImageIcon;

public class Card02 extends Card {
	

	public Card02() {
		super("CECS 100",
				new int[]{},//learning, craft, integrity
				new int[]{14,17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card2.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(1);
		p.changeLearning(1);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
	}

	public CardAction play(Player p) {
		
		if(p.getRNumLocation() != 14 && p.getRNumLocation() != 17){
			fail(p);
		} else rewards(p);
		return CardAction.NONE;
	}
}
	
