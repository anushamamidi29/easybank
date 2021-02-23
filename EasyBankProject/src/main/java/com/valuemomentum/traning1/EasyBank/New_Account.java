package com.valuemomentum.traning1.EasyBank;
import java.util.Scanner;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class New_Account {
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	
	protected String first_name;
	protected String middle_name;
	protected String last_name;
	protected String gender;
	protected String dateofbirth;
	protected String address;
	protected String city;
	protected String state;
	protected long aadhar_number;
	protected String email;
	protected String password;
	Scanner sc;
	private static final String sqlUpdate = "INSERT INTO customerdetails(account_type,first_name,middle_name,last_name,gender,dob,city,state,aadhaar_number,Email,password )"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	
	public void fill_form()
	{
		
		try 
		{
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sqlUpdate);
			
			sc=new Scanner(System.in);
		     System.out.println(" Type of Account :");
			pstmt.setString(1, sc.next());
			System.out.println("FIRST NAME:");
			pstmt.setString(2,sc.next() );
			System.out.println("MIDDLE NAME:");
			pstmt.setString(3, sc.next());
			System.out.println("LAST NAME:");
			pstmt.setString(4, sc.next());
			System.out.println("GENDER:");
			pstmt.setString(5, sc.next());
			System.out.println("DOB:");
			pstmt.setString(6, sc.next());
			System.out.println("CITY:");
			pstmt.setString(7, sc.next());
			System.out.println("STATE:");
			pstmt.setString(8, sc.next());
			System.out.println("Aadhaar_number");
			pstmt.setString(9, sc.next());
			System.out.println("Email-id:");
			pstmt.setString(10, sc.next());
			System.out.println("password:");
			pstmt.setString(11, sc.next());
			
			
			System.out.println("1.SUBMIT");
			System.out.println("2.EXIT");
			int option=sc.nextInt();
			if(option==1)
			{
				int rowAffected =pstmt.executeUpdate();
				if(rowAffected ==1)
				{
	
				System.out.println(" Account Created Succesfully");
				System.out.println(" ");
				System.out.println("Login to Start Online Banking");
			
				
				}
				else {
					System.out.println("Failed to Create account!! Try Again");
				     }
			}
			else 
			{
				System.out.println(" Application closed");
			}
			
			 pstmt.close();
			 con.close();
				
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}
