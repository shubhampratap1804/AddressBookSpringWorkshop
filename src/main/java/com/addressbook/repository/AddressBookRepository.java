package com.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
	@Query(value = "select * from addressbooktable where city = :city", nativeQuery = true)
	List<AddressBookData> findContactByCity(String city);
}
