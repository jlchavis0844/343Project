package termProject;

import javax.swing.ImageIcon;

public class Card29 extends Card {
	
	public Card29() {
		super("Loud Buzzing",
				new int[]{0,3,0},//learning, craft, integrity
				new int[]{18},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card29.png")));		
	}

	@Override
	public void rewards(Player p) {
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
			retCA = CardAction.PICK;
			retCA.setResult("for a Chip of choice");
		} else {
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
