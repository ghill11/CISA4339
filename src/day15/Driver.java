package day15;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {
	private List<Student> courseRoster;
	private JFrame frame;
	private JPanel panel;
	private JTable table;
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
		courseRoster = initData();
		initComponents();
	} // end ctor
	
	private List<Student> initData(){
		List<Student> roster = new ArrayList<Student>();
		roster.add(new Student("Grace","Hopper",4.0));
		roster.add(new Student("Steve","Jobs",1.2));
		return roster;
	} // end initData
	
	private void initComponents() {
		frame = new JFrame();
		frame.setTitle("Day 15 Demonstration");
		frame.setLayout(null);
		frame.setSize(new Dimension(475,300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(100,100);
		panel.setSize(new Dimension(frame.getSize()));
		panel.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Student Information", 
				   TitledBorder.LEFT, TitledBorder.TOP));
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
} // end Driver