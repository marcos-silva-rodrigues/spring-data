package com.marcos.rodrigues.spring.data.controller;

import com.marcos.rodrigues.spring.data.models.Event;
import com.marcos.rodrigues.spring.data.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> findAll() {
        return (List<Event>) this.eventRepository.findAll();
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return this.eventRepository.save(event);
    }

}
