package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }

    @RequestMapping(value={"/contact"})
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }
    @RequestMapping(value={"/saveMsg"}, method=POST)
    public String saveMsg(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact submission has errors "+errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
