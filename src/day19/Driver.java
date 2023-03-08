package day19;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {
	
	// T is type returned by doInBackground(), done(), and get()
	// V is the type used for intermediate results during publish() and process() methods
	// https://www.codementor.io/@isaib.cicourel/swingworker-in-java-du1084lyl
	private class Update extends SwingWorker<Void, Integer> {
		@Override
		protected Void doInBackground() throws Exception {
			NumberFormat nf = NumberFormat.getIntegerInstance();
			int delay = nf.parse(textDelay.getText()).intValue();
			for (int i=1;i<=100;i++) {
				publish(i); 
				Thread.sleep(delay);
			} // end for
			return null;
		} // end doInBackground

		@Override
		protected void process(List<Integer> chunk) { // the V type is nested inside a List
			// https://stackoverflow.com/questions/18535303/how-are-the-publish-and-process-methods-on-swingworker-properly-used
			status.setValue(chunk.get(0));
		} // end process
	} // end Update
	
    private class GoButtonHandler implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent ae) {
    		new Update().execute();
		} // end actionPerformed
    } // end GoButtonHandler
    
	private JFrame frame;
	private JPanel panel;
	private JLabel labelDelay;
	private JTextField textDelay;
	private JButton goButton;
	private JProgressBar status;
	
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
		
		labelDelay = new JLabel("Enter delay (in milliseconds):");
		labelDelay.setSize(new Dimension(200, 20));
		labelDelay.setLocation(75, 80);
		panel.add(labelDelay);
		
		textDelay = new JTextField("100");
		textDelay.setSize(new Dimension(80, 20));
		textDelay.setLocation(250, 80);
		panel.add(textDelay);
		
		goButton = new JButton("Go!");
		goButton.setSize(new Dimension(80, 40));
		goButton.setLocation(160, 110);
		goButton.addActionListener(new GoButtonHandler());
		panel.add(goButton);
		
		status = new JProgressBar();
		status.setSize(350, 50);
		status.setLocation(25, 160);
		status.setValue(0);
		status.setForeground(Color.GREEN);
		panel.add(status);
		
		frame.setResizable(false);
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
} // end Driver