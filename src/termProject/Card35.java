package termProject;

import javax.swing.ImageIcon;

public class Card35 extends Card {
	
	public Card35() {
		super("Chem 111",
				new int[]{0,5,0},//learning, craft, integrity
				new int[]{2,3,5,7,8,9},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card35.png")));	
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//p.move(2);
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
