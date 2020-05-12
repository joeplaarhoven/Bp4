package com.example.bp4.Theater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theater_id;
    private Integer huisnummer;
    
    @Column(name = "theaternaam", nullable = false, unique = true)
    private String theaternaam;
    @Column(name = "straatnaam", nullable = false, unique = false)
    private String straatnaam;
    @Column(name = "postcode", nullable = false, unique = false)
    private String postcode;
    @Column(name = "plaats", nullable = false, unique = false)
    private String plaats;
   
    
    public Theater(Integer theater_id, String theaternaam) {
    	this.theater_id = theater_id;
    	this.theaternaam = theaternaam;
    }
    
    public Theater(String theaternaam, String straatnaam, Integer huisnummer, String postcode, String plaats) {
    	this.theaternaam = theaternaam;
    	this.straatnaam = straatnaam;
    	this.huisnummer = huisnummer;
    	this.postcode = postcode;
    	this.plaats = plaats;
    }
    
    public Theater() {
    	
    }

    public Integer getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Integer theater_id) {
        this.theater_id = theater_id;
    }

	public Integer getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(Integer huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getTheaternaam() {
		return theaternaam;
	}

	public void setTheaternaam(String theaternaam) {
		this.theaternaam = theaternaam;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

}
