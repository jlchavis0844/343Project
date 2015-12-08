package termProject;

import javax.swing.ImageIcon;

public class Card47 extends Card {

	public Card47() {
		super("PHIL 270",
				new int[]{5,0,0},//learning, craft, integrity
				new int[]{8},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card47.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeQP(5);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(20);
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
			retCA.setResult("and fails; teleport to the Milk Bar");
		}
		return retCA;
	}

}
