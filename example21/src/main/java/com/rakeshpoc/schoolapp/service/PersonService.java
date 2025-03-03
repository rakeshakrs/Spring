package com.rakeshpoc.schoolapp.service;

import com.rakeshpoc.schoolapp.constants.SchoolConstants;
import com.rakeshpoc.schoolapp.model.Person;
import com.rakeshpoc.schoolapp.model.Roles;
import com.rakeshpoc.schoolapp.repository.PersonRepository;
import com.rakeshpoc.schoolapp.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean isPersonSaved(Person person){
        boolean isSaved=false;
        Roles byRoleName = rolesRepository.getByRoleName(String.valueOf(SchoolConstants.STUDENT));
        person.setRoles(byRoleName);
        Person saved = personRepository.save(person);
        if(null!=saved && saved.getPersonId()>0){
            isSaved=true;

        }
        return isSaved;

    }
}
