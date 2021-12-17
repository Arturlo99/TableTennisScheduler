package com.ttscore.controller;

import com.ttscore.dto.*;
import com.ttscore.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/tournaments/all")
    Iterable<TournamentDTO> findAllTournamentsForList() {
        return tournamentService.findAllTournamentsForList();
    }

    @PostMapping("/tournaments/details/{id}")
    TournamentDetailsDTO findTournamentDetailsByIdAndEmail(@PathVariable Integer id, @RequestBody String email) {
        return tournamentService.findTournamentDetailsByIdAndEmail(id, email);
    }

    @PostMapping("/tournaments/enroll")
    ResponseEntity<TournamentEnrollmentResponseDTO> enrollInOrWithdrawFromTournament(@RequestBody TournamentEnrollmentDTO enrollment) {
        return tournamentService.enrollInOrWithdrawFromTournament(enrollment);
    }

    @PostMapping("/create-event")
    ResponseEntity<?> createNewTournament(@RequestBody NewTournamentDTO newTournamentDTO) {
        return tournamentService.createNewTournament(newTournamentDTO);
    }

    @DeleteMapping("/delete-event/{id}")
    ResponseEntity<?> deleteTournament(@PathVariable Integer id) {
        return tournamentService.deleteTournament(id);
    }

}