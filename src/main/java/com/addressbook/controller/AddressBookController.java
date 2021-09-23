package com.addressbook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/addressbook")
@Slf4j
public class AddressBookController {

	List<AddressBookDTO> contactList = new ArrayList<>();
	public static AtomicLong counter = new AtomicLong();

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		ResponseDTO responseDTO = new ResponseDTO("Retrieved all data from addressbook!", contactList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("id") int id) {
		for (AddressBookDTO myList : contactList) {
			if (myList.getId() == id) {
				ResponseDTO responseDTO = new ResponseDTO("Found contact list by id!", myList);
				return new ResponseEntity<>(responseDTO, HttpStatus.OK);
			} else {
				ResponseDTO responseDTO = new ResponseDTO("Not found contact list by id!", myList);
				return new ResponseEntity<>(responseDTO, HttpStatus.OK);
			}
		}
		return null;
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContactAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		addressBookDTO.setId(counter.incrementAndGet());
		contactList.add(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created contact into the contactlist!", addressBookDTO);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<List<AddressBookDTO>> updateContactAddressBook(@PathVariable("id") int id,
			@RequestBody AddressBookDTO addressBookDTO) {
		contactList.get(id).setFirstName(addressBookDTO.getFirstName());
		contactList.get(id).setAddress(addressBookDTO.getAddress());
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteContactAddressBookById(@PathVariable("id") int id) {
		for (AddressBookDTO myList : contactList) {
			if (myList.getId() == id) {
				contactList.remove(id);
				ResponseDTO responseDTO = new ResponseDTO("Deleted contact by id!", contactList);
				return new ResponseEntity<>(responseDTO, HttpStatus.OK);

			} else {
				ResponseDTO responseDTO = new ResponseDTO("Contact not found in the list!", contactList);
				return new ResponseEntity<>(responseDTO, HttpStatus.OK);
			}
		}
		return null;
	}
}
