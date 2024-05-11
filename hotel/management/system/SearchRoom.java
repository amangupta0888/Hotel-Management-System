package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

	JTable tbl;
	JButton btn, btn1;
	JComboBox cmbBed;
	JCheckBox chk;

	SearchRoom() {
		getContentPane().setBackground(Color.black);
		setLayout(null);

		JLabel rInfo = new JLabel("Search For Rooms");
		rInfo.setBackground(Color.black);
		rInfo.setForeground(Color.lightGray);
		rInfo.setFont(new Font("Serif", Font.PLAIN, 25));
		rInfo.setBounds(430, 10, 260, 35);
		add(rInfo);

		JLabel lblBed = new JLabel("Bed Type");
		lblBed.setBounds(80, 51, 100, 30);
		lblBed.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBed.setForeground(Color.white);
		add(lblBed);

		String str[] = { "Single Bed", "Double Bed" };
		cmbBed = new JComboBox(str);
		cmbBed.setBounds(175, 55, 120, 25);
		cmbBed.setForeground(Color.white);
		cmbBed.setBackground(Color.black);
		add(cmbBed);

		chk = new JCheckBox("Display Available Rooms Only");
		chk.setBackground(Color.black);
		chk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chk.setForeground(Color.white);
		chk.setBounds(730, 55, 250, 29);
		add(chk);

		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(90, 105, 110, 30);
		l1.setForeground(Color.white);
		add(l1);

		JLabel l2 = new JLabel("Availability");
		l2.setBounds(300, 105, 110, 30);
		l2.setForeground(Color.white);
		add(l2);

		JLabel l3 = new JLabel("Cleaning Status");
		l3.setBounds(485, 105, 110, 30);
		l3.setForeground(Color.white);
		add(l3);

		JLabel l4 = new JLabel("Bed Type");
		l4.setBounds(680, 105, 110, 30);
		l4.setForeground(Color.white);
		add(l4);

		JLabel l5 = new JLabel("Price");
		l5.setBounds(880, 105, 110, 30);
		l5.setForeground(Color.white);
		add(l5);

		tbl = new JTable();
		tbl.setBounds(35, 135, 965, 415);
		add(tbl);

		try {
			Connector cn = new Connector();
			ResultSet rst = cn.stmt.executeQuery("select * from rooms");
			tbl.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (Exception e) {
			e.printStackTrace();
		}

		btn1 = new JButton("Submit");
		btn1.setBackground(Color.gray);
		btn1.setForeground(Color.white);
		btn1.setBounds(385, 572, 120, 35);
		btn1.setFont(new Font("Serif", Font.PLAIN, 20));
		btn1.addActionListener(this);
		add(btn1);

		btn = new JButton("Back");
		btn.setBackground(Color.gray);
		btn.setForeground(Color.white);
		btn.setBounds(566, 572, 120, 35);
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
				String qry1 = "select * from rooms where bed_type = '" + cmbBed.getSelectedItem() + "'";
				String qry2 = "select * from rooms where availability = 'Yes' And bed_type = '"
						+ cmbBed.getSelectedItem() + "'";

				Connector cn = new Connector();
				ResultSet rs;
				if (chk.isSelected()) {
					rs = cn.stmt.executeQuery(qry2);
				} else {
					rs = cn.stmt.executeQuery(qry1);
				}
				tbl.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else {
			setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		new SearchRoom();
	}

}
