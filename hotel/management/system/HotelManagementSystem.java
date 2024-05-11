package com.java.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener {

	HotelManagementSystem() {
		setBounds(150, 65, 1220, 680);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/b2.jpg"));
		JLabel img = new JLabel(i1);
		img.setBounds(0, 0, 1220, 680);
		add(img);

		JLabel txt = new JLabel("HOTEL MANAGEMENT SYSTEM");
		txt.setBounds(40, 40, 800, 40);
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("serif", Font.PLAIN, 50));
		img.add(txt);

		JButton btn = new JButton("Next >>");
		btn.setBounds(1020, 580, 150, 50);
		btn.setBackground(Color.YELLOW);
		btn.setForeground(Color.RED);
		btn.addActionListener(this);
		btn.setFont(new Font("serif", Font.PLAIN, 25));
		img.add(btn);

		setVisible(true);

		while (true) {
			txt.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception er) {
				er.printStackTrace();
			}
			txt.setVisible(true);
			try {
				Thread.sleep(500);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();

	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}

}
