package com.addressbook.model;

import com.addressbook.dto.AddressBookDTO;

import lombok.Data;
@Data
public class AddressBookData {
	
	private int contactId;
	private String firstName;
	private String lastName;
	private String address;
	
	public AddressBookData(int id, AddressBookDTO addressBookDTO) {
		this.contactId = id;
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
		this.address = addressBookDTO.address;
	}
}
