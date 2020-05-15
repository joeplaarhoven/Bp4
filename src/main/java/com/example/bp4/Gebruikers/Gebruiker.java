package com.example.bp4.Gebruikers;

import javax.persistence.*;

@Entity
@Table(name="gebruikers")
public class Gebruiker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruiker_id;
    private String geboortedatum;

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

    @Column(name = "leeftijdscategorie", nullable = false, unique = false)
    private String leeftijdscategorie;

    public String getGebruiker_voornaam() {
		return gebruiker_voornaam;
	}

	public void setGebruiker_voornaam(String gebruiker_voornaam) {
		this.gebruiker_voornaam = gebruiker_voornaam;
	}

	public String getGebruiker_achternaam() {
		return gebruiker_achternaam;
	}

	public void setGebruiker_achternaam(String gebruiker_achternaam) {
		this.gebruiker_achternaam = gebruiker_achternaam;
	}


	public Gebruiker(String gebruiker_voornaam, String gebruiker_achternaam, String geboortedatum, String afkomst, String leeftijdscategorie, String gebruikersnaam, String wachtwoord) {
        this.gebruiker_voornaam = gebruiker_voornaam;
        this.gebruiker_achternaam= gebruiker_achternaam;
        this.geboortedatum =geboortedatum;
        this.afkomst = afkomst;
        this.leeftijdscategorie = leeftijdscategorie;
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

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getLeeftijdscategorie() {
        return leeftijdscategorie;
    }

    public void setLeeftijdscategorie(String leeftijdscategorie) {
        this.leeftijdscategorie = leeftijdscategorie;
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
