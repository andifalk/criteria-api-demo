package com.example.criteriaapidemo.repository;

import com.example.criteriaapidemo.model.Address;
import com.example.criteriaapidemo.model.Address_;
import com.example.criteriaapidemo.model.Person;
import com.example.criteriaapidemo.model.Person_;
import org.springframework.data.jpa.domain.Specification;

public final class AddressSpecs {

    private AddressSpecs() {
    }

    public static Specification<Address> hasStreet(String street) {
        return (root, query, builder) -> builder.equal(root.get(Address_.street), street);
    }

    public static Specification<Address> hasZip(String zip) {
        return (root, query, builder) -> builder.equal(root.get(Address_.zip), zip);
    }

    public static Specification<Address> hasCity(String city) {
        return (root, query, builder) -> builder.equal(root.get(Address_.city), city);
    }
}
