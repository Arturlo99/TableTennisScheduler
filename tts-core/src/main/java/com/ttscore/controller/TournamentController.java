package com.ttscore.controller;

import com.ttscore.dto.TournamentDTO;
import com.ttscore.dto.TournamentDetailsDTO;
import com.ttscore.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/all")
    Iterable<TournamentDTO> findAllTournamentsForList() {
        return tournamentRepository.findAllTournamentsForList();
    }

    @GetMapping("/details/{id}")
    TournamentDetailsDTO findTournamentDetailsById(@PathVariable Integer id) {
        return tournamentRepository.findTournamentDetailsUsingId(id);
    }
}