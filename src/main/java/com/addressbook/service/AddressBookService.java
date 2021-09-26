package com.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.AddressBookCustomException;
import com.addressbook.model.AddressBookData;
import com.addressbook.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	AddressBookRepository addressBookRepository;
	
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataById(int id) {
		return addressBookRepository.findById(id)
				.orElseThrow( () -> 
					new AddressBookCustomException("Contact with this id " + id + "doest not exists!"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =null;
		addressBookData = new AddressBookData(addressBookDTO);
		log.debug("AddressBook Data:"+addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(id);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int id) {
		AddressBookData addressBookData = this.getAddressBookDataById(id);
		addressBookRepository.delete(addressBookData);
	}
}
