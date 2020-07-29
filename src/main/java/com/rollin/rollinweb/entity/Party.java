package com.rollin.rollinweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long capacity;
    private String city;
    private String genre;
    public String description;

    @ManyToMany(mappedBy = "parties")

    private List<Gamer> gamers = new ArrayList<>();

    public Party() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Gamer> getGamers(){
        return gamers;
    }
    public void setGamers(List<Gamer> gamers){
        this.gamers = gamers;
    }
}
