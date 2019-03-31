package com.mysolutions.startrisk.repository;

import com.mysolutions.startrisk.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByLastName(@Param("lastName") String lastName);
    List<Person> findByFirstName(@Param("firstName") String firstName);
    List<Person> findByBirthDate(@Param("birthDate") Date birthDate);
}
