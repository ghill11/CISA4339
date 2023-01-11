package day11;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class JFrameDriver {
	private JFrame frame;
	private JPanel panel;
	private JPanel contents;
	
	public static void main(String[] args) { // What is going on in here?
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JFrameDriver();
			} // end method run
		});
	} // end main
	
	public JFrameDriver() {
		super();
		initComponents(); // Why invoke this instead of moving that method's contents into the ctor?
	} // end ctor
	
	private void initComponents() {
		frame = new JFrame();
		frame.setTitle("Demonstration Graphical User Interface");
		frame.setLayout(null);
		frame.setSize(new Dimension(425, 300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // What does this do?
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(100, 100);
		panel.setSize(new Dimension(frame.getSize()));
		panel.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Panel with titled border", 
				   TitledBorder.LEFT, TitledBorder.TOP)); // What does this do?
		
		contents = new MyDrawing(150, 150);
		contents.setLayout(null);
		contents.setLocation(15, 15);
		contents.setSize(contents.getPreferredSize()); // Why do this instead of just passing 150, 150 like we did in the ctor?
		panel.add(contents); // What does this do?
		
		frame.setContentPane(panel); // What does this do?
		frame.setVisible(true); // What does this do?
	} // end initComponents
} // end JFrameDriver