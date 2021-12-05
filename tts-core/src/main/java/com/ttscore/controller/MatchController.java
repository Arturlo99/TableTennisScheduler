package com.ttscore.controller;

import com.ttscore.dto.GenerateTournamentMatchesDTO;
import com.ttscore.dto.MatchDTO;
import com.ttscore.model.Match;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.MatchRepository;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class MatchController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;

    @PostMapping("/generate-tournament-matches")
    ResponseEntity<?> generateTournamentMatches(@RequestBody GenerateTournamentMatchesDTO requestBody) {
        User u = userRepository.findUserByEmail(requestBody.getUserEmail());
        Tournament t = tournamentRepository.findTournamentById(requestBody.getMatches().get(0).getTournamentId());
        if (t != null && u != null) {
            requestBody.getMatches().forEach(match -> {
                User firstPlayer = userRepository.findUserById(match.getFirstPlayerId());
                User secondPlayer = userRepository.findUserById(match.getSecondPlayerId());
                matchRepository.save(new Match(firstPlayer, secondPlayer, match.getFinalResult(), t));
            });
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PutMapping("/update-match")
    ResponseEntity<?> updateMatch(@RequestBody MatchDTO matchDTO) {
        Match match = matchRepository.getById(matchDTO.getMatchId());
        match.setFinalResult(matchDTO.getFinalResult());
        matchRepository.save(match);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}