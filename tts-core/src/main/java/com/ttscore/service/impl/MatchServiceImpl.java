package com.ttscore.service.impl;

import com.ttscore.dto.GenerateTournamentMatchesDTO;
import com.ttscore.dto.MatchDTO;
import com.ttscore.model.Match;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.MatchRepository;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public ResponseEntity<List<MatchDTO>> generateTournamentMatches(GenerateTournamentMatchesDTO requestBody) {
        User u = userRepository.findUserByEmail(requestBody.getUserEmail());
        Tournament t = tournamentRepository.findTournamentById(requestBody.getMatches().get(0).getTournamentId());
        if (t != null && u != null) {
            List<Match> matchesToBeSaved = new ArrayList<>();
            requestBody.getMatches().forEach(match -> {
                User firstPlayer = userRepository.findUserById(match.getFirstPlayerId());
                User secondPlayer = userRepository.findUserById(match.getSecondPlayerId());
                matchesToBeSaved.add(new Match(firstPlayer, secondPlayer, match.getFinalResult(), t));
            });
            matchRepository.saveAll(matchesToBeSaved);
            return new ResponseEntity<>(requestBody.getMatches(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public ResponseEntity<?> updateMatch(MatchDTO matchDTO) {
        Match match = matchRepository.getById(matchDTO.getMatchId());
        match.setFinalResult(matchDTO.getFinalResult());
        matchRepository.save(match);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
