package com.rakeshpoc.schoolapp.repository;

import com.rakeshpoc.schoolapp.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {

     List<Contact>   findByStatus(String status);

     //@Query("select c from Contact c where status= :status")
     @Query(value = "select * from contact_msg where status= :status",nativeQuery = true)
     Page<Contact> findByStatus(String status, Pageable pageable);

     @Transactional
     @Modifying
     @Query("UPDATE Contact c set c.status= ?1 where c.contactId=?2")
     int updateStatusById(String status,int id);

     Page<Contact> findOpenMsgs(String status, Pageable pageable);

     @Transactional
     @Modifying
     int updateMsgStatusById(String status,int id);

     @Query(nativeQuery = true)
     Page<Contact> findOpenMsgsNative(String status, Pageable pageable);

     @Transactional
     @Modifying
     @Query(nativeQuery = true)
     int updateMsgStatusByIdNative(String status,int id);

}
