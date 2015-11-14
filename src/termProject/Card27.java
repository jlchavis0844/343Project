package termProject;

import javax.swing.ImageIcon;

public class Card27 extends Card {
	
	public Card27() {
		super("Program Crashes",
				new int[]{2,0,0},//learning, craft, integrity
				new int[]{20},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card27.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//discard game card
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.PICK;
			retCA.setResult("for 5 QP and a Chip of choice");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
	}
	
}
