package com.marcos.rodrigues.spring.data.controller;

import com.marcos.rodrigues.spring.data.models.Event;
import com.marcos.rodrigues.spring.data.models.Person;
import com.marcos.rodrigues.spring.data.repository.EventRepository;
import com.marcos.rodrigues.spring.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events/{eventId}/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    public PersonController(PersonRepository personRepository, EventRepository eventRepository) {
        this.personRepository = personRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Person> findAll(@PathVariable Long eventId) {

        Optional<Event> event = this.eventRepository.findById(eventId);
        if (event.isPresent()) {
            List<Person> people = event.get()
                    .getPeople()
                    .stream()
                    .collect(Collectors.toList());
            return people;
        }
        return new ArrayList<>();
    }

    @PostMapping
    public Person create(@RequestBody Person person, @PathVariable Long eventId) {
        Optional<Event> event = this.eventRepository.findById(eventId);

        if (event.isPresent()) {
            person.setEventId(event.get());
        }

        return this.personRepository.save(person);
    }
}
