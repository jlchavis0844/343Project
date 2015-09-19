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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class GameBoard extends JFrame {
	private JScrollPane scrollPane;
	private JPanel contentPane;
	int test;

	/**
	 * Create the frame.
	 */
	public GameBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1900, 1060);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel boardBack = new JLabel("Game Background");
		boardBack.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/graphics/CSULBMap3.png")));
		
		JLabel playerMarker1 = new JLabel("player1");
		playerMarker1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		playerMarker1.setForeground(Color.RED);
		playerMarker1.setBounds(50, 50, 300, 30);
		
		JLabel playerMarker2 = new JLabel("player2");
		playerMarker2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		playerMarker2.setForeground(Color.RED);
		playerMarker2.setBounds(50, 80, 300, 30);
		
		JLabel playerMarker3 = new JLabel("player3");
		playerMarker3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		playerMarker3.setForeground(Color.RED);
		playerMarker3.setBounds(50, 110, 300, 30);
		
		scrollPane = new JScrollPane();
		boardBack.setLabelFor(scrollPane);
		scrollPane.setBounds(10, 10, 1864, 700);
		scrollPane.setViewportView(boardBack);
		contentPane.add(scrollPane);
		
		boardBack.add(playerMarker1);
		boardBack.add(playerMarker2);
		boardBack.add(playerMarker3);
		
		JScrollPane consoleScroll = new JScrollPane();
		consoleScroll.setBounds(648, 938, 1226, 72);
		contentPane.add(consoleScroll);
		
		JTextArea consoleBox = new JTextArea();
		consoleScroll.setViewportView(consoleBox);
		
		JList moveBox = new JList();
		moveBox.setBounds(10, 721, 252, 289);
		moveBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(moveBox);
		
		JButton drawBtn = new JButton("Draw New Card");
		drawBtn.setBounds(272, 721, 145, 64);
		contentPane.add(drawBtn);
		
		JButton moveBtn = new JButton("Move Player");
		moveBtn.setBounds(272, 834, 145, 64);
		moveBtn.setEnabled(!moveBox.isSelectionEmpty());
		contentPane.add(moveBtn);
		
		JButton pCardBtn = new JButton("Play Card");
		pCardBtn.setBounds(272, 946, 145, 64);
		contentPane.add(pCardBtn);
		
		JTextArea infoBox = new JTextArea();
		infoBox.setBounds(648, 721, 1226, 206);
		infoBox.setLineWrap(true);
		infoBox.setEditable(false);
		infoBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(infoBox);
		
		JLabel cardLabel = new JLabel("New label");
		cardLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cardLabel.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/graphics/card1.png")));
		cardLabel.setBounds(427, 721, 211, 289);
		contentPane.add(cardLabel);
		
		Room roomArr[] = buildRooms(21);
		
		test = 0;
		
		
	
		/****************Test module******************/
		JButton btnTest = new JButton("Step Through Classes");
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moveBox.setListData(getNames(roomArr[test].getNeighbors(),roomArr));
				consoleBox.setText(consoleBox.getText() + "\n Room " + test + " out of " + roomArr.length);
				playerMarker1.setLocation(roomArr[test].getX(), roomArr[test].getY());
				playerMarker2.setLocation(roomArr[test].getX(), roomArr[test].getY()+30);
				playerMarker3.setLocation(roomArr[test].getX(), roomArr[test].getY()+60);
				//repaint();
				if (test == roomArr.length-1){
					test = 0;
				} else {
					test++;	
				}
			}
		});
		btnTest.setBounds(272, 796, 145, 23);
		contentPane.add(btnTest);
		/********************End Test Module*************/
		
	}//end constructor

	/**
	 * builds all the rooms in a hard-coded manner.
	 * @param SIZE int of how many rooms will be in the room array
	 * @return Room[] an array of rooms, this is an array of all rooms
	 */
	public Room[] buildRooms(int SIZE ){
		Room[] temp = new Room[SIZE];
		
		temp[0] = new Room(50, 50,"George Allen Field",0);
		temp[0].addNeighbor(new int[]{1,3,5,4});
		temp[1] = new Room(440, 30,"Japanese Garden",1);
		temp[1].addNeighbor(new int[]{0,3,2});
		temp[2] = new Room(1025, 80,"Student Parking",2);
		temp[2].addNeighbor(new int[]{1,3,5});
		temp[3]  = new Room(420, 270, "The Pyramid",3);
		temp[3].addNeighbor(new int[]{0,1,2});
		temp[4]  = new Room(40, 750, "West Walkway",4);
		temp[4].addNeighbor(new int[]{5,12,7});
		temp[5]  = new Room(450, 565,"Rec Center",5);
		temp[5].addNeighbor(new int[]{4,3,0});
		temp[6]  = new Room(1045, 585,"Forbidden Parking",6);
		temp[6].addNeighbor(new int[]{2,5,10});
		temp[7]  = new Room(20, 1720,"Library",7);
		temp[7].addNeighbor(new int[]{8,4});
		temp[8]  = new Room(480, 1780,"LA 5",8);
		temp[8].addNeighbor(new int[]{7,9});
		temp[9]  = new Room(1160, 1670, "Brautwurst Hall",9);
		temp[9].addNeighbor(new int[]{10,8});
		temp[10]  = new Room(1450, 963,"East Walkway",10);
		temp[10].addNeighbor(new int[]{15,9});
		temp[11]  = new Room(170, 875, "Computer Lab",11);
		temp[11].addNeighbor(new int[]{12});
		temp[12]  = new Room(165, 1140,"North Hall",12);
		temp[12].addNeighbor(new int[]{4,11,13,14,16,15});
		temp[13]  = new Room(175, 1330, "Room of Retirement",13);
		temp[13].addNeighbor(new int[]{12});
		temp[14]  = new Room(590, 910,"ECS 302",14);
		temp[14].addNeighbor(new int[]{12});
		temp[15]  = new Room(820, 1150,"South Hall",15);
		temp[15].addNeighbor(new int[]{14,18,19,10,20,17});
		temp[16]  = new Room(590, 1390, "Elevators",16);
		temp[16].addNeighbor(new int[]{12});
		temp[17]  = new Room(800, 1375,"ECS 308",17);
		temp[17].addNeighbor(new int[]{15});
		temp[18]  = new Room(1020, 875, "EAT Club",18);
		temp[18].addNeighbor(new int[]{15});
		temp[19]  = new Room(1240, 870, "Confrence Room",19);
		temp[19].addNeighbor(new int[]{15});
		temp[20]  = new Room(1200, 1390, "Lactation Lounge",20);
		temp[20].addNeighbor(new int[]{15});
		
		return temp;
	}
	
	/**
	 * takes an ArrayList of neighbors room numbers and the room list 
	 * and turns it into an array of Strings of room names
	 * @param nList ArrayList<Integer> of neighboring room numbers
	 * @param roomArr Room[] the master list of rooms.
	 * @return String[] an array of neighboring room names
	 */
	public String[] getNames(ArrayList<Integer> nList, Room roomArr[]){
		String nNames[] = new String[nList.size()];
		
		for(int i = 0; i < nList.size(); i++){
			for(int j = 0; j < roomArr.length; j++){
				if (roomArr[j].getRoomNum() == nList.get(i)){
					nNames[i] = roomArr[j].getRoomName();
				}//end if statement
			}//end inner for loop
		}//end out for loop
		
		return nNames;
	}
	
}
