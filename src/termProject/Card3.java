package termProject;

import javax.swing.ImageIcon;

public class Card3 extends Card {
	
	public Card3() {
		super("The Outpost",
				new int[]{},//learning, craft, integrity
				new int[]{0,1,2,3,4,5,7,8,9,10},//rooms you can play the card in
				1, //year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card3.png")));		
	}

	@Override
	public void rewards(Player p) {
		//choose chip
		//p.changeQP(1);
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
		// TODO Auto-generated method stub
		return CardAction.NONE;
	}
	
}
