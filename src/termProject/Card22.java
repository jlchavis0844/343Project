package termProject;

import javax.swing.ImageIcon;

public class Card22 extends Card {
	
	public Card22() {
		super("The Outpost",
				new int[]{},
				new int[]{0,1,2,3,4,5,7,8,9,10},1,
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card3.png")));		
	}

	@Override
	public void rewards(Player p) {
		//choose chip
		//p.changeQP(1);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
	}
	
}
