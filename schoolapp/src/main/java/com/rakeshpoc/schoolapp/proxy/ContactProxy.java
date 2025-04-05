package com.rakeshpoc.schoolapp.proxy;

import com.rakeshpoc.schoolapp.config.ProjectConfiguration;
import com.rakeshpoc.schoolapp.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact",url = "http://localhost:8080/api/contact",configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @RequestMapping(value = "/getMessagesByStatus",method = RequestMethod.GET)
    @Headers(value = "Content-type=application/json")
    public List<Contact> getMsgByStatus(@RequestParam("status") String status);
}
