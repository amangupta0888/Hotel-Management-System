package com.java.hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {

	JComboBox ids;
	JTextField idNo, nameTf, countryTf, depositeTf;
	JRadioButton bMale, bFemale;
	Choice alctRoom;
	JLabel checkintime;
	JButton addCst, cncl;

	AddCustomer() {
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel txt = new JLabel("New Customer Form");
		txt.setBounds(450, 11, 300, 35);
		txt.setFont(new Font("serif", Font.PLAIN, 22));
		add(txt);

		JLabel cstID = new JLabel("Customer ID Card");
		cstID.setBounds(60, 75, 180, 30);
		cstID.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstID);

		String str1[] = { "Aadhar Card", "Driving Licence", "PAN Card", "Ration Card", "Voter-ID Card" };
		ids = new JComboBox(str1);
		ids.setBackground(Color.white);
		ids.setBounds(280, 75, 180, 30);
		add(ids);

		JLabel cstIdNo = new JLabel("ID Card Number");
		cstIdNo.setBounds(60, 125, 150, 30);
		cstIdNo.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstIdNo);

		idNo = new JTextField();
		idNo.setBounds(280, 125, 185, 25);
		add(idNo);

		JLabel cstName = new JLabel("Customer Name");
		cstName.setBounds(60, 175, 155, 30);
		cstName.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstName);

		nameTf = new JTextField();
		nameTf.setBounds(280, 175, 185, 25);
		add(nameTf);

		JLabel cstGender = new JLabel("Gender");
		cstGender.setBounds(60, 225, 150, 30);
		cstGender.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstGender);

		bMale = new JRadioButton("Male");
		bMale.setBackground(Color.white);
		bMale.setBounds(280, 225, 60, 25);
		bMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(bMale);

		bFemale = new JRadioButton("Female");
		bFemale.setBackground(Color.white);
		bFemale.setBounds(350, 225, 70, 25);
		bFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(bFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(bMale);
		bg.add(bMale);

		JLabel cstCountry = new JLabel("Country");
		cstCountry.setBounds(60, 275, 70, 30);
		cstCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstCountry);

		countryTf = new JTextField();
		countryTf.setBounds(280, 275, 185, 25);
		add(countryTf);

		JLabel cstRoom = new JLabel("Room Number");
		cstRoom.setBounds(60, 325, 190, 30);
		cstRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(cstRoom);

		alctRoom = new Choice();

		try {
			Connector cnct = new Connector();
			String qry = "select * from rooms where Availability = 'Yes'";
			ResultSet rs = cnct.stmt.executeQuery(qry);
			while (rs.next()) {
				alctRoom.add(rs.getString("Room_No"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		alctRoom.setBounds(280, 325, 185, 25);
		add(alctRoom);

		JLabel chkIn = new JLabel("Check-In-Time");
		chkIn.setBounds(60, 375, 190, 30);
		chkIn.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(chkIn);

		Date dt = new Date();

		checkintime = new JLabel("" + dt);
		checkintime.setBounds(280, 375, 250, 25);
		checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
		add(checkintime);

		JLabel dpst = new JLabel("Deposite");
		dpst.setBounds(60, 425, 190, 30);
		dpst.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(dpst);

		depositeTf = new JTextField();
		depositeTf.setBounds(280, 425, 185, 25);
		add(depositeTf);

		addCst = new JButton("Add Customer");
		addCst.setForeground(Color.white);
		addCst.setBackground(Color.BLACK);
		addCst.setFont(new Font("Raleway", Font.PLAIN, 20));
		addCst.setBounds(80, 485, 200, 30);
		addCst.addActionListener(this);
		add(addCst);

		cncl = new JButton("Cancel");
		cncl.setForeground(Color.white);
		cncl.setBackground(Color.BLACK);
		cncl.setFont(new Font("Raleway", Font.PLAIN, 20));
		cncl.setBounds(315, 485, 100, 30);
		cncl.addActionListener(this);
		add(cncl);

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
		Image i1 = i.getImage().getScaledInstance(320, 320, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel img = new JLabel(i2);
		img.setBounds(600, 40, 320, 450);
		add(img);

		setBounds(240, 99, 1050, 650);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCst) {
			String idType = (String) ids.getSelectedItem();
			String idNumber = idNo.getText();
			String name = nameTf.getText();
			String gender = null;

			if (bMale.isSelected()) {
				gender = "Male";
			} else if (bFemale.isSelected()) {
				gender = "Female";
			}

			String country = countryTf.getText();
			String roomNo = alctRoom.getSelectedItem();
			String date = checkintime.getText();
			String deposit = depositeTf.getText();

			if (idNumber.equals("")) {
				JOptionPane.showMessageDialog(null, "Customer Identity Card Number Required. ");
				return;
			}
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Customer Name Required. ");
				return;
			}
			if (country.equals("")) {
				JOptionPane.showMessageDialog(null, "Country name should not be empty.");
				return;
			}
			if (roomNo.equals("")) {
				JOptionPane.showMessageDialog(null, "Please allot a room. ");
				return;
			}
			if (deposit.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Deposit Your Amount.");
				return;
			}

			try {
				String qry1 = "insert into customer values('" + idType + "','" + idNumber + "','" + name + "','"
						+ gender + "','" + country + "','" + roomNo + "','" + date + "','" + deposit + "')";
				String qry2 = "update rooms set Availability = 'No' where Room_No = '" + roomNo + "'";

				Connector cnct1 = new Connector();
				cnct1.stmt.executeUpdate(qry1);
				cnct1.stmt.executeUpdate(qry2);

				JOptionPane.showMessageDialog(null, "New Customer Added Successfully.");
				setVisible(false);
				new Reception();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == cncl) {
			setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		new AddCustomer();
	}

}
