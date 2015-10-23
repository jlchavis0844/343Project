package termProject;

import javax.swing.ImageIcon;

public class Card19 extends Card {
	
	public Card19() {
		super("KIN 253",
				new int[]{0,0,4},//learning, craft, integrity
				new int[]{0},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card19.png")));			
	}

	@Override
	public void rewards(Player p) {
		p.changeCraft(2);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//p.move(13);
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
