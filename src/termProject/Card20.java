package termProject;

import javax.swing.ImageIcon;

public class Card20 extends Card {
	
	public Card20() {
		super("Goodbye, Professor",
				new int[]{6,6,6},
				new int[]{13},1,
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card4.png")));		
	}

	@Override
	public void rewards(Player p) {
		p.changeQP(10);
	}

	@Override
	public void fail(Player p) {
		//lose 1 card
		p.changeQP(-2);
	}
	
}
