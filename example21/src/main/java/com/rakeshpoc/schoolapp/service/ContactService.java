package com.rakeshpoc.schoolapp.service;

import com.rakeshpoc.schoolapp.constants.SchoolConstants;
import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    private final Logger log=LoggerFactory.getLogger("ContactService.class");

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(String.valueOf(SchoolConstants.OPEN));
        contact.setCreatedBy(String.valueOf(SchoolConstants.ANONYMOUS));
        contact.setCreatedAt(LocalDateTime.now());
        int result=contactRepository.saveContact(contact);
        if(result>0){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.displayContactMessages(String.valueOf(SchoolConstants.OPEN));
    }

    public boolean isContactUpdated(int id, String updatedBy){
        boolean isUpdated=false;
        int result=contactRepository.updateContact(id,String.valueOf(SchoolConstants.CLOSE),updatedBy);
        if(result>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
