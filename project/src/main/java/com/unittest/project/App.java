package com.unittest.project;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		AuthorizeUser au = new AuthorizeUser();
		boolean lin = au.authorizeUser();

		if (lin) {
			System.out.println("User Logged in");
		} else {
			System.out.println("try again");
		}

	}
}
