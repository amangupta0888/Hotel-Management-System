package com.java.hotel.management.system;

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
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Rooms extends JFrame implements ActionListener {

	JTable tbl;
	JButton btn;

	Rooms() {
		getContentPane().setBackground(Color.black);
		setLayout(null);

		JLabel rInfo = new JLabel("All Rooms Information");
		rInfo.setBackground(Color.BLACK);
		rInfo.setForeground(Color.lightGray);
		rInfo.setFont(new Font("Serif", Font.PLAIN, 25));
		rInfo.setBounds(430, 10, 260, 35);
		add(rInfo);

		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(35, 55, 110, 30);
		l1.setForeground(Color.white);
		add(l1);

		JLabel l2 = new JLabel("Availability");
		l2.setBounds(136, 55, 110, 30);
		l2.setForeground(Color.white);
		add(l2);

		JLabel l3 = new JLabel("Cleanig Status");
		l3.setBounds(235, 55, 110, 30);
		l3.setForeground(Color.white);
		add(l3);

		JLabel l4 = new JLabel("Bed Type");
		l4.setBounds(340, 55, 110, 30);
		l4.setForeground(Color.white);
		add(l4);

		JLabel l5 = new JLabel("Price");
		l5.setBounds(440, 55, 110, 30);
		l5.setForeground(Color.white);
		add(l5);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/room12.jpg"));
		Image i1 = i.getImage().getScaledInstance(390, 450, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(600, 60, 390, 450);
		add(img);

		tbl = new JTable();
		tbl.setBounds(35, 85, 500, 400);
		add(tbl);

		try {
			Connector cn = new Connector();
			ResultSet rst = cn.stmt.executeQuery("select * from rooms");
			tbl.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (Exception e) {
			e.printStackTrace();
		}

		btn = new JButton("Back");
		btn.setBackground(Color.gray);
		btn.setForeground(Color.white);
		btn.setBounds(416, 525, 120, 35);
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
		btn.addActionListener(this);
		add(btn);

		setBounds(240, 99, 1050, 650);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();

	}

	public static void main(String[] args) {
		new Rooms();
	}
}
