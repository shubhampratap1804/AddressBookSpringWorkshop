package com.addressbook.service;

import java.util.List;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBookData;


public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int id);
	
	List<AddressBookData> findContactByCity(String city);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO);

	void deleteAddressBookData(int id);
}
