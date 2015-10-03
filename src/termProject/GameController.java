package termProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GameController implements ActionListener, ListSelectionListener{
	private GameModel model; 
	private GameView view;
	
	public GameController(GameModel m, GameView v){
		model = m;
		view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Move Player"){
			System.out.println(e.getActionCommand());
			//call movePlayer() function
		} else if(e.getActionCommand() == "Play Card"){
			System.out.println(e.getActionCommand());
			//call PlayCard() method
		} else if(e.getActionCommand() == "Draw New Card"){
			System.out.println(e.getActionCommand());
		} else {
			System.out.println("Something went wrong");
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting() == false){
			JList tempList = (JList)e.getSource();
			//call some sort of roomSelected() method using tempList
			System.out.println(tempList.getSelectedValue());
		}
	}

}
