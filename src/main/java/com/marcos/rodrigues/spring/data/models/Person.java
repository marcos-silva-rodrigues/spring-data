package com.marcos.rodrigues.spring.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event eventId;

    public Person() {
    }

    public Person(String name, Event event) {
        this.name = name;
        this.eventId = event;
    }

    public Person(Long id, String name,  Event event) {
        this.id = id;
        this.name = name;
        this.eventId = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }
}
