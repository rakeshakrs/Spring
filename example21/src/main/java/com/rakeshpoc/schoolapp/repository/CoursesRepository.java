package com.rakeshpoc.schoolapp.repository;


import com.rakeshpoc.schoolapp.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
