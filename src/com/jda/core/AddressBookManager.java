package com.jda.core;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.jda.util.Scan;

public class AddressBookManager {
private static List<String> Files = Scan.getFiles();
private static List<AddressBook> totaladdbook = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

	while (true) {
	System.out.println("1. Create an address book");
	System.out.println("2. Open an address book");
	System.out.println("3. Close an address book");
	System.out.println("4. Save an address book");
	System.out.println("5. Save as address book");
	System.out.println("6. If you want to Quit");
	int ans = Scan.getInt();
	//Scan.getString();
	if (ans != 6) {
	switch (ans) {
	case 1: {
	createAddressBook();
	}
	break;
	case 2: {
	openAddressBook();
	}
	break;
	case 3: {
	closeAddressBook();
	}
	break;
	case 4: {
	saveAddressBook();
	}
	break;
	case 5: {
	saveAsAddressBook();
	}
	}
	} else {
	break;
	}
	}
	}
	
	
	

	public static void createAddressBook() throws IOException {
	System.out.println("Enter the name of the address book:");
	String name = Scan.getString();
	while (Files.contains(name + ".json")) {
	System.out.print("Filename already exists! Enter name again :");
	name = Scan.getString();
	
	}
	String fileName =	"//home//bridgelabz//workspace//ObjectOriented//src"+ "//" + name + ".json";
	File file = new File(fileName);
	file.createNewFile();
	Files.add(name + ".json");
	}

	public static void openAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println(Files);
	ObjectMapper mapper = new ObjectMapper();
	List<Person> person = new ArrayList<>();
	System.out.println("Enter the name of the address book:");
	String name = Scan.getString();
	try {
	person = mapper.readValue(new File("//home//bridgelabz//workspace//ObjectOriented//src" + "//" + name + ".json"), new TypeReference<ArrayList<Person>>() {
	});
	} catch (IOException e) {
	person = new ArrayList<Person>();
	}
	AddressBook addressBook = new AddressBook(name);
	while (true) {
	System.out.println("1. Create new entry");
	System.out.println("2. Edit information");
	System.out.println("3. Delete an entry");
	System.out.println("4. Sort by last name");
	System.out.println("5. Sort by zip");
	System.out.println("6. Go back to main menu");
	System.out.print("Enter choice :");
	int ans = Scan.getInt();
	Scan.getString();
	if (ans != 6) {
	switch (ans) {
	case 1: {
	person = addressBook.addPerson(person);
	}
	break;
	case 2: {
	person = addressBook.editBook(person);
	}
	break;
	case 3: {
	person = addressBook.deletePerson(person);
	}
	break;
	case 4: {
	person = addressBook.sortByLastName(person);
	}
	break;
	case 5: {
	person = addressBook.sortByZip(person);
	}
	break;
	}
	} else {
	break;
	}
	}
	addressBook.setAllPersons(person);
	totaladdbook.add(addressBook);
	}

	public static void closeAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
	if (totaladdbook.size() == 1) {
	System.out.println("Save the file?(yes or no)");
	String choice = Scan.getString();
	if (choice.equals("yes")) {
	saveAddressBook();
	}
	totaladdbook.remove(0);
	} else {
	System.out.println("Address Books open:");
	for (AddressBook x : totaladdbook) {
	System.out.println(x.getAddressBookName());
	}
	System.out.println("Enter the Address Book name to be closed:");
	String name = Scan.getString();
	System.out.println("Save the file?(yes or no)");
	String choice = Scan.getString();
	if (choice.equals("yes")) {
	saveAddressBook();
	}
	totaladdbook.remove(name);
	}
	}

	public static void saveAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	if (totaladdbook.size() == 1) {
	String totalData = mapper.writerWithDefaultPrettyPrinter()
	.writeValueAsString(totaladdbook.get(0).getAllPersons());
	FileWriter file = new FileWriter("//home//bridgelabz//workspace//ObjectOriented//src" + "//" + totaladdbook.get(0).getAddressBookName() + ".json");
	System.out.println(totalData);
	file.write(totalData);
	file.close();
	} else {
	System.out.println("Enter the name of the file to be saved:");
	String name = Scan.getString();
	for (AddressBook adb : totaladdbook) {
	if (adb.getAddressBookName().equals(name)) {
	String totalData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adb.getAllPersons());
	FileWriter file = new FileWriter("//home//bridgelabz//workspace//ObjectOriented//src" + "//" + adb.getAddressBookName() + ".json");
	System.out.println(totalData);
	file.write(totalData);
	file.close();
	break;
	}
	}
	}
	}

	public static void saveAsAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	System.out.println("Save as name :");
	String name = Scan.getString();
	if (totaladdbook.size() == 1) {
	String totalData = mapper.writerWithDefaultPrettyPrinter()
	.writeValueAsString(totaladdbook.get(0).getAllPersons());
	FileWriter file = new FileWriter("//home//bridgelabz//workspace//ObjectOriented//src" + "//" + name + ".json");
	System.out.println(totalData);
	file.write(totalData);
	file.close();
	} else {
	System.out.println("Enter the name of the file to be saved:");
	String name1 = Scan.getString();
	for (AddressBook adb : totaladdbook) {
	if (adb.getAddressBookName().equals(name1)) {
	String totalData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adb.getAllPersons());
	FileWriter file = new FileWriter("//home//bridgelabz//workspace//ObjectOriented//src" + "//" + name + ".json");
	System.out.println(totalData);
	file.write(totalData);
	file.close();
	break;
	}
	}
	}
	}


}

