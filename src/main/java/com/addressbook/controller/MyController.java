package com.addressbook.controller;

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
@RequestMapping("/addressbook")
public class MyController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAddressBookDataById(@PathVariable("id") int id) {
		return new ResponseEntity<String>("Get Call Success for id: " + id, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addContactAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Created contact for: " + addressBookDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateContactAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated contact for: " + addressBookDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContactAddressBookById(@PathVariable("id") int id) {
		return new ResponseEntity<String>("Deleted contact for id: " + id, HttpStatus.OK);
	}
}
