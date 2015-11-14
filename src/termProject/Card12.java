package termProject;

import javax.swing.ImageIcon;

public class Card12 extends Card {
	
	public Card12() {
		super("Enjoying the Peace",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{1},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card12.png")));			
	}

	@Override
	public void rewards(Player p) {
		//reward is given in the play for this card
		//choice of learning or integrity
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
			retCA.setExcluded("craft");
			retCA.setResult("for 1 Learning Chip or 1 Craft Chip");
		}else{
			fail(p);
			retCA.setResult("and fails");	
		}
		return retCA;
	}
	
}
