package com.example.controller;

import com.example.request.CreateUserRequestDTo;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    /*
    *
    * Perform CRUD operation
    *
    * */

    @Autowired
    UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> fetchAllUsers(){
        log.info("fetch all users from controller");
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createUser(@Valid @RequestBody CreateUserRequestDTo createUserRequestDTo){
        log.info("Performing create user data {}",createUserRequestDTo);
        return new ResponseEntity<>(userService.createUser(createUserRequestDTo),HttpStatus.CREATED);
    }
}
