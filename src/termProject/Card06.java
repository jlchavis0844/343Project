package termProject;

import javax.swing.ImageIcon;

public class Card06 extends Card {
	
	public Card06() {
		super("Math 122",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{7},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card6.png")));		
	}

	@Override
	public void rewards(Player p) {
		//p.changeLearning(1) or p.changeIntegrity(1);
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
		CardAction temp = CardAction.PICK;
		temp.setExcluded("craft");
		return temp;
		
	}
	
}
