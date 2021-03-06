package com.example.bp4.Cabaretier;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

//Geeft aan dat de class Cabaretier een entiteit is
@Entity
//Hier geef je aan welke class de ID/PK class
@IdClass(CabaretierPK.class)
//Naam van de tabel in de database
@Table(name = "Cabaretiers")
public class Cabaretier extends Voorstelling {
	
	//Variabelen declareren
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer cabaretier_id;
	
	public Integer voorstelling_id;
    
    @Column(name = "cabaretier_voornaam", nullable = true, unique = false)
    public String cabaretier_voornaam;
    @Column(name = "cabaretier_achternaam", nullable = true, unique = false)
    public String cabaretier_achternaam;
    @Column(name = "geboortedatum", nullable = true, unique = false)
    public String geboortedatum;
    @Column(name = "geslacht", nullable = true, unique = false)
    public String geslacht;

    //Constructor voor een voorstelling in te plannen
    public Cabaretier(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, boolean geannuleerd, Integer cabaretier_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, geannuleerd, cabaretier_id);

        this.cabaretier_id = cabaretier_id;
	}
    
    //Constructor voor het toevoegen van cabaretier	
	public Cabaretier(String cabaretier_voornaam, String cabaretier_achternaam, String geboortedatum, String geslacht, Integer voorstelling_id) {
		this.cabaretier_voornaam = cabaretier_voornaam;
		this.cabaretier_achternaam = cabaretier_achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
		this.voorstelling_id = voorstelling_id;
	}
	
	public Cabaretier() {
		
	}
	
	//Getters & Setters van Cabaretier
	public Integer getCabaretier_id() {
		return cabaretier_id;
	}

	public void setCabaretier_id(Integer cabaretier_id) {
		this.cabaretier_id = cabaretier_id;
	}

	public String getCabaretier_voornaam() {
		return cabaretier_voornaam;
	}

	public void setCabaretier_voornaam(String cabaretier_voornaam) {
		this.cabaretier_voornaam = cabaretier_voornaam;
	}

	public String getCabaretier_achternaam() {
		return cabaretier_achternaam;
	}

	public void setCabaretier_achternaam(String cabaretier_achternaam) {
		this.cabaretier_achternaam = cabaretier_achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public Integer getVoorstelling_id() {
		return voorstelling_id;
	}

	public void setVoorstelling_id(Integer voorstelling_id) {
		this.voorstelling_id = voorstelling_id;
	}	
		
}
