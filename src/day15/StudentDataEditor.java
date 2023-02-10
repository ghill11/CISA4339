package day15;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class StudentDataEditor extends JDialog {
	
	private class SaveButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			
		} // end actionPerformed
	} // end SaveButtonHandler
	
	private class CancelButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			
		} // end actionPerformed
	} // end CancelButtonHandler
	
	
	private JPanel panel;
	private JLabel lblFName;
	private JLabel lblLName;
	private JLabel lblgpa;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtgpa;
	private JButton save;
	private JButton cancel;
	
	public StudentDataEditor() {
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
		txtFName.setLocation(80,20);
		txtFName.setSize(100, 20);
		panel.add(txtFName);
		
		lblLName = new JLabel("Last name:");
		lblLName.setLocation(10,50);
		lblLName.setSize(100, 20);
		panel.add(lblLName);
		
		txtLName = new JTextField(15);
		txtLName.setLocation(80,50);
		txtLName.setSize(100, 20);
		panel.add(txtLName);
		
		lblgpa = new JLabel("GPA:");
		lblgpa.setLocation(10,80);
		lblgpa.setSize(100, 20);
		panel.add(lblgpa);
		
		txtgpa = new JTextField(15);
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