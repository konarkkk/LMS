package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_6;
    private JButton b1,b2,b3;
    private JDateChooser dateChooser;

    public static void main(String[] args) {
	new ReturnBook().setVisible(true);
    }

    public ReturnBook() {
        setBounds(450, 300, 617, 363);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("BookID");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(52, 52, 87, 24);
	contentPane.add(lblNewLabel);

	JLabel lblStudentid = new JLabel("CollegeID");
	lblStudentid.setForeground(Color.BLACK);
	lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblStudentid.setBounds(243, 52, 87, 24);
	contentPane.add(lblStudentid);

	JLabel lblBook = new JLabel("Book");
	lblBook.setForeground(Color.BLACK);
	lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBook.setBounds(52, 98, 71, 24);
	contentPane.add(lblBook);

	JLabel lblName = new JLabel("Name");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(300, 98, 71, 24);
	contentPane.add(lblName);

	JLabel lblDateOfIssue = new JLabel("Date of Issue");
	lblDateOfIssue.setForeground(Color.BLACK);
	lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfIssue.setBounds(52, 144, 105, 29);
	contentPane.add(lblDateOfIssue);

	JLabel lblDateOfReturn = new JLabel("Date of Return");
	lblDateOfReturn.setForeground(Color.BLACK);
	lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfReturn.setBounds(52, 190, 118, 29);
	contentPane.add(lblDateOfReturn);

        textField = new JTextField();
	textField.setForeground(new Color(105, 105, 105));
	textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField.setBounds(128, 56, 105, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setForeground(new Color(105, 105, 105));
	textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField_1.setBounds(340, 56, 93, 20);
	contentPane.add(textField_1);
	textField_1.setColumns(10);

	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBounds(443, 52, 105, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
	contentPane.add(b1);

	textField_2 = new JTextField();
	textField_2.setEditable(false);
	textField_2.setForeground(new Color(0, 100, 0));
	textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_2.setBounds(128, 102, 162, 20);
	contentPane.add(textField_2);
	textField_2.setColumns(10);

	textField_3 = new JTextField();
	textField_3.setEditable(false);
	textField_3.setForeground(new Color(0, 100, 0));
	textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_3.setColumns(10);
	textField_3.setBounds(369, 102, 179, 20);
	contentPane.add(textField_3);

	textField_6 = new JTextField();
	textField_6.setForeground(new Color(0, 100, 0));
	textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_6.setEditable(false);
	textField_6.setColumns(10);
	textField_6.setBounds(167, 145, 162, 20);
	contentPane.add(textField_6);

	dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy/MM/dd");
	dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	dateChooser.setBounds(167, 190, 172, 29);
	contentPane.add(dateChooser);

	b2 = new JButton("Return");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b2.setBounds(369, 150, 149, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
	contentPane.add(b2);
        
	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b3.setBounds(369, 200, 149, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.BLACK);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 2, true), "Return-Panel",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
	panel.setBounds(10, 24, 569, 269);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from history where CID = ? and BID =?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField_1.getText());
		st.setString(2, textField.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    textField_2.setText(rs.getString("BName"));
                    textField_3.setText(rs.getString("SName"));
                    textField_6.setText(rs.getString("Idate"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2){
                String sql = "update history set Rdate= ? where TID=(select TID from books where BID=?)";
		PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
		st.setString(2, textField.getText());
		int i = st.executeUpdate();
		if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Return Successful");
		} else
                    JOptionPane.showMessageDialog(null, "error");
		
            }
            if(ae.getSource() == b2){
                String sql = "update books set TID=NULL where BID=?;";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField.getText());
		int i = st.executeUpdate();
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Home().setVisible(true);	
            }
        }catch(Exception e){
            
        }
    }
}
