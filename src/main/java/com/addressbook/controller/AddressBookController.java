package com.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.addressbook.model.AddressBookData;
import com.addressbook.service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	IAddressBookService addressBookService;

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Get address book successful!", addressBookList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("id") int id) {
		AddressBookData addressBookData = addressBookService.getAddressBookDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get call by id is successful!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContactAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created contact into the contactlist!", addressBookData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateContactAddressBook(@PathVariable("id") int id,
			@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookService.updateAddressBookData(id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Update contactlist successful!", addressBookData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getbycity/{city}")
	public ResponseEntity<ResponseDTO> getContactBySameCity(@PathVariable("city") String city){
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.findContactByCity(city);
		ResponseDTO responseDTO = new ResponseDTO("Get call search by city is successful!", addressBookList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteContactAddressBookById(@PathVariable("id") int id) {
		addressBookService.deleteAddressBookData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book data successfully!", "Deleted for id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
