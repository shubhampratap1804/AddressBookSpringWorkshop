package com.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.addressbook.dto.AddressBookDTO;

import lombok.Data;


@Data 
@Entity
@Table(name = "addressbooktable")
public class AddressBookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_Id")
	private int contactId;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String email;
	
	public AddressBookData() { }
	
	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}
	

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
		this.address = addressBookDTO.address;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.email = addressBookDTO.email;
	}
}
