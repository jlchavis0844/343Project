package termProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this is the game controller class that will interact with the view and model classes
 * @author James
 * v 1.3
 */
public class GameController implements ActionListener, ListSelectionListener, MouseListener{
	private GameModel model; //the model class which holds rooms and players
	private GameView view;// the view class which is the game board
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
	 * 
	 * @return
	 */
	private Card getCurrentCard(){
		return model.getpList().getHuman().getHand().get(view.getCurrentCard());
	}

	/**
	 * 
	 * @return
	 */
	private Player getHuman(){
		return model.getpList().getHuman();
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
			if(model.getpList().getCurrent().getMoveCount() == 3){
				view.disableMoveBox();
			}	
		} else if(e.getActionCommand() == "Play Card"){//if play card button is triggered
			System.out.println(e.getActionCommand());
			Player currentPlayer = getHuman();
			System.out.println(currentPlayer.getPName() + " plays ''" + getCurrentCard().getName() + "''" );
			getHuman().getHand().discard(getCurrentCard(), model.getDiscardDeck());
			//model.playCard(currentPlayer, getCurrentCard());
			view.refreshCards(getHuman().getHand());
			model.updateInfo(view.getInfoBox());
			if(getHuman().getHand().isFull() || model.getLiveDeck().getSize() == 0){
				view.toggleDraw(false);
			} else {
				view.toggleDraw(true);
			}
			refreshPlayer();
			
		} else if(e.getActionCommand() == "Draw New Card"){//if draw new card button is triggered
			System.out.println(e.getActionCommand());
			model.drawCard(getHuman().getHand());
			view.setCurrentCard(getHuman().getHand().getLastAdded());//sets the recently added card to the current card
			view.refreshCards(getHuman().getHand());
			model.updateInfo(view.getInfoBox());
			if(getHuman().getHand().isFull() || model.getLiveDeck().getSize() == 0){
				view.toggleDraw(false);
			}
			//System.out.println(view.chipPicker());
		} else {
			System.out.println("Something went wrong");//error case?
		}
	}//end Action Event Listener

	/**
	 * Selection listener for the Selection List Box
	 * since this is tied to only one component, lets not make a separate method
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
		model.getpList().movePlayer(model.getpList().getHuman(), selectedRoom);//call the movePlayer for the current player and selected room
		view.getMoveList().setListData(model.getrList().getNeighborNames(selectedRoom));//update the move list
		String message = "Moving " + model.getpList().getHuman().getPName() + " to " + selectedRoom.getRoomName();
		view.toConsole(message);
		view.setMoveBoxStatus();//refresh moveBtn status	
	}
	
	/**
	 * Resets the player's moveCount after turn.
	 * Sets the next player in pList as current and refreshes moveBox 
	 */
	private void refreshPlayer(){
		view.toConsole(model.getpList().getCurrent().getPName() + " plays card " + getCurrentCard().getName());
		model.getpList().setNextPlayer();//get the next player
		view.enableMoveBox();//turn the move button on
		startAITurns();//start the AI run of turns
	}
	
	
	/**
	 * takes the 2 AI players through a their random turns
	 */
	public void startAITurns(){
		for(int i = 0; i < 2; i++){//start 2 loops (1 per AI player)
			Vector<String> printVector = model.aiPlay();//ai gameplay
			for(String s: printVector){//prints player info to the screen
				view.toConsole(s);
			}
		}
		model.updateInfo(view.getInfoBox());
		
	}
	
	
	/*	Start mouse listener functions
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		view.cycleCards(getHuman().getHand());
		System.out.println("Cycling cards");	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
