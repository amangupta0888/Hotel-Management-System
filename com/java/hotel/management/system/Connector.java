package com.java.hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
	Connection con;
	Statement stmt;

	Connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hotel?characterEncoding=latin1";
			String user = "root";
			String pwd = "root";

			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
