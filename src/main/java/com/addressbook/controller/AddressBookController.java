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

@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

	List<AddressBookDTO> contactList = new ArrayList<>();
	public static AtomicLong counter = new AtomicLong();

	@GetMapping("/get")
	public ResponseEntity<List<AddressBookDTO>> getAddressBookData() {
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<AddressBookDTO>> getAddressBookDataById(@PathVariable("id") int id, @RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<List<AddressBookDTO>> addContactAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		addressBookDTO.setId(counter.incrementAndGet());
		contactList.add(addressBookDTO);
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<List<AddressBookDTO>> updateContactAddressBook(@PathVariable("id") int id, @RequestBody AddressBookDTO addressBookDTO) {
		contactList.get(id).setFirstName(addressBookDTO.getFirstName());
		contactList.get(id).setAddress(addressBookDTO.getAddress());
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<AddressBookDTO>> deleteContactAddressBookById(@PathVariable("id") int id) {
		contactList.remove(id);
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}
}
