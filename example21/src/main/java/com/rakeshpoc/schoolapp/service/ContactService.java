package com.rakeshpoc.schoolapp.service;

import com.rakeshpoc.schoolapp.constants.SchoolConstants;
import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    private final Logger log=LoggerFactory.getLogger("ContactService.class");

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(String.valueOf(SchoolConstants.OPEN));
        Contact result=contactRepository.save(contact);
        if(null != result && (result.getContactId()>0)){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findByStatus(String.valueOf(SchoolConstants.OPEN));
    }

    public Page<Contact> findMsgsWithStatus(int pageNum,String sortField,String sortDir){
        int pageSize=5;
        Pageable pageable= PageRequest.of(pageNum-1,pageSize,
                sortDir.equals("asc")? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return contactRepository.findOpenMsgsNative(String.valueOf(SchoolConstants.OPEN), pageable);
    }

    public boolean isContactUpdated(int id){
        boolean isUpdated=false;

        int result=contactRepository.updateMsgStatusByIdNative(String.valueOf(SchoolConstants.CLOSE),id);
        if(result>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
