package termProject;

import javax.swing.ImageIcon;

public class Card03 extends Card {
	
	public Card03() {
		super("The Outpost",
				new int[]{0,0,0},//learning, craft, integrity
				new int[]{0,1,2,3,4,5,7,8,9,10},//rooms you can play the card in
				1, //year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card3.png")));		
	}

	@Override
	public void rewards(Player p) {
		// chip of choice
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
	}

	public CardAction play(Player p) {
		if(roomCheck(p.getRNumLocation()) && prereqCheck(p)){
			retCA = CardAction.PICK;
			retCA.setResult("for a Chip of choice");
			
		} else {
			fail(p);
			retCA.setResult("and fails");
		}
		return retCA;
	}
	
}
