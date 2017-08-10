package com.example.criteriaapidemo.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person extends AbstractPersistable<Long> {

    private String firstname;

    private String lastname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Person() {
    }

    public Person(String firstname, String lastname, List<Address> addresses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = addresses;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
