package com.marcos.rodrigues.spring.data.repository;

import com.marcos.rodrigues.spring.data.models.Event;
import com.marcos.rodrigues.spring.data.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findByEventId(Pageable pageable, Event eventId);
}
