package termProject;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		GameModel model = new GameModel();//make the model
		GameView view = new GameView(model);//make the view
		GameController controller = new GameController(model, view);//make the controller
		
		//register controller as listeners
		view.registerListener(controller);
		
		//writes player info to the view infoBox
		model.updateInfo(view.getInfoBox());
		
		view.refreshCards(model.getpList().getHuman().getHand());
		
	}//end main function

}//end main class
