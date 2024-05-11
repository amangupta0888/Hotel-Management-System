package com.java.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class PickupService extends JFrame implements ActionListener {

	JTable tbl;
	JButton btn, btn1;
	Choice carType;
	JCheckBox chk;

	PickupService() {
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel rInfo = new JLabel("Taxi Services");
		rInfo.setBackground(Color.white);
		rInfo.setForeground(Color.blue);
		rInfo.setFont(new Font("Serif", Font.PLAIN, 25));
		rInfo.setBounds(430, 10, 260, 35);
		add(rInfo);

		JLabel lblBed = new JLabel("Car Brand Type");
		lblBed.setBounds(50, 65, 139, 30);
		lblBed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed.setBackground(Color.white);
		add(lblBed);

		carType = new Choice();
		carType.setBounds(195, 70, 155, 25);
		carType.setBackground(Color.white);
		add(carType);

		try {
			Connector cn = new Connector();
			ResultSet rs = cn.stmt.executeQuery("select * from drivers");
			while (rs.next()) {
				carType.add(rs.getString("Car_Brand"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel l1 = new JLabel("Driver Name");
		l1.setBounds(69, 125, 110, 30);
		add(l1);

		JLabel l2 = new JLabel("Age");
		l2.setBounds(220, 125, 110, 30);
		add(l2);

		JLabel l3 = new JLabel("Gender");
		l3.setBounds(350, 125, 110, 30);
		add(l3);

		JLabel l4 = new JLabel("Car Brand");
		l4.setBounds(490, 125, 110, 30);
		add(l4);

		JLabel l5 = new JLabel("Car Model");
		l5.setBounds(620, 125, 110, 30);
		add(l5);

		JLabel l6 = new JLabel("Driver Contact");
		l6.setBounds(740, 125, 110, 30);
		add(l6);

		JLabel l7 = new JLabel("Licence Number");
		l7.setBounds(880, 125, 110, 30);
		add(l7);

		tbl = new JTable();
		tbl.setBounds(35, 160, 965, 395);
		add(tbl);

		try {
			Connector cn = new Connector();
			ResultSet rst = cn.stmt.executeQuery("select * from drivers");
			tbl.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (Exception e) {
			e.printStackTrace();
		}

		btn1 = new JButton("Submit");
		btn1.setBackground(Color.gray);
		btn1.setForeground(Color.white);
		btn1.setBounds(385, 550, 120, 35);
		btn1.setFont(new Font("Serif", Font.PLAIN, 20));
		btn1.addActionListener(this);
		add(btn1);

		btn = new JButton("Back");
		btn.setBackground(Color.gray);
		btn.setForeground(Color.white);
		btn.setBounds(566, 550, 120, 35);
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
		btn.addActionListener(this);
		add(btn);

		setBounds(240, 99, 1050, 660);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			try {
				String qry = "select * from drivers where Car_Brand = '" + carType.getSelectedItem() + "'";
				Connector cn = new Connector();
				ResultSet rs;
				rs = cn.stmt.executeQuery(qry);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else {
			setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		new PickupService();
	}
}
