package termProject;

import javax.swing.ImageIcon;

public class Card37 extends Card {
	
	public Card37() {
		super("Make a Friend",
				new int[]{0,0,2},//learning, craft, integrity
				new int[]{12,15},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card37.png")));
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(3);
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		//lose 1 card
		p.changeQP(-2);
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.PICK;
			retCA.setResult("and gets 3 QP and a choice of chip");
		} else {
			retCA = CardAction.DISCARD;
			retCA.setResult("failed");
			fail(p);
		}
		return retCA;
	}
}
