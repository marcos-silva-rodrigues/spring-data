package com.marcos.rodrigues.spring.data.controller;

import com.marcos.rodrigues.spring.data.models.Event;
import com.marcos.rodrigues.spring.data.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Event> findAll(Pageable pageable) {
        Page<Event> events = this.eventRepository.findAll(pageable);
        return events;
    }

    @GetMapping("/sort")
    public List<Event> findAllSorting() {
        List<Event> events = (List<Event>) this.eventRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return events;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return this.eventRepository.save(event);
    }

}
