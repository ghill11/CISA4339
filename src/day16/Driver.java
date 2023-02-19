package day16;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {

	private class PicutureClickHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			doLoadNewImage();
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
	} // end PicutureClickHandler
	
	private class BackgroundClickHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			doChangeBackgroundColor();
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
	} // end BackgroundClickHandler
	
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			doProgress();
		} // end actionPerformed
	} // end ButtonHandler
	
	private JFrame frame;
	private JPanel panel;
	private JLabel pic;
	private JProgressBar progress;
	private JButton button;
	
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
		panel.addMouseListener(new BackgroundClickHandler());
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("src\\images\\CISA-logo.png")); // why are we using two slashes?
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
		pic = new JLabel();
		pic.setIcon(new ImageIcon(myPicture));
		pic.setSize(myPicture.getWidth(), myPicture.getHeight()); // what are we doing here?
		pic.setLocation(10,60);
		pic.addMouseListener(new PicutureClickHandler());
		panel.add(pic);
		
		progress = new JProgressBar();
		progress.setSize(200, 25);
		progress.setLocation(10, 20);
		panel.add(progress);
		
		button = new JButton("Do Progress!");
		button.setSize(150, 20);
		button.setLocation(230, 20);
		button.addActionListener(new ButtonHandler());
		panel.add(button);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
	
	private void doLoadNewImage() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir")); // what is this "user.dir" stuff?
		if (jfc.showDialog(frame, "Select File") == JFileChooser.APPROVE_OPTION) { // why do we need this conditional test?
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(jfc.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
			pic.setIcon(new ImageIcon(myPicture));
			pic.setSize(myPicture.getWidth(), myPicture.getHeight()); // why do we need to do this?
			pic.repaint(); // what does this do?
		} // end if
	} // end doLoadNewImage
	
	private void doChangeBackgroundColor() {
		Color color = JColorChooser.showDialog(frame, "Choose Background Color", panel.getBackground());
		if (color != null) {
			panel.setBackground(color);
		} // end if
	} // end doChangeBackgroundColor
	
	private void doProgress() {
		
		// why does the program "hang" during this loop sequence?

		try {
			for (int i=0;i<=100;i+=10) {
				Thread.sleep(250); // what does this do?
				progress.setValue(i); // why can't we see the individual progress increments?
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end doProgress
} // end Driver