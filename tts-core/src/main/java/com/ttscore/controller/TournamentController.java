package com.ttscore.controller;

import com.ttscore.dto.TournamentDTO;
import com.ttscore.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/all")
    Iterable<TournamentDTO> all() {
        return tournamentRepository.findAllTournamentsForList();
    }
}