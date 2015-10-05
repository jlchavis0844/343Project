package termProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * JPanel constructor used to draw game board and run most game functions
 * @author James
 *
 */
public class GameView extends JFrame {
	private static final long serialVersionUID = 1L;//Suppresses warnings
	private JScrollPane scrollPane;//the scroll pane for the background
	private JPanel contentPane; //the panel for all the goodies
	private JButton moveBtn;//the button to move players
	@SuppressWarnings("rawtypes")
	private JList moveBox; //list of possible moves for the player
	private JLabel boardBack;//label that holds the background image
	private JButton drawBtn; //button that draws another card from the deck
	private JButton pCardBtn;//the button that plays a card.
	private JTextArea infoBox;//test box that holds current info about the game
	private JLabel cardLabel;//the label that holds picture of the current card
	//PlayerList pList;//object to build a list of players and player markers
	@SuppressWarnings("unused")
	private GameModel model;//contains all the player and room info
	private JScrollPane scrPane;//holds the info box/button objects
	JLabel markers[];//holds all the player markers
	JLabel playerMarker0; //label for player #1
	JLabel playerMarker1; //label for player #1
	JLabel playerMarker2; //label for player #1
	JTextArea consoleBox; //holds scrolling info about moves made ect.

//TODO: move all object decelerations outside constructor
//TODO: consider adding rooms as an enumerated class
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public GameView(GameModel model) {
		
		//set model
		this.model = model;
		
		//construct JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1900, 1060);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//JScrollPane scrPane = new JScrollPane(contentPane);
		
		//build scroll panel for the console
		boardBack = new JLabel("Game Background");
		boardBack.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/CSULBMap3.png")));
		scrollPane = new JScrollPane();
		boardBack.setLabelFor(scrollPane);
		scrollPane.setViewportView(boardBack);
		scrollPane.setPreferredSize(new Dimension(1920, 1080));
							
		//create a the list of possible moves
		moveBox = new JList();
		moveBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		moveBox.setListData(model.getrList().getNeighborNames(17));
		
		//creates draw new card button
		drawBtn = new JButton("Draw New Card");
		
		//creates a label to display the card being played
		cardLabel = new JLabel("New label");
		cardLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cardLabel.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/card1.png")));
		
		//creates the player information box
		infoBox = new JTextArea();
		infoBox.setLineWrap(true);
		infoBox.setEditable(false);
		infoBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//create the move player button
		moveBtn = new JButton("Move Player");
		moveBtn.setEnabled(false);
		
		//create play card button
		pCardBtn = new JButton("Play Card");

		//create a scroll pane for the info boxes and buttons
		scrPane = new JScrollPane(contentPane);
		
		//start create the consoleBox
		consoleBox = new JTextArea();
		consoleBox.setEditable(false);
		consoleBox.setLineWrap(true);
		consoleBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//everything here is to set the layout in a scalable layout, ignore is.
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(moveBox, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(drawBtn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveBtn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(pCardBtn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(cardLabel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(consoleBox, GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
						.addComponent(infoBox))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(moveBox, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(drawBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(moveBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(pCardBtn, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addComponent(cardLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(infoBox, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(consoleBox, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{moveBox, drawBtn, moveBtn, pCardBtn, cardLabel, consoleBox, infoBox}));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1884, Short.MAX_VALUE)
				.addComponent(scrPane, GroupLayout.DEFAULT_SIZE, 1884, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrPane, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//make the frame viable
		setVisible(true);
		
		//load player markers
		markers = model.getpList().getMarkers();
		playerMarker0 = markers[0];
		playerMarker1 = markers[1];
		playerMarker2 = markers[2];
		for (int i = 0; i < 3; i++){
			boardBack.add(markers[i]);//add to board
		}
		
		//prime console box
		consoleBox.setText("starting game");
		
	}//end constructor
	
	/**
	 * used to register several listeners attached to buttons so the controller can act
	 * @param listener - The controller that extends listener
	 */
	public void registerListener(GameController listener){
		moveBtn.addActionListener(listener);
		pCardBtn.addActionListener(listener);
		moveBox.addListSelectionListener(listener);
		drawBtn.addActionListener(listener);
	}
	
	/**
	 * returns the moveBox JList so that it can be updated by controller
	 * @return JList moveBox
	 */
	public JList getMoveList(){
		return  moveBox;
	}
	
	/**
	 * returns the scrolling console box. text should be appended
	 * @return JTextArea of the scrolling console
	 */
	public JTextArea getGameConsole(){
		return consoleBox;
	}
	
	/**
	 * checks if moveList has a selection, and toggles moveBtn accordingly
	 */
	public void setMoveBoxStatus(){
		if(moveBox.isSelectionEmpty()){//if no selection is made
			moveBtn.setEnabled(false);//disable the button
		} else {
			moveBtn.setEnabled(true);//enable the button
		}
	}
}
