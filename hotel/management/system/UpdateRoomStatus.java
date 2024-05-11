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

public class UpdateRoomStatus extends JFrame implements ActionListener {
	Choice ch;
	JTextField roomNo, available, cleanStatus;
	JButton checkBtn, updateBtn, backBtn;

	UpdateRoomStatus() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel head = new JLabel("Update Room Status");
		head.setFont(new Font("Tahoma", Font.PLAIN, 24));
		head.setBounds(370, 15, 280, 35);
		head.setForeground(Color.BLUE);
		add(head);

		JLabel csId = new JLabel("Customer Id");
		csId.setBounds(80, 98, 100, 30);
		csId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(csId);

		ch = new Choice();
		ch.setBounds(215, 100, 165, 30);
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
		csRN.setBounds(80, 155, 100, 30);
		csRN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(csRN);

		roomNo = new JTextField();
		roomNo.setBounds(215, 155, 165, 25);
		add(roomNo);

		JLabel availablility = new JLabel("Availability");
		availablility.setBounds(80, 210, 120, 30);
		availablility.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(availablility);

		available = new JTextField();
		available.setBounds(215, 210, 165, 25);
		add(available);

		JLabel clean = new JLabel("Cleaning Status");
		clean.setBounds(80, 265, 120, 30);
		clean.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(clean);

		cleanStatus = new JTextField();
		cleanStatus.setBounds(215, 265, 165, 25);
		add(cleanStatus);

		checkBtn = new JButton("Check");
		checkBtn.setBounds(100, 330, 110, 35);
		checkBtn.setFont(new Font("Tahom", Font.PLAIN, 17));
		checkBtn.setForeground(Color.white);
		checkBtn.setBackground(Color.black);
		checkBtn.addActionListener(this);
		add(checkBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(240, 330, 110, 35);
		updateBtn.setFont(new Font("Tahom", Font.PLAIN, 17));
		updateBtn.setForeground(Color.white);
		updateBtn.setBackground(Color.black);
		updateBtn.addActionListener(this);
		add(updateBtn);

		backBtn = new JButton("Cancel");
		backBtn.setBounds(175, 395, 110, 35);
		backBtn.setFont(new Font("Tahom", Font.PLAIN, 17));
		backBtn.setForeground(Color.white);
		backBtn.setBackground(Color.black);
		backBtn.addActionListener(this);
		add(backBtn);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/customer1.jpeg"));
		Image i1 = i.getImage().getScaledInstance(370, 350, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(515, 72, 370, 350);
		add(img);

		setBounds(280, 109, 1000, 500);
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

				}
				ResultSet rs1 = cn.stmt.executeQuery("select * from rooms where Room_No = '" + roomNo.getText() + "'");
				while (rs1.next()) {
					available.setText(rs1.getString("Availability"));
					cleanStatus.setText(rs1.getString("Cleaning_Status"));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == updateBtn) {
			String numb = ch.getSelectedItem();
			String room = roomNo.getText();
			String avl = available.getText();
			String status = cleanStatus.getText();

			try {
				Connector cn = new Connector();
				cn.stmt.executeUpdate("update rooms set availbility = '" + avl + "', cleaning_status = '" + status
						+ "', where room_no = '" + room + "'");
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
		new UpdateRoomStatus();
	}
}
