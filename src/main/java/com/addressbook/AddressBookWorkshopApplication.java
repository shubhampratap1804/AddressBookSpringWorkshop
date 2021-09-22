package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookWorkshopApplication {

	//Main method
	public static void main(String[] args) {
		SpringApplication.run(AddressBookWorkshopApplication.class, args);
		System.out.println("Welcome to the spring address book development!");
	}
}
