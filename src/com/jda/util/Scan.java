package com.jda.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {
	



	public static int getInt() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		return num;
	
	}
  	
	public static String getString() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		return value;
	
	}

	public static List<String> getFiles() {
		// TODO Auto-generated method stub
		
		File folder = new File("//home//bridgelabz//workspace//ObjectOriented//src");
	   File[] allFiles = folder.listFiles(new FilenameFilter() {
	       @Override
	       public boolean accept(File dir, String name) {
	           return name.endsWith(".json");
	       }
	   });

	    List<String> Files = new ArrayList<>();
	   for (int i = 0; i < allFiles.length; i++) {
	      Files.add(allFiles[i].getName());
	   }
	
	return Files;
	
}
}
