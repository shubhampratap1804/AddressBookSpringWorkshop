package com.addressbook.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {

	// Class Variables
	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}$", message = "Contact's firstname is invalid!")
	public String firstName;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}$", message = "Contact's lastname is invalid!")
	public String lastName;

	public String address;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{3,}$", message = "City name should start with uppercase and having atleast 4 characters!")
	public String city;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{1,}$", message = "City name should start with uppercase and having atleast 2 characters!")
	public String state;

	@Pattern(regexp = "^[0-9]{6}$", message = "Valid pincode should exactly be 6 digits long!")
	public long zip;

	@Pattern(regexp = "^[0-9]{10}$", message = "A valid phonenumber should exactly be 10 digits long!")
	public long phoneNumber;

	@Pattern(regexp = "([a-zA-Z0-9./.-])+.([a-zA-Z0-9./.-])?@([a-z]{2,7})+.([a-z]{2,4})+.([a-z]{2,4})?", message = "Valid format is: abc.xyz@gmail.com")
	public String email;

	/*Generated constructor for all the instance variable in the DTO class.
	 * Making all variables as public to be accessed outside class directly by AddressBookData class.
	 * */
	public AddressBookDTO(long id, String firstName, String lastName, String address, String city, String state, long zip, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
