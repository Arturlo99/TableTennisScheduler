package com.ttscore.controller;

import com.ttscore.dto.CredentialsDTO;
import com.ttscore.model.User;
import com.ttscore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public Map<String, String> user(@RequestBody CredentialsDTO credentials) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findUserByEmail(credentials.getEmail());
        if (user != null) {
            if (user.getPassword().equals(credentials.getPassword())) {
                response.put("loggedIn", "true");
                response.put("role", user.getRole());
            } else {
                response.put("loggedIn", "false");
            }
        }
        return response;
    }
}