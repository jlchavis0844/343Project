package termProject;

import javax.swing.ImageIcon;

public class Card26 extends Card {
	
	public Card26() {
		super("A New Laptop",
				new int[]{0,0,4},//learning, craft, integrity
				new int[]{11},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card26.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(3);
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
		// TODO Auto-generated method stub
		return CardAction.NONE;
	}
	
}
