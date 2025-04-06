package com.rakeshpoc.schoolapp.repository;


import com.rakeshpoc.schoolapp.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "courses")
public interface CoursesRepository extends JpaRepository<Courses, Integer> {


    public List<Courses> findByOrderByName();

    public List<Courses> findByOrderByNameDesc();
}
