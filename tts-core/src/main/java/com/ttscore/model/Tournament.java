package com.ttscore.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "t_tournament")
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private String street;
    private LocalDateTime date;
    private String organizer;
    private String description;
    private Integer maxPlayers;
    @ManyToMany(mappedBy = "tournaments")
    private Set<User> users;

    public Tournament() {}

    public Tournament(String name, String city, String street, LocalDateTime date, String organizer, String description, Integer maxPlayers) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.date = date;
        this.organizer = organizer;
        this.description = description;
        this.maxPlayers = maxPlayers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}