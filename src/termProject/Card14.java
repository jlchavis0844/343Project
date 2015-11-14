package termProject;

import javax.swing.ImageIcon;

public class Card14 extends Card {
	
	public Card14() {
		super("Buddy Up",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{0,18},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card14.png")));			
	}

	@Override
	public void rewards(Player p) {
		//reward is given in the play for this card
		//choice of learning or craft
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
			retCA.setExcluded("integrity");
			retCA.setResult("for 1 Learning Chip or 1 Craft Chip");
		}else{
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
