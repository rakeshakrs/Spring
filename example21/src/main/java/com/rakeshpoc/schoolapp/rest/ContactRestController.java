package com.rakeshpoc.schoolapp.rest;

import com.rakeshpoc.schoolapp.constants.SchoolConstants;
import com.rakeshpoc.schoolapp.model.Contact;
import com.rakeshpoc.schoolapp.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = ("*"))
public class ContactRestController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(value="/getMessagesByStatus",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    //@ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam(name="status") String status){
        return contactRepository.findByStatus(status);
    }


    @GetMapping("/getAllMsgByStatus")
    public List<Contact> getAllMsgByStatus(@RequestBody Contact contact){
        if(null!=contact && contact.getStatus()!=null){
            return contactRepository.findByStatus(contact.getStatus());
        }else{
            return List.of();
        }

    }


    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("test") String test, @Valid
                                            @RequestBody Contact contact){
        log.info("Header parameter test is {}",test);
        contactRepository.save(contact);
        Response response=new Response();
        response.setStatusCode("200");
        response.setStatusMessage("contact created");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("isMessageSaved","true")
                .body(response);
    }

    @DeleteMapping("/deleteContact")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> contact){
        HttpHeaders headers = contact.getHeaders();
        headers.forEach((key,value)->
                log.info("Header key value pair {} {}",key,value));
        Contact body = contact.getBody();
        contactRepository.deleteById(Objects.requireNonNull(body).getContactId());
        Response response=new Response();
        response.setStatusCode("200");
        response.setStatusMessage("Contact deleted");
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/updateMsg")
    public ResponseEntity<Response> updateContact(@RequestBody Contact contact){
        Optional<Contact> contact1 = contactRepository.findById(contact.getContactId());
        Response response=new Response();
        if(contact1.isPresent()){
            contact1.get().setStatus(String.valueOf(SchoolConstants.CLOSE));
            contactRepository.save(contact1.get());
        }else{
            response.setStatusCode("400");
            response.setStatusMessage("Bad request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatusCode("200");
        response.setStatusMessage("contact updated");
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
