package com.example.bp4.Gebruiker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruikerId;
    private Integer leeftijd, leeftijdsCategorie;
    private String voornaam, achternaam, afkomst, gerbruikersnaam, wachtwoord;

    public Integer getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(Integer gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public Integer getLeeftijdsCategorie() {
        return leeftijdsCategorie;
    }

    public void setLeeftijdsCategorie(Integer leeftijdsCategorie) {
        this.leeftijdsCategorie = leeftijdsCategorie;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAfkomst() {
        return afkomst;
    }

    public void setAfkomst(String afkomst) {
        this.afkomst = afkomst;
    }

    public String getGerbruikersnaam() {
        return gerbruikersnaam;
    }

    public void setGerbruikersnaam(String gerbruikersnaam) {
        this.gerbruikersnaam = gerbruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
