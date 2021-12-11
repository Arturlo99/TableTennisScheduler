package com.ttscore.service;

import com.ttscore.dto.CredentialsDTO;
import com.ttscore.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<?> createNewUser(User user);

    Map<String, String> login(CredentialsDTO credentials);
}
