package com.CompanyLockersPvtLtd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusinessLogic2 {
	public final static ArrayList<String> f3=new ArrayList<String>();
	final static File folder = new File("C:\\Users\\m123m\\eclipse-workspace\\VirtualKeyforYourRepositories");
	final static File files( String f) {
		
		File f1 = new File(f); 
		return f1;
		
	}
		

	public static void search(String fn) throws IOException {
		
		if(files(fn).exists()) {
			
			//if(fn.equals(files(fn).getCanonicalFile().getName())) { 
				//System.out.println(files(fn).getCanonicalFile());
				System.out.println("File Exists as!.."+files(fn).getCanonicalFile().getName());
				//System.out.println("File Name: "+files(fn).getName());
				System.out.println("File Path: "+files(fn).getCanonicalPath());
				System.out.println("Readable: "+files(fn).canRead());
				System.out.println("Writable: "+files(fn).canWrite());
				System.out.println("File size: "+files(fn).length());
				
			}
			else			
			{
				System.out.println("File Not Found!");
				
			}			
			
		}
		
		
	//}
	
	public static void sortFiles() {
		//System.out.println("Enter file Directory name: ");
		
		try {
			BusinessLogic2.listFilesForFolder(folder);
			Collections.sort(f3);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("sorted list of file names:");
		
		for(String s:f3)
			System.out.println(s);
		
	}
	
	public void addFile() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the filename to be created");
		
		String fn = sc.next();
		
		//Boolean res= search(file);
					
		try {
			if(files(fn).exists()) {
				
				System.out.println("File Exists!..");
				System.out.println("File Name: "+files(fn).getCanonicalFile());
				System.out.println("File Path: "+files(fn).getCanonicalPath());
				System.out.println("Readable: "+files(fn).canRead());
				System.out.println("Writable: "+files(fn).canWrite());
				System.out.println("File size: "+files(fn).length());
			}
			else			
			{
				if(files(fn).createNewFile())
					System.out.println("File Created!");
				
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	
	public void deleteFile(String file) throws IOException {
		//if(file.equals(file))
		
		if(files(file).exists()) {
			String fn = file;
			if(fn.equals(files(file).getCanonicalFile().getName())) { 
				System.out.println(files(file).getCanonicalFile());
				files(fn).delete();
				System.out.println("file found and deleted");}
			else{
				System.out.println("file not found!");
				}
			}
	}
	
		
	public static void listFilesForFolder(final File folder) {
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	           
	            	f3.add(fileEntry.getName());
	            	
	        } else {
	        	f3.add(fileEntry.getName());
	        }
	    }
	}

	
	
}
