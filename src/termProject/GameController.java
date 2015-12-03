package termProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.naming.SizeLimitExceededException;
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
		startHumanTurn();//sets default start condition for human turn
	}
	
	/**
	 * 
	 * @return
	 */
	private Card getCurrentCard(){
		return getHuman().getHand().get(view.getCurrentCard());
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
				//view.disableMoveBox();
				view.setMoveBoxStatus(false);
			}	
		} else if(e.getActionCommand() == "Play Card"){//if play card button is triggered
			System.out.println(e.getActionCommand());
			Player currentPlayer = getHuman();
			System.out.println(currentPlayer.getPName() + " plays ''" + getCurrentCard().getName() + "''" );
			CardAction message = getCurrentCard().play(getHuman());//plays the card with the human
			
			//print the card play result to console
			String tCard = getCurrentCard().getName();//current card's name
			String result = message.getResult();//store result for printing
			view.toConsole(getHuman().getPName()+" plays "+tCard+" "+result);//write to view's console
			
			getHuman().getHand().discard(getCurrentCard(), model.getDiscardDeck());//discard currentCard
			
			//process return cardAction
			switch (message){
				case DISCARD:
					pickDiscard();//make choice and discard the choice
					break;
					
				case DRAW:
					//draw a another random card
					model.drawCard(getHuman().getHand());//draw a new card
					//launch discard picker if over 
					if(getHuman().getHand().getSize() > 7){
						pickDiscard();
					}
					break;
				
				case DRAW2:
					for(int i = 0; i < 2; i++){
						//draw a another random card
						model.drawCard(getHuman().getHand());//draw a new card
						//launch discard picker if over 
						if(getHuman().getHand().getSize() > 7){
							pickDiscard();
						}
					}
					break;
					
				case PICK:
					//message.getExcluded();
					new ChipPicker(getHuman(),message.getExcluded());//launch chip picker dialog
					break;
					
				case TELEPORT://player room loc set by card, using movePlayer
					//moves the player using movePlayer to location set in the card
					Room tRoom = model.getrList().find(getHuman().getRNumLocation());
					model.getpList().movePlayer(getHuman(),tRoom);
					view.setMoveList(model.getrList().getNeighborNames(tRoom));
					break;
					
				default:
					System.out.println(message);
					break;
			
			}
			message.setExcluded(null);//reset excluded chip button
			message = CardAction.NONE;//reset CardAction after the card is played

			view.refreshCards(getHuman().getHand());
			/*
			model.updateInfo(view.getInfoBox());
			if(getHuman().getHand().isFull() || model.getLiveDeck().getSize() == 0){
				view.setDrawButtonStatus(false);
			} else {
				view.setDrawButtonStatus(true);
			}
			*/
			endHumanTurn();
			
		} else if(e.getActionCommand() == "Draw New Card"){//if draw new card button is triggered
			System.out.println(e.getActionCommand());//debugging
			view.setMoveBoxStatus(true);//enable room list
			view.setPlayButtonStatus(true);//enabled playcard button
			model.drawCard(getHuman().getHand());//draws the card from live deck, adds to hand
			view.setCurrentCard(getHuman().getHand().getLastAdded());//sets the recently added card to the current card
			view.refreshCards(getHuman().getHand());//redraws deck to screen
			model.updateInfo(view.getInfoBox());//refresh info box w/ player stats
			int cardIndex = getHuman().getHand().getLastAdded();//temp use for last added function
			view.toConsole(getHuman().getPName()+" draws "+getHuman().getHand().get(cardIndex).getName());
			view.setDrawButtonStatus(false);//disables draw card button, only 1 per turn
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
	private void moveCurrentPlayer(){
		model.getpList().movePlayer(model.getpList().getHuman(), selectedRoom);//call the movePlayer for the current player and selected room
		view.setMoveList(model.getrList().getNeighborNames(selectedRoom));//update the move list
		String message = "Moving " + model.getpList().getHuman().getPName() + " to " + selectedRoom.getRoomName();
		view.toConsole(message);
		view.setMoveBoxStatus();//refresh moveBtn status	
	}
	
	/**
	 * Resets the player's moveCount after turn.
	 * Sets the next player in pList as current and refreshes moveBox 
	 */
	private void endHumanTurn(){
		//view.toConsole(model.getpList().getCurrent().getPName() + " plays card " + getCurrentCard().getName()); //moved to actionPerformed
		model.getpList().setNextPlayer();//get the next player
		//view.enableMoveBox();//turn the move button on
		view.setMoveBoxStatus(true);//
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
		model.checkRound1();
		startHumanTurn();//ends AI, starts human term.
		
	}
	
	/**
	 * Disables buttons for the human turn until
	 * the human player draws a card
	 */
	private void startHumanTurn(){//turn off everything except draw button
		view.setMoveButtonStatus(false);
		view.setPlayButtonStatus(false);
		view.setMoveBoxStatus(false);
		view.setDrawButtonStatus(true);
		model.checkDeck();
	}
	
	/**
	 * runs the discard diag for the human to pick the discarded card
	 */
	public void pickDiscard(){
		DiscardDiag dis = new DiscardDiag(model.getpList().getHuman(), model.getDiscardDeck());
		model.updateInfo(view.getInfoBox());
		view.toConsole(dis.getMessage());
		view.refreshCards(model.getpList().getHuman().getHand());
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
		// left blank intentionally
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// left blank intentionally
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// left blank intentionally
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// left blank intentionally
		
	}
	
}
