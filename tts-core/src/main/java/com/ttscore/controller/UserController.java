package com.ttscore.controller;

import com.ttscore.model.User;
import com.ttscore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    ResponseEntity<?> createNewUser(@RequestBody User user) {
        if(userRepository.countUsingEmail(user.getEmail())>0){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
