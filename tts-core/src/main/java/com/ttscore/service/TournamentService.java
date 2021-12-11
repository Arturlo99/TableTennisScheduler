package com.ttscore.service;

import com.ttscore.dto.*;
import org.springframework.http.ResponseEntity;

public interface TournamentService {

    Iterable<TournamentDTO> findAllTournamentsForList();

    TournamentDetailsDTO findTournamentDetailsByIdAndEmail(Integer id, String email);

    ResponseEntity<TournamentEnrollmentResponseDTO> enrollForTournament(TournamentEnrollmentDTO enrollment);

    ResponseEntity<?> createNewTournament(NewTournamentDTO newTournamentDTO);

    ResponseEntity<?> deleteTournament(Integer id);
}