package com.dal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
	static Connection con;
	public static Connection getMyconnection() {
	  try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "shshi");
			System.out.println(con);
		} catch (SQLException e) {		
			e.printStackTrace();
		}    
	  return con;
	}
		
	public static void main(String[] args) {
		System.out.println(getMyconnection());
}
}