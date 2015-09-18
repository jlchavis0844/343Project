package termProject;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//creates threadable EventQueue
		EventQueue.invokeLater(new Runnable() {
			public void run() {//start thread
				try {//exception handling
					GameBoard frame = new GameBoard();//call gameboard constructor
					frame.setVisible(true);//set visible
				} catch (Exception e) {//exception
					e.printStackTrace();
				}//end try catch
			}//end thread
		});//end EventQueue
				
	}//end main function

}//end main class
