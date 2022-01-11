package com.ttscore.controller;

import com.ttscore.dto.CredentialsDTO;
import com.ttscore.model.User;
import com.ttscore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    ResponseEntity<?> createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody CredentialsDTO credentials) {
        return userService.login(credentials);
    }
}
