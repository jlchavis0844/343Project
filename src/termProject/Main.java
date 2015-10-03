package termProject;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		GameModel model = new GameModel();
		GameView view = new GameView(model);
		GameController controller = new GameController(model, view);
		
		//register controller as listeners
		view.registerListener(controller);
		
	}//end main function

}//end main class
