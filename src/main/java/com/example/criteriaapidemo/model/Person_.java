package com.example.criteriaapidemo.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

/**
 * JPA metamodel for {@link Person}.
 */
public abstract class Person_ {

    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile ListAttribute<Person, Address> addresses;
    public static volatile SingularAttribute<Person, String> lastname;

}
