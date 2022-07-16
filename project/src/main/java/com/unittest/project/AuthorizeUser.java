package com.unittest.project;

import java.util.Scanner;

public class AuthorizeUser {

	public boolean authorizeUser() {

		String uname = null;
		String pwd = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Ueername:");
		uname = sc.next();
		System.out.println("Enter Password:");
		pwd = sc.next();

		if (uname.equalsIgnoreCase("Admin")) {
			if (pwd.equals("Admin@123")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

}
