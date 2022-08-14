package com.marcos.rodrigues.spring.data.repository;

import com.marcos.rodrigues.spring.data.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
