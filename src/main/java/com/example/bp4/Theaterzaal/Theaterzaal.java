package com.example.bp4.Theaterzaal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theaterzalen")
public class Theaterzaal {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer theaterzaal_id;
    private Integer tz_theater_id;
    private Integer zitplaatsen;
    
    @Column(name = "zaalnaam", nullable = false, unique = false)
    public String zaalnaam;
    
    public Theaterzaal(Integer tz_theater_id, String zaalnaam, Integer zitplaatsen) {
    	this.tz_theater_id = tz_theater_id;
    	this.zaalnaam = zaalnaam;
    	this.zitplaatsen = zitplaatsen;
    }
    
	public Theaterzaal(String zaalnaam, Integer theaterzaal_id) {
	    	this.zaalnaam = zaalnaam;
	    	this.theaterzaal_id = theaterzaal_id;
	}
    public Theaterzaal() {
    	
    }

	public Integer getTheaterzaal_id() {
		return theaterzaal_id;
	}

	public void setTheaterzaal_id(Integer theaterzaal_id) {
		this.theaterzaal_id = theaterzaal_id;
	}

	public Integer getTz_theater_id() {
		return tz_theater_id;
	}

	public void setTz_theater_id(Integer tz_theater_id) {
		this.tz_theater_id = tz_theater_id;
	}

	public Integer getZitplaatsen() {
		return zitplaatsen;
	}

	public void setZitplaatsen(Integer zitplaatsen) {
		this.zitplaatsen = zitplaatsen;
	}

	public String getZaalnaam() {
		return zaalnaam;
	}

	public void setZaalnaam(String zaalnaam) {
		this.zaalnaam = zaalnaam;
	}
	
}
