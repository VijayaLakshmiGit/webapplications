package com.webserviceHttp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Gsonsample {

	public static void main(String[] args) throws IOException {

		Customer customer = new Customer();
		customer.setId(2);
		customer.setFirstname("anusha");
		customer.setLastname("pothala");
		customer.setStreet("stevenson");
		customer.setCity("fremont");

		Gson gson = new Gson();
		// Object to json
		Gson gsonprint = new GsonBuilder().setPrettyPrinting().create();
		FileWriter writer = new FileWriter("C:\\Users/anu3p/gsondata.json");
		String jsonstring = gson.toJson(customer);
		System.out.println(jsonstring);

		// json to Object
		Customer gsoncust = gsonprint.fromJson(jsonstring, Customer.class);
		System.out.println(gsoncust);

		// file writing
		Gson gson1 = new Gson();
		File file = new File("C:/Users/anu3p/gsondata1.JSON");
		FileWriter writer1 = new FileWriter(file);
		writer1.write(gson1.toJson(customer));
		writer1.close();

		// filereading
		Gson gson2 = new Gson();
		Reader reader = new FileReader(file);
		Customer cust = gson2.fromJson(jsonstring, Customer.class);
		System.out.println(cust);

	}

}
