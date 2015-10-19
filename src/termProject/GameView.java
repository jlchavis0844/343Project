package termProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * JPanel constructor used to draw game board and run most game functions
 * @author James
 *
 */
public class GameView extends JFrame {
	private static final long serialVersionUID = 1L;//Suppresses warnings
	private JScrollPane backgroundScrollPane;//the scroll pane for the background
	private JPanel contentPane; //the panel for all the goodies
	private JButton moveBtn;//the button to move players
	@SuppressWarnings("rawtypes")
	private JList moveBox; //list of possible moves for the player
	private JLabel boardBack;//label that holds the background image
	private JButton drawBtn; //button that draws another card from the deck
	private JButton pCardBtn;//the button that plays a card.
	private JTextArea infoBox;//test box that holds current info about the game
	private JLabel cardLabel;//the label that holds picture of the current card
	@SuppressWarnings("unused")
	private GameModel model;//contains all the player and room info
	private JScrollPane infoScrollPane;//holds the info box/button objects
	private JLabel markers[];//holds all the player markers
	@SuppressWarnings("unused")
	private JLabel playerMarker0; //label for player #1
	@SuppressWarnings("unused")
	private JLabel playerMarker1; //label for player #2
	@SuppressWarnings("unused")
	private JLabel playerMarker2; //label for player #3
	private JTextArea consoleBox; //holds scrolling info about moves made ect.
	private JScrollPane consoleScrollPane;
	private int currentCard;
	private JPanel deckPanel;
	private JList cardList;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public GameView(GameModel model) {
		
		//set model
		this.model = model;
		currentCard = 0;//starts the deck label at the beginning
		
		//construct JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1900, 1060);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//JScrollPane scrPane = new JScrollPane(contentPane);
		
		//build scroll panel for the console
		boardBack = new JLabel("Game Background");
		boardBack.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/CSULBMap3.png")));
		boardBack.setPreferredSize(new Dimension(boardBack.getIcon().getIconWidth(),boardBack.getIcon().getIconHeight()));
		backgroundScrollPane = new JScrollPane();
		boardBack.setLabelFor(backgroundScrollPane);
		backgroundScrollPane.setViewportView(boardBack);
		backgroundScrollPane.setPreferredSize(new Dimension(1920, 1080));
							
		//create a the list of possible moves
		moveBox = new JList();
		moveBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		moveBox.setListData(model.getrList().getNeighborNames(17));
		
		//creates draw new card button
		drawBtn = new JButton("Draw New Card");
		
		//creates the player information box
		infoBox = new JTextArea();
		infoBox.setFont(new Font("Monospaced", Font.PLAIN, 16));
		infoBox.setLineWrap(true);
		infoBox.setEditable(false);
		infoBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//create the move player button
		moveBtn = new JButton("Move Player");
		moveBtn.setEnabled(false);
		
		//create play card button
		pCardBtn = new JButton("Play Card");

		//create a scroll pane for the info boxes and buttons
		infoScrollPane = new JScrollPane(contentPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(backgroundScrollPane, GroupLayout.DEFAULT_SIZE, 1884, Short.MAX_VALUE)
				.addComponent(infoScrollPane, GroupLayout.DEFAULT_SIZE, 1884, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(backgroundScrollPane, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(infoScrollPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
		//for the console box
		consoleScrollPane = new JScrollPane();
		
		//start create the consoleBox
		consoleBox = new JTextArea();
		consoleScrollPane.setViewportView(consoleBox);
		consoleBox.setEditable(false);
		consoleBox.setLineWrap(true);
		consoleBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//prime console box
		consoleBox.setText("starting game\n");
		
		deckPanel = new JPanel();
		deckPanel.setLayout(null);
		
		//creates a label to display the card being played
		cardLabel = new JLabel("New label");
		cardLabel.setBounds(129, 35, 207, 275);
		deckPanel.add(cardLabel);
		cardLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cardLabel.setIcon(new ImageIcon(GameView.class.getResource("/termProject/graphics/card1.png")));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{moveBox, drawBtn, moveBtn, pCardBtn, cardLabel, consoleBox, infoBox}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(moveBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(drawBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(moveBtn, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(pCardBtn, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(deckPanel, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(consoleScrollPane, GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
						.addComponent(infoBox, GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(moveBox, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(drawBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(moveBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(pCardBtn, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(deckPanel, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(infoBox, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(consoleScrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		
		cardList = new JList();
		cardList.setEnabled(false);
		cardList.setValueIsAdjusting(true);
		cardList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cardList.setBackground(SystemColor.menu);
		cardList.setBounds(10, 35, 110, 264);
		cardList.setSelectionMode(0);
		deckPanel.add(cardList);
				
		contentPane.setLayout(gl_contentPane);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);//launched maximized
		
		
	}//end constructor
	
	/**
	 * used to register several listeners attached to buttons so the controller can act
	 * @param listener - The controller that extends listener
	 */
	public void registerListener(GameController listener){
		moveBtn.addActionListener(listener);//for the move button
		pCardBtn.addActionListener(listener);//for the play card button
		moveBox.addListSelectionListener(listener);//for the box of possible moves
		drawBtn.addActionListener(listener);//draw card button
		cardLabel.addMouseListener(listener);//mouse listener to cycle through card deck
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


	/**
	 * disable moveBox selection
	 */
	public void disableMoveBox(){
		moveBox.setEnabled(false); 
	}
	
	/**
	 * enable moveBox selection
	 */
	public void enableMoveBox(){
		moveBox.setEnabled(true); 
	}
	
	/**
	 * prints the given string to the console
	 * <p>
	 * Do not use \n, a line break is added after every message
	 * </p>
	 * @param s the string to be added
	 */
	public void toConsole(String s){
		consoleBox.setText(consoleBox.getText() + s + "\n");
	}
	
	/**
	 * return The infoBox from the GameView as JTextArea
	 * @return JTextArea of infoBox
	 */
	public JTextArea getInfoBox(){
		return infoBox;
	}
	
	public void errorDialog(String s){
		//JOptionPane temp = new JOptionPane();
		JOptionPane.showMessageDialog(getContentPane(), s, "Oppsy", JOptionPane.ERROR_MESSAGE);
	}
	
	public String chipPicker() {
		JPanel parent = new JPanel();
		JLabel textLabel = new JLabel("Choose which chip you would like as a reward\n");
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//textLabel.setBounds(20, 11, 252, 51);
		parent.add(textLabel);
		JRadioButton lc = new JRadioButton("Learning");
		lc.setBounds(46, 76, 67, 23);
		JRadioButton cc = new JRadioButton("Crafting");
		cc.setBounds(118, 76, 65, 23);
		JRadioButton ic = new JRadioButton("Integrity");
		ic.setBounds(188, 76, 67, 23);
		//parent.setLayout(null);
		parent.add(lc);
		parent.add(cc);
		parent.add(ic);
		
		JOptionPane.showMessageDialog(null, parent);
		if(lc.isSelected()){
			return "Learning";
		} else if(cc.isSelected()){
			return "Crafting";
		} else return "Integrity";
		
	}
	
	@SuppressWarnings("unchecked")
	public void refreshCards(Hand h){
		ImageIcon icon = h.get(currentCard).getImg();
		cardLabel.setIcon(icon);
		
		cardList.setListData(new String[]{h.get(0).getName(),h.get(1).getName(),h.get(2).getName(),
			h.get(3).getName(),h.get(4).getName(),h.get(5).getName(),h.get(6).getName(),h.get(7).getName()});
		cardList.setSelectedIndex(currentCard);
		System.out.println("Displaying card " + h.get(currentCard).getName() +
				" " + h.get(currentCard).getClass().toString());
	}
	
	public void cycleCards(Hand h){
		currentCard++;
		if (currentCard == 8){
			currentCard = 0;
		}
		refreshCards(h);
	}
	
	public int getCurrentCard(){
		return currentCard;
	}
}//end class
