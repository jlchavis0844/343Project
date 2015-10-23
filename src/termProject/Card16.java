package termProject;

import javax.swing.ImageIcon;

public class Card16 extends Card {
	
	public Card16() {
		super("The Big Game",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{3},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card16.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeCraft(1);
		//p.move(20);
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
