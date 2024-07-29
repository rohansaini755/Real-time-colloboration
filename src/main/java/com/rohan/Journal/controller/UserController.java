package com.rohan.Journal.controller;

import com.rohan.Journal.Entity.User;
import com.rohan.Journal.Repo.UserRepository;
import com.rohan.Journal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getAllUser();
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
//        System.out.println("enter");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
