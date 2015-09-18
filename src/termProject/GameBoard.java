package termProject;

import java.awt.BorderLayout;
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


public class GameBoard extends JFrame {
	private JScrollPane scrollPane;
	private JPanel contentPane;

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
		boardBack.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/CSULBMap3.png")));
		//boardBack.setBounds(10, 10, 1864, 700);
		//contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setSize(1864, 700);
		scrollPane.setLocation(10, 10);
		scrollPane.setViewportView(boardBack);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList moveBox = new JList();
		moveBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		moveBox.setBounds(10, 721, 252, 289);
		contentPane.add(moveBox);
		
		JButton drawBtn = new JButton("Draw New Card");
		drawBtn.setBounds(284, 721, 211, 64);
		contentPane.add(drawBtn);
		
		JButton moveBtn = new JButton("Move Player");
		moveBtn.setBounds(284, 834, 211, 64);
		contentPane.add(moveBtn);
		
		JButton pCardBtn = new JButton("Play Card");
		pCardBtn.setBounds(284, 946, 211, 64);
		contentPane.add(pCardBtn);
		
		JTextArea infoBox = new JTextArea();
		infoBox.setLineWrap(true);
		infoBox.setEditable(false);
		infoBox.setBounds(715, 721, 1159, 206);
		contentPane.add(infoBox);
		
		JTextArea consoleBox = new JTextArea();
		consoleBox.setLineWrap(true);
		consoleBox.setEditable(false);
		consoleBox.setBounds(715, 938, 1159, 72);
		contentPane.add(consoleBox);

	}
	
	public Room[] buildRooms(int SIZE ){
		Room[] temp = new Room[SIZE];
		
		Room room0 = new Room("George All Field",0);
		Room room1 = new Room("Japanese Garden",1);
		Room room2= new Room("Student Parking",2);
		Room room3 = new Room("The Pyramid",3);
		Room room4 = new Room("West Walkway",4);
		Room room5 = new Room("Health Center",5);
		Room room6 = new Room("Forbidden Parking",6);
		Room room7 = new Room("Library",7);
		Room room8 = new Room("LA 5",8);
		Room room9 = new Room("Brautwurst Hall",9);
		Room room10 = new Room("East Walkway",10);
		Room room11 = new Room("Computer Lab",11);
		Room room12 = new Room("North Hall",12);
		Room room13 = new Room("Room of Retirement",13);
		Room room14 = new Room("ECS 302",14);
		Room room15 = new Room("South Hall",15);
		Room room16 = new Room("Elevators",16);
		Room room17 = new Room("ECS 308",17);
		Room room18 = new Room("EAT Club",18);
		Room room19 = new Room("Confrence Room",19);
		Room room20 = new Room("Lactation Lounge",20);
		
		return temp;
		
	}
}
