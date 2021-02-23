package com.valuemomentum.traning1.EasyBank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin_user_login {
	Scanner sc = new Scanner(System.in);
	Connection con;
	Statement stmt;
	ResultSet rs;

	String query1 = "select Email ,password from Admin";
	String query2 = "select Email ,password from customerdetails ";

	public void Admin_login() {

		String email_id1;
		String password1;

		System.out.println("Email-id:");
		email_id1 = sc.next();
		System.out.println("Password:");
		password1 = sc.next();

		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();

			rs = stmt.executeQuery(query1);
			int count = 0;
			while (rs.next()) {
				String email_id = rs.getString(1);
				String password = rs.getString(2);
				if (email_id1.contentEquals(email_id) && password1.contentEquals(password)) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println("Login Sucessfull");
				// after login as admin we have to write if-loop
				System.out.println(" ");
				while (true) {
					System.out.println("1.TRANSCATION RECORDS");
					System.out.println("2.TRANSCATION RECORDS OF PARTICULAR PERSON");
					System.out.println("3.DELETE ACCOUNT");
					System.out.println("4.LOGOUT");

					int option = sc.nextInt();
					if (option == 1) {
						// method from admin_operations;
						new Admin_operations().getTranscation_records();
						System.out.println(" ");

					}

					else if (option == 2) {
						// method of getting selected transcation records from admin_operations;
						new Admin_operations().getSelectedTranscation_records();
						System.out.println(" ");

					}

					else if(option==3){
						new Admin_operations().delete_account(); // method to delete account
						System.out.println(" ");
					}
					else if(option==4){
						
						System.out.println(" logout Sucessful");
						break;
					}
				}
				}
			 else {
				System.out.println("please check the email-id and password");
				new Admin_user_login().Admin_login();

			}

			rs.close();
			stmt.close();
			con.close();
				}
		catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	public void Customer_login() {

		System.out.println("Email-id:");
		String email_id2 = sc.next();
		System.out.println("Password:");
		String password2 = sc.next();

		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();

			rs = stmt.executeQuery(query2);
			int count = 0;
			while (rs.next()) {
				String email_id = rs.getString("Email");
				String password = rs.getString("password");
				if (email_id2.contentEquals(email_id) && password2.contentEquals(password)) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println("Login Sucessfull");
				System.out.println("1.BALANCE");
				System.out.println("2.WITHDRAWAL");
				System.out.println("3.DEPOSIT");
				System.out.println("4.REQUEST TO DELETE ACCOUNT");

				int option = sc.nextInt();
				if (option == 1) {
					// Method for balance check
				} else if (option == 2) {
					// Method for withdrawal
				} else if (option == 3) {
					// Method for Deposit
				} else {
					// method to request delete account
				}
			} else {
				System.out.println("please check the email-id and password");
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
