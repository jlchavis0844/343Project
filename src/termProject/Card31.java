package termProject;

import javax.swing.ImageIcon;

public class Card31 extends Card {
	
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
		p.setRNumLocation(2);//teleport to Student Parking
	}
	
	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA = CardAction.DRAW;
			retCA.setResult("for 5 QP and 1 Game Card");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Student Parking");
		}
		return retCA;
	}

	
}
