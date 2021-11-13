package com.ttscore.controller;

import com.ttscore.model.Tournament;
import com.ttscore.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/all")
    List<Tournament> all() {
        return tournamentRepository.findAll();
    }
}