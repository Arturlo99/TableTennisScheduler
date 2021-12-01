package com.ttscore.controller;

import com.ttscore.dto.*;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/tournaments/details/{id}")
    TournamentDetailsDTO findTournamentDetailsById(@PathVariable Integer id, @RequestBody String email) {
        Tournament t = tournamentRepository.findTournamentById(id);
        User u = userRepository.findUserByEmail(email);
        Boolean userEnrolled = t.getUsers().contains(u);

        return new TournamentDetailsDTO(t.getName(), t.getDate(), t.getOrganizer(), t.getDescription(),
                t.getUsers().size(), t.getCity(), t.getCity(), t.getMaxPlayers(), userEnrolled);
    }

    /*
        Returns true if user is assigned to the specific tournament otherwise false
     */
    @PostMapping("/tournaments/enroll")
    @ResponseBody
    ResponseEntity<TournamentEnrollmentResponseDTO> enrollForTournament(@RequestBody TournamentEnrollmentDTO enrollment) {
        User user = userRepository.findUserByEmail(enrollment.getUserEmail());
        if (user != null) {
            Tournament t = tournamentRepository.findTournamentById(enrollment.getTournamentId());
            if (t != null) {
                if (t.getUsers().contains(user)) {
                    t.getUsers().remove(user);
                    user.getTournaments().remove(t);
                    tournamentRepository.save(t);
                    userRepository.save(user);
                    return new ResponseEntity<>(new TournamentEnrollmentResponseDTO(t.getUsers().size(), false),
                            HttpStatus.OK);
                } else if (t.getUsers().size() < t.getMaxPlayers()) {
                    t.getUsers().add(user);
                    user.getTournaments().add(t);
                    tournamentRepository.save(t);
                    userRepository.save(user);

                    return new ResponseEntity<>(new TournamentEnrollmentResponseDTO(t.getUsers().size(), true),
                            HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping("/create-event")
    @ResponseBody
    ResponseEntity<?> createNewTournament(@RequestBody NewTournamentDTO t) {
        User organizer = userRepository.findUserByEmail(t.getOrganizerEmail());
        if (organizer != null) {
            tournamentRepository.save(new Tournament(t.getName(), t.getCity(), t.getStreet(), t.getDate(),
                    organizer.getName() + ' ' + organizer.getLastName(), t.getDescription(), t.getMaxPlayers()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}