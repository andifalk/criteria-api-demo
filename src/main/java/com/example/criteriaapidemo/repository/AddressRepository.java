package com.example.criteriaapidemo.repository;

import com.example.criteriaapidemo.model.Address;
import com.example.criteriaapidemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address,Long>, JpaSpecificationExecutor<Person> {
}
