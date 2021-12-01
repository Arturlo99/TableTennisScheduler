package com.ttscore.dto;

import java.time.LocalDateTime;

public class TournamentDTO {
    private Integer id;
    private String name;
    private String city;
    private String street;
    private LocalDateTime date;
    private Integer enrolledPlayers;
    private Integer maxPlayers;

    public TournamentDTO(Integer id, String name, String city, String street, LocalDateTime date, Integer enrolledPlayers, Integer maxPlayers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.date = date;
        this.enrolledPlayers = enrolledPlayers;
        this.maxPlayers = maxPlayers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
