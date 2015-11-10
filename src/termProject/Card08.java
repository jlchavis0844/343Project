package termProject;

import javax.swing.ImageIcon;

public class Card08 extends Card {
	
	public Card08() {
		super("Research Compilers",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{7},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card8.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeLearning(1);
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
