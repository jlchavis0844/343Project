package termProject;

import javax.swing.ImageIcon;

public class Card50 extends Card{

	public Card50() {
		super("Spring Break",
				new int[]{5,5,5},//learning, craft, integrity
				new int[]{2},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card50.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//chip of choice
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
			retCA = CardAction.PICK;
			retCA.setResult("for 5 QP and a Chip of Choice");
		} else {
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}

}
