package termProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class GameBoard extends JFrame {
	private JScrollPane scrollPane;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard frame = new GameBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(10, 721, 252, 289);
		contentPane.add(list);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GameBoard.class.getResource("/termProject/test.png")));
		lblNewLabel.setBounds(505, 721, 200, 281);
		contentPane.add(lblNewLabel);

	}
}
