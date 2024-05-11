package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JLabel usr, uid, psw;
	JTextField un, uidtf;
	JPasswordField pstf;
	JButton btn1, btn2, psdbtn;
	boolean psdShow = false;

	Login() {
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);

		JLabel hd = new JLabel("HOTEL AG WELCOMES YOU");
		hd.setBounds(155, 15, 700, 40);
		hd.setForeground(Color.WHITE);
		hd.setFont(new Font("serif", Font.PLAIN, 38));
		add(hd);

		usr = new JLabel("Username");
		usr.setBounds(90, 110, 170, 30);
		usr.setFont(new Font("serif", Font.PLAIN, 25));
		add(usr);

		un = new JTextField();
		un.setBounds(220, 110, 250, 35);
		add(un);

		uid = new JLabel("User ID");
		uid.setBounds(90, 190, 170, 30);
		uid.setFont(new Font("serif", Font.PLAIN, 25));
		add(uid);

		uidtf = new JTextField();
		uidtf.setBounds(220, 190, 250, 35);
		add(uidtf);

		psw = new JLabel("Password");
		psw.setBounds(90, 270, 170, 30);
		psw.setFont(new Font("serif", Font.PLAIN, 25));
		add(psw);

		pstf = new JPasswordField();
		pstf.setBounds(220, 270, 250, 35);
		add(pstf);

		psdbtn = new JButton("Show");
		psdbtn.setBounds(400, 270, 70, 35);
		psdbtn.setBackground(Color.BLUE);
		psdbtn.setForeground(Color.WHITE);
		psdbtn.setFont(new Font("Serif", Font.PLAIN, 16));
		psdbtn.addActionListener(this);
		add(psdbtn);

		btn1 = new JButton("Login");
		btn1.setBounds(140, 345, 95, 40);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.white);
		btn1.setFont(new Font("serif", Font.PLAIN, 18));
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new JButton("Cancel");
		btn2.setBounds(270, 345, 95, 40);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.white);
		btn2.setFont(new Font("serif", Font.PLAIN, 18));
		btn2.addActionListener(this);
		add(btn2);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/user.jpg"));
		JLabel img = new JLabel(i);
		img.setBounds(470, -23, 360, 450);
		add(img);

		setBounds(295, 140, 820, 450);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == psdbtn) {
			psdShow = !psdShow;
			if (psdShow) {
				psdbtn.setText("Hide");
				pstf.setEchoChar((char) 0);
			} else {
				psdbtn.setText("Show");
				pstf.setEchoChar('\u2022');
			}
		}
		if (e.getSource() == btn1) {
			String user = un.getText();
			String userId = uidtf.getText();
			String pwd = pstf.getText();

			try {
				Connector c = new Connector();
				String qry = "select * from logindata where userid = '" + userId + "' and password = '" + pwd + "'";
				ResultSet rs = c.stmt.executeQuery(qry);

				if (rs.next()) {
					setVisible(false);
					new Home();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid data....");
					setVisible(false);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == btn2) {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Login();
	}

}
