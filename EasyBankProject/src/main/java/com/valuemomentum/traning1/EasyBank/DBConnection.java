package com.valuemomentum.traning1.EasyBank;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EasyBank",
					"root","anusha@1929");
			return con;
		
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
			
		}
	}
}
