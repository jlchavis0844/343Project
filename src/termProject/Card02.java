package termProject;

import javax.swing.ImageIcon;

public class Card02 extends Card {
	

	public Card02() {
		super("CECS 100",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{14,17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card2.png")));
				replaceable = true;
	}

	@Override
	public void rewards(Player p) {
		p.changeLearning(1);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
	}

	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 1 Learning Chip");
		} else {
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
}
	
