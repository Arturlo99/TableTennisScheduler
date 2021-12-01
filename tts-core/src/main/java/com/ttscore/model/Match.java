package com.ttscore.model;

import javax.persistence.*;
import java.util.Set;

@Table(name = "t_match")
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User firstPlayer;
    @ManyToOne
    private User secondPlayer;
    private String finalResult;
    private String setResults;
    private int tournamentId;
    @ManyToMany
    @JoinTable(
            name = "t_match_user",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> players;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getSetResults() {
        return setResults;
    }

    public void setSetResults(String setResults) {
        this.setResults = setResults;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int eventId) {
        this.tournamentId = eventId;
    }

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }

    public User getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(User firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public User getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(User secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}