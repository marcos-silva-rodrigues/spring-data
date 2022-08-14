package com.marcos.rodrigues.spring.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double value;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Set<Person> people;

    public Event() {
    }

    public Event(Long id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
