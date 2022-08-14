package com.marcos.rodrigues.spring.data.repository;

import com.marcos.rodrigues.spring.data.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
