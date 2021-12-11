package com.ttscore.service;

import com.ttscore.dto.GenerateTournamentMatchesDTO;
import com.ttscore.dto.MatchDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MatchService {

    ResponseEntity<List<MatchDTO>> generateTournamentMatches(GenerateTournamentMatchesDTO requestBody);

    ResponseEntity<?> updateMatch(MatchDTO matchDTO);
}
