package com.vipsamleti.springjpademo.controller;

import com.vipsamleti.springjpademo.model.User;
import com.vipsamleti.springjpademo.model.UserContact;
import com.vipsamleti.springjpademo.repository.UserContactRepository;
import com.vipsamleti.springjpademo.repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users/contacts")
public class UserContactController {

    @Autowired
    private UserContactRepository userContactRepository;

    @Autowired
    private UserJPARepository userJPARepository;

    @GetMapping("/all")
    public List<UserContact> getUserContact(){
        return userContactRepository.findAll();
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserContact> loadUserContact(@RequestBody UserContact userContact,
                                          @PathVariable final long id) throws Exception{

        User user = userJPARepository.findById(id)
                .orElseThrow(() -> new Exception());

        userContact.setUser(user);
        userContactRepository.save(userContact);
        return ResponseEntity.ok().body(userContact);
    }
}
