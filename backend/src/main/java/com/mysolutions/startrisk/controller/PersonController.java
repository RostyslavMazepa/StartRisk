package com.mysolutions.startrisk.controller;

import com.mysolutions.startrisk.entity.Person;
import com.mysolutions.startrisk.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController()
@RequestMapping("/api")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewPerson(@RequestParam String firstName,
                                      @RequestParam String middleName,
                                      @RequestParam String lastName,
                                      @RequestParam Date birthDate,
                                      @RequestParam Boolean sex) {
        Person person = new Person(firstName, middleName, lastName, birthDate, sex);
        personRepository.save(person);

        LOG.info(person.toString() + " successfully saved into DB");

        return person.getId();
    }

    @GetMapping(path="/person/{id}")
    public @ResponseBody Person getPersonById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return personRepository.findById(id).get();
    }
}
