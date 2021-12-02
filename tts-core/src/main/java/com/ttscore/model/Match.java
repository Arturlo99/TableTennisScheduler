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
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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