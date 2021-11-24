package com.ttscore.controller;

import com.ttscore.dto.NewTournamentDTO;
import com.ttscore.dto.TournamentDTO;
import com.ttscore.dto.TournamentDetailsDTO;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tournaments/all")
    Iterable<TournamentDTO> findAllTournamentsForList() {
        return tournamentRepository.findAllTournamentsForList();
    }

    @GetMapping("/tournaments/details/{id}")
    TournamentDetailsDTO findTournamentDetailsById(@PathVariable Integer id) {
        return tournamentRepository.findTournamentDetailsUsingId(id);
    }

    @PostMapping("/create-event")
    ResponseEntity<?> createNewTournament(@RequestBody NewTournamentDTO t) {
        User organizer = userRepository.findUserByEmail(t.getOrganizerEmail());
        if (organizer == null) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        tournamentRepository.save(new Tournament(t.getName(), t.getCity(), t.getStreet(), t.getDate(),
                organizer.getName() + ' ' + organizer.getLastName(), t.getDescription(), t.getMaxPlayers()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}