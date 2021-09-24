package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.AddressBookCustomException;
import com.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	List<AddressBookData> contactList = new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return contactList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int id) {
		return contactList.stream()
					.filter(addressBookData -> addressBookData.getContactId() == id)
						.findFirst()
							.orElseThrow(() -> new AddressBookCustomException("Contact Not Found!"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =null;
		addressBookData = new AddressBookData(contactList.size()+1, addressBookDTO);
		contactList.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(id);
		addressBookData.setFirstName(addressBookDTO.firstName);
		addressBookData.setLastName(addressBookDTO.lastName);
		addressBookData.setAddress(addressBookDTO.address);
		contactList.set(id-1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int id) {
		contactList.remove(id-1);
	}
}
