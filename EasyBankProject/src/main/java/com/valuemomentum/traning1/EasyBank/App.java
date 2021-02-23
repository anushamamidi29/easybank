package com.valuemomentum.traning1.EasyBank;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
Admin_user_login ad = new Admin_user_login();
		
		New_Account account = new New_Account();

		System.out.println("***********EASY BANK****************");

		System.out.println("1.LOGIN ");
		System.out.println("2.ABOUT BANK ");
		System.out.println("3.OPEN NEW ACCOUNT");
		System.out.println("4.EXIT");

		Scanner s = new Scanner(System.in);
		int option = s.nextInt();

		if (option == 1) // 1.LOGIN
		{
			System.out.println("***********TO LOGIN****************");
			System.out.println("1.ADMIN");
			System.out.println("2.CUSTOMER");
			System.out.println("3.EXIT");

			option = s.nextInt();
			if (option == 1) {
				ad.Admin_login();
			} // call method for admin login

			if (option == 2) {
				ad.Customer_login(); // call method for customer login
				// after login as customer we have to write while with switch

			}
			/*
			 * else { System.out.println(" application closed"); }
			 */

		}

		if (option == 2) // 2.ABOUT BANK
		{
			System.out.println("**********WELCOME TO EASY BANK***********");
			System.out.println("online bank easy banking no need to come to bank etc....");
		}

		if (option == 3) // 3.OPEN ACCOUNT
		{
			System.out.println("                TO OPEN A NEW BANK ACCOUNT              ");
			System.out.println("1.FILL FORM");
			System.out.println("2.EXIT");

			option = s.nextInt();
			if (option == 1) {
				account.fill_form(); // CALL METHOD OF NEW ACCOUNT

				/*
				 * System.out.println("1.LOGIN"); System.out.println("2.EXIT");
				 * option=s.nextInt();
				 * 
				 * if(option==1) { ad.Customer_login(); //call method for customer login } else
				 * { System.out.println("Application closed "); }
				 */
			} else {
				System.out.println("application closed ");
			}
		}

		if (option == 4) // CLOSED
		{
			System.out.println(" application closed");
			System.exit(0);
		}

		if (option < 0 || option > 4) // INVALID OPTION
		{
			System.out.println("INVALID SELECTION");
		}
s.close();
    }
    
}
