package com.marcos.rodrigues.spring.data.controller;

import com.marcos.rodrigues.spring.data.models.Person;
import com.marcos.rodrigues.spring.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> findAll() {
        return (List<Person>) this.personRepository.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return this.personRepository.save(person);
    }
}
