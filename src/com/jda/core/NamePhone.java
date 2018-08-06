package com.jda.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jda.util.Scan;

public class NamePhone {
	
	private String fullName;
	private String phoneNumber;
	private static String tempstorage;
	private Pattern p;
	private  Matcher m;
	
	
	
	public static void main(String[] args) throws IOException {
		tempstorage = filetostring();
		NamePhone np = new NamePhone();
		np.userdata();
		np.updateName();
		np.updateFullName();
		updateDate();
		np.updatePhoneNumber();
	}

	private static void updateDate() {
		// TODO Auto-generated method stub
		
	}

	private static String filetostring() throws IOException {
		return new String(Files.readAllBytes(Paths.get("/home/bridgelabz/workspace/ObjectOriented/src/name.txt")));
	}

	public void userdata() {
		System.out.println("Enter the full name:");
		fullName = Scan.getString();
		System.out.println("Enter your phone number:");
		phoneNumber = Scan.getString();
	}

	public void updateName() {
		p = Pattern.compile("<<\\w+>>");
		m = p.matcher(tempstorage);
		if (m.find()) {
			tempstorage = m.replaceAll(fullName.split(" ")[0]);
		}
	}

	public void updateFullName() {
		p = Pattern.compile("<<\\w+\\s\\w+>>");
		m = p.matcher(tempstorage);
		if (m.find()) {
			tempstorage = m.replaceAll(fullName);
		}
	}



	public void updatePhoneNumber() {
		p = Pattern.compile("x{10}");
		m = p.matcher(tempstorage);
		if (m.find()) {
			tempstorage = m.replaceAll(phoneNumber);
		}
		System.out.println(tempstorage);
	}



}
