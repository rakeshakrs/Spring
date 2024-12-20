package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }

    @RequestMapping(value={"/contact"})
    public String displayContactPage(){
        return "contact.html";
    }
    @RequestMapping(value={"/saveMsg"}, method=POST)
    public ModelAndView saveMsg(Contact contact){
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
