package com.example.criteriaapidemo;

import com.example.criteriaapidemo.model.Address;
import com.example.criteriaapidemo.model.Person;
import com.example.criteriaapidemo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.example.criteriaapidemo.repository.PersonSpecs.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.jpa.domain.Specifications.where;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriteriaApiDemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void verifyQueryByFirstAndLastName() {

		this.entityManager.persist(new Person("Hans", "Mustermann",
                Arrays.asList(new Address("Hauptstr.15", "70771", "Leinfelden"),
                        new Address("Nebenstr. 11", "70159", "Stuttgart"))));

        this.entityManager.persist(new Person("Bernd", "Mustermann",
                Arrays.asList(new Address("Hauptstr.15", "70771", "Leinfelden"),
                        new Address("Nebenstr. 11", "70159", "Stuttgart"))));

        List<Person> personList = personRepository.findAll(where(hasFirstName("Hans")).and(hasLastName("Mustermann")));
        assertThat(personList).isNotNull().hasSize(1);

    }

    @Test
    public void verifyQueryByLivingInStreet() {

        this.entityManager.persist(new Person("Hans", "Mustermann",
                Arrays.asList(new Address("Hauptstr.15", "70771", "Leinfelden"),
                        new Address("Nebenstr. 11", "70159", "Stuttgart"))));

        this.entityManager.persist(new Person("Bernd", "Mustermann",
                Arrays.asList(new Address("Hauptstr.17", "70771", "Leinfelden"),
                        new Address("Nebenstr. 1", "70159", "Stuttgart"))));

        List<Person> personList = personRepository.findAll(
                where(hasLastName("Mustermann")).and(isLivingInStreet("Hauptstr.17")));

        assertThat(personList).isNotNull().hasSize(1);
    }

}
