package com.rollin.rollinweb.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String pseudo;
    private Date birthday;
    private String livesIn;
    private String biography;
    private boolean noob;

    @ManyToMany
    @JoinTable(name = "gamer_party", joinColumns = @JoinColumn(name = "gamer_id"), inverseJoinColumns = @JoinColumn(name = "party_id"))
    private List<Party> parties = new ArrayList<>();

    public Gamer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLivesIn() {
        return livesIn;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setLivesIn(String livesIn) {
        this.livesIn = livesIn;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public boolean isNoob() {
        return noob;
    }

    public void setNoob(boolean noob) {
        this.noob = noob;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

}
