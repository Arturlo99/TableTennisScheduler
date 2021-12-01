package com.ttscore.controller;

import com.ttscore.model.Match;
import com.ttscore.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/all")
    List<Match> all() {
        return matchRepository.findAll();
    }
}