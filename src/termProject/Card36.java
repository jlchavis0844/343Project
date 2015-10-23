package termProject;

import javax.swing.ImageIcon;

public class Card36 extends Card {
	
	public Card36() {
		super("Learning Linux",
				new int[]{0,2,3},//learning, craft, integrity
				new int[]{11},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card36.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(3);
		//chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-1);
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		// TODO Auto-generated method stub
		return CardAction.NONE;
	}
	
}
