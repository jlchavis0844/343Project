package termProject;

import javax.swing.ImageIcon;

public class Card28 extends Card {
	
	public Card28() {
		super("CECS 100",
				new int[]{},
				new int[]{14,17},1,
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card2.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(1);
	}

	@Override
	public void fail(Player p) {
		p.changeQP(-2);
	}
	
}
