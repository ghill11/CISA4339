package day16;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {

	private JFrame frame;
	private JPanel panel;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Driver();
			} // end method run
		});
	} // end main
	
	public Driver() {
		initComponents();
	} // end ctor
	
	private void initComponents() {
		frame = new JFrame();
		frame.setTitle("Day 16 Demonstration");
		frame.setLayout(null);
		frame.setSize(new Dimension(475,300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(100,100);
		panel.setSize(new Dimension(frame.getSize()));
		panel.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Image file display", 
				   TitledBorder.LEFT, TitledBorder.TOP));
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("src\\images\\CISA-logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
		JLabel pic = new JLabel(new ImageIcon(myPicture));
		pic.setSize(441,96);
		pic.setLocation(10,20);
		panel.add(pic);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
} // end Driver