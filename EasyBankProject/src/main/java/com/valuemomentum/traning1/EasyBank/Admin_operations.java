package com.valuemomentum.traning1.EasyBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin_operations {
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	Scanner sc = new Scanner(System.in);

	public void getTranscation_records() {
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select t_id,account_number,transcation_type,status,amount from Transcations ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getDouble(5));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getSelectedTranscation_records() {

		String sqlUpdate = "select * from Transcations where account_number=?";

		try {
			System.out.println("enter Account_number :");
			int account_number = sc.nextInt();

			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setInt(1, account_number);
			rs = pstmt.executeQuery();

			// System.out.println("Id\t\tName\t\tAge\n");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getDate(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " "
						+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getDouble(7) + " " + rs.getDouble(8));
			}
			rs.close();

			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// if customer wants to delete their account they will send a request to admin
		// then Admin will delete it

		// method to delete
		public void delete_account() {
			

			try {
				System.out.println("enter Account-number to be Deleted:");
				int account_number = sc.nextInt();
				String sqlUpdate = "delete  from customerdetails where account_number="+ account_number;
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				

				int count = stmt.executeUpdate(sqlUpdate);
				if(count>0) {
					System.out.println("Account Deleted Sucessfully");
				}
				else {
					System.out.println("Invalid Account-number!! Check the account number and Try Again .....");
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
}
