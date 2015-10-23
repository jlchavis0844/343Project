package termProject;

import javax.swing.ImageIcon;

public class Card22 extends Card {
	
	public Card22() {
		super("Score a Goal!",
				new int[]{0,3,0},//learning, craft, integrity
				new int[]{0},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card22.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(5);
		p.changeIntegrity(1);
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
