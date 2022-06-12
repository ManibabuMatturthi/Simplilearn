package com.CompanyLockersPvtLtd;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		// Initiating String Variable to return the Welcome page along the Developer Information 
		String wel="------------------------------------------------------------------------\n "
				+ "Welcome to CompanyLockersPvtLtd\n"
				+  "------------------------------------------------------------------------\n";
		System.out.println(wel);
		System.out.println("Project Name: (Virtual Key for Your Repositories)");
		System.out.println("Developer Name: Mani Babu M");
		
		//calling Main Menu
		mainMenu();
	}
	
	// Main Menu implemented here 
	public static void mainMenu() throws IOException {
		Scanner s1= new Scanner(System.in);
		
		String[] menu={
				"1. Sort the file contents.",
				"2. Core file Operations.",
				"3. close App."				
		};
		System.out.println("Main Menu:");
		for(String s:menu)
			System.out.println(s);
		System.out.println("select your Choice:");
		int ch=s1.nextInt();
		// Switch case written here to navigate to the selected option  
		switch(ch) {
		case 1:
			//calling the sort method from Business logic method
			BusinessLogic2.sortFiles();
			//calling main menu to continue with the menu.
			mainMenu();
			break;
			
		case 2:
			//navigating to the file operations menu by calling options method
			options();
			break;			
			
		case 3:
			
			//Quitting from the menu
			
			System.out.println("closing the app.....");
			break;
			
		default:
			// to warn the wrong option entry and navigating to main menu to proceed with app 
			System.out.println("worng selection, try again");
			mainMenu();
		}
		}
	
	// Options method implemented here to go with file operations 
		
	public static void options() throws IOException {
		
		//initiated and declared String array to store the operation names
		String[] menu = {
				"a. Create file",
				"b. Delete file",
				"c. Search file",
				"d. Return to Main menu"
		};
		System.out.println("File Operations:");
		for(String s:menu)
			System.out.println(s);
		System.out.println("Select your Choice:");
		Scanner s2= new Scanner(System.in);
		String ch = s2.next();
		BusinessLogic2 bl = new BusinessLogic2();
		//Selecting Choice for the file operations
		switch (ch) {
			case "a":				
				System.out.println("Creating a file:");
				bl.addFile();
				options();
				break;
			case "b":
				System.out.println("Enter the file name to be Deleted:");
				String del = s2.next();
				bl.deleteFile(del);
				options();
				break;
			case "c":
				System.out.println("Enter the file name to be Search:");
				Scanner s3=new Scanner(System.in);
				String fn=s3.next();
				BusinessLogic2.search(fn);
				options();
				break;
			case "d":
				System.out.println("Returning to Main Menu!");
				mainMenu();
				
		default:
			System.out.println("Invalid Option try again");
			options();
		}
		
	}
		
}
