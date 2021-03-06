package com.ttscore.repository;

import com.ttscore.dto.TournamentDTO;
import com.ttscore.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Query("SELECT new com.ttscore.dto.TournamentDTO(t.id, t.name, t.city, t.street, t.date, size(t.users), t.maxPlayers) FROM Tournament t")
    Iterable<TournamentDTO> findAllTournamentsForList();

    Tournament findTournamentById(Integer id);
}