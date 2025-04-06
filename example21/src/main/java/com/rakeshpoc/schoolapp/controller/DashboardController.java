package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.config.SchoolAppProps;
import com.rakeshpoc.schoolapp.model.Person;
import com.rakeshpoc.schoolapp.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Value("${schoolapp.pageCount}")
    private int pageCount;
    @Value("${schoolapp.test}")
    private String pageCountExample;

    @Autowired
    private SchoolAppProps schoolAppProps;

    @Autowired
    private Environment environment;

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
        log.info("pageCount {}",pageCountExample);
        log.info("pageCount {}",pageCount);
        log.info("pageCount from school props {}",schoolAppProps.getPageCount());
        log.info("pageCount from environment {}",environment.getProperty("schoolapp.pageCount"));
        log.info("test from environment {}",environment.getProperty("schoolapp.test"));

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
