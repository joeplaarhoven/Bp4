package com.example.bp4.Gebruikers;

import javax.persistence.*;

@Entity
@Table(name="gebruikers")
public class Gebruiker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruiker_id;
    private Integer leeftijd;

    @Column(name = "gebruikerVoornaam", nullable = false, unique = false)
    private String gebruikerVoornaam;

    @Column(name = "gebruikerAchternaam", nullable = false, unique = false)
    private String gebruikerAchternaam;

    @Column(name = "afkomst", nullable = false, unique = false)
    private String afkomst;

    @Column(name = "gebruikersnaam", nullable = false, unique = true)
    private String gebruikersnaam;

    @Column(name = "wachtwoord", nullable = false, unique = false)
    private String wachtwoord;

    @Column(name = "leeftijdsCategorie", nullable = false, unique = false)
    private String leeftijdsCategorie;

    public Gebruiker(String gebruikerVoornaam, String gebruikerAchternaam, Integer leeftijd, String afkomst, String leeftijdsCategorie, String gebruikersnaam, String wachtwoord) {
        this.gebruikerVoornaam = gebruikerVoornaam;
        this.gebruikerAchternaam= gebruikerAchternaam;
        this.leeftijd = leeftijd;
        this.afkomst = afkomst;
        this.leeftijdsCategorie = leeftijdsCategorie;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Gebruiker() {

    }

    public Integer getGebruiker_id() {
        return gebruiker_id;
    }

    public void setGebruiker_id(Integer gebruiker_id) {
        this.gebruiker_id = gebruiker_id;
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
