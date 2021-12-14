package com.ttscore;

import com.ttscore.dto.GenerateTournamentMatchesDTO;
import com.ttscore.dto.MatchDTO;
import com.ttscore.model.Match;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.MatchRepository;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.impl.MatchServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MatchServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    MatchServiceImpl matchService;

    private static final Integer MATCH_ID = 1;
    private static final Integer FIRST_PLAYER_ID = 1;
    private static final Integer SECOND_PLAYER_ID = 2;
    private static final Integer TOURNAMENT_ID = 1;
    private static final String FINAL_RESULT = "3:0";
    private static final String EMAIL = "EMAIL";

    @Test
    void shouldUpdateMatch(){
        //given
        MatchDTO matchDTO = mock(MatchDTO.class);
        Match match = new Match();
        when(matchDTO.getMatchId()).thenReturn(MATCH_ID);
        when(matchDTO.getFinalResult()).thenReturn(FINAL_RESULT);
        when(matchRepository.getById(MATCH_ID)).thenReturn(match);

        //when
        ResponseEntity<?> result = matchService.updateMatch(matchDTO);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(matchRepository).save(match);
    }


    @Test
    void shouldGenerateTournamentMatches(){
        //given
        GenerateTournamentMatchesDTO requestBody = new GenerateTournamentMatchesDTO();
        requestBody.setUserEmail(EMAIL);
        MatchDTO matchDTO = new MatchDTO(MATCH_ID, FIRST_PLAYER_ID, SECOND_PLAYER_ID, FINAL_RESULT, TOURNAMENT_ID);
        requestBody.setMatches(List.of(matchDTO));
        User admin = new User();
        Tournament tournament = new Tournament();
        when(userRepository.findUserByEmail(requestBody.getUserEmail())).thenReturn(admin);
        when(tournamentRepository.findTournamentById(TOURNAMENT_ID)).thenReturn(tournament);
        //when
        ResponseEntity<?> result = matchService.generateTournamentMatches(requestBody);

        //then
        Assertions.assertThat(result.getBody()).isEqualTo(requestBody.getMatches());
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
