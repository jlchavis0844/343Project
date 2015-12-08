package termProject;

import javax.swing.ImageIcon;

public class Card48 extends Card {

	public Card48() {
		super("ENGL 317",
				new int[]{0,5,0},//learning, craft, integrity
				new int[]{8},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card48.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeQP(5);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(6);
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 5 QP");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Forbidden Parking");
		}
		return retCA;
	}

}
