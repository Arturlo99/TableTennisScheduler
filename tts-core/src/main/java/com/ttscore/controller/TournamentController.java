package com.ttscore.controller;

import com.ttscore.dto.*;
import com.ttscore.model.Match;
import com.ttscore.model.User;
import com.ttscore.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    ResponseEntity<TournamentEnrollmentResponseDTO> enrollForTournament(@RequestBody TournamentEnrollmentDTO enrollment) {
        return tournamentService.enrollForTournament(enrollment);
    }

    @PostMapping("/create-event")
    ResponseEntity<?> createNewTournament(@RequestBody NewTournamentDTO newTournamentDTO) {
        return tournamentService.createNewTournament(newTournamentDTO);
    }

    @DeleteMapping("/delete-event/{id}")
    ResponseEntity<?> deleteTournament(@PathVariable Integer id) {
        return tournamentService.deleteTournament(id);
    }

    private List<UserForTournamentDTO> fetchUsersForTournament(List<User> users) {
        return users.stream().map(u -> new UserForTournamentDTO
                (u.getId(), u.getName(), u.getLastName())).collect(Collectors.toList());
    }

    private List<MatchDTO> fetchTournamentMatches(List<Match> matches) {
        return matches.stream().map(m -> new MatchDTO(m.getId(), m.getFirstPlayer().getId(), m.getSecondPlayer().getId(),
                m.getFinalResult(), m.getTournament().getId())).collect(Collectors.toList());
    }
}