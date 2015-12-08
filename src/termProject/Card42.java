package termProject;

import javax.swing.ImageIcon;

public class Card42 extends Card{

	public Card42() {
		super("CECS 201",
				new int[]{3,3,3},//learning, craft, integrity
				new int[]{14},//rooms you can play the card in
				2,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card42.png")));
	}

	@Override
	public void rewards(Player p) {
		p.changeLearning(2);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
		p.setRNumLocation(9);
	}

	/* (non-Javadoc)
	 * @see termProject.Card#play(termProject.Player)
	 */
	@Override
	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			rewards(p);
			retCA.setResult("for 2 Learning Chips");
		} else {
			fail(p);
			retCA = CardAction.TELEPORT;
			retCA.setResult("and fails; teleport to Bratwurst Hall");
		}
		return retCA;
	}
}
