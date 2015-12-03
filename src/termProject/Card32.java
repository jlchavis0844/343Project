package termProject;

import javax.swing.ImageIcon;

public class Card32 extends Card {
	
	public Card32() {
		super("Elective Class",
				new int[]{2,0,0},//learning, craft, integrity
				new int[]{7},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card32.png")));	
				replaceable = true;
	}

	@Override
	public void rewards(Player p) {
		p.changeLearning(1);
		//get card
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
			retCA = CardAction.DRAW;
			retCA.setResult("for 1 Learning Chip and 1 Game Card");
		} else {
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
