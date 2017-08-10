package com.example.criteriaapidemo.repository;

import com.example.criteriaapidemo.model.Address;
import com.example.criteriaapidemo.model.Address_;
import com.example.criteriaapidemo.model.Person;
import com.example.criteriaapidemo.model.Person_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.ListJoin;

public final class PersonSpecs {

    private PersonSpecs() {
    }

    public static Specification<Person> hasFirstName(String firstName) {
        return (root, query, builder) -> builder.equal(root.get(Person_.firstname), firstName);
    }

    public static Specification<Person> hasLastName(String lastName) {
        return (root, query, builder) -> builder.equal(root.get(Person_.lastname), lastName);
    }

    public static Specification<Person> isLivingInStreet(String street) {
        return (root, query, builder) -> {
            ListJoin<Person, Address> addressListJoin = root.join(Person_.addresses);
            return builder.equal(addressListJoin.get(Address_.street), street);
        };
    }

}
