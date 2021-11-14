package library.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class aboutUs extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b2;

        public static void main(String[] args) {
            new aboutUs().setVisible(true);			
	}
        public aboutUs() {
            
            super("About Us - Group 10");
            setBackground(new Color(173, 216, 230));
            setBounds(500, 250, 700, 500);
		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel l1 = new JLabel("New label");
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/logo.png"));
            Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l1 = new JLabel(i3);
            l1.setBounds(500, 40, 100, 100);
            contentPane.add(l1);


            JLabel l3 = new JLabel("Library");
            l3.setForeground(new Color(255, 0, 117));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(200, 60, 150, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("Mangement System");
            l4.setForeground(new Color(61, 44, 141));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(110, 110, 405, 40);
            contentPane.add(l4);
            
            JLabel l6 = new JLabel("Developed By : Group 10");
            l6.setForeground(new Color(23, 215, 160));
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            l6.setBounds(70, 198, 600, 35);
            contentPane.add(l6);

            JLabel l7 = new JLabel("LCI2020050 lci2020050@iiitl.ac.in Konark Kumar Koshta");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l7.setBounds(70, 260, 600, 34);
            contentPane.add(l7);

            JLabel l8 = new JLabel("LCI2020070 lci2020070@iiitl.ac.in Mradul Kumar Gangle");
            l8.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l8.setBounds(70, 290, 600, 34);
            contentPane.add(l8);

            JLabel l9 = new JLabel("LCI2020075 lci2020075@iiitl.ac.in Khyati Vaishnavi Singh");
            l9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l9.setBounds(70, 320, 600, 34);
            contentPane.add(l9);

            JLabel l10 = new JLabel("LCI2020080 lci2020080@iiitl.ac.in Ritu Kumari");
            l10.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l10.setBounds(70, 350, 600, 34);
            contentPane.add(l10);
            
        b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(10, 10, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
	contentPane.add(b2);	     
        contentPane.setBackground(Color.WHITE);
	}

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();           
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);
            }
            con.c.close();
        }catch(Exception e){
            
        }
    }    

}

