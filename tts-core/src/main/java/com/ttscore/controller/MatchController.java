package com.ttscore.controller;

import com.ttscore.dto.GenerateTournamentMatchesDTO;
import com.ttscore.dto.MatchDTO;
import com.ttscore.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping("/generate-tournament-matches")
    ResponseEntity<List<MatchDTO>> generateTournamentMatches(@RequestBody GenerateTournamentMatchesDTO requestBody) {
        return matchService.generateTournamentMatches(requestBody);
    }

    @PutMapping("/update-match")
    ResponseEntity<?> updateMatch(@RequestBody MatchDTO matchDTO) {
        return matchService.updateMatch(matchDTO);
    }
}