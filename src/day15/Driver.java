package day15;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Driver {
	
	private class AddButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			
		} // end actionPerformed
	} // end AddButtonHandler
	
	private List<Student> courseRoster;
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JScrollPane scroll;
	private JButton add;
	
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
		roster.add(new Student("Katherine","Johnson",3.98));
		roster.add(new Student("Steve","Jobs",1.2));
		roster.add(new Student("Ada","Countess of Lovelace",3.67));
		roster.add(new Student("Marvin","the Martian",3.9));
		roster.add(new Student("Gossamer","the Monster",2.83));
		roster.add(new Student("Fred","Flintstone",1.67));
		roster.add(new Student("George","Jetson",2.58));
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
		
		
		Object[] columnNames = new Object[] {"First Name","Last Name", "GPA"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // 0 indicates no rows at this time
		for (Student eachOne: courseRoster) {
			tableModel.addRow(new Object[] {eachOne.getfName(),eachOne.getlName(),eachOne.getGpa()});
		} // end for
		table = new JTable(tableModel);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF ); // allows us to manage the column width without Java overriding our settings!

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setWidth(100);
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setWidth(125);
		columnModel.getColumn(1).setPreferredWidth(125);
		columnModel.getColumn(2).setWidth(150);
		columnModel.getColumn(2).setPreferredWidth(150);
		
		scroll = new JScrollPane(table);
		scroll.setSize(new Dimension(375,125));
		scroll.setLocation(10,25);
		panel.add(scroll);
		
		add = new JButton("Add New Record");
		add.setFont(new Font("Arial",Font.BOLD,18));
		add.setLocation(10,175);
		add.setSize(200,40);
		add.addActionListener(new AddButtonHandler());
		panel.add(add);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents
} // end Driver