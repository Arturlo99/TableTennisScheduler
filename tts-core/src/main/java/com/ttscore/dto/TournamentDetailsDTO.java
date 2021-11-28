package com.ttscore.dto;

import java.time.LocalDateTime;

public class TournamentDetailsDTO {
    private String name;
    private LocalDateTime date;
    private String organizer;
    private String description;
    private Integer enrolledPlayers;
    private String city;
    private String street;
    private Integer maxPlayers;
    private Boolean userEnrolled;

    public TournamentDetailsDTO(String name, LocalDateTime date, String organizer, String description, Integer enrolledPlayers, String city, String street, Integer maxPlayers) {
        this.name = name;
        this.date = date;
        this.organizer = organizer;
        this.description = description;
        this.enrolledPlayers = enrolledPlayers;
        this.city = city;
        this.street = street;
        this.maxPlayers = maxPlayers;
    }

    public TournamentDetailsDTO(String name, LocalDateTime date, String organizer, String description, Integer enrolledPlayers, String city, String street, Integer maxPlayers, Boolean userEnrolled) {
        this.name = name;
        this.date = date;
        this.organizer = organizer;
        this.description = description;
        this.enrolledPlayers = enrolledPlayers;
        this.city = city;
        this.street = street;
        this.maxPlayers = maxPlayers;
        this.userEnrolled = userEnrolled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getEnrolledPlayers() {
        return enrolledPlayers;
    }

    public void setEnrolledPlayers(Integer enrolledPlayers) {
        this.enrolledPlayers = enrolledPlayers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Boolean getUserEnrolled() {
        return userEnrolled;
    }

    public void setUserEnrolled(Boolean userEnrolled) {
        this.userEnrolled = userEnrolled;
    }
}
