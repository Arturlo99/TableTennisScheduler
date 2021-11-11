package com.ttscore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class UserController {
    @Autowired
    private final UserController userController;

    public UserController(UserController userController) {
        this.userController = userController;
    }
}
