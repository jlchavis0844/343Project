package termProject;

import javax.swing.ImageIcon;

public class Card05 extends Card {
	
	public Card05() {
		super("CECS 105",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{14,17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card5.png")));	
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

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
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
