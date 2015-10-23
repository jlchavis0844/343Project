package termProject;

import javax.swing.ImageIcon;

public class Card38 extends Card {
	
	public Card38() {
		super("Enjoying Nature",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{0,1,2,3,4,5,6,7,8,9,10},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card38.png")));		
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
