package com.jda.core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.jda.util.Scan;

public class Inventoooory {
	
	private static String folder = "//home//bridgelabz//workspace//ObjectOriented//src" ;
	static ObjectMapper mapper = new ObjectMapper();
	static List<Features> allProducts = new ArrayList<>();

	public static String pojotojson(List<Features> allProducts)
			throws JsonGenerationException, JsonMappingException, IOException {
		String json = mapper.writeValueAsString(allProducts);
		return json;
	}

	public static void writejsontofile(String json) throws IOException {
		FileWriter file = new FileWriter(folder + "/Inventory.json");
		file.write(json);
		file.close();
	}

	public static List<Features> getInput(List<Features> allProducts) {
		for (int i = 0; i < 3; i++) {
			Features product = new Features();
			System.out.println("Enter the name:");
			product.setName(Scan.getString());
			System.out.println("Enter the weight:");
			product.setWeight(Scan.getInt());
			System.out.println("Enter the price:");
			product.setPrice(Scan.getInt());
			Scan.getString();
			allProducts.add(product);
		}
		return allProducts;
	}

	public static void calculateValue(List<Features> allProducts) {
		System.out.println("\nThe values are :");
		for (Features f : allProducts) {
			float value = f.getPrice() * f.getWeight();
			System.out.println(f.getName() + " : " + value);
		}
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	allProducts = getInput(allProducts);
	writejsontofile(pojotojson(allProducts));
	calculateValue(allProducts);	}

}
