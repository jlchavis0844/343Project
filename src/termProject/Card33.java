package termProject;

import javax.swing.ImageIcon;

public class Card33 extends Card {
	
	public Card33() {
		super("Professor Hoffman",
				new int[]{3,0,0},//learning, craft, integrity
				new int[]{11,12,13,14,15,16,17,18,19},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card33.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//get 2 cards
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-5);
		//teleport to Milk Bar
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.DRAW2;
			retCA.setResult("for 5 QP and 2 Game Cards");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("Failed, teleporting to milk bar");
			p.setRNumLocation(20);//to the milk bar!
		}
		return retCA;
	}
	
}
