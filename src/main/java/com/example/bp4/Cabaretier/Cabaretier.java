package com.example.bp4.Cabaretier;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

@Entity
@IdClass(CabaretierPK.class)
@Table(name = "Cabaretiers")
public class Cabaretier extends Voorstelling {
	
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
   
    public Cabaretier(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, Integer cabaretier_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, cabaretier_id);

        this.cabaretier_id = cabaretier_id;
	}	

	public Cabaretier(Integer cabaretier_id, String cabaretier_voornaam, String cabaretier_achternaam, String geboortedatum, String geslacht) {
		this.cabaretier_id = cabaretier_id;
		this.cabaretier_voornaam = cabaretier_voornaam;
		this.cabaretier_achternaam = cabaretier_achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
	}
	
	public Cabaretier(String cabaretier_voornaam, String cabaretier_achternaam, String geboortedatum, String geslacht, Integer voorstelling_id) {
		this.cabaretier_voornaam = cabaretier_voornaam;
		this.cabaretier_achternaam = cabaretier_achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
		this.voorstelling_id = voorstelling_id;
	}
	
//	public Caberetier(Integer theaterzaal_id, 
//			String voorstellingSoort, 
//			String leeftijdsCat, 
//			String afkomst, 
//			String datum, 
//			String tijd, 
//			Integer caberetier_id, 
//			String voornaam, 
//			String achternaam, 
//			String leeftijd, 
//			String geslacht) {
//		super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, caberetier_id);
//
//        this.caberatier_id = caberatier_id;
//        this.caberetier_voornaam = voornaam;
//        this.caberetier_achternaam = achternaam;
//        this.leeftijd = leeftijd;
//        this.geslacht = geslacht;
//	}


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

	public Integer getVoorstelling_id() {
		return voorstelling_id;
	}

	public void setVoorstelling_id(Integer voorstelling_id) {
		this.voorstelling_id = voorstelling_id;
	}	
		
}
