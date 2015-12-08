package termProject;

import javax.swing.ImageIcon;

public class Card43 extends Card{

	public Card43() {
		super("CECS 277",
				new int[]{0,5,0},//learning, craft, integrity
				new int[]{17},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card43.png")));
	}
	
	@Override
	public void rewards(Player p) {
		p.changeIntegrity(2);
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
			retCA.setResult("for 2 Integrity Chips");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Forbidden Parking");
		}
		return retCA;
	}


}
