package day10;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class FractalDriver {
    private class GoButtonHandler implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent ae) {
    		try {
    			new Fractal(textLevels.getText());
    		} catch (Exception e) {
    			e.printStackTrace();
    		} // end catch
		} // end actionPerformed
    } // end GoButtonHandler
    
    private JFrame frame;
	private JPanel panel;
	private JLabel labelLevels;
	private JTextField textLevels;
	private JButton goButton;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FractalDriver();
			} // end method run
		});
	} // end main
	
	public FractalDriver() {
		initComponents();
	} // end ctor
	
	private void initComponents() {
		frame = new JFrame();
		frame.setTitle("Demonstration Threaded Status Bar");
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
		
		labelLevels = new JLabel("Number of levels to draw:");
		labelLevels.setSize(new Dimension(200, 20));
		labelLevels.setLocation(75, 80);
		panel.add(labelLevels);
		
		textLevels = new JTextField("10");
		textLevels.setSize(new Dimension(80, 20));
		textLevels.setLocation(250, 80);
		panel.add(textLevels);
		
		goButton = new JButton("Go!");
		goButton.setSize(new Dimension(80, 40));
		goButton.setLocation(160, 110);
		goButton.addActionListener(new GoButtonHandler());
		panel.add(goButton);
		
		frame.setResizable(false);
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
} // end FractalDriver