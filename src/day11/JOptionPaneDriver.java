package day11;

import javax.swing.JOptionPane;

public class JOptionPaneDriver {

	public static void main(String[] args) {
		String fName = JOptionPane.showInputDialog("Hi, what is your first name?");
		JOptionPane.showMessageDialog(null, "Greetings, " + fName, "Nice to meet you!", JOptionPane.PLAIN_MESSAGE);

		int choice = JOptionPane.showConfirmDialog(null, "Please click your choice of buttons!");
		// 0 = button 1, 1 = button 2, 2 = button 3
		String clicked = choice == 0?"Yes":choice == 1?"No":"Cancel";
		JOptionPane.showMessageDialog(null, "You clicked the " + clicked + " button!", "Clicked Button Report", JOptionPane.PLAIN_MESSAGE);

		// we can label the buttons as we choose
		Object[] buttons = {"CISA","Accounting","EFIRM","Mgmt. & Mktg."};
		int buttonChoice = JOptionPane.showOptionDialog(null, "Please select your department", "Department Indication", JOptionPane.YES_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null /*no custom icon*/, buttons, buttons[0] /*indicate default button*/);
		JOptionPane.showMessageDialog(null, "You clicked button #:" + (buttonChoice+1) + ".", "Clicked Button Report", JOptionPane.PLAIN_MESSAGE);
	} // end main
} // end JOptionPaneDriver