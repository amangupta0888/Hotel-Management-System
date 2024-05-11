package com.java.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener {
	Choice ch;
	JTextField roomNo, name, checkIn, price, pending;
	JButton checkBtn, updateBtn, backBtn;

	UpdateCheck() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel head = new JLabel("Update Customer's Status");
		head.setFont(new Font("Tahoma", Font.PLAIN, 24));
		head.setBounds(370, 15, 280, 35);
		head.setForeground(Color.BLUE);
		add(head);

		JLabel csId = new JLabel("Customer Id");
		csId.setBounds(80, 75, 100, 30);
		csId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(csId);

		ch = new Choice();
		ch.setBounds(215, 76, 165, 30);
		add(ch);

		try {
			Connector cn = new Connector();
			ResultSet rs = cn.stmt.executeQuery("select * from customer");

			while (rs.next()) {
				ch.add(rs.getString("ID_No"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel csRN = new JLabel("Room Number");
		csRN.setBounds(80, 120, 100, 30);
		csRN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(csRN);

		roomNo = new JTextField();
		roomNo.setBounds(215, 120, 165, 25);
		add(roomNo);

		JLabel csName = new JLabel("Customer Name");
		csName.setBounds(80, 165, 120, 30);
		csName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(csName);

		name = new JTextField();
		name.setBounds(215, 165, 165, 25);
		add(name);

		JLabel chkIn = new JLabel("Checkin Time");
		chkIn.setBounds(80, 205, 120, 30);
		chkIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chkIn);

		checkIn = new JTextField();
		checkIn.setBounds(215, 205, 165, 25);
		add(checkIn);

		JLabel prc = new JLabel("Amount Paid");
		prc.setBounds(80, 250, 120, 30);
		prc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(prc);

		price = new JTextField();
		price.setBounds(215, 250, 165, 25);
		add(price);

		JLabel pendingAmt = new JLabel("Pending Amount");
		pendingAmt.setBounds(80, 295, 120, 30);
		pendingAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(pendingAmt);

		pending = new JTextField();
		pending.setBounds(215, 295, 165, 25);
		add(pending);

		checkBtn = new JButton("Check");
		checkBtn.setBounds(100, 368, 110, 35);
		checkBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkBtn.setForeground(Color.white);
		checkBtn.setBackground(Color.black);
		checkBtn.addActionListener(this);
		add(checkBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(240, 368, 110, 35);
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		updateBtn.setForeground(Color.white);
		updateBtn.setBackground(Color.black);
		updateBtn.addActionListener(this);
		add(updateBtn);

		backBtn = new JButton("Cancel");
		backBtn.setBounds(175, 445, 110, 35);
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backBtn.setForeground(Color.white);
		backBtn.setBackground(Color.black);
		backBtn.addActionListener(this);
		add(backBtn);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/customer1.jpeg"));
		Image i1 = i.getImage().getScaledInstance(370, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(515, 82, 370, 400);
		add(img);

		setBounds(240, 99, 1000, 600);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkBtn) {
			try {
				String id = ch.getSelectedItem();
				String qry = "select * from customer where ID_No = '" + id + "'";

				Connector cn = new Connector();
				ResultSet rs = cn.stmt.executeQuery(qry);

				while (rs.next()) {
					roomNo.setText(rs.getString("Room_No"));
					name.setText(rs.getString("Name"));
					checkIn.setText(rs.getString("Check_In_Time"));
					price.setText(rs.getString("Deposit_Amt"));
				}
				ResultSet rs1 = cn.stmt.executeQuery("select * from rooms where Room_No = '" + roomNo.getText() + "'");
				while (rs1.next()) {
					String price1 = rs1.getString("Price");
					int amtPaid = Integer.parseInt(price1) - Integer.parseInt(price.getText());
					pending.setText("" + amtPaid);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == updateBtn) {
			String numb = ch.getSelectedItem();
			String room = roomNo.getText();
			String name1 = name.getText();
			String check_in = checkIn.getText();
			String deposit = price.getText();

			try {
				Connector cn = new Connector();
				cn.stmt.executeUpdate(
						"update customer set Room_No = '" + room + "', Name = '" + name1 + "', Check_in_Time = '"
								+ check_in + "', Deposit_Amt = '" + deposit + "', where ID_No = '" + numb + "'");
				JOptionPane.showMessageDialog(null, "Data Updated Successfully.");

				setVisible(false);
				new Reception();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == backBtn) {
			setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		new UpdateCheck();
	}
}
