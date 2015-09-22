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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * JPanel constructor used to draw game board and run most game functions
 * @author James
 *
 */
public class GameBoard extends JFrame {
	private JScrollPane scrollPane;//the scroll pane for the background
	private JPanel contentPane; //the panel for all the goodies
	int human; //tracks the array index of the player being used as the user player
	Room roomArr[]; //holds all the rooms
	Player players[];//holds the 3 players
	JButton moveBtn;//the button to move players
	JList moveBox; //list of possible moves for the player
	JTextArea consoleBox; //Scrolling updates
	JScrollPane consoleScroll;//holds consoleBox so that the console scrolls
	JLabel boardBack;//label that holds the background image
	JButton drawBtn; //button that draws another card from the deck
	JButton pCardBtn;//the button that plays a card.
	JTextArea infoBox;//test box that holds current info about the game
	JLabel cardLabel;//the label that holds picture of the current card
	PlayerList pList;//object to build a list of players and player markers
	
//TODO: move all object decelerations outside constructor
//TODO: consider adding rooms as an enumerated class
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public GameBoard() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1900, 1060);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		consoleScroll = new JScrollPane();
		consoleScroll.setBounds(648, 938, 1226, 72);
		contentPane.add(consoleScroll);
		
		consoleBox = new JTextArea();
		consoleScroll.setViewportView(consoleBox);
		
		RoomList rList = new RoomList(21);
		roomArr =rList.getRList();//load all the rooms
		
		PlayerList pList = new PlayerList();
		players = pList.getPlayerList();//load the players
		JLabel[] pMarkers = pList.getMarkers();
		
		human = (new Random()).nextInt(3);// random number 0-2
		consoleBox.setText("\nThe Human player is " + players[human].getPName()+ " and is starting in ECS 308");

		boardBack = new JLabel("Game Background");
		boardBack.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/graphics/CSULBMap3.png")));

		scrollPane = new JScrollPane();
		boardBack.setLabelFor(scrollPane);
		scrollPane.setBounds(10, 10, 1864, 700);
		scrollPane.setViewportView(boardBack);
		contentPane.add(scrollPane);
		
		for(JLabel l: pMarkers){
			boardBack.add(l);
		}
		
		moveBox = new JList();
		moveBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				moveBtn.setEnabled(!moveBox.isSelectionEmpty());
			}
		});
		moveBox.setBounds(10, 721, 252, 289);
		moveBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		moveBox.setListData(rList.getNeighborNames(roomArr[17].getRoomName()));
		contentPane.add(moveBox);
		
		drawBtn = new JButton("Draw New Card");
		drawBtn.setBounds(272, 721, 145, 64);
		contentPane.add(drawBtn);
		
		moveBtn = new JButton("Move Player");
		moveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (moveBox.getSelectedValue() == null){
					//TODO: just leave empty or add error message
				}else {
					Room newRoom = rList.find((String)moveBox.getSelectedValue());
					pList.movePlayer(players[human], newRoom);//move the human player to the new room
					//Room newRoom = pList.movePlayer((String)moveBox.getSelectedValue(),players[human],roomArr);
					moveBox.setListData(rList.getNeighborNames(newRoom.getRoomName()));//reloads move box
					moveBtn.setEnabled(false);//disables move button
					consoleBox.setText(consoleBox.getText() + "\nMoving " + players[human].getPName() + " to " + newRoom.getRoomName());
				}
			}
		});
		moveBtn.setBounds(272, 834, 145, 64);
		moveBtn.setEnabled(!moveBox.isSelectionEmpty());
		contentPane.add(moveBtn);
		
		pCardBtn = new JButton("Play Card");
		pCardBtn.setBounds(272, 946, 145, 64);
		contentPane.add(pCardBtn);
		
		infoBox = new JTextArea();
		infoBox.setBounds(648, 721, 1226, 206);
		infoBox.setLineWrap(true);
		infoBox.setEditable(false);
		infoBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(infoBox);
		
		cardLabel = new JLabel("New label");
		cardLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cardLabel.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/graphics/card1.png")));
		cardLabel.setBounds(427, 721, 211, 289);
		contentPane.add(cardLabel);
		
	}//end constructor

}
