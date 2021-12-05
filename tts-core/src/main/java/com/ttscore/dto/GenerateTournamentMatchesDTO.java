package com.ttscore.dto;

import java.util.List;

public class GenerateTournamentMatchesDTO {
    private List<MatchDTO> matches;
    private String userEmail;

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
