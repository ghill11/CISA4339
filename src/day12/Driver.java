package day12;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {

	private class ClickHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			doSentence();
		} // end mouseClicked
		@Override
		public void mousePressed(MouseEvent e) {
		} // end mousePressed

		@Override
		public void mouseReleased(MouseEvent e) {
		} // end mouseReleased

		@Override
		public void mouseEntered(MouseEvent e) {
		} // end mouseEntered

		@Override
		public void mouseExited(MouseEvent e) {
		} // end mouseExited
	} // end ClickHandler
	
	private JFrame frame;
	private JPanel panel;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextArea txtSentence;
	private JScrollPane scroll;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Driver();
			} // end method run
		});
	} // end main
	
	public Driver() {
		super();
		initComponents();
	} // end ctor
	
	private void initComponents() {
		frame = new JFrame();
		frame.setTitle("Demonstration Graphical User Interface");
		frame.setLayout(null);
		frame.setSize(new Dimension(425, 300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(100, 100);
		panel.setSize(new Dimension(frame.getSize()));
		panel.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Panel with titled border", 
				   TitledBorder.LEFT, TitledBorder.TOP));
		
		lblFirstName = new JLabel("Please enter the student's first name:");
		lblFirstName.setLocation(10,20); // this will be relative to the parent container!
		lblFirstName.setSize(225, 20);
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField("Bruce"); // leave the ctor invocation blank if you wish no default value
		txtFirstName.setLocation(235,20);
		txtFirstName.setSize(125, 20);
		panel.add(txtFirstName);
		
		lblLastName = new JLabel("Please enter the student's last name:");
		lblLastName.setLocation(10,50);
		lblLastName.setSize(225, 20);
		panel.add(lblLastName);
		
		txtLastName = new JTextField("Bear");
		txtLastName.setLocation(235,50);
		txtLastName.setSize(125, 20);
		panel.add(txtLastName);
		
		txtSentence = new JTextArea("This is a sentence.");
		txtSentence.setWrapStyleWord(true); // what does this do?
		txtSentence.setLineWrap(true); // what does this do?
		txtSentence.setEditable(false); // what does this do?
		txtSentence.addMouseListener(new ClickHandler()); // what does this do?
		scroll = new JScrollPane(txtSentence);
		scroll.setLocation(10,80);
		scroll.setSize(300, 100);
		panel.add(scroll);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		
		// Let's make this program "do something"
		doSentence();
	} // end initComponents
	
	private void doSentence() {
		String gpa = JOptionPane.showInputDialog(frame, "What is the student's GPA?");
		txtSentence.setText(txtFirstName.getText() + " " + txtLastName.getText() + " has a " + gpa + " GPA!");
	} // end doSentence
} // end Driver