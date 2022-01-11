package com.ttscore.service.impl;

import com.ttscore.dto.CredentialsDTO;
import com.ttscore.model.User;
import com.ttscore.repository.RoleRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> createNewUser(User user) {
        if (userRepository.countUsingEmail(user.getEmail()) > 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        user.setRole(roleRepository.getById(2));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Map<String, String> login(CredentialsDTO credentials) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findUserByEmail(credentials.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
                response.put("loggedIn", "true");
                response.put("role", user.getRole().getName());
            } else {
                response.put("loggedIn", "false");
            }
        }
        return response;
    }
}
