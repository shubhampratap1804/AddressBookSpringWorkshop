package com.addressbook.dto;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {

	// Class Variables
	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}", message = "Contact's firstname is invalid!")
	public String firstName;

	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}", message = "Contact's lastname is invalid!")
	public String lastName;
	
	@Pattern(regexp = "^[A-Z]{1,}[a-z]{2,}", message = "Contact's address is invalid!")
	public String address;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City name should start with uppercase and having atleast 3 characters!")
	public String city;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City name should start with uppercase and having atleast 3 characters!")
	public String state;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Follow 3 mandatory, 2 optional part system!")
	public String email;

	
	/*Generated constructor for all the instance variable in the DTO class.
	 * Making all variables as public to be accessed outside class directly by AddressBookData class.
	 * */
	public AddressBookDTO(int id, String firstName, String lastName, String address, String city, String state, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
	}
}
