package com.ttscore.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TournamentDetailsDTO {
    private String name;
    private LocalDateTime date;
    private Integer organizerId;
    private String organizerName;
    private String organizerLastName;
    private String description;
    private Integer enrolledPlayers;
    private String city;
    private String street;
    private Integer maxPlayers;
    private Boolean userEnrolled;
    private List<UserForTournamentDTO> users;
    private List<MatchDTO> matches;

    public TournamentDetailsDTO(String name, LocalDateTime date, Integer organizerId, String organizerName,
                                String organizerLastName, String description, Integer enrolledPlayers, String city,
                                String street, Integer maxPlayers) {
        this.name = name;
        this.date = date;
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerLastName = organizerLastName;
        this.description = description;
        this.enrolledPlayers = enrolledPlayers;
        this.city = city;
        this.street = street;
        this.maxPlayers = maxPlayers;
    }

    public TournamentDetailsDTO(String name, LocalDateTime date, Integer organizerId, String organizerName,
                                String organizerLastName, String description, Integer enrolledPlayers,
                                String city, String street, Integer maxPlayers, Boolean userEnrolled,
                                List<UserForTournamentDTO> users, List<MatchDTO> matches) {
        this.name = name;
        this.date = date;
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerLastName = organizerLastName;
        this.description = description;
        this.enrolledPlayers = enrolledPlayers;
        this.city = city;
        this.street = street;
        this.maxPlayers = maxPlayers;
        this.userEnrolled = userEnrolled;
        this.users = users;
        this.matches = matches;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
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

    public List<UserForTournamentDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserForTournamentDTO> users) {
        this.users = users;
    }

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerLastName() {
        return organizerLastName;
    }

    public void setOrganizerLastName(String organizerLastName) {
        this.organizerLastName = organizerLastName;
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }
}
