package termProject;

import javax.swing.ImageIcon;

public class Card34 extends Card {
	
	public Card34() {
		super("Oral Communication",
				new int[]{0,0,4},//learning, craft, integrity
				new int[]{2,3,5,7,8,9},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card34.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(4);
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
			retCA.setResult("thes 4 QP and a chip of choice");
		} else {
			fail(p);
			retCA = CardAction.DISCARD;
			retCA.setResult("failed");
		}
		return retCA;
	}
	
}
