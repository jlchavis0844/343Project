package termProject;

import javax.swing.ImageIcon;

public class Card30 extends Card {
	
	public Card30() {
		super("Professor Englert",
				new int[]{0,0,3},//learning, craft, integrity
				new int[]{19},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card30.png")));		
	}

	@Override
	public void rewards(Player p) {
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//lose 1 card
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			retCA = CardAction.PICK;
			retCA.setResult("for a Chip of choice");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
	}
	
}
