package com.rakeshpoc.schoolapp.controller;

import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.model.Response;
import com.rakeshpoc.schoolapp.proxy.ContactProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactProxy contactProxy;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;


    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam String status){
        return contactProxy.getMsgByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact){
        String uri="http://localhost:8080/api/contact/saveMsg";
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("test","test");
        HttpEntity<Contact> contactHttpEntity=new HttpEntity<>(contact,httpHeaders);
        ResponseEntity<com.rakeshpoc.schoolapp.model.Response> response=restTemplate.exchange(uri, HttpMethod.POST,contactHttpEntity,
                Response.class);
        return response;
    }

    @PostMapping("/saveMessage")
    public Mono<Response> savemessage(@RequestBody Contact contact){
        String uri="http://localhost:8080/api/contact/saveMsg";
        return webClient.post().uri(uri)
                .header("test","test")
                .body(Mono.just(contact), Contact.class)
                .retrieve()
                .bodyToMono(Response.class);

    }

}
