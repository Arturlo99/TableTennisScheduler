package com.ttscore.dto;

import java.util.List;

public class TournamentEnrollmentResponseDTO {
    private Boolean userEnrolled;
    private List<UserForTournamentDTO> users;

    public TournamentEnrollmentResponseDTO(Boolean userEnrolled, List<UserForTournamentDTO> users) {
        this.userEnrolled = userEnrolled;
        this.users = users;
    }

    public Boolean getUserEnrolled() {
        return userEnrolled;
    }

    public void setUserEnrolled(Boolean userEnrolled) {
        this.userEnrolled = userEnrolled;
    }

    public List<UserForTournamentDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserForTournamentDTO> users) {
        this.users = users;
    }
}
