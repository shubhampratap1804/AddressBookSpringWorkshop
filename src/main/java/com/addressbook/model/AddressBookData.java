package com.addressbook.model;

import com.addressbook.dto.AddressBookDTO;

import lombok.Data;
@Data
public class AddressBookData {
	
	private int contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private long zip;
	private long phoneNumber;
	private String email;
	
	public AddressBookData(int id, AddressBookDTO addressBookDTO) {
		this.contactId = id;
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
		this.address = addressBookDTO.address;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip = addressBookDTO.zip;
		this.phoneNumber = addressBookDTO.phoneNumber;
		this.email = addressBookDTO.email;
	}
}
