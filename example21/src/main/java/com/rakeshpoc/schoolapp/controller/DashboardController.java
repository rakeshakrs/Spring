package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Person;
import com.rakeshpoc.schoolapp.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession){
        Person person = personRepository.getByEmail(authentication.getName());
        httpSession.setAttribute("loggedInPerson",person);
        model.addAttribute("username",person.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());
        //throw new RuntimeException("Its been a good day");
        logMessages();
        return "dashboard.html";
    }

    private void logMessages(){
        log.error("error log");
        log.warn("warn log");
        log.info("info log");
        log.debug("debug log");
        log.trace("trace log");
    }
}
