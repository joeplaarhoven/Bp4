package com.example.bp4.Caberetier;

import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.*;

@Entity
@IdClass(CaberetierPK.class)
@Table(name = "Caberetiers")
public class Caberetier extends Voorstelling {
	
	
    private Integer caberatier_id;
    private String caberetier_achternaam;
    private String caberetier_voornaam;
    private String leeftijd;
    private String geslacht;
       
   
    public Caberetier(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst,
			String datum, String tijd, Integer caberatier_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, caberatier_id);

        this.caberatier_id = caberatier_id;
	}


	

	public Caberetier( Integer caberatier_id, String caberetier_achternaam, String caberetier_voornaam,
			String leeftijd, String geslacht) {
		this.caberatier_id = caberatier_id;
		this.caberetier_achternaam = caberetier_achternaam;
		this.caberetier_voornaam = caberetier_voornaam;
		this.leeftijd = leeftijd;
		this.geslacht = geslacht;
	}






	public Caberetier() {
		
	}


	public Integer getCaberatier_id() {
        return caberatier_id;
    }

    public void setCaberatier_id(Integer caberatier_id) {
        this.caberatier_id = caberatier_id;
    }


	public String getCaberetier_achternaam() {
		return caberetier_achternaam;
	}


	public void setCaberetier_achternaam(String caberetier_achternaam) {
		this.caberetier_achternaam = caberetier_achternaam;
	}


	public String getCaberetier_voornaam() {
		return caberetier_voornaam;
	}


	public void setCaberetier_voornaam(String caberetier_voornaam) {
		this.caberetier_voornaam = caberetier_voornaam;
	}


	public String getLeeftijd() {
		return leeftijd;
	}


	public void setLeeftijd(String leeftijd) {
		this.leeftijd = leeftijd;
	}


	public String getGeslacht() {
		return geslacht;
	}


	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

}
