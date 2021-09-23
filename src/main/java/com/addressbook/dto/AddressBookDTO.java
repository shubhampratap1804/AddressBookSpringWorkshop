package com.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {

	// Class Variables
	public String firstName;
	public String lastName;
	public String address;
	
	public AddressBookDTO(long id, String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "name: =" + firstName +" " + lastName + " ," + "address: " + address;
	}
}
