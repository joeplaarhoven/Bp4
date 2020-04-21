package com.example.bp4.Gebruikers;

import javax.persistence.*;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruikerID;
    private Integer leeftijd;

    @Column(name = "gebruikerVoornaam", nullable = false, unique = false)
    private String gebruikerVoornaam;

    @Column(name = "gebruikerAchternaam", nullable = false, unique = false)
    private String gebruikerAchternaam;

    @Column(name = "afkomst", nullable = false, unique = false)
    private String afkomst;

    @Column(name = "gebruikersnaam", nullable = false, unique = false)
    private String gebruikersnaam;

    @Column(name = "wachtwoord", nullable = false, unique = false)
    private String wachtwoord;

    @Column(name = "leeftijdsCategorie", nullable = false, unique = false)
    private String leeftijdsCategorie;

    public Integer getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(Integer gebruikerID) {
        this.gebruikerID = gebruikerID;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getLeeftijdsCategorie() {
        return leeftijdsCategorie;
    }

    public void setLeeftijdsCategorie(String leeftijdsCategorie) {
        this.leeftijdsCategorie = leeftijdsCategorie;
    }

    public String getGebruikerVoornaam() {
        return gebruikerVoornaam;
    }

    public void setGebruikerVoornaam(String gebruikerVoornaam) {
        this.gebruikerVoornaam = gebruikerVoornaam;
    }

    public String getGebruikerAchternaam() {
        return gebruikerAchternaam;
    }

    public void setGebruikerAchternaam(String gebruikerAchternaam) {
        this.gebruikerAchternaam = gebruikerAchternaam;
    }

    public String getAfkomst() {
        return afkomst;
    }

    public void setAfkomst(String afkomst) {
        this.afkomst = afkomst;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
