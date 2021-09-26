package com.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
