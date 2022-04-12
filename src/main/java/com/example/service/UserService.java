package com.example.service;

import com.example.repository.UserRepository;
import com.example.request.CreateUserRequestDTo;
import models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserInfo> fetchAllUsers(){
        return userRepository.findAll();

    }

    public UserInfo createUser(CreateUserRequestDTo createUserRequestDTo){
        return userRepository.save(createUserRequestDTo.toUser());
    }
}
