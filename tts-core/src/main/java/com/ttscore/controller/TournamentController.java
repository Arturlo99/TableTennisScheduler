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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Tournament t = tournamentRepository.findTournamentById(id);
        return new TournamentDetailsDTO(t.getName(), t.getDate(), t.getOrganizer().getId(), t.getOrganizer().getName(),
                t.getOrganizer().getLastName(), t.getDescription(), t.getUsers().size(), t.getCity(), t.getStreet(),
                t.getMaxPlayers(), false, this.fetchUsersForTournament(t.getUsers()), t.getMatches());
    }

    @PostMapping("/tournaments/details/{id}")
    TournamentDetailsDTO findTournamentDetailsByIdAndEmail(@PathVariable Integer id, @RequestBody String email) {
        Tournament t = tournamentRepository.findTournamentById(id);
        User u = userRepository.findUserByEmail(email);
        Boolean userEnrolled = t.getUsers().contains(u);
        return new TournamentDetailsDTO(t.getName(), t.getDate(), t.getOrganizer().getId(), t.getOrganizer().getName(),
                t.getOrganizer().getLastName(), t.getDescription(), t.getUsers().size(), t.getCity(), t.getStreet(),
                t.getMaxPlayers(), userEnrolled, this.fetchUsersForTournament(t.getUsers()), t.getMatches());
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
                    organizer, t.getDescription(), t.getMaxPlayers()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @DeleteMapping("/delete-event/{id}")
    ResponseEntity<?> deleteTournament( @PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            tournamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    private List<UserForTournamentDTO> fetchUsersForTournament (List<User> users) {
        return  users.stream().map(o -> new UserForTournamentDTO
                (o.getId(), o.getName(), o.getLastName())).collect(Collectors.toList());
    }
}