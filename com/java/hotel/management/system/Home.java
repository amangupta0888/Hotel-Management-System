package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {

	Home() {
		setBounds(0, 0, 1550, 1000);
		setLayout(null);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
		Image i1 = i.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(0, 0, 1500, 1000);
		add(img);

		JLabel txt = new JLabel("HOTEL AG WELCOMES YOU");
		txt.setBounds(7, 50, 900, 70);
		txt.setFont(new Font("serif", Font.BOLD, 55));
		txt.setForeground(Color.CYAN);
		img.add(txt);

		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1550, 50);
		mb.setBackground(Color.black);
		img.add(mb);

		JMenu mn1 = new JMenu("Hotel Management");
		mn1.setBounds(0, 0, 100, 45);
		mn1.setFont(new Font("serif", Font.PLAIN, 18));
		mn1.setForeground(Color.RED);
		mb.add(mn1);

		JMenuItem rec = new JMenuItem("Reception");
		rec.addActionListener(this);
		mn1.add(rec);

		JMenu mn2 = new JMenu("Admin");
		mn2.setBounds(100, 0, 100, 45);
		mn2.setFont(new Font("serif", Font.PLAIN, 18));
		mn2.setForeground(Color.blue);
		mb.add(mn2);

		JMenuItem addEmp = new JMenuItem("Add Employee");
		addEmp.addActionListener(this);
		mn2.add(addEmp);

		JMenuItem addRoom = new JMenuItem("Add Rooms");
		addRoom.addActionListener(this);
		mn2.add(addRoom);

		JMenuItem addDvr = new JMenuItem("Add Drivers");
		addDvr.addActionListener(this);
		mn2.add(addDvr);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add Employee")) {
			new AddEmployee();
		} else if (e.getActionCommand().equals("Add Rooms")) {
			new AddRoom();
		} else if (e.getActionCommand().equals("Add Drivers")) {
			new AddDrivers();
		} else if (e.getActionCommand().equals("Reception")) {
			new Reception();
		}
	}

	public static void main(String[] args) {
		new Home();
	}
}
