package com.example.bp4.Gebruikers;

import javax.persistence.*;

@Entity
@Table(name="gebruikers")
public class Gebruiker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruiker_id;
    private Integer leeftijd;

    @Column(name = "gebruiker_voornaam", nullable = false, unique = false)
    private String gebruiker_voornaam;

    @Column(name = "gebruiker_achternaam", nullable = false, unique = false)
    private String gebruiker_achternaam;

    @Column(name = "afkomst", nullable = false, unique = false)
    private String afkomst;

    @Column(name = "gebruikersnaam", nullable = false, unique = true)
    private String gebruikersnaam;

    @Column(name = "wachtwoord", nullable = false, unique = false)
    private String wachtwoord;

    @Column(name = "leeftijds_categorie", nullable = false, unique = false)
    private String leeftijds_categorie;

    public Gebruiker(String gebruiker_voornaam, String gebruiker_achternaam, Integer leeftijd, String afkomst, String leeftijds_categorie, String gebruikersnaam, String wachtwoord) {
        this.gebruiker_voornaam = gebruiker_voornaam;
        this.gebruiker_achternaam= gebruiker_achternaam;
        this.leeftijd = leeftijd;
        this.afkomst = afkomst;
        this.leeftijds_categorie = leeftijds_categorie;
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

    public String getLeeftijdscategorie() {
        return leeftijds_categorie;
    }

    public void setLeeftijdsCategorie(String leeftijds_categorie) {
        this.leeftijds_categorie = leeftijds_categorie;
    }

    public String getGebruikerVoornaam() {
        return gebruiker_voornaam;
    }

    public void setGebruikerVoornaam(String gebruiker_voornaam) {
        this.gebruiker_voornaam = gebruiker_voornaam;
    }

    public String getGebruikerAchternaam() {
        return gebruiker_achternaam;
    }

    public void setGebruikerAchternaam(String gebruiker_achternaam) {
        this.gebruiker_achternaam = gebruiker_achternaam;
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
