package termProject;

import javax.swing.ImageIcon;

public class Card20 extends Card {
	
	public Card20() {
		super("Learning Netbeans",
				new int[]{3,0,0},//learning, craft, integrity
				new int[]{20},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card20.png")));			
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
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 5 QP");
		}else{
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
