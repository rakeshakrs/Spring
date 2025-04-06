package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Address;
import com.rakeshpoc.schoolapp.model.Person;
import com.rakeshpoc.schoolapp.model.Profile;
import com.rakeshpoc.schoolapp.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller(value = "ProfileControllerBean")
public class ProfileController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model, HttpSession httpSession){
        Profile profile=new Profile();
        Person loggedInPerson = (Person) httpSession.getAttribute("loggedInPerson");
        profile.setName(loggedInPerson.getName());
        profile.setMobileNumber(loggedInPerson.getMobileNumber());
        profile.setEmail(loggedInPerson.getEmail());
        if(loggedInPerson.getAddress()!=null && loggedInPerson.getPersonId()>0){
            profile.setAddress1(loggedInPerson.getAddress().getAddress1());
            profile.setAddress2(loggedInPerson.getAddress().getAddress2());
            profile.setCity(loggedInPerson.getAddress().getCity());
            profile.setState(loggedInPerson.getAddress().getState());
            profile.setZipCode(loggedInPerson.getAddress().getZipcode());
        }
        ModelAndView modelAndView=new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }

    @PostMapping("/updateProfile")
    public String updateprofile(@Valid @ModelAttribute("profile") Profile profile, Errors errors
                                ,HttpSession httpSession){
        if(errors.hasErrors()){
            return "profile.html";
        }
        Person person=(Person) httpSession.getAttribute("loggedInPerson");
        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNumber(profile.getMobileNumber());
        if(person.getAddress() ==null || !(person.getAddress().getAddressId()>0)){
            person.setAddress(new Address());
        }
        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZipcode(profile.getZipCode());
        Person savedPerson = personRepository.save(person);
        httpSession.setAttribute("loggedInPerson", savedPerson);
        return "redirect:/displayProfile";
    }
}
