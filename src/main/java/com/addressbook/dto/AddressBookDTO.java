package com.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {

	// Class Variables
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	
	public AddressBookDTO(long id, String firstName, String lastName, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
}
