package com.rakeshpoc.schoolapp.repository;

import com.rakeshpoc.schoolapp.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass,Integer> {

    EazyClass findById(int id);
}
