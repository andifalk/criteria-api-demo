package com.example.criteriaapidemo.model;

import javax.persistence.metamodel.SingularAttribute;

/**
 * JPA metamodel for {@link Address}.
 */
public abstract class Address_ {

    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> zip;
    public static volatile SingularAttribute<Address, String> city;

}
