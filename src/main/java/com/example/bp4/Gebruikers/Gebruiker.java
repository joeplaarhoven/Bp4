package com.example.bp4.Gebruikers;

import javax.persistence.*;

//aangeven dat dit een entiteit is
@Entity
//de naam van de tabel in de database
@Table(name="gebruikers")
public class Gebruiker {
	
	//variabelen declareren
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer gebruiker_id;
   
    @Column(name = "gebruiker_voornaam", nullable = false, unique = false)
    private String gebruiker_voornaam;

    @Column(name = "gebruiker_achternaam", nullable = false, unique = false)
    private String gebruiker_achternaam;

    @Column(name = "geboortedatum", nullable = false, unique = false)
    private String geboortedatum;

    @Column(name = "leeftijdscategorie", nullable = false, unique = false)
    private String leeftijdscategorie;

    @Column(name = "afkomst", nullable = false, unique = false)
    private String afkomst;

    @Column(name = "gebruikersnaam", nullable = false, unique = true)
    private String gebruikersnaam;

    @Column(name = "wachtwoord", nullable = false, unique = false)
    private String wachtwoord;

    //Constructors
    public Gebruiker(String gebruiker_voornaam, String gebruiker_achternaam, String geboortedatum, String leeftijdscategorie, String afkomst, String gebruikersnaam, String wachtwoord) {
        this.gebruiker_voornaam = gebruiker_voornaam;
        this.gebruiker_achternaam = gebruiker_achternaam;
        this.geboortedatum = geboortedatum;
        this.leeftijdscategorie = leeftijdscategorie;
        this.afkomst = afkomst;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }


    public Gebruiker(Integer gebruiker_id, String gebruiker_voornaam, String gebruiker_achternaam, String geboortedatum, String leeftijdscategorie, String afkomst, String gebruikersnaam, String wachtwoord) {
        this.gebruiker_id = gebruiker_id;
    	this.gebruiker_voornaam = gebruiker_voornaam;
        this.gebruiker_achternaam = gebruiker_achternaam;
        this.geboortedatum = geboortedatum;
        this.leeftijdscategorie = leeftijdscategorie;
        this.afkomst = afkomst;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Gebruiker() {

    }

    //get sets
	public Integer getGebruiker_id() {
		return gebruiker_id;
	}

	public void setGebruiker_id(Integer gebruiker_id) {
		this.gebruiker_id = gebruiker_id;
	}

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
