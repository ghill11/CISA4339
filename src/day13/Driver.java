package day13;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Driver {
	
	private class RegistrationButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			demoStudent.addCourse(txtCourse.getText());
			updateSchedule();
		} // end actionPerformed
	} // end RegistrationHandler

	private class DropButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			demoStudent.dropCourse(txtCourse.getText());
			updateSchedule();			
		} // end actionPerformed
	} // end DropButtonHandler
	
	private JFrame frame;
	private JPanel panel;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblGPA;
	private JLabel lblCourse;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtGPA;
	private JTextField txtCourse;
	private JTextArea txtSchedule;
	private JScrollPane scroll;
	private JButton btnAddCourse;
	private JButton btnDropCourse;
	private JCheckBox graduating;
	private JRadioButton freshman;
	private JRadioButton sophomore;
	private JRadioButton junior;
	private JRadioButton senior;
	private ButtonGroup standing; // notice no "J" prefix!
	private Student demoStudent = new Student("Grace","Hopper",3.89);
	
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
		frame.setTitle("Day 13 Demonstration");
		frame.setLayout(null);
		frame.setSize(new Dimension(475,300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(100,100);
		panel.setSize(new Dimension(frame.getSize()));
		panel.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Student Information Panel", 
				   TitledBorder.LEFT, TitledBorder.TOP));
		
		lblFirstName = new JLabel("First name:");
		lblFirstName.setLocation(10,20);
		lblFirstName.setSize(100,20);
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField(demoStudent.getfName());
		txtFirstName.setLocation(110,20);
		txtFirstName.setSize(125,20);
		panel.add(txtFirstName);
		
		lblLastName = new JLabel("Last name:");
		lblLastName.setLocation(10,50);
		lblLastName.setSize(100,20);
		panel.add(lblLastName);
		
		txtLastName = new JTextField(demoStudent.getlName());
		txtLastName.setLocation(110,50);
		txtLastName.setSize(125,20);
		panel.add(txtLastName);
		
		lblGPA = new JLabel("GPA:");
		lblGPA.setLocation(10,80);
		lblGPA.setSize(100,20);
		panel.add(lblGPA);
		
		txtGPA = new JTextField(String.valueOf(demoStudent.getGpa()));
		txtGPA.setLocation(110,80);
		txtGPA.setSize(125,20);
		panel.add(txtGPA);
		
		txtSchedule = new JTextArea();
		txtSchedule.setWrapStyleWord(true);
		txtSchedule.setLineWrap(true);
		txtSchedule.setEditable(false);
		scroll = new JScrollPane(txtSchedule);
		scroll.setLocation(10,110);
		scroll.setSize(300,100);
		panel.add(scroll);
		
		lblCourse = new JLabel("Course Number:");
		lblCourse.setLocation(10,220);
		lblCourse.setSize(100,20);
		panel.add(lblCourse);
		
		txtCourse = new JTextField();
		txtCourse.setLocation(110,220);
		txtCourse.setSize(50,20);
		panel.add(txtCourse);
		
		btnAddCourse = new JButton("Register!");
		btnAddCourse.setLocation(170,220);
		btnAddCourse.setSize(100,20);
		btnAddCourse.addActionListener(new RegistrationButtonHandler());
		panel.add(btnAddCourse);
		
		btnDropCourse = new JButton("Drop!");
		btnDropCourse.setLocation(290,220);
		btnDropCourse.setSize(100,20);
		btnDropCourse.addActionListener(new DropButtonHandler());
		panel.add(btnDropCourse);
		
		graduating = new JCheckBox("Graduating this semester?"); // can pass a 2nd argument [boolean] to indicate checked by default 
		graduating.setLocation(250,20);
		graduating.setSize(185,20);
		panel.add(graduating);
		
		standing = new ButtonGroup(); // instantiate the button group!
		
		freshman = new JRadioButton("Freshman", true); // this one will be selected by default
		freshman.setActionCommand("freshman");
		freshman.setLocation(250,50);
		freshman.setSize(100,20);
		standing.add(freshman); // add radio button object to the group
		panel.add(freshman); // add the radio button object to the container, not the group!
		
		sophomore = new JRadioButton("Sophomore");
		sophomore.setActionCommand("sophomore");
		sophomore.setLocation(250,70);
		sophomore.setSize(100,20);
		standing.add(sophomore);
		panel.add(sophomore);
		
		junior = new JRadioButton("Junior");
		junior.setActionCommand("junior");
		junior.setLocation(350,50);
		junior.setSize(100,20);
		standing.add(junior);
		panel.add(junior);
		
		senior = new JRadioButton("Senior");
		senior.setActionCommand("senior");
		senior.setLocation(350,70);
		senior.setSize(100,20);
		standing.add(senior);
		panel.add(senior);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	} // end initComponents

	private void updateSchedule() {
		this.txtSchedule.setText(this.standing.getSelection().getActionCommand().toUpperCase());
		this.txtSchedule.append(" " + (this.graduating.isSelected()?" GRADUATING!":"") + "\n");
		this.txtSchedule.append(demoStudent.toString());
	} // end updateSchedule
} // end Driver