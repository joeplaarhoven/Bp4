package com.example.bp4.Cabaretier;

import javax.persistence.*;

@Entity
@Table(name="cabaretiers")
public class Cabaretier {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cabaretier_id;
	
	@Column(name = "cabaretier_voornaam", nullable = false, unique = false)
    private String cabaretier_voornaam;
	@Column(name = "cabaretier_achternaam", nullable = false, unique = false)
    private String cabaretier_achternaam;
	@Column(name = "geboortedatum", nullable = false, unique = false)
    private String geboortedatum;
	@Column(name = "geslacht", nullable = false, unique = false)
    private String geslacht;
	
    public Cabaretier(String cabaretier_voornaam, String cabaretier_achternaam, String geboortedatum, String geslacht) {
    	this.cabaretier_voornaam = cabaretier_voornaam;
    	this.cabaretier_achternaam = cabaretier_achternaam;
    	this.geboortedatum = geboortedatum;
    	this.geslacht = geslacht;
    }
    
    public Cabaretier() {
    	
    }
	
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
		
}
