package termProject;

import javax.swing.ImageIcon;

public class Card17 extends Card {
	
	public Card17() {
		super("Math 123",
				new int[]{5,0,0},//learning, craft, integrity
				new int[]{14,17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card17.png")));			
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(3);
	}

	@Override
	public void fail(Player p) {
		//lose 1 card
		p.changeQP(-3);
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
