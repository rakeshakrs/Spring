package com.rakeshpoc.schoolapp.service;

import com.rakeshpoc.schoolapp.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContactService {

    private final Logger log=LoggerFactory.getLogger("ContactService.class");

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        log.info(contact.toString());
        return isSaved;
    }
}
