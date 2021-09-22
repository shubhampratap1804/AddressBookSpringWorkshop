package com.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {

	// Class Variables
	public String name;
	public long salary;

	// Created constructor
	public AddressBookDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "name: =" + name + " ," + "salary: " + salary;
	}
}
