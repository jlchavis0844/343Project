package termProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this is the game controller class that will interact with the view and model classes
 * @author James
 * v 1.3
 */
public class GameController implements ActionListener, ListSelectionListener{
	private GameModel model; //the model class which holds rooms and players
	private GameView view;// the view class which is the game board
	private Player current; // tracks the current player
	private Room selectedRoom; // when a room selection is made, this room is updated to the selected room
	
	/**
	 * Constructor for the GameController
	 * @param m The model object to control
	 * @param v The view class to control
	 */
	public GameController(GameModel m, GameView v){
		model = m;//assigns the model class
		view = v;// assigns the view class
	}

	/**
	 * implements the listeners for all buttons in the view
	 * Buttons include Move Player, Play Card, and Draw New Card
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Move Player"){//if move player button is triggered
			System.out.println(e.getActionCommand());
			moveCurrentPlayer();
			
		} else if(e.getActionCommand() == "Play Card"){//if play card button is triggered
			System.out.println(e.getActionCommand());
			//call PlayCard() method
		} else if(e.getActionCommand() == "Draw New Card"){//if draw new card button is triggered
			System.out.println(e.getActionCommand());
		} else {
			System.out.println("Something went wrong");//error case?
		}
	}//end Action Event Listener

	/**
	 * Selection listener for the Selection List Box
	 * since this is tied to only one component, lets not make a seperate method
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting() == true){//on selection
			JList tempList = (JList)e.getSource();//recreate the selection list
			String temp = (String)tempList.getSelectedValue(); 
			selectedRoom = model.getrList().find(temp);//match selected room
			System.out.println(tempList.getSelectedValue());//for debugging
			view.setMoveBoxStatus();//update the moveBtn as needed
		}
	}
	
	/**
	 * moves the current player to selected room
	 * <p>
	 * if the moveBtn in the view class is clicked, this method will move the current player into whatever room is selected
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	private void moveCurrentPlayer(){
		current = model.getpList().getCurrent();//update the current player
		model.getpList().movePlayer(current, selectedRoom);//call the movePlayer for the current player and selected room
		view.getMoveList().setListData(model.getrList().getNeighborNames(selectedRoom));//update the move list
		view.getGameConsole().append("\nMoving " + current.getPName() + " to " + selectedRoom.getRoomName());//info to consolse
		view.setMoveBoxStatus();//refresh moveBtn status
	}
}
