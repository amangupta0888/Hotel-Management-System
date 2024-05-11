package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

	JButton newCustomer, newRooms, allEmp, mgInfo, cstInfo, srchRoom, updStat, roomStat, pkup, checkout;

	Reception() {
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel h1 = new JLabel("Hotel AG Welcomes You");
		h1.setBounds(265, 12, 350, 32);
		h1.setForeground(Color.blue);
		h1.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(h1);

		newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(65, 70, 200, 35);
		newCustomer.setForeground(Color.white);
		newCustomer.setBackground(Color.black);
		newCustomer.setFont(new Font("Serif", Font.PLAIN, 19));
		newCustomer.addActionListener(this);
		add(newCustomer);

		newRooms = new JButton("Rooms");
		newRooms.setBounds(65, 125, 200, 35);
		newRooms.setForeground(Color.white);
		newRooms.setBackground(Color.black);
		newRooms.setFont(new Font("Serif", Font.PLAIN, 19));
		newRooms.addActionListener(this);
		add(newRooms);

		allEmp = new JButton("Employee Info");
		allEmp.setBounds(65, 180, 200, 35);
		allEmp.setForeground(Color.white);
		allEmp.setBackground(Color.black);
		allEmp.setFont(new Font("Serif", Font.PLAIN, 19));
		allEmp.addActionListener(this);
		add(allEmp);

		cstInfo = new JButton("Customer Info");
		cstInfo.setBounds(65, 235, 200, 35);
		cstInfo.setForeground(Color.white);
		cstInfo.setBackground(Color.black);
		cstInfo.setFont(new Font("Serif", Font.PLAIN, 19));
		cstInfo.addActionListener(this);
		add(cstInfo);

		mgInfo = new JButton("Manager Info");
		mgInfo.setBounds(65, 290, 200, 35);
		mgInfo.setForeground(Color.white);
		mgInfo.setBackground(Color.black);
		mgInfo.setFont(new Font("Serif", Font.PLAIN, 19));
		mgInfo.addActionListener(this);
		add(mgInfo);

		checkout = new JButton("Check-Out");
		checkout.setBounds(65, 345, 200, 35);
		checkout.setForeground(Color.white);
		checkout.setBackground(Color.black);
		checkout.setFont(new Font("Serif", Font.PLAIN, 19));
		checkout.addActionListener(this);
		add(checkout);

		updStat = new JButton("Update Status");
		updStat.setBounds(65, 400, 200, 35);
		updStat.setForeground(Color.white);
		updStat.setBackground(Color.black);
		updStat.setFont(new Font("Serif", Font.PLAIN, 19));
		updStat.addActionListener(this);
		add(updStat);

		roomStat = new JButton("Room Status");
		roomStat.setBounds(65, 455, 200, 35);
		roomStat.setForeground(Color.white);
		roomStat.setBackground(Color.black);
		roomStat.setFont(new Font("Serif", Font.PLAIN, 19));
		roomStat.addActionListener(this);
		add(roomStat);

		srchRoom = new JButton("Search Room");
		srchRoom.setBounds(65, 510, 200, 35);
		srchRoom.setForeground(Color.white);
		srchRoom.setBackground(Color.black);
		srchRoom.setFont(new Font("Serif", Font.PLAIN, 19));
		srchRoom.addActionListener(this);
		add(srchRoom);

		pkup = new JButton("Pickup Service");
		pkup.setBounds(65, 565, 200, 35);
		pkup.setForeground(Color.white);
		pkup.setBackground(Color.black);
		pkup.setFont(new Font("Serif", Font.PLAIN, 19));
		pkup.addActionListener(this);
		add(pkup);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/reception2.jpg"));
		Image i1 = i.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(350, 75, 450, 500);
		add(img);

		setBounds(290, 99, 900, 670);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newCustomer) {
			setVisible(false);
			new AddCustomer();
		} else if (e.getSource() == newRooms) {
			setVisible(false);
			new Rooms();
		} else if (e.getSource() == allEmp) {
			setVisible(false);
			new EmployeeInfo();
		} else if (e.getSource() == cstInfo) {
			setVisible(false);
			new CustomerInfo();
		} else if (e.getSource() == mgInfo) {
			setVisible(false);
			new ManagerInfo();
		} else if (e.getSource() == srchRoom) {
			setVisible(false);
			new SearchRoom();
		} else if (e.getSource() == updStat) {
			setVisible(false);
			new UpdateCheck();
		} else if (e.getSource() == roomStat) {
			setVisible(false);
			new UpdateRoomStatus();
		} else if (e.getSource() == pkup) {
			setVisible(false);
			new PickupService();
		} else if (e.getSource() == checkout) {
			setVisible(false);
			new Checkout();
		}

	}

	public static void main(String[] args) {
		new Reception();
	}

}
