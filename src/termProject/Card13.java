package termProject;

import javax.swing.ImageIcon;

public class Card13 extends Card {
	
	public Card13() {
		super("Parking Violation",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{6},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card13.png")));			
	}

	@Override
	public void rewards(Player p) {
		p.changeLearning(2);
		//discard 1 game card 
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
			retCA = CardAction.DISCARD;
			retCA.setResult("for 1 Learning Chip; discard a card for additional Learning Chip");
		}else{
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
