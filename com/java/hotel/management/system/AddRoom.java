package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom extends JFrame implements ActionListener {
	JTextField rnTF, prcTF;
	JComboBox roomAvail, bedType, cleanStat;
	JButton sbmt, cncl;

	AddRoom() {
		setLayout(null);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
		Image i1 = i.getImage().getScaledInstance(320, 320, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(600, 40, 320, 450);
		add(img);

		JLabel hName = new JLabel("HOTEL AG");
		hName.setBounds(400, 15, 250, 40);
		hName.setFont(new Font("Tahoma", Font.PLAIN, 39));
		hName.setForeground(Color.LIGHT_GRAY);
		add(hName);

		JLabel rHead = new JLabel("Add Room");
		rHead.setBounds(185, 65, 120, 35);
		rHead.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 25));
		rHead.setForeground(Color.gray);
		add(rHead);

		JLabel rn = new JLabel("Room Number");
		rn.setBounds(100, 120, 130, 30);
		rn.setFont(new Font("Serif", Font.PLAIN, 21));
		rn.setForeground(Color.white);
		add(rn);

		rnTF = new JTextField();
		rnTF.setBounds(270, 120, 190, 25);
		add(rnTF);

		JLabel rAvail = new JLabel("Available");
		rAvail.setBounds(100, 175, 110, 30);
		rAvail.setFont(new Font("Serif", Font.PLAIN, 21));
		rAvail.setForeground(Color.white);
		add(rAvail);

		String str1[] = { "Yes", "No" };
		roomAvail = new JComboBox(str1);
		roomAvail.setBounds(270, 175, 190, 25);
		add(roomAvail);

		JLabel bed = new JLabel("Bed Type");
		bed.setBounds(100, 230, 110, 30);
		bed.setFont(new Font("Serif", Font.PLAIN, 21));
		bed.setForeground(Color.white);
		add(bed);

		String str2[] = { "Single Bed", "Double Bed" };
		bedType = new JComboBox(str2);
		bedType.setBounds(270, 230, 190, 25);
		add(bedType);

		JLabel rc = new JLabel("Cleaning Status");
		rc.setBounds(100, 285, 130, 30);
		rc.setFont(new Font("Serif", Font.PLAIN, 21));
		rc.setForeground(Color.white);
		add(rc);

		String str3[] = { "Cleaned", "Dirty" };
		cleanStat = new JComboBox(str3);
		cleanStat.setBounds(270, 285, 190, 25);
		add(cleanStat);

		JLabel prc = new JLabel("Price");
		prc.setBounds(100, 340, 130, 30);
		prc.setFont(new Font("Serif", Font.PLAIN, 21));
		prc.setForeground(Color.white);
		add(prc);

		prcTF = new JTextField();
		prcTF.setBounds(270, 340, 190, 25);
		add(prcTF);

		sbmt = new JButton("Submit");
		sbmt.setFont(new Font("Serif", Font.PLAIN, 24));
		sbmt.setBounds(125, 425, 140, 38);
		sbmt.setBackground(Color.LIGHT_GRAY);
		sbmt.addActionListener(this);
		add(sbmt);

		cncl = new JButton("Cancel");
		cncl.setFont(new Font("Serif", Font.PLAIN, 24));
		cncl.setBounds(290, 425, 140, 38);
		cncl.setBackground(Color.LIGHT_GRAY);
		cncl.addActionListener(this);
		add(cncl);

		getContentPane().setBackground(Color.black);
		setBounds(240, 90, 1050, 535);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbmt) {
			String roomNo = rnTF.getText();
			String availability = (String) roomAvail.getSelectedItem();
			String cleaness = (String) cleanStat.getSelectedItem();
			String bdType = (String) bedType.getSelectedItem();
			String roomPrice = prcTF.getText();

			try {
				Connector cn = new Connector();
				String qry = "insert into rooms values('" + roomNo + "','" + availability + "','" + cleaness + "','"
						+ bdType + "','" + roomPrice + "')";
				cn.stmt.executeUpdate(qry);

				JOptionPane.showMessageDialog(null, "New Room Added Successfully.");
				setVisible(false);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new AddRoom();
	}

}
