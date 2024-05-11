package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame implements ActionListener {

	JTable tbl;
	JButton btn;

	EmployeeInfo() {
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);

		JLabel head1 = new JLabel("Employee Information");
		head1.setForeground(Color.CYAN);
		head1.setBackground(Color.GRAY);
		head1.setFont(new Font("Serif", Font.PLAIN, 26));
		head1.setBounds(500, 10, 250, 40);
		add(head1);

		JLabel l1 = new JLabel("Employee Name");
		l1.setBounds(62, 55, 110, 30);
		l1.setForeground(Color.white);
		add(l1);

		JLabel l2 = new JLabel("ID Number");
		l2.setBounds(219, 55, 110, 30);
		l2.setForeground(Color.white);
		add(l2);

		JLabel l3 = new JLabel("Age");
		l3.setBounds(385, 55, 110, 30);
		l3.setForeground(Color.white);
		add(l3);

		JLabel l4 = new JLabel("Gender");
		l4.setBounds(520, 55, 110, 30);
		l4.setForeground(Color.white);
		add(l4);

		JLabel l5 = new JLabel("Role");
		l5.setBounds(670, 55, 110, 30);
		l5.setForeground(Color.white);
		add(l5);

		JLabel l6 = new JLabel("Salary");
		l6.setBounds(805, 55, 110, 30);
		l6.setForeground(Color.white);
		add(l6);

		JLabel l7 = new JLabel("Phone Number");
		l7.setBounds(940, 55, 110, 30);
		l7.setForeground(Color.white);
		add(l7);

		JLabel l8 = new JLabel("Email ID");
		l8.setBounds(1080, 55, 110, 30);
		l8.setForeground(Color.white);
		add(l8);

		tbl = new JTable();
		tbl.setBounds(40, 87, 1155, 450);
		add(tbl);

		try {
			Connector cn = new Connector();
			ResultSet rst = cn.stmt.executeQuery("select * from employee");
			tbl.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (Exception e) {
			e.printStackTrace();
		}

		btn = new JButton("Back");
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setBounds(555, 560, 120, 35);
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
		btn.addActionListener(this);
		add(btn);

		setBounds(240, 99, 1250, 650);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();

	}

	public static void main(String[] args) {
		new EmployeeInfo();
	}
}
