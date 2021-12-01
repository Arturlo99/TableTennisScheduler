package com.ttscore.dto;

public class TournamentEnrollmentResponseDTO {
    private Integer enrolledPlayers;
    private Boolean userEnrolled;

    public TournamentEnrollmentResponseDTO(Integer enrolledPlayers, Boolean userEnrolled) {
        this.enrolledPlayers = enrolledPlayers;
        this.userEnrolled = userEnrolled;
    }

    public Integer getEnrolledPlayers() {
        return enrolledPlayers;
    }

    public void setEnrolledPlayers(Integer enrolledPlayers) {
        this.enrolledPlayers = enrolledPlayers;
    }

    public Boolean getUserEnrolled() {
        return userEnrolled;
    }

    public void setUserEnrolled(Boolean userEnrolled) {
        this.userEnrolled = userEnrolled;
    }
}
