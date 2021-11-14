package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1;

	public Login_user() {
            
	setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230));
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(160, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(160, 124, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(260, 93, 160, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(260, 128, 160, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.BLACK);
	b1.setBackground(new Color(250, 250, 210));
	b1.setBounds(250, 181, 113, 39);
	panel.add(b1);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(176, 224, 230));
		panel2.setBounds(24, 40, 434, 263);
		panel.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
		try {
                    if (textField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                        this.setVisible(false);
                        new Home().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
        }
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
