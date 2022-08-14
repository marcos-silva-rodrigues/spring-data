package com.marcos.rodrigues.spring.data.repository;

import com.marcos.rodrigues.spring.data.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
