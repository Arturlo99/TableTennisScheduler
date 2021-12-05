package com.ttscore.dto;

public class UserForTournamentDTO {
    private Integer id;
    private String name;
    private String lastName;
    private MatchDTO matches;

    public UserForTournamentDTO(Integer id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MatchDTO getMatches() {
        return matches;
    }

    public void setMatches(MatchDTO matches) {
        this.matches = matches;
    }
}
