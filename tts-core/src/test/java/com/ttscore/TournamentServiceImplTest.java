package com.ttscore;

import com.ttscore.dto.TournamentEnrollmentDTO;
import com.ttscore.model.Tournament;
import com.ttscore.model.User;
import com.ttscore.repository.TournamentRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.impl.TournamentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TournamentServiceImplTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TournamentServiceImpl tournamentService;

    private static final Integer TOURNAMENT_ID = 1;
    private static final String EMAIL = "EMAIL";

    @Test
    void shouldEnrollInTournament() {
        //given
        TournamentEnrollmentDTO enrollment = new TournamentEnrollmentDTO();
        enrollment.setTournamentId(TOURNAMENT_ID);
        enrollment.setUserEmail(EMAIL);
        Tournament tournament = new Tournament();
        User user = new User();
        user.setTournaments(new HashSet<>());
        User user2 = new User();
        user2.setTournaments(new HashSet<>(List.of(tournament)));
        tournament.setMaxPlayers(8);
        tournament.setUsers( new ArrayList<>(List.of(user2)));
        when(userRepository.findUserByEmail(EMAIL)).thenReturn(user);
        when(tournamentRepository.findTournamentById(TOURNAMENT_ID)).thenReturn(tournament);

        //when
        ResponseEntity<?> result = tournamentService.enrollInOrWithdrawFromTournament(enrollment);

        //then
        verify(tournamentRepository).save(tournament);
        verify(userRepository).save(user);
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
