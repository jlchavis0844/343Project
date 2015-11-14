package termProject;

import javax.swing.ImageIcon;

public class Card26 extends Card {
	
	public Card26() {
		super("A New Laptop",
				new int[]{0,0,4},//learning, craft, integrity
				new int[]{11},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card26.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(3);
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//discard a game card
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.PICK;
			retCA.setResult("for 3 QP and a Chip of choice");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
	}
	
}
