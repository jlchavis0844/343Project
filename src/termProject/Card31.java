package termProject;

import javax.swing.ImageIcon;

public class Card31 extends Card {
	
	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		// TODO Auto-generated method stub
		return CardAction.NONE;
	}

	public Card31() {
		super("Soccer Goalie",
				new int[]{3,3,0},//learning, craft, integrity
				new int[]{0},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card31.png")));	
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		//get game card
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		//p.move(2);
	}
	
}
