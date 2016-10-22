package com.fannie.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetConnection {

	static Connection conn = null;
	public PreparedStatement ps = null;
	public PreparedStatement ps1 = null;
	public ResultSet rs = null;

	public static Connection mysqlCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return conn = DriverManager.getConnection("jdbc:mysql://localhost/fannie", "root", "mysql");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
