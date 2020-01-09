package com.vipsamleti.springjpademo.controller;

import com.vipsamleti.springjpademo.model.User;
import com.vipsamleti.springjpademo.model.UserLog;
import com.vipsamleti.springjpademo.repository.UserJPARepository;
import com.vipsamleti.springjpademo.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJPARepository userRepository;

    @Autowired
    private UserLogRepository userLogRepository;



    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable final long id)throws Exception{

        User user = userRepository.findById(id)
                    .orElseThrow(() -> new Exception());

        CompletableFuture.runAsync(() -> {
            UserLog userLog = new UserLog();
            userLog.setLog("User requested for id..");
            userLog.setUserId(user.getId());
            userLogRepository.save(userLog);
            user.setUserLogs(Arrays.asList(userLog));
            userRepository.save(user);
        });

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<User> getByName(@PathVariable final String name) throws ExecutionException, InterruptedException {

        User user = userRepository.getByName(name);

        CompletableFuture.runAsync(() -> {
            UserLog userLog = new UserLog();
            userLog.setLog("User requested for name..");
            userLog.setUserId(user.getId());
            userLogRepository.save(userLog);
            user.setUserLogs(Arrays.asList(userLog));
            userRepository.save(user);
        });

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity loadUser(@RequestBody final User user){

        userRepository.save(user);
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
