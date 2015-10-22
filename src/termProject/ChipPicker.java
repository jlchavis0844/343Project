package termProject;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class ChipPicker extends JFrame{
	JDialog d1;
	DiagListener listener;
	Player tempPlayer;

	public ChipPicker(Player p) {
		
		tempPlayer = p;
        d1=new JDialog(this,"Chip Chooser",true);
        listener = new DiagListener();
        
		setTitle("Chip Chooser");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        // Set size
        d1.setSize(400,532);
        setSize(400,532);
        getContentPane().setLayout(null);
        d1.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        d1.getContentPane().add(panel);
        
        JButton button = new JButton(Chips.INTEGRITY.toString());
        button.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/Integ.png")));
        button.setBounds(80, 5, 250, 130);
        button.addActionListener(listener);
        panel.add(button);
        
        JButton button_1 = new JButton(Chips.LEARNING.toString());
        button_1.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/learn.png")));
        button_1.setBounds(80, 139, 250, 130);
        button_1.addActionListener(listener);
        panel.add(button_1);
        
        JButton button_2 = new JButton(Chips.CRAFTING.toString());
        button_2.setIcon(new ImageIcon(ChipPicker.class.getResource("/termProject/graphics/crafting.png")));
        button_2.setBounds(80, 273, 250, 130);
        button_2.addActionListener(listener);
        panel.add(button_2);
        
        JLabel label = new JLabel("Choose A Chip");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(80, 413, 250, 14);
        panel.add(label);
        
        
        d1.setVisible(true);
	}
	
	private class DiagListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  if(e.getActionCommand() == Chips.INTEGRITY.toString()){
	    		  tempPlayer.changeIntegrity(1);
	    		  System.out.println(Chips.INTEGRITY);
	    		  setVisible(false);
	    		  dispose();
	    	  } else if(e.getActionCommand() == Chips.CRAFTING.toString()){
	    		  tempPlayer.changeCraft(1);
	    		  System.out.println(Chips.CRAFTING);
	    		  setVisible(false);
	    		  dispose();
	    	  } else {
	    		  tempPlayer.changeLearning(1);
	    		  System.out.println(Chips.LEARNING);
	    		  setVisible(false);
	    		  dispose();
	    	  }
	      }
	}
}


