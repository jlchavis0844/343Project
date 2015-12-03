package termProject;

import javax.swing.ImageIcon;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Card17 extends Card {
	
	public Card17() {
		super("Math 123",
				new int[]{5,0,0},//learning, craft, integrity
				new int[]{14,17},//rooms you can play the card in
				1,//year that the cards belong to
				new ImageIcon(GameView.class.getResource("/termProject/graphics/card17.png")));	
				replaceable = true;
	}

	@Override
	public void rewards(Player p) {
		Media hit = new Media(rewardStr);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
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
			retCA = CardAction.DISCARD;
			retCA.setResult("and fails; discard 1 Game Card");
		}
		return retCA;
	}
	
}
