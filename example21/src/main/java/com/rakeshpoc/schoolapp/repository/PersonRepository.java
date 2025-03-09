package com.rakeshpoc.schoolapp.repository;

import com.rakeshpoc.schoolapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person getByEmail(String email);
}
