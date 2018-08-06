package com.jda.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jda.util.Scan;

public class AddressBook {
	
	private List<Person> allPersons = new ArrayList<>();
	private String AddressBookName;

	public List<Person> getAllPersons() {
	return allPersons;
	}

	public void setAllPersons(List<Person> allPersons) {
	this.allPersons = allPersons;
	}

	public String getAddressBookName() {
	return AddressBookName;
	}

	public void setAddressBookName(String addressBookName) {
	AddressBookName = addressBookName;
	}

	public AddressBook(String name) {
	this.AddressBookName = name;
	}

	public List<Person> addPerson(List<Person> person) {
	Person entry = new Person();
	System.out.print("Enter the first name:");
	entry.setFirstname(Scan.getString());
	System.out.print("Enter last name");
	entry.setLastname(Scan.getString());
	System.out.print("Enter the address:");
	entry.setAddress(Scan.getString());
	System.out.print("Enter the city:");
	entry.setCity(Scan.getString());
	System.out.print("Enter the state:");
	entry.setState(Scan.getString());
	System.out.print("Enter the zip:");
	entry.setZip(Scan.getString());
	System.out.print("Enter the phone number:");
	entry.setPhonenumber(Scan.getString());
	person.add(entry);
	return person;
	}

	public List<Person> editBook(List<Person> allPersons) {
	System.out.println("Enter the name of the user:");
	String name = Scan.getString();
	for (Person person : allPersons) {
	if (person.getFirstname().equals(name)) {
	String change;
	System.out.println("Enter the new address, type No for no change");
	change = Scan.getString();
	if (!change.equals("No")) {
	person.setAddress(change);
	}
	System.out.println("Enter the city, type No for no change");
	change = Scan.getString();
	if (!change.equals("0")) {
	person.setCity(change);
	}
	System.out.println("Enter the new state, type No for no change");
	change = Scan.getString();
	if (!change.equals("0")) {
	person.setState(change);
	}
	System.out.println("Enter the new zipcode, type No for no change");
	String zip = Scan.getString();
	if (!change.equals("0")) {
	person.setZip(zip);
	}
	
	
	String number;
	System.out.println("Enter the new phone number, type No for no change");
	number = Scan.getString();
	if (number != "0") {
	person.setPhonenumber(number);
	}
	}
	}
	return allPersons;
	}

	

	public List<Person> deletePerson(List<Person> allPersons) {
	System.out.println("Enter the name of the user:");
	String name = Scan.getString();
	for (Person x : allPersons) {
	if (x.getFirstname().equals(name)) {
	allPersons.remove(x);	
	break;
	}
	}
	return allPersons;
	}

	class CompName implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
	String lastName1 = arg0.getFirstname().split(" ")[1];
	String lastName2 = arg1.getFirstname().split(" ")[1];
	if (lastName1.compareTo(lastName2) < 0) {
	return -1;
	} else if (lastName1.compareTo(lastName2) > 0) {
	return 1;
	} else if (lastName1.equals(lastName2)) {
	String firstName1 = arg0.getLastname().split(" ")[0];
	String firstName2 = arg1.getLastname().split(" ")[0];
	if (firstName1.compareTo(firstName2) < 0) {
	return -1;
	} else {
	return 1;
	}
	}
	return 0;
	}
	}

	class CompZipCode implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
	if (o1.getZip().compareTo(o2.getZip())<0) {
	return -1;
	} else if ((o1.getZip().compareTo(o2.getZip())>0)) {
	return 1;
	} else {
	String lastName1 = o1.getFirstname().split(" ")[1];
	String lastName2 = o2.getFirstname().split(" ")[1];
	if (lastName1.compareTo(lastName2) < 0) {
	return -1;
	} else if (lastName1.compareTo(lastName2) > 0) {
	return 1;
	} else if (lastName1.equals(lastName2)) {
	String firstName1 = o1.getLastname().split(" ")[0];
	String firstName2 = o2.getLastname().split(" ")[0];
	if (firstName1.compareTo(firstName2) < 0) {
	return -1;
	} else {
	return 1;
	}
	}
	return 0;
	}
	}
	}

	public List<Person> sortByLastName(List<Person> allPersons) {
	Collections.sort(allPersons, new CompName());
	return allPersons;
	}

	public List<Person> sortByZip(List<Person> allPersons) {
	Collections.sort(allPersons, new CompZipCode());
	return allPersons;
	}

	public void print() {
	for (Person p : allPersons) {
	System.out.println("Name : " + p.getFirstname());
	System.out.println("Address : " + p.getAddress());
	System.out.println("City : " + p.getCity());
	System.out.println("State : " + p.getState());
	System.out.println("Zip Code : " + p.getZip());
	System.out.println("Phone Number : " + p.getPhonenumber());
	System.out.print("\n");
	}
	}


}
