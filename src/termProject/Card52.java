package termProject;

import javax.swing.ImageIcon;

public class Card52 extends Card {

	public Card52() {
		super("Linux Crashed",
				new int[]{0,5,0},//learning, craft, integrity
				new int[]{11},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card52.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//lose game card
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.PICK;
			retCA.setResult("for 5 QP and a Chip of Choice");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails");
		}
		return retCA;
	}

}
