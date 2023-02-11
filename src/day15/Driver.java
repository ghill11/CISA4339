package day15;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Driver {
	
	public class StudentDataEditor extends JDialog {
		
		private class SaveButtonHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (activeRow == -1) { // this is a new record
					courseRoster.add(new Student(txtFName.getText(), txtLName.getText(), Double.valueOf(txtgpa.getText())));
				} else { // edit an existing record
					Student editMe = courseRoster.get(activeRow);
					editMe.setfName(txtFName.getText());
					editMe.setlName(txtLName.getText());
					editMe.setGpa(Double.valueOf(txtgpa.getText()));
					// why don't we need to add "editMe" back to the collection?
				} // end else
				showData();
				dispose();
			} // end actionPerformed
		} // end SaveButtonHandler
		
		private class CancelButtonHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dispose();
			} // end actionPerformed
		} // end CancelButtonHandler
		
		private List<Student> courseRoster;
		private int activeRow;
		private JPanel panel;
		private JLabel lblFName;
		private JLabel lblLName;
		private JLabel lblgpa;
		private JTextField txtFName;
		private JTextField txtLName;
		private JTextField txtgpa;
		private JButton save;
		private JButton cancel;
		
		public StudentDataEditor(int activeRow, List<Student> courseRoster) {
			this.activeRow = activeRow;
			this.courseRoster = courseRoster;
			initComponents();
		} // end ctor
		
		private void initComponents() {
			this.setSize(new Dimension(200,210));
			this.setTitle("Data Editor");

			panel = new JPanel();
			panel.setLayout(null);
			panel.setLocation(100,100);
			panel.setSize(new Dimension(this.getSize()));
			panel.setBorder(BorderFactory.createTitledBorder(
					   BorderFactory.createEtchedBorder(), "Student Information", 
					   TitledBorder.LEFT, TitledBorder.TOP));
			
			lblFName = new JLabel("First name:");
			lblFName.setLocation(10,20);
			lblFName.setSize(100, 20);
			panel.add(lblFName);
			
			txtFName = new JTextField(15);
			if (activeRow!=-1) {txtFName.setText(courseRoster.get(activeRow).getfName());}
			txtFName.setLocation(80,20);
			txtFName.setSize(100, 20);
			panel.add(txtFName);
			
			lblLName = new JLabel("Last name:");
			lblLName.setLocation(10,50);
			lblLName.setSize(100, 20);
			panel.add(lblLName);
			
			txtLName = new JTextField(15);
			if (activeRow!=-1) {txtLName.setText(courseRoster.get(activeRow).getlName());}
			txtLName.setLocation(80,50);
			txtLName.setSize(100, 20);
			panel.add(txtLName);
			
			lblgpa = new JLabel("GPA:");
			lblgpa.setLocation(10,80);
			lblgpa.setSize(100, 20);
			panel.add(lblgpa);
			
			txtgpa = new JTextField(15);
			if (activeRow!=-1) {txtgpa.setText(String.valueOf(courseRoster.get(activeRow).getGpa()));}
			txtgpa.setLocation(80,80);
			txtgpa.setSize(100, 20);
			panel.add(txtgpa);

			save = new JButton("Save Record");
			save.setLocation(10,125);
			save.setSize(125,20);
			save.addActionListener(new SaveButtonHandler());
			panel.add(save);
			
			cancel = new JButton("Cancel");
			cancel.setLocation(10,150);
			cancel.setSize(125,20);
			cancel.addActionListener(new CancelButtonHandler());
			panel.add(cancel);
			
			this.setContentPane(panel);
			this.setSize(200,220);
			this.setModal(true);
			this.setVisible(true);
		} // end initComponents
	} // end StudentDataEditor
	
	private class AddButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			new StudentDataEditor(-1, courseRoster); // -1 indicates this will be a new record
		} // end actionPerformed
	} // end AddButtonHandler
	
	private class RowSelectionListener  implements ListSelectionListener  {
		@Override
		public void valueChanged(ListSelectionEvent e) {
        	// need to check .getValueIsAdjusting() as the event is fired twice
        	// doing this makes sure only one popup is created!
            if (table.getSelectedRow() != -1 && e.getValueIsAdjusting()) {
                // create a new modal popup window
    			new StudentDataEditor(table.getSelectedRow(), courseRoster); // -1 indicates this will be a new record
            } // end if
        } // end valueChanged
	} // end RowSelectionListener 
	
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

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // allows us to manage the column width without Java overriding our settings!
        table.getSelectionModel().addListSelectionListener(new RowSelectionListener());

        showData(); // why break this to another method?
		
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
	
	public void showData() { // this is reusable!
		Object[] columnNames = new Object[] {"First Name","Last Name", "GPA"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // 0 indicates no rows at this time
		for (Student eachOne: courseRoster) { // now add the rows of data
			tableModel.addRow(new Object[] {eachOne.getfName(),eachOne.getlName(),eachOne.getGpa()});
		} // end for
		table.setModel(tableModel);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setWidth(100);
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setWidth(125);
		columnModel.getColumn(1).setPreferredWidth(125);
		columnModel.getColumn(2).setWidth(150);
		columnModel.getColumn(2).setPreferredWidth(150);
	} // end showData
} // end Driver