package termProject;

import javax.swing.ImageIcon;

public class Card18 extends Card {
	
	public Card18() {
		super("Physics 151",
				new int[]{0,3,0},//learning, craft, integrity
				new int[]{17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card18.png")));			
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
	}

	@Override
	public void fail(Player p) {
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
